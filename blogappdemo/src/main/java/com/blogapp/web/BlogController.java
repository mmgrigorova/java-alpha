package com.blogapp.web;

import com.blogapp.models.BlogPost;
import com.blogapp.services.base.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogposts")
public class BlogController {
    private BlogPostsService blogPostsService;

    @Autowired
    public BlogController(BlogPostsService blogPostsService) {
        this.blogPostsService = blogPostsService;
    }

    // Run app with http://localhost:8080
    @RequestMapping("/")
    public List<BlogPost> listPosts() {
        try {
            return blogPostsService.listAllBlogPosts();
        } catch (NullPointerException e) {
            System.out.println("No posts yet");
            return null;
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/"
    )
    public void createBlogPost(@RequestBody BlogPost post) {
        blogPostsService.createBlogPost(post);
    }

    // Question - There is some logic in the controller. How to avoid?
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public BlogPost getPost(@PathVariable("id") String idString) {
        int id = Integer.parseInt(idString);
        return (BlogPost) blogPostsService.searchBlogPosts(x -> x.getId() == id);

    }
}
