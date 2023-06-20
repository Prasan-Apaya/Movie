package com.prasan.movie.repository;

import com.prasan.movie.models.MovieResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieResult, Integer> {
}
