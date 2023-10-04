package com.dream.tickettrove.service.dto;

public class BookedSeatRequest {
    private Integer rowNum;
    private Integer seatNum;

    public BookedSeatRequest() {
    }

    public BookedSeatRequest(Integer rowNum, Integer seatNum) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public Integer getSeatNum() {
        return seatNum;
    }
}
