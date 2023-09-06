package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaLocationRepository extends JpaRepository<Cinema, Long> {

}
