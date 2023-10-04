package com.dream.tickettrove.controller;

import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.service.MovieService;
import com.dream.tickettrove.service.dto.MovieResponse;
import com.dream.tickettrove.service.dto.ShowtimeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponse> getAllNowShowing() {
        return movieService.findAllNowShowing();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    @GetMapping(value = "/{id}/showtimes", params = {"cinemaId", "date"})
    public List<ShowtimeResponse> getShowtimesByMovieCinemaDate(@PathVariable Integer id,
                                                                @RequestParam Long cinemaId,
                                                                @RequestParam String date) {
        return movieService.getShowtimesByMovieCinemaDate(id, cinemaId, date);
    }

    @GetMapping(value = "/{id}/showtimes", params = "date")
    public List<Cinema> getDateById(@PathVariable Integer id, @RequestParam String date) {
        return movieService.findCinemasByMovieAndDate(id, date);
    }
}
