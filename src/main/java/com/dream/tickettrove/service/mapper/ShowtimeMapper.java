package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.service.dto.SeatResponse;
import com.dream.tickettrove.service.dto.ShowtimeResponse;
import org.springframework.beans.BeanUtils;

public class ShowtimeMapper {

    public static ShowtimeResponse toResponse(Showtime showtime, Cinema cinema) {
        ShowtimeResponse showtimeResponse = new ShowtimeResponse();
        BeanUtils.copyProperties(showtime, showtimeResponse);
        showtimeResponse.setCinema(cinema);
        return showtimeResponse;
    }

}
