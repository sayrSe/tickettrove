package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.SeatsNotFoundException;
import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.repository.SeatRepository;
import com.dream.tickettrove.service.dto.SeatLayoutResponse;
import com.dream.tickettrove.service.mapper.SeatMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    public SeatLayoutResponse getSeatLayout(Integer showtimeId) {
        List<Seat> seats = seatRepository.findByShowtimeId(showtimeId);
        if(seats == null) throw new SeatsNotFoundException();

        Integer maxRow = seats.stream()
                .max(Comparator.comparing(Seat::getRowNum))
                .get()
                .getRowNum();

        return SeatMapper.toResponse(showtimeId, seats, maxRow);
    }

}
