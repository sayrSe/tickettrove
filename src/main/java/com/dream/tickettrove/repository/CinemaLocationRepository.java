package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.CinemaLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaLocationRepository extends JpaRepository<CinemaLocation, Long> {

}
