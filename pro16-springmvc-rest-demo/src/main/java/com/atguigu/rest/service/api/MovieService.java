package com.atguigu.rest.service.api;

import com.atguigu.rest.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    Movie getMovieById(String movieId);

    void saveMovie(Movie movie);

    void updateMovie(Movie movie);

    void removeMovieById(String movieId);

    boolean isMovieNameExist(String movieName);
}
