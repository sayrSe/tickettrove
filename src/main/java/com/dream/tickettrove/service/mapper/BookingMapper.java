package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.BookedSeat;
import com.dream.tickettrove.model.Booking;
import com.dream.tickettrove.service.dto.BookedSeatRequest;
import com.dream.tickettrove.service.dto.BookingRequest;
import org.springframework.beans.BeanUtils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class BookingMapper {
    public static Booking toResponse(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        ZonedDateTime now = ZonedDateTime.now( ZoneId.systemDefault() );
        Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());
        String referenceNumber = String.format("%012d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));

        BeanUtils.copyProperties(bookingRequest, booking);
        booking.setBookingDate(timestamp);
        booking.setReferenceNumber(referenceNumber);

        return booking;
    }

    public static BookedSeat toResponse(BookedSeatRequest bookedSeatRequest, Integer bookingId){
        BookedSeat bookedSeat = new BookedSeat();
        BeanUtils.copyProperties(bookedSeatRequest, bookedSeat);
        bookedSeat.setBookingId(bookingId);
        return bookedSeat;
    }
}
