package com.dream.tickettrove.service.mapper;

import com.dream.tickettrove.model.Hall;
import com.dream.tickettrove.service.dto.HallResponse;
import org.springframework.beans.BeanUtils;

public class HallMapper {

    private HallMapper() {
        // Empty Constructor
    }

    public static HallResponse toResponse(Hall hall){
        HallResponse hallResponse = new HallResponse();
        BeanUtils.copyProperties(hall, hallResponse);
        return hallResponse;
    }
}
