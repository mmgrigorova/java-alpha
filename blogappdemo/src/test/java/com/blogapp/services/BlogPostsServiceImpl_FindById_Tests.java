package com.blogapp.services;

import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import org.junit.Test;

public class BlogPostsServiceImpl_FindById_Tests {
    private GenericRepository<BlogPost> mockRepository;
    private BlogPostsServiceImpl service;
    private BlogPost blogPost;

    @Test
    public void fingById_WhenValidId_AndBlogPostIsPresent_ReturnBlogPost(){

    }

    @Test
    public void findById_WhenBlogPostIsNotPresent_ReturnNull(){

    }

}
