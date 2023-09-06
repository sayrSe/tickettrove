package com.dream.tickettrove.api;

import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.repository.SeatRepository;
import com.dream.tickettrove.service.dto.SeatLayoutResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SeatApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SeatRepository seatRepository;
    @BeforeEach
    void setUp() {
        seatRepository.deleteAll();
    }

    @Test
    void should_return_seatLayoutResponse_when_get_given_showtimeId() throws Exception {
        List<Seat> seats = List.of(seatRepository.save(new Seat(1, 10, 1, Boolean.FALSE)));
        SeatLayoutResponse seatLayoutResponse = new SeatLayoutResponse(1, 10, seats);

        mockMvc.perform(get("/seats/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.showtimeId").value(1))
                .andExpect(jsonPath("$.maxRow").value(10))
                .andExpect(jsonPath("$.seats.length()").value(1));
    }
}
