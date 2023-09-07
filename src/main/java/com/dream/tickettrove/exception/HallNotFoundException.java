package com.dream.tickettrove.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HallNotFoundException extends RuntimeException {
    public HallNotFoundException() {
        super("Hall not found.");
    }
}