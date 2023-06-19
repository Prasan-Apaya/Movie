package com.prasan.movie.controller;

import com.prasan.movie.models.MovieBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "latest")
public class LatestMovieController {

    @Autowired
    RestTemplate restTemplate;
    HttpHeaders headers;
    @Value("${movie.api.url}")
    String url;
    /**
     * To do proper configuration
     */
    public LatestMovieController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("x-api-key", "85ec23f1d042093b93f7cbfcceb12fa9");
        //headers.add("x-access-token","eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NWVjMjNmMWQwNDIwOTNiOTNmN2NiZmNjZWIxMmZhOSIsInN1YiI6IjVlNmQ1NzM4MmYzYjE3MDAxMTQzYjY4MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mhfUWuVTd-R5VIp9wATl8Bi9KI6O4l9qsyFjdHK03lY");
    }

    @GetMapping("/get-latest-movies")
    public ResponseEntity getLatestMoviesRunning(){
        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<MovieBase> result = restTemplate.exchange(url, HttpMethod.GET, request, MovieBase.class);
        MovieBase latestMoviesResponse = result.getBody();

        return ResponseEntity.ok().body(latestMoviesResponse);
    }
}
