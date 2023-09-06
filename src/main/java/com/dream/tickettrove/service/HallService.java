package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.SeatsNotFoundException;
import com.dream.tickettrove.model.Hall;
import com.dream.tickettrove.model.Seat;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.model.ShowtimeSeat;
import com.dream.tickettrove.repository.HallRepository;
import com.dream.tickettrove.repository.SeatRepository;
import com.dream.tickettrove.repository.ShowtimeRepository;
import com.dream.tickettrove.repository.ShowtimeSeatRepository;
import com.dream.tickettrove.service.dto.HallResponse;
import com.dream.tickettrove.service.dto.SeatResponse;
import com.dream.tickettrove.service.mapper.HallMapper;
import com.dream.tickettrove.service.mapper.SeatMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    private final HallRepository hallRepository;
    private final ShowtimeSeatRepository showtimeSeatRepository;
    private final SeatRepository seatRepository;
    private final ShowtimeRepository showtimeRepository;

    public HallService(HallRepository hallRepository, ShowtimeSeatRepository showtimeSeatRepository, SeatRepository seatRepository, ShowtimeRepository showtimeRepository){
        this.hallRepository = hallRepository;
        this.showtimeSeatRepository = showtimeSeatRepository;
        this.seatRepository = seatRepository;
        this.showtimeRepository = showtimeRepository;
    }

    public HallResponse getHallLayout(Integer showtimeId){
        Integer hallId = showtimeRepository.findById(showtimeId)
                .orElseThrow(SeatsNotFoundException::new)
                .getHallId();
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(SeatsNotFoundException::new);
        List<ShowtimeSeat> showtimeSeats = showtimeSeatRepository.findByShowtimeId(showtimeId);
        List<Seat> seats = seatRepository.findByHallId(hallId);

        HallResponse hallResponse = HallMapper.toResponse(hall);
        hallResponse.setSeats(getSeats(seats, showtimeSeats));

        return hallResponse;
    }

    private List<SeatResponse> getSeats(List<Seat> seats, List<ShowtimeSeat> showtimeSeats) {
        List<SeatResponse> seatResponses = new ArrayList<>();
        int showtimeSeatIndex = 0;
        for (Seat seat : seats) {
            if (seat.getAvailable()) {
                seatResponses.add(SeatMapper.toResponse(seat, showtimeSeats.get(showtimeSeatIndex++)));
                if(showtimeSeatIndex == showtimeSeats.size()) break;
            }else{
                seatResponses.add(SeatMapper.toResponse(seat));
            }
        }
        return seatResponses;
    }
}
