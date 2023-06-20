package com.prasan.movie.service;

import com.prasan.movie.models.MovieResult;
import com.prasan.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void saveAll(ArrayList<MovieResult> movieResult){
        try {
            movieRepository.saveAll(movieResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
