package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.service.dto.ShowtimeSeatResponse;

import java.util.List;

public class ShowtimeSeatMapper {
    public static ShowtimeSeatResponse toResponse(Integer showtimeId, List<ShowtimeSeat> showtimeSeats, int maxRow) {
        ShowtimeSeatResponse showtimeSeatResponse = new ShowtimeSeatResponse();

        showtimeSeatResponse.setShowtimeId(showtimeId);
        showtimeSeatResponse.setMaxRow(maxRow);
        showtimeSeatResponse.setSeats(showtimeSeats);

        return showtimeSeatResponse;
    }
}
