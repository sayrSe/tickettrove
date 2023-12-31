package com.dream.tickettrove.controller;

import com.dream.tickettrove.service.OtpService;
import com.dream.tickettrove.service.dto.OtpResponse;
import com.dream.tickettrove.service.dto.OtpVerifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otp")
public class OtpController {
    private final OtpService otpService;
    @Autowired
    public OtpController(OtpService otpService){
        this.otpService = otpService;
    }

    @PostMapping(params = {"phoneNumber"})
    @ResponseStatus(HttpStatus.CREATED)
    public void generateOtpCode(@RequestParam String phoneNumber){
        otpService.generateOtpCode(phoneNumber);
    }

    @GetMapping(value="/verify", params={"phoneNumber", "code"})
    public OtpVerifyResponse verifyCode(@RequestParam String phoneNumber, @RequestParam String code){
        return otpService.verifyCode(phoneNumber, code);
    }

    @GetMapping
    public List<OtpResponse> getOtpResponses(){
        return otpService.getOtpResponses();
    }
}
