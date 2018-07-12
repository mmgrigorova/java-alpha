package com.blogapp.services.base;

import com.blogapp.models.BlogPost;

import java.util.List;
import java.util.function.Predicate;

public interface BlogPostsService {
    List<BlogPost> listAllBlogPosts();

    List<BlogPost> searchBlogPosts(Predicate<BlogPost> condition);

    BlogPost createBlogPost(BlogPost blogPost);

    BlogPost findById(int id);


    BlogPost updateBlogPost(int id, BlogPost newPost);

    boolean deleteBlogPost(int id);

}
