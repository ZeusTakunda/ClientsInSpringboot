package com.codewithmanu.clientsinspringboot.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoClientTest {

    @Autowired
    private TodoClient todoClient;

    @Test
    void testFindAll() {
        List<Todo> todo = todoClient.findAll();
        assertEquals(200,todo.size());
    }

}