package com.blogapp.services;

import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogPostsServiceImpl_FindById_Tests {
    @Mock
    private GenericRepository<BlogPost> mockRepository;

    private BlogPostsServiceImpl service;
    private BlogPost blogPost;

    @Before
    public void beforeTests(){
        blogPost = new BlogPost("Author 1", "Test Content 1" );

        when(mockRepository.getOne(blogPost.getId()))
                .thenReturn(blogPost);
        when(mockRepository.getOne(-1))
                .thenReturn(null);
        service = new BlogPostsServiceImpl(mockRepository);
    }

    @Test
    public void fingById_WhenValidId_AndBlogPostIsPresent_ReturnBlogPost(){

        int postId = blogPost.getId();

        BlogPost result = null;
        String blogPostContent = "";

        try {
            result = service.findById(postId);
            blogPostContent = blogPost.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String actualPostContent = result.getContent();

        Assert.assertEquals(blogPostContent, actualPostContent);
    }

    @Test (expected = Exception.class)
    public void findById_WhenBlogPostIsNotPresent_ReturnNull() throws Exception{
        service.findById(-1);
    }
}
