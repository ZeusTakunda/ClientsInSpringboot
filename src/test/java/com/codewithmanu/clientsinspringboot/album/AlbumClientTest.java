package com.codewithmanu.clientsinspringboot.album;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlbumClientTest {

    @Autowired
    AlbumClient albumClient;

    @Test
    void testFindAlbums() {
        List<Album> albums = albumClient.findAlbums();
        assertEquals(100, albums.size());
    }
}