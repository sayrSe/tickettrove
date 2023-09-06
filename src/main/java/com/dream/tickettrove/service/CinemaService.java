package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.ResourceNotFoundException;
import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.repository.CinemaLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaLocationRepository cinemaLocationRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaLocationRepository.findAll();
    }

    public Cinema getCinemaById(Long id) {
        return cinemaLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema not found with id " + id));
    }
}
