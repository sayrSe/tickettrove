package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Movie;
import com.dream.tickettrove.service.dto.MovieResponse;
import org.springframework.beans.BeanUtils;

public class MovieMapper {

    private MovieMapper() {
    }

    public static MovieResponse toResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        BeanUtils.copyProperties(movie, movieResponse);
        return movieResponse;
    }
}
