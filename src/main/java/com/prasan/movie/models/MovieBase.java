package com.prasan.movie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieBase {
    public MovieDates dates;
    public int page;
    public ArrayList<MovieResult> results;
    public int total_pages;
    public int total_results;
}
