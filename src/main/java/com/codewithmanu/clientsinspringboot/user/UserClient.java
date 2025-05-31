package com.codewithmanu.clientsinspringboot.user;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class UserClient {

    private final WebClient webClient;

    public UserClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    public Flux<User> findALl() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public User findUserById(Integer userId) {
        return webClient.get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
