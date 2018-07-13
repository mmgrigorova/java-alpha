package com.blogapp.services;

import com.blogapp.data.BlogPostsRepositoryImpl;
import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import org.junit.Assert;
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

    @Test
    public void fingById_WhenValidId_AndBlogPostIsPresent_ReturnBlogPost(){

        blogPost = new BlogPost("Author 1", "Test Content 1" );

        when(mockRepository.getOne(blogPost.getId()))
                .thenReturn(blogPost);
        when(mockRepository.getOne(5))
                .thenReturn(null);

        int postId = blogPost.getId();
        mockRepository.add(blogPost);
        service = new BlogPostsServiceImpl(mockRepository);

        BlogPost result = service.findById(postId);
        int resultId = result.getId();

        Assert.assertEquals(postId, resultId);

    }

    @Test
    public void findById_WhenBlogPostIsNotPresent_ReturnNull(){

    }
}
