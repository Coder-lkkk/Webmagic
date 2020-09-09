package com.lkkk.service;

import po.Blog;

public interface CsdnBlogService {

    public int insertBlog(Blog blog);

    public void crawlCsdnBlog();
}
