package com.codewithmanu.clientsinspringboot.user;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public User findOne(){
        return webClient.get()
                .uri("/users/1")
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
