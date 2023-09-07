package com.dream.tickettrove.service;

import com.dream.tickettrove.repository.OtpRepository;
import com.dream.tickettrove.model.Otp;
import com.dream.tickettrove.service.dto.OtpResponse;
import com.dream.tickettrove.service.dto.OtpVerifyResponse;
import com.dream.tickettrove.service.mapper.OtpMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public OtpVerifyResponse verifyCode(String phoneNumber, String code) {
        OtpVerifyResponse otpVerifyResponse = new OtpVerifyResponse();
        List<Otp> otps = otpRepository.findByPhoneNumber(phoneNumber);
        if(otps.size() > 0){
            List<Otp> filteredOtp = otps.stream()
                    .filter(otp -> otp.getCode().equals(code))
                    .collect(Collectors.toList());
            if(filteredOtp.size() != 0){
                otpVerifyResponse.setMatched(Boolean.TRUE);
                return otpVerifyResponse;
            }
        }

        otpVerifyResponse.setMatched(Boolean.FALSE);
        return otpVerifyResponse;
    }

    public List<OtpResponse> getOtpResponses() {
        List<Otp> otps = otpRepository.findAll();
        return otps.stream()
                .map(OtpMapper::toResponse)
                .collect(Collectors.toList());
    }
}
