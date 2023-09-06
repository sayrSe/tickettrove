package com.dream.tickettrove.controller;

import com.dream.tickettrove.service.SeatService;
import com.dream.tickettrove.service.dto.SeatLayoutResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {
    public final SeatService seatService;

    public SeatController(SeatService seatService){
        this.seatService = seatService;
    }

    @GetMapping("/{showtimeId}")
    public SeatLayoutResponse getSeatLayout(@PathVariable Integer showtimeId){
        return seatService.getSeatLayout(showtimeId);
    }
}
