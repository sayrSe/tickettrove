package com.dream.tickettrove.controller;

import com.dream.tickettrove.service.ShowtimeSeatService;
import com.dream.tickettrove.service.dto.ShowtimeSeatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class ShowtimeSeatController {
    public final ShowtimeSeatService showtimeSeatService;

    public ShowtimeSeatController(ShowtimeSeatService showtimeSeatService){
        this.showtimeSeatService = showtimeSeatService;
    }

    @GetMapping("/{showtimeId}")
    public ShowtimeSeatResponse getSeatLayout(@PathVariable Integer showtimeId){
        return showtimeSeatService.getSeatLayout(showtimeId);
    }
}
