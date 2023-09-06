package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.service.dto.SeatLayoutResponse;

import java.util.List;

public class SeatMapper {
    public static SeatLayoutResponse toResponse(Integer showtimeId, List<Seat> seats, int maxRow) {
        SeatLayoutResponse seatLayoutResponse = new SeatLayoutResponse();

        seatLayoutResponse.setShowtimeId(showtimeId);
        seatLayoutResponse.setMaxRow(maxRow);
        seatLayoutResponse.setSeats(seats);

        return seatLayoutResponse;
    }
}
