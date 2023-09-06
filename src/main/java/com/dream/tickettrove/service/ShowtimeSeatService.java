package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.SeatsNotFoundException;
import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.repository.ShowtimeSeatRepository;
import com.dream.tickettrove.service.dto.ShowtimeSeatResponse;
import com.dream.tickettrove.service.mapper.ShowtimeSeatMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ShowtimeSeatService {
    private final ShowtimeSeatRepository showtimeSeatRepository;

    public ShowtimeSeatService(ShowtimeSeatRepository showtimeSeatRepository){
        this.showtimeSeatRepository = showtimeSeatRepository;
    }

    public ShowtimeSeatResponse getSeatLayout(Integer showtimeId) {
        List<ShowtimeSeat> showtimeSeats = showtimeSeatRepository.findByShowtimeId(showtimeId);
        if(showtimeSeats == null) throw new SeatsNotFoundException();

        Integer maxRow = showtimeSeats.stream()
                .max(Comparator.comparing(ShowtimeSeat::getRowNum))
                .get()
                .getRowNum();

        return ShowtimeSeatMapper.toResponse(showtimeId, showtimeSeats, maxRow);
    }

}
