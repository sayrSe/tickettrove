package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Otp;
import com.dream.tickettrove.service.dto.OtpResponse;
import org.springframework.beans.BeanUtils;

public class OtpMapper {
    public static OtpResponse toResponse(Otp otp){
        OtpResponse otpResponse = new OtpResponse();
        BeanUtils.copyProperties(otp, otpResponse);
        return otpResponse;
    }
}
