package com.dream.tickettrove.service.dto;

import java.util.List;

public class HallResponse {
    private Integer hallNumber;
    private Integer maxRow;
    private Integer maxCol;
    private List<SeatResponse> seats;

    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Integer getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
    }

    public Integer getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(Integer maxCol) {
        this.maxCol = maxCol;
    }

    public List<SeatResponse> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatResponse> seats) {
        this.seats = seats;
    }
}
