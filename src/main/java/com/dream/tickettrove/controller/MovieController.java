package com.dream.tickettrove.controller;

import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.service.MovieService;
import com.dream.tickettrove.service.dto.MovieResponse;
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
    public List<Showtime> getShowtimesByMovieCinemaDate(@PathVariable Integer id,
                                                        @RequestParam Long cinemaId,
                                                        @RequestParam String date) {
        return movieService.getShowtimesByMovieCinemaDate(id, cinemaId, date);
    }

    @GetMapping("/showtime/{id}")
    public List<Showtime> getDateById(@PathVariable Integer id) {
        return movieService.findDate(id);
    }
}
