package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.ShowtimeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeSeatRepository extends JpaRepository<ShowtimeSeat, Integer> {
    List<ShowtimeSeat> findByShowtimeId(Integer showtimeId);
}
