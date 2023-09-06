package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    List<Showtime> findShowtimesByMovieId(Integer id);
    List<Showtime> findByMovieId(Integer id);
}
