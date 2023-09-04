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
    }

    @Test
    void should_find_all_movies() throws Exception {
        Movie movie = movieRepository.save(buildMovie());

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
    void should_find_now_showing_movies() throws Exception {
        Movie movie = movieRepository.save(buildMovie());
        showtimeRepository.save(buildNowShowtime(movie));

        mockMvc.perform(get("/movies?showing={0}", "true"))
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

    private Showtime buildNowShowtime(Movie movie) {
        Showtime showtime = new Showtime();
        showtime.setMovieId(movie.getId());
        showtime.setRoomId(1);
        showtime.setStartTime("11:00");
        showtime.setEndTime("12:30");
        showtime.setShowing(true);
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
}
