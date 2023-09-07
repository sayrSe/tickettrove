package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.service.dto.SeatResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SeatMapper {
    public static SeatResponse toResponse(Seat seat, ShowtimeSeat showtimeSeat) {
        SeatResponse seatResponse = new SeatResponse();
        BeanUtils.copyProperties(showtimeSeat, seatResponse);
        BeanUtils.copyProperties(seat, seatResponse);
        return seatResponse;
    }

    public static SeatResponse toResponse(Seat seat) {
        SeatResponse seatResponse = new SeatResponse();
        BeanUtils.copyProperties(seat, seatResponse);
        return seatResponse;
    }
}
