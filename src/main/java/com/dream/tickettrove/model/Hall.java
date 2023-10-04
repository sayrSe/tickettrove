package com.dream.tickettrove.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cinemaId;
    private Integer hallNumber;
    private Integer maxRow;
    private Integer maxCol;

    public Hall(){
        // Empty Constructor
    }

    public Hall(Integer cinemaId, Integer hallNumber, Integer maxRow, Integer maxCol){
        this.cinemaId = cinemaId;
        this.hallNumber = hallNumber;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Integer getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
    }

    public Integer getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(Integer maxCol) {
        this.maxCol = maxCol;
    }
}
