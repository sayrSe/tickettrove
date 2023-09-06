package com.dream.tickettrove.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer showtimeId;
    private Integer rowNum;
    private Integer seatNum;
    private Boolean isReserved;

    public Seat(){

    }

    public Seat(Integer showtimeId, Integer rowNum, Integer seatNum, Boolean isReserved){
        this.showtimeId = showtimeId;
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.isReserved = isReserved;
    }

    public Integer getId() {
        return id;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }
}
