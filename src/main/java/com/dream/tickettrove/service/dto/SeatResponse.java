package com.dream.tickettrove.service.dto;

import com.dream.tickettrove.model.ShowtimeSeat;

import java.util.List;

public class SeatResponse {

    private Integer id;
    private Integer gridRow;
    private Integer gridCol;
    private Integer rowNum;
    private Integer seatNum;
    private Boolean isReserved;
    private Boolean isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGridRow() {
        return gridRow;
    }

    public void setGridRow(Integer gridRow) {
        this.gridRow = gridRow;
    }

    public Integer getGridCol() {
        return gridCol;
    }

    public void setGridCol(Integer gridCol) {
        this.gridCol = gridCol;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

}
