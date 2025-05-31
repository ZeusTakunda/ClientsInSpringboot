package com.codewithmanu.clientsinspringboot.userposts;

import com.codewithmanu.clientsinspringboot.post.Post;
import com.codewithmanu.clientsinspringboot.post.PostClient;
import com.codewithmanu.clientsinspringboot.user.User;
import com.codewithmanu.clientsinspringboot.user.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPostsService {

    public static User user;
    public static Post post;

    static UserClient userClient = new UserClient(WebClient.builder());
    static PostClient postClient = new PostClient(RestClient.builder());



    public static List<UserPosts> userPostsList = new ArrayList<>();

    public static List<Post> postsList = new ArrayList<>();
    public static Flux<User> userList = new Flux<User>() {
        @Override
        public void subscribe(CoreSubscriber<? super User> coreSubscriber) {

        }
    };




    static {

        userList = userClient.findALl();
        postsList = postClient.findAll();

        userList.subscribe(user -> {
            for (Post post: postsList) {
                if (user.id() == post.userId()){
                    userPostsList.add(new UserPosts(user.id(), user.name(),post.id(),post.title()));
                }

            }
        });
    }




    public List<UserPosts> getAllUserPosts(){
        return userPostsList.stream().collect(Collectors.toList());
    }

    public List<UserPosts> getUserPostsById(int userId){
        userPostsList.clear();
        user = userClient.findUserById(userId);
        for (Post post: postsList) {
            if (userId == post.userId()) {

                userPostsList.add(new UserPosts(user.id(), user.name(), post.id(), post.title()));
            }

        }

        return userPostsList.stream().collect(Collectors.toList());
    }
}
