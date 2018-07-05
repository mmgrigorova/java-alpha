package com.blogapp.web;

import com.blogapp.models.BlogPost;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/blogposts")
public class BlogController {
    private List<BlogPost> blogPosts;

    public BlogController(){
        blogPosts = new ArrayList<>();
    }

    //create list seeText

    @RequestMapping("/")
    public List<BlogPost> listPosts(){
        return blogPosts;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/"
    )
    public void createBlogPost(@RequestBody BlogPost post){
        blogPosts.add(post);
    }


    private BlogPost findPostbyID( String idString){
        int id = Integer.parseInt(idString);
        return blogPosts.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public BlogPost getPost(@PathVariable("id") String idString){
        return findPostbyID(idString);

    }

}
