package com.dream.tickettrove.service.dto;

import java.util.List;

public class BookingRequest {
    private Integer showtimeId;
    private String customerPhone;
    private List<BookedSeatRequest> bookedSeats;

    public BookingRequest() {
    }

    public BookingRequest(Integer showtimeId, String customerPhone, List<BookedSeatRequest> bookedSeats) {
        this.showtimeId = showtimeId;
        this.customerPhone = customerPhone;
        this.bookedSeats = bookedSeats;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public List<BookedSeatRequest> getBookedSeats() {
        return bookedSeats;
    }
}
