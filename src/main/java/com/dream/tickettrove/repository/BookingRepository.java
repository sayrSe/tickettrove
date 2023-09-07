package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findByReferenceNumber(String referenceNumber);
}
