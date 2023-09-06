package com.dream.tickettrove.api;

import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.repository.CinemaLocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CinemaApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CinemaLocationRepository cinemaLocationRepository;

    @BeforeEach
    void setUp() {
        cinemaLocationRepository.deleteAll();
    }

    @Test
    void should_return_all_cinemas_when_perform_get_given_all_cinemas() throws Exception{
        //given
        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(new Cinema(1L, "Cinema 1", "Address 1"));
        cinemas.add(new Cinema(2L, "Cinema 2", "Address 2"));
         //when
        when(cinemaLocationRepository.findAll()).thenReturn(cinemas);
         //then
        mockMvc.perform(MockMvcRequestBuilders.get("/cinemas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Cinema 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Cinema 2"));
    }
    
    @Test
    void should_return_cinema_by_id_when_perform_get_given_cinema_id() throws Exception {
        //given
        Long cinemaId = 1L;
        Cinema cinema = new Cinema(cinemaId, "Cinema 1", "Address 1");
        //when
        when(cinemaLocationRepository.findById(cinemaId)).thenReturn(Optional.of(cinema));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/cinemas/{id}", cinemaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(cinemaId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Cinema 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Address 1"));
    }
}
