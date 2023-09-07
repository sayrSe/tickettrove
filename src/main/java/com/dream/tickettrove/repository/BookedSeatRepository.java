package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, Integer> {
    List<BookedSeat> findByBookingId(Integer id);
}
