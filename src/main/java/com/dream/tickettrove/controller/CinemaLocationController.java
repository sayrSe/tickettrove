package com.dream.tickettrove.controller;

import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.service.CinemaService;
import com.dream.tickettrove.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaLocationController {
    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable Long id) {
        return cinemaService.getCinemaById(id);
    }
}
