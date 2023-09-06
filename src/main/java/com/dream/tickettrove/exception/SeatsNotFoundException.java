package com.dream.tickettrove.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeatsNotFoundException extends RuntimeException{
    public SeatsNotFoundException(){
        super("Seats of Showtime ID Not found.");
    }
}
