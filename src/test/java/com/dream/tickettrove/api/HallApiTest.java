package com.dream.tickettrove.api;

import com.dream.tickettrove.model.Hall;
import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.repository.HallRepository;
import com.dream.tickettrove.repository.SeatRepository;
import com.dream.tickettrove.repository.ShowtimeRepository;
import com.dream.tickettrove.repository.ShowtimeSeatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HallApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private HallRepository hallRepository;
    @Autowired
    private ShowtimeSeatRepository showtimeSeatRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @BeforeEach
    void setUp() {
        hallRepository.deleteAll();
        showtimeSeatRepository.deleteAll();
        seatRepository.deleteAll();
    }

    @Test
    public void should_return_hallResponse_when_get_given_showtimeId() throws Exception{
        Hall hall = hallRepository.save(new Hall(1, 10, 2, 3));
        Showtime newShowtime = new Showtime();
        newShowtime.setHallId(1);
        Showtime showtime = showtimeRepository.save(newShowtime);

        seatRepository.save(new Seat(1, 1, 1, Boolean.TRUE));
        seatRepository.save(new Seat(1, 1, 2, Boolean.FALSE));
        seatRepository.save(new Seat(1, 1, 3, Boolean.TRUE));
        seatRepository.save(new Seat(1, 2, 1, Boolean.FALSE));
        seatRepository.save(new Seat(1, 2, 2, Boolean.TRUE));

        ShowtimeSeat first = showtimeSeatRepository.save(new ShowtimeSeat(1, 1, 1, Boolean.TRUE));
        showtimeSeatRepository.save(new ShowtimeSeat(1, 1, 2, Boolean.FALSE));
        showtimeSeatRepository.save(new ShowtimeSeat(1,2,1, Boolean.TRUE));

        mockMvc.perform(get("/showtimes/{showtimeId}/halls", showtime.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hallNumber").value(10))
                .andExpect(jsonPath("$.maxRow").value(2))
                .andExpect(jsonPath("$.maxCol").value(3))
                .andExpect(jsonPath("$.seats.length()").value(5))
                .andExpect(jsonPath("$.seats[0].id").value(first.getId()))
                .andExpect(jsonPath("$.seats[0].gridRow").value(1))
                .andExpect(jsonPath("$.seats[0].gridCol").value(1))
                .andExpect(jsonPath("$.seats[0].rowNum").value(1))
                .andExpect(jsonPath("$.seats[0].seatNum").value(1))
                .andExpect(jsonPath("$.seats[0].reserved").value(Boolean.TRUE))
                .andExpect(jsonPath("$.seats[0].available").value(Boolean.TRUE));
    }
}
