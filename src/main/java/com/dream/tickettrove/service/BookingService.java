package com.dream.tickettrove.service;

import com.dream.tickettrove.model.Booking;
import com.dream.tickettrove.repository.BookedSeatRepository;
import com.dream.tickettrove.repository.BookingRepository;
import com.dream.tickettrove.service.dto.BookingRequest;
import com.dream.tickettrove.service.mapper.BookingMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookedSeatRepository bookedSeatRepository;
    public BookingService(BookingRepository bookingRepository, BookedSeatRepository bookedSeatRepository){
        this.bookingRepository = bookingRepository;
        this.bookedSeatRepository = bookedSeatRepository;
    }

    public void createBooking(BookingRequest bookingRequest) {
        Booking booking = BookingMapper.toResponse(bookingRequest);
        Booking newBooking = bookingRepository.save(booking);
        bookingRequest.getBookedSeats()
                .forEach(seat -> bookedSeatRepository.save(BookingMapper.toResponse(seat, newBooking.getId())));
    }
}
