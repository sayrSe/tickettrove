package com.dream.tickettrove.service;

import com.dream.tickettrove.model.*;
import com.dream.tickettrove.repository.*;
import com.dream.tickettrove.service.dto.BookingRequest;
import com.dream.tickettrove.service.dto.BookingResponse;
import com.dream.tickettrove.service.mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookedSeatRepository bookedSeatRepository;
    private final ShowtimeRepository showtimeRepository;
    private final CinemaLocationRepository cinemaLocationRepository;
    private final HallRepository hallRepository;
    public BookingService(BookingRepository bookingRepository,
                          BookedSeatRepository bookedSeatRepository,
                          ShowtimeRepository showtimeRepository,
                          CinemaLocationRepository cinemaLocationRepository,
                          HallRepository hallRepository){
        this.bookingRepository = bookingRepository;
        this.bookedSeatRepository = bookedSeatRepository;
        this.showtimeRepository = showtimeRepository;
        this.cinemaLocationRepository = cinemaLocationRepository;
        this.hallRepository = hallRepository;
    }

    public void createBooking(BookingRequest bookingRequest) {
        Booking booking = BookingMapper.toResponse(bookingRequest);
        Booking newBooking = bookingRepository.save(booking);
        bookingRequest.getBookedSeats()
                .forEach(seat -> bookedSeatRepository.save(BookingMapper.toResponse(seat, newBooking.getId())));
    }

    public BookingResponse getByReference(String referenceNumber) {
        BookingResponse bookingResponse = new BookingResponse();
        Booking booking = bookingRepository.findByReferenceNumber(referenceNumber);
        List<BookedSeat> bookedSeats = bookedSeatRepository.findByBookingId(booking.getId());
        List<String> bookedSeatsString = bookedSeats.stream().map(this::transformValueToString).collect(Collectors.toList());

        bookingResponse.setReferenceNumber(referenceNumber);
        bookingResponse.setPhoneNumber(booking.getCustomerPhone());
        bookingResponse.setShowtimeId(booking.getShowtimeId());
        bookingResponse.setBookedSeats(bookedSeatsString);

        return bookingResponse;
    }

    private String transformValueToString(BookedSeat seat){
        String row = "";
        if(seat.getRowNum() > 26){
            row = String.valueOf((char)(seat.getRowNum() + 'A' - 1));
        }else{
            row = 'A' + String.valueOf((char)(seat.getRowNum() - 26 + 'A' - 1));
        }
        return row + seat.getSeatNum();
    }
}
