package com.dream.tickettrove.api;

import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.repository.ShowtimeSeatRepository;
import com.dream.tickettrove.service.dto.ShowtimeSeatLayoutResponse;
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
public class ShowtimeShowtimeSeatApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ShowtimeSeatRepository showtimeSeatRepository;
    @BeforeEach
    void setUp() {
        showtimeSeatRepository.deleteAll();
    }

    @Test
    void should_return_seatLayoutResponse_when_get_given_showtimeId() throws Exception {
        List<ShowtimeSeat> showtimeSeats = List.of(showtimeSeatRepository.save(new ShowtimeSeat(1, 10, 1, Boolean.FALSE)));
        ShowtimeSeatLayoutResponse showtimeSeatLayoutResponse = new ShowtimeSeatLayoutResponse(1, 10, showtimeSeats);

        mockMvc.perform(get("/seats/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.showtimeId").value(1))
                .andExpect(jsonPath("$.maxRow").value(10))
                .andExpect(jsonPath("$.seats.length()").value(1));
    }
}
