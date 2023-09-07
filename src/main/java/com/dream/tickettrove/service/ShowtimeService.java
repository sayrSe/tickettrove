package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.ShowtimeNotFoundException;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    public ShowtimeService(ShowtimeRepository showtimeRepository){
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime getById(Integer id) {
        return showtimeRepository.findById(id)
                .orElseThrow(ShowtimeNotFoundException::new);
    }
}
