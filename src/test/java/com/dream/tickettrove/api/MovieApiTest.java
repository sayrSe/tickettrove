package com.dream.tickettrove.api;

import com.dream.tickettrove.model.Movie;
import com.dream.tickettrove.model.Showtime;
import com.dream.tickettrove.repository.MovieRepository;
import com.dream.tickettrove.repository.ShowtimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
        showtimeRepository.deleteAll();
    }

    @Test
    void should_find_now_showing_movies() throws Exception {
        Movie movie = movieRepository.save(buildMovie());
        Movie pastMovie = movieRepository.save(buildPastMovie());
        showtimeRepository.save(buildNowShowtime(movie));
        showtimeRepository.save(buildPastShowtime(pastMovie));

        mockMvc.perform(get("/movies"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(movie.getId()))
                .andExpect(jsonPath("$[0].title").value(movie.getTitle()))
                .andExpect(jsonPath("$[0].poster").value(movie.getPoster()))
                .andExpect(jsonPath("$[0].synopsis").value(movie.getSynopsis()))
                .andExpect(jsonPath("$[0].shortDescription").value(movie.getShortDescription()))
                .andExpect(jsonPath("$[0].releaseDate").value(movie.getReleaseDate()))
                .andExpect(jsonPath("$[0].runtime").value(movie.getRuntime()))
                .andExpect(jsonPath("$[0].rating").value(movie.getRating()))
                .andExpect(jsonPath("$[0].director").value(movie.getDirector()))
                .andExpect(jsonPath("$[0].actors").value(movie.getActors()))
                .andExpect(jsonPath("$[0].showtimes").doesNotExist());
    }

    @Test
    void should_find_movie_by_id() throws Exception {
        Movie movie = movieRepository.save(buildMovie());

        mockMvc.perform(get("/movies/{id}", movie.getId()))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(movie.getId()))
                .andExpect(jsonPath("$.title").value(movie.getTitle()))
                .andExpect(jsonPath("$.poster").value(movie.getPoster()))
                .andExpect(jsonPath("$.synopsis").value(movie.getSynopsis()))
                .andExpect(jsonPath("$.shortDescription").value(movie.getShortDescription()))
                .andExpect(jsonPath("$.releaseDate").value(movie.getReleaseDate()))
                .andExpect(jsonPath("$.runtime").value(movie.getRuntime()))
                .andExpect(jsonPath("$.rating").value(movie.getRating()))
                .andExpect(jsonPath("$.director").value(movie.getDirector()))
                .andExpect(jsonPath("$.actors").value(movie.getActors()))
                .andExpect(jsonPath("$.showtimes").doesNotExist());
    }

    @Test
    void should_find_showtimes_by_movies() throws Exception {
        Movie movie = movieRepository.save(buildMovie());
        Showtime nowShowtime = showtimeRepository.save(buildNowShowtime(movie));
        showtimeRepository.save(buildPastShowtime(movie));

        SimpleDateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));

        mockMvc.perform(get("/movies/{id}/showtimes", movie.getId()))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(nowShowtime.getId()))
                .andExpect(jsonPath("$[0].movieId").value(nowShowtime.getMovieId()))
                .andExpect(jsonPath("$[0].hallId").value(nowShowtime.getHallId()))
                .andExpect(jsonPath("$[0].startTime").value(iso8601Format.format(nowShowtime.getStartTime()) + "+00:00"))
                .andExpect(jsonPath("$[0].endTime").value(iso8601Format.format(nowShowtime.getEndTime()) + "+00:00"))
                .andExpect(jsonPath("$[0].showtimes").doesNotExist());
    }

    private Showtime buildNowShowtime(Movie movie) throws ParseException {
        Showtime showtime = new Showtime();
        showtime.setMovieId(movie.getId());
        showtime.setHallId(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        showtime.setStartTime(dateFormat.parse("2023-12-12 15:00:00"));
        showtime.setEndTime(dateFormat.parse("2023-12-12 17:00:00"));
        return showtime;
    }

    private Showtime buildPastShowtime(Movie movie) throws ParseException {
        Showtime showtime = new Showtime();
        showtime.setMovieId(movie.getId());
        showtime.setHallId(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        showtime.setStartTime(dateFormat.parse("1999-09-10 15:00:00"));
        showtime.setEndTime(dateFormat.parse("1999-09-10 17:00:00"));
        return showtime;
    }

    private Movie buildMovie() {
        Movie movie = new Movie();
        movie.setTitle("Movie 1");
        movie.setPoster("/image.png");
        movie.setSynopsis("There was once a test.");
        movie.setShortDescription("This is a movie");
        movie.setReleaseDate("2023-01-15");
        movie.setRuntime(120);
        movie.setRating("PG-13");
        movie.setDirector("John Smith");
        movie.setActors("Robert Downey, Chris Evans");
        return movie;
    }

    private Movie buildPastMovie() {
        Movie movie = new Movie();
        movie.setTitle("Movie 2");
        movie.setPoster("/image.png");
        movie.setSynopsis("There was once a test.");
        movie.setShortDescription("This is a movie");
        movie.setReleaseDate("2023-01-15");
        movie.setRuntime(120);
        movie.setRating("PG-13");
        movie.setDirector("John Smith");
        movie.setActors("Robert Downey, Chris Evans");
        return movie;
    }
}
