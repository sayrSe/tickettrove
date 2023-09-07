package com.dream.tickettrove.service;

import com.dream.tickettrove.exception.MovieNotFoundException;
import com.dream.tickettrove.model.Movie;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.repository.MovieRepository;
import com.dream.tickettrove.repository.ShowtimeRepository;
import com.dream.tickettrove.service.dto.MovieResponse;
import com.dream.tickettrove.service.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ShowtimeRepository showtimeRepository;

    public MovieService(MovieRepository movieRepository, ShowtimeRepository showtimeRepository) {
        this.movieRepository = movieRepository;
        this.showtimeRepository = showtimeRepository;
    }

    public List<MovieResponse> findAllNowShowing() {
        List<Integer> nowShowingMovies = showtimeRepository.findAll().stream()
                .filter(this::isMovieShowingNow)
                .map(Showtime::getMovieId)
                .distinct()
                .collect(Collectors.toList());
        return movieRepository.findAll().stream()
                .filter(movie -> nowShowingMovies.contains(movie.getId()))
                .map(MovieMapper::toResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse findById(Integer id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        return MovieMapper.toResponse(movie);
    }

    private boolean isMovieShowingNow(Showtime showtime) {
        Date currentDate = new Date();
        return showtime.getStartTime().after(currentDate) && showtime.getEndTime().after(currentDate);
    }

    public List<Showtime> findDate(Integer id) {
        return showtimeRepository.findByMovieId(id);
    }

    public List<Showtime> getShowtimesByMovieCinemaDate(Integer id, Long cinemaId, String date) {
        return showtimeRepository.findByMovieId(id).stream()
                .filter(showtime -> cinemaId.equals(showtime.getCinemaId()))
                .sorted(Comparator.comparing(Showtime::getStartTime))
                .filter(showtime -> isShowtimeChosenDate(showtime.getStartTime(), date))
                .filter(this::isMovieShowingNow)
                .collect(Collectors.toList());
    }

    private boolean isShowtimeChosenDate(Date startTime, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(startTime).equals(date);
    }
}
