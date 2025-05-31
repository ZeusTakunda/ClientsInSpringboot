package com.codewithmanu.clientsinspringboot.userposts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userposts")
@CrossOrigin
@Component
public class UserPostsController {

    @Autowired
    UserPostsService userPostsService;

    @GetMapping("/getAllUserPosts")
    public List<UserPosts> getAllUserPosts(){
        return userPostsService.getAllUserPosts();
    }


    @GetMapping("/getAllUserPostsById/{userId}")
    public List<UserPosts> getAllUserPostsById(@PathVariable Integer userId){
        return userPostsService.getUserPostsById(userId);
    }
}
