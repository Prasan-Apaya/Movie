package com.prasan.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MovieResult {
    @Column
    public boolean adult;
    @Column
    public String backdropPath;
    @Column(name = "genre_ids")
    public ArrayList<Integer> genreIds;
    @Id
    public int id;
    @Column(name = "original_language")
    public String originalLanguage;
    @Column(name = "original_title")
    public String originalTitle;
    @Column(columnDefinition="text")
    public String overview;
    @Column
    public double popularity;
    @Column(name = "poster_path")
    public String posterPath;
    @Column(name = "release_date")
    public String releaseDate;
    @Column
    public String title;
    @Column
    public boolean video;
    @Column(name = "vote_average")
    public double vote_average;
    @Column(name = "vote_count")
    public int vote_count;
}
