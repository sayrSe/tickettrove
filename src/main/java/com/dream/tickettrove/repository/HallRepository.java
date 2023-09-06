package com.dream.tickettrove.repository;

import com.dream.tickettrove.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {

}
