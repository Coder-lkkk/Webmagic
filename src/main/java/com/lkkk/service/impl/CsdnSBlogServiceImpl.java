package com.lkkk.service.impl;

import com.lkkk.dao.CsdnBlogDao;
import com.lkkk.service.CsdnBlogService;
import com.lkkk.webmagic.CsdnPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Blog;

@Service("blogService")
public class CsdnSBlogServiceImpl implements CsdnBlogService {

    @Autowired
    private CsdnBlogDao csdnBlogDao;
    @Autowired
    private CsdnPageProcessor csdnPageProcessor;

    @Override
    public int insertBlog(Blog blog) {
        return csdnBlogDao.insertBlog(blog);
    }

    @Override
    public void crawlCsdnBlog() {
        csdnPageProcessor.start();
    }
}
