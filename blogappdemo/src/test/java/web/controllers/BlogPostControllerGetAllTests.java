package web.controllers;


import com.blogapp.BlogappApplication;
import com.blogapp.models.BlogPost;
import com.blogapp.services.base.BlogPostsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogappApplication.class)
@AutoConfigureMockMvc
public class BlogPostControllerGetAllTests {
    private List<BlogPost> blogs;
    @MockBean
    BlogPostsService service;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setup(){
        blogs = new ArrayList<>();
        blogs.add(new BlogPost("Author 1", "Test Post 1"));
        blogs.add(new BlogPost("Author 2", "Test Post 2"));

        when(service.listAllBlogPosts())
                .thenReturn(blogs);
    }

    @Test
    public void getAll_whenRestaurants_shouldStatus200AndContainRestaurants() throws Exception {

        ResultActions expect = mockMvc.perform(
                get("/api/blogposts")
        )
                .andDo(print())
                .andExpect(status().isOk());

        blogs
            .forEach(post ->
            {
                try {
                    expect.andExpect(
                        content()
                            .string(containsString(post.getContent()))
                    );
                } catch (Exception e) {
                    Assert.fail();
                }
            });
    }
}
