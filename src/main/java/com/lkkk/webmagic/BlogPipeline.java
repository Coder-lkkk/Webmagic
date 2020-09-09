package com.lkkk.webmagic;


import com.lkkk.dao.CsdnBlogDao;
import com.lkkk.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import po.Blog;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by rf on 2019/4/3.
 */
@Component
public class BlogPipeline implements Pipeline {
    @Autowired
    private CsdnBlogDao blogDao;
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
        blogDao = (CsdnBlogDao)SpringContextUtil.getBean("blogDao");
      Blog blog = resultItems.get("blog");
        blogDao.insertBlog(blog);
    }
}
