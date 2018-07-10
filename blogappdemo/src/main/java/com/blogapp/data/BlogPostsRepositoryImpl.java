package com.blogapp.data;

import com.blogapp.data.base.GenericRepository;
import com.blogapp.models.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class BlogPostsRepositoryImpl implements GenericRepository<BlogPost> {
    private static List<BlogPost> blogPosts;

    static {
        blogPosts = new ArrayList<>();
    }

    @Override
    public List<BlogPost> list() {
        return blogPosts;
    }

    @Override
    public Stream<BlogPost> modelStream() {
        return blogPosts.stream();
    }

    @Override
    public BlogPost findById(int id) {
        return modelStream().filter(x -> id == x.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public BlogPost create(BlogPost model) {
        blogPosts.add(model);
        return model;
    }

    @Override
    public BlogPost update(int id, BlogPost newPost) {
        BlogPost post = findById(id);
        post = newPost;
        return newPost;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < blogPosts.size(); i++) {
            if (blogPosts.get(i).getId() == id){
                blogPosts.remove(i);
                return true;
            }
        }
        return false;
    }
}
