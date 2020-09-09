package com.lkkk.dao;

import org.apache.ibatis.annotations.Param;
import po.Blog;

public interface CsdnBlogDao {

    /*新增博客*/
    int insertBlog(@Param("blog") Blog blog);
}
