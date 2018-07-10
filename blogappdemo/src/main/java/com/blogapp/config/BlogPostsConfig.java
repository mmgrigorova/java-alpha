package com.blogapp.config;

import com.blogapp.data.BlogPostsRepositoryImpl;
import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import com.blogapp.services.BlogPostsServiceImpl;
import com.blogapp.services.base.BlogPostsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostsConfig {
//    private static GenericRepository<BlogPost> blogPostsRepository;
//    @Bean
//    public GenericRepository<BlogPost> genericRepository(){
//        if (blogPostsRepository == null){
//            blogPostsRepository = new BlogPostsRepositoryImpl();
//        }
//        return blogPostsRepository;
//    }
//
//    @Bean
//    public BlogPostsService blogPostsService(){
//        return new BlogPostsServiceImpl(blogPostsRepository);
//    }
}
