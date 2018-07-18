package web.controllers;


import com.blogapp.models.BlogPost;
import com.blogapp.services.base.BlogPostsService;
import com.blogapp.web.BlogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Array;
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
@SpringBootTest(classes = BlogController.class)
@AutoConfigureMockMvc
public class BlogController_listPosts_Tests {

    @MockBean
    BlogPostsService service;

    @Autowired
    MockMvc mockMvc;
//
//    @Before
//    public void setTests(){
//        List<BlogPost> blogPosts;
//        blogPosts  = new ArrayList<>();
//        blogPosts.add(new BlogPost("Author 1", "Content 1"));
//        blogPosts.add(new BlogPost("Author 2", "Content 2"));
//        when(service.listAllBlogPosts())
//                .thenReturn(blogPosts);
//    }

    @Test
    public void istPosts_WhenBlogPosts_thenStatus200AndBlogPosts() throws Exception {
        List<BlogPost> blogPosts = Arrays.asList(
                new BlogPost("Author 1", "Content 1"),
                new BlogPost("Author 2", "Content 2")
        );

//        when(service.listAllBlogPosts())
//                .thenReturn(blogPosts);
//
//        ResultActions result = mockMvc.perform(
//                get("/api/blogposts")
//        )
//                .andDo(print())
//                .andExpect(status().isOk());
        when(service.listAllBlogPosts())
                .thenReturn(blogPosts);

        ResultActions expect = mockMvc.perform(
                get("/api/blogposts")
        )
                .andDo(print())
                .andExpect(status().isOk());


//        blogPosts.forEach(blogPost ->
//                {
//                    try {
//                        result.andExpect(content()
//                                .string(containsString(blogPost.getContent())));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Assert.fail();
//                    }
//                }
//        );


    }


}
