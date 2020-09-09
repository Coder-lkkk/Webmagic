package com.lkkk.webmagic;

import org.springframework.stereotype.Component;
import po.Blog;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

@Component
public class CsdnPageProcessor implements PageProcessor {
    //这里没有办法自动注入，所以把调用dao的操作写在了pipeline里面
/*    @Autowired
    private BlogDao blogDao;*/

    private BlogPipeline blogPipeline = new BlogPipeline();
    public CsdnPageProcessor(){
        //想通过applicationcontext的方式实例化dao也不成功
        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
        this.blogDao = (BlogDao)context.getBean("blogDao");*/
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    private String detailUrl = "https://blog\\.csdn\\.net/\\S+/article/details/\\d+";
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex(detailUrl).all());

        if (page.getUrl().regex(detailUrl).match()) {
            Html html = page.getHtml();
            String title = html.xpath("//h1[@class='title-article']/text()").toString();
            String publishTime = html.xpath("//div[@class='article-bar-top']/span[@class='time']/text()").get();
            String tag = html.xpath("//div[@class='article-bar-top']/span[@class='tags-box artic-tag-box']/a/text()").toString();
            String specialColumn = html.xpath("//div[@class='article-bar-top']/div[@class='tags-box space']/a/text()").toString();
            String author = html.xpath("//a[@class='follow-nickName']/text()").toString();
            String sourceUrl = page.getUrl().toString();
            String readNum = html.xpath("//span[@class='read-count']/text()").toString();
//            page.putField("title",title);
//            page.putField("publishTime",publishTime);
//            page.putField("tag",tag);
//            page.putField("column",specialColumn);
//            page.putField("author",author);
//            page.putField("sourceUrl",sourceUrl);
//            page.putField("readNum",readNum);
            Blog blog = new Blog(title,publishTime,tag,specialColumn,author,sourceUrl,readNum);
            page.putField("blog",blog);
        }

    }

    public Site getSite() {
        return site;
    }

    public void start() {
        long startTime, endTime;
        System.out.println("-----------启动爬虫程序-----------");
        startTime = System.currentTimeMillis();
        Spider.create(new CsdnPageProcessor())
                .addUrl("https://blog.csdn.net/weixin_41660213/article/details/91354179")
                .addPipeline(new ConsolePipeline())
                .addPipeline(blogPipeline)
//                .addPipeline(new JsonFilePipeline("D:/software engineering/Java爬虫/CSDNblogcrawdata"))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
        endTime = System.currentTimeMillis();
        System.out.println("结束爬虫程序，耗时约 " + ((endTime - startTime) / 1000) + " 秒！");
    }
}
