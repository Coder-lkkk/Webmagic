package com.lkkk.controller;

import com.lkkk.dao.CsdnBlogDao;
import com.lkkk.service.CsdnBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/csdnBlog")
public class CsdnBlogController {

    @Autowired
    private CsdnBlogService csdnBlogService;

    //爬取csdn博客资源
    @RequestMapping(value = "/crawl")
    public void toMain() {
        csdnBlogService.crawlCsdnBlog();
    }
}
