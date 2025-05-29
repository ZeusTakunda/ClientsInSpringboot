package com.codewithmanu.clientsinspringboot.album;

import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface AlbumClient {

    @GetExchange("/albums")
    List<Album> findAlbums();


}
