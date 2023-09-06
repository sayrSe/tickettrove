package com.dream.tickettrove.service.dto;

import com.dream.tickettrove.model.ShowtimeSeat;

import java.util.List;

public class ShowtimeSeatLayoutResponse {
    private Integer showtimeId;
    private Integer maxRow;
    private List<ShowtimeSeat> showtimeSeats;

    public ShowtimeSeatLayoutResponse() {
    }
    public ShowtimeSeatLayoutResponse(Integer showtimeId, Integer maxRow, List<ShowtimeSeat> showtimeSeats) {
        this.showtimeId = showtimeId;
        this.maxRow = maxRow;
        this.showtimeSeats = showtimeSeats;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Integer getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
    }

    public List<ShowtimeSeat> getSeats() {
        return showtimeSeats;
    }

    public void setSeats(List<ShowtimeSeat> showtimeSeats) {
        this.showtimeSeats = showtimeSeats;
    }
}
