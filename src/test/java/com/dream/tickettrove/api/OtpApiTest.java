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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OtpApiTest {
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
}
