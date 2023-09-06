package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.service.dto.ShowtimeSeatLayoutResponse;

import java.util.List;

public class ShowtimeSeatMapper {
    public static ShowtimeSeatLayoutResponse toResponse(Integer showtimeId, List<ShowtimeSeat> showtimeSeats, int maxRow) {
        ShowtimeSeatLayoutResponse showtimeSeatLayoutResponse = new ShowtimeSeatLayoutResponse();

        showtimeSeatLayoutResponse.setShowtimeId(showtimeId);
        showtimeSeatLayoutResponse.setMaxRow(maxRow);
        showtimeSeatLayoutResponse.setSeats(showtimeSeats);

        return showtimeSeatLayoutResponse;
    }
}
