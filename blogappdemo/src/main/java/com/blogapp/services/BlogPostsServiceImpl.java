package com.blogapp.services;

import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import com.blogapp.services.base.BlogPostsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BlogPostsServiceImpl implements BlogPostsService {
    private GenericRepository<BlogPost> blogPostsRepository;

    public BlogPostsServiceImpl(GenericRepository<BlogPost> blogPostRepository) {
        this.blogPostsRepository = blogPostRepository;
    }

    @Override
    public List<BlogPost> listAllBlogPosts() {
        return blogPostsRepository.list();
    }

    public BlogPost findById(int id) {
        try {
            return blogPostsRepository.getOne(id);
        } catch (NullPointerException e){
            System.out.println("No such blog post.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BlogPost> searchBlogPosts(Predicate<BlogPost> condition) {
        return blogPostsRepository.modelStream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        try {
            blogPostsRepository.add(blogPost);
        } catch (NullPointerException e) {
            System.out.println("The blog post is null");
        }

        return blogPost;
    }

    @Override
    public void updateBlogPost(int id, BlogPost newPost) {
        blogPostsRepository.update(id, newPost);
    }

    @Override
    public boolean deleteBlogPost(int id) {
        return blogPostsRepository.delete(id);
    }
}
