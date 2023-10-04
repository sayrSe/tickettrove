package com.dream.tickettrove.api;

import com.dream.tickettrove.model.Otp;
import com.dream.tickettrove.repository.OtpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OtpApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OtpRepository otpRepository;
    @BeforeEach
    void setUp() {
        otpRepository.deleteAll();
    }

    @Test
    void should_generate_six_digit_otp_when_post_given_phone_number () throws Exception{
        String phoneNumber = "109020295";

        mockMvc.perform(post("/otp").param("phoneNumber", phoneNumber))
                .andExpect(status().isCreated());

        List<Otp> otps = otpRepository.findByPhoneNumber(phoneNumber);
        assertNotNull(otps);
        assertEquals(1, otps.size());
        assertEquals(phoneNumber, otps.get(0).getPhoneNumber());
        assertNotNull(otps.get(0).getCode());
        assertEquals(6, otps.get(0).getCode().length());
    }

    @Test
    void should_return_true_otpVerifyResponse_when_get_given_phone_number_and_otp () throws Exception{
        String phoneNumber = "87291740271";
        String code = "192841";
        Otp otp = otpRepository.save(new Otp(phoneNumber, code));

        mockMvc.perform(get("/otp/verify")
                        .param("phoneNumber", phoneNumber)
                        .param("code", code))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.matched").value(Boolean.TRUE));
    }

    @Test
    void should_return_false_otpVerifyResponse_when_get_given_phone_number_and_otp () throws Exception{
        String phoneNumber = "10384562593";
        String correctCode = "371024";
        String wrongCode = "141267";
        Otp otp = otpRepository.save(new Otp(phoneNumber, correctCode));

        mockMvc.perform(get("/otp/verify")
                        .param("phoneNumber", phoneNumber)
                        .param("code", wrongCode))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.matched").value(Boolean.FALSE));
    }
}
