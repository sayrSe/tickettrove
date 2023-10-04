package com.dream.tickettrove.controller;

import com.dream.tickettrove.service.HallService;
import com.dream.tickettrove.service.dto.HallResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HallController {
    public final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping("/showtimes/{showtimeId}/halls")
    public HallResponse getHallLayout(@PathVariable Integer showtimeId) {
        return hallService.getHallLayout(showtimeId);
    }
}

