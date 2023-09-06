package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.ResourceNotFoundException;
import com.dream.tickettrove.model.Cinema;
import com.dream.tickettrove.repository.CinemaLocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CinemaServiceTest {
    @InjectMocks
    private CinemaService cinemaService;
    @Mock
    private CinemaLocationRepository cinemaLocationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_return_all_cinemas_when_get_given_all_cinemas() {
        //given
        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(new Cinema(1L, "Address 1"));
        cinemas.add(new Cinema(2L, "Address 2"));
         //when
        when(cinemaLocationRepository.findAll()).thenReturn(cinemas);
         //then
        List<Cinema> result = cinemaService.getAllCinemas();

        assertEquals(cinemas.size(), result.size());
        assertEquals(cinemas, result);
    }

    @Test
    void should_return_cinema_by_id_when_get_given_cinema_id() {
        //given
         Long id = 1L;
         Cinema cinema = new Cinema(id, "Address 1");
         //when
        when(cinemaLocationRepository.findById(id)).thenReturn(Optional.of(cinema));
         //then
        Cinema result = cinemaService.getCinemaById(id);

        assertNotNull(result);
        assertEquals(cinema, result);
    }

    @Test
    void should_throw_exception_not_found_when_get_given_cinema_id() {
        //given
        Long id = 1L;
         //when
        when(cinemaLocationRepository.findById(id)).thenReturn(Optional.empty());
         //then
        assertThrows(ResourceNotFoundException.class, () -> cinemaService.getCinemaById(id));
    }
}
