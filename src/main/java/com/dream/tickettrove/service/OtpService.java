package com.dream.tickettrove.service;

import com.dream.tickettrove.repository.OtpRepository;
import com.dream.tickettrove.model.Otp;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    private final OtpRepository otpRepository;
    public OtpService(OtpRepository otpRepository){
        this.otpRepository = otpRepository;
    }

    public void generateOtpCode(String phoneNumber) {
        Random randomNumber = new Random();
        int generatedNumber = randomNumber.nextInt(999999);
        String code = String.format("%06d", generatedNumber);
        Otp otp = new Otp(phoneNumber, code);

        otpRepository.save(otp);
    }
}
