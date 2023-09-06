package com.dream.tickettrove.service.dto;

import com.dream.tickettrove.model.Seat;

import java.util.List;

public class SeatLayoutResponse {
    private Integer showtimeId;
    private Integer maxRow;
    private List<Seat> seats;

    public SeatLayoutResponse() {
    }
    public SeatLayoutResponse(Integer showtimeId, Integer maxRow, List<Seat> seats) {
        this.showtimeId = showtimeId;
        this.maxRow = maxRow;
        this.seats = seats;
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
