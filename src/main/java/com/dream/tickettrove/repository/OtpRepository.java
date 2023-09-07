package com.dream.tickettrove.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dream.tickettrove.model.Otp;

import java.util.List;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {
    List<Otp> findByPhoneNumber(String phoneNumber);
}
