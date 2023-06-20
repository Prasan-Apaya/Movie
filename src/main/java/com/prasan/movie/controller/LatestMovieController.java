package com.prasan.movie.controller;

import com.prasan.movie.models.MovieBase;
import com.prasan.movie.service.MovieService;
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
    @Value("${movie.api.now.playing.url}")
    String latestMovieUrl;

    @Value("${movie.api.popular.url}")
    String popularMovieUrl;

    @Autowired
    MovieService movieService;

    /**
     * To do proper configuration
     */
    public LatestMovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("x-api-key", "85ec23f1d042093b93f7cbfcceb12fa9");
        //headers.add("x-access-token","eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NWVjMjNmMWQwNDIwOTNiOTNmN2NiZmNjZWIxMmZhOSIsInN1YiI6IjVlNmQ1NzM4MmYzYjE3MDAxMTQzYjY4MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mhfUWuVTd-R5VIp9wATl8Bi9KI6O4l9qsyFjdHK03lY");
    }

    @GetMapping("/get-latest-movies")
    public ResponseEntity<MovieBase> getLatestMoviesRunning() {
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<MovieBase> latestMovieResult = restTemplate.exchange(latestMovieUrl, HttpMethod.GET, request, MovieBase.class);
        MovieBase latestMoviesResponse = latestMovieResult.getBody();
        movieService.saveAll(latestMoviesResponse.getResults());
        return ResponseEntity.ok().body(latestMoviesResponse);
    }

    @GetMapping("/get-popular-movies")
    public ResponseEntity<MovieBase> getPopularMovies(){
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<MovieBase> popularMovieResult = restTemplate.exchange(popularMovieUrl, HttpMethod.GET, request, MovieBase.class);
        movieService.saveAll(popularMovieResult.getBody().getResults());
        return ResponseEntity.ok().body(popularMovieResult.getBody());
    }
}
