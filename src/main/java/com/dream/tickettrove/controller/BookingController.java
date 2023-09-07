package com.dream.tickettrove.controller;

import com.dream.tickettrove.service.BookingService;
import com.dream.tickettrove.service.dto.BookingRequest;
import com.dream.tickettrove.service.dto.BookingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    public final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBooking(@RequestBody BookingRequest bookingRequest){
        bookingService.createBooking(bookingRequest);
    }

    @GetMapping("/{referenceNumber}")
    public BookingResponse getBookingByReference(@PathVariable String referenceNumber){
        return bookingService.getByReference(referenceNumber);
    }
}
