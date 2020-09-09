package com.lkkk.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import po.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class BlogDaoTest {

    @Autowired
    private CsdnBlogDao blogDao;

    @Test
    public void insertBlog() {
        Blog blog = new Blog("1", "1", "1", "1", "1", "1", "1");
        System.out.println("插入博客："+blog);
        blogDao.insertBlog(blog);
    }
}