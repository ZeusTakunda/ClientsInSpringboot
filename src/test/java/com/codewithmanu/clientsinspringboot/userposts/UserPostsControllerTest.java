package com.codewithmanu.clientsinspringboot.userposts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserPostsControllerTest {

   private UserPosts userPosts;




    @Autowired
    UserPostsService userpostsService;
    @Autowired
    private WebTestClient webTestClient;

   @Test
    void getAllUserPosts() {


       List<UserPosts> userPosts = userpostsService.getAllUserPosts();
       assertEquals(100, userPosts.size());
   }

   @Test
    void getUserPostsById() {
       List<UserPosts> userPosts = userpostsService.getUserPostsById(1);
       assertEquals(10, userPosts.size());
   }

}