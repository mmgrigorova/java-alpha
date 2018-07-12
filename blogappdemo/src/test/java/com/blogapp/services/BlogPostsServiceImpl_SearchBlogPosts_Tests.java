package com.blogapp.services;

import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import com.blogapp.services.base.BlogPostsService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogPostsServiceImpl_SearchBlogPosts_Tests {
    @Mock
    private GenericRepository<BlogPost> mockRepository;

    private BlogPostsService service;
    private List<BlogPost> blogPosts;

    @Before
    public void beforeTest() {
        blogPosts = new ArrayList<>();

        when(mockRepository.modelStream())
                .thenReturn(blogPosts.stream());

        service = new BlogPostsServiceImpl(mockRepository);
    }

    @Test
    public void searchBlogPosts_WhenContentMatch_ReturnListOfBlogPosts() {
        //Arrange
        blogPosts.add(new BlogPost("Arthur 1", "Content 1"));
        blogPosts.add(new BlogPost("Arthur 2", "Content 2"));
        blogPosts.add(new BlogPost("Arthur 3", "Content 3"));
        blogPosts.add(new BlogPost("Arthur 4", "Content 4"));
        blogPosts.add(new BlogPost("Arthur 11", "Content 11"));

        //Act
        List<BlogPost> resultBlogPosts = service.searchBlogPosts(
                blogPost -> blogPost.getContent().contains("1")
        );

        //Assert
        Assert.assertNotNull(resultBlogPosts.stream()
                .filter(blogPost -> blogPost.getContent().equals("Content 1"))
                .findFirst()
                .orElse(null));

        Assert.assertNotNull(resultBlogPosts.stream()
                .filter(blogPost -> blogPost.getContent().equals("Content 11"))
                .findFirst()
                .orElse(null));

        int resultSize = resultBlogPosts.size();
        int expectedSize = 2;
        Assert.assertEquals(resultSize, expectedSize);
    }

    @Test
    public void searchBlogPosts_WhenNoBlogPosts_ReturnEmptyList() {
        List<BlogPost> resultBlogPosts = service
                .searchBlogPosts(blogPost -> true);
        int resultSize = resultBlogPosts.size();
        int expectedSize = 0;

        Assert.assertEquals(resultSize, expectedSize);
    }

    @Test
    public void searchBlogPosts_WhenNoMatch_ReturnEmptyList() {
        blogPosts.add(new BlogPost("Author A", "Content A"));
        blogPosts.add(new BlogPost("Author B", "Content B"));
        blogPosts.add(new BlogPost("Author C", "Content C"));
        blogPosts.add(new BlogPost("Author D", "Content D"));
        blogPosts.add(new BlogPost("Author E", "Content E"));

        List<BlogPost> resultBlogPosts = service
                .searchBlogPosts(
                        blogPost -> blogPost.getContent().contains("1")
                );
        int resultSize = resultBlogPosts.size();
        int expectedSize = 0;

        Assert.assertEquals(resultSize, expectedSize);
    }

}
