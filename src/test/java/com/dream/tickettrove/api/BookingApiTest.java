package com.dream.tickettrove.api;

import com.dream.tickettrove.model.BookedSeat;
import com.dream.tickettrove.model.Booking;
import com.dream.tickettrove.repository.BookedSeatRepository;
import com.dream.tickettrove.repository.BookingRepository;
import com.dream.tickettrove.service.BookingService;
import com.dream.tickettrove.service.dto.BookingRequest;
import com.dream.tickettrove.service.dto.BookedSeatRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookingApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookedSeatRepository bookedSeatRepository;
    @Autowired
    private BookingService bookingService;
    @BeforeEach
    void setup(){
        bookingRepository.deleteAll();
        bookedSeatRepository.deleteAll();
    }

    @Test
    void should_create_booking_when_post_given_showtimeId_and_phoneNumber () throws Exception{
        Integer showtimeId = 1;
        String phoneNumber = "28104729281";
        List<BookedSeatRequest> bookedSeatRequests = List.of(new BookedSeatRequest(1, 1), new BookedSeatRequest(1, 2), new BookedSeatRequest(1, 3));
        BookingRequest bookingRequest = new BookingRequest(showtimeId, phoneNumber, bookedSeatRequests);

        mockMvc.perform(post("/booking")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(bookingRequest)))
                .andExpect(status().isCreated());

        List<Booking> bookings = bookingRepository.findAll();
        assertNotNull(bookings);
        assertEquals(1, bookings.size());
        assertEquals(showtimeId, bookings.get(0).getShowtimeId());
        assertEquals(phoneNumber, bookings.get(0).getCustomerPhone());
        assertNotNull(bookings.get(0).getBookingDate());
        assertNotNull(bookings.get(0).getReferenceNumber());

        List<BookedSeat> bookedSeats = bookedSeatRepository.findAll();
        assertNotNull(bookedSeats);
        assertEquals(3, bookedSeats.size());
        assertEquals(bookings.get(0).getId(), bookedSeats.get(0).getBookingId());
        assertEquals(1, bookedSeats.get(0).getRowNum());
        assertEquals(1, bookedSeats.get(0).getSeatNum());
    }

    @Test
    void should_return_bookingResponse_when_get_given_referenceNumber() throws Exception {
        Integer showtimeId = 1;
        String phoneNumber = "28104729281";
        List<BookedSeatRequest> bookedSeatRequests = List.of(new BookedSeatRequest(1, 1), new BookedSeatRequest(1, 2), new BookedSeatRequest(1, 3));
        BookingRequest bookingRequest = new BookingRequest(showtimeId, phoneNumber, bookedSeatRequests);

        bookingService.createBooking(bookingRequest);
        List<Booking> bookings = bookingRepository.findAll();
        List<BookedSeat> bookedSeats = bookedSeatRepository.findAll();
        String referenceNumber = bookings.get(0).getReferenceNumber();

        mockMvc.perform(get("/booking/"+ referenceNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.referenceNumber").value(referenceNumber))
                .andExpect(jsonPath("$.showtimeId").exists())
                .andExpect(jsonPath("$.phoneNumber").exists())
                .andExpect(jsonPath("$.bookedSeats").exists());
    }
}
