/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.repositories.MovieJPA;
import com.lauracercas.moviecards.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

//Imports añadidos
import com.lauracercas.moviecards.service.movie.MovieService;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import java.util.Optional;

@SpringBootTest // Añadido
class MovieServiceImplTest {

    @Mock
    private MovieJPA movieJPA;
    
    // private MovieServiceImpl sut;
    @InjectMocks // auto inject movieJPA
    private MovieService sut = new MovieServiceImpl();

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = openMocks(this);
        // sut = new MovieServiceImpl();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void shouldGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        movies.add(new Movie());

        when(movieJPA.findAll()).thenReturn(movies);

        List<Movie> result = sut.getAllMovies();

        assertEquals(2, result.size());
    }

    @Test
    public void shouldGetMovieById() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Sample Movie");

        // when(movieJPA.getById(anyInt())).thenReturn(movie);
        when(movieJPA.findById(anyInt())).thenReturn(Optional.of(movie));

        Movie result = sut.getMovieById(1);

        assertEquals(1, result.getId());
        assertEquals("Sample Movie", result.getTitle());
    }

    @Test
    public void shouldSaveMovie() {
        Movie movie = new Movie();
        movie.setTitle("New Movie");

        when(movieJPA.save(movie)).thenReturn(movie);

        Movie result = sut.save(movie);

        assertEquals("New Movie", result.getTitle());
    }

}