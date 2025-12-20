/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.unittest.controller;

import com.lauracercas.moviecards.controller.MovieController;
//import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
//import com.lauracercas.moviecards.util.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class MovieControllerTest {

    // @Mock
    // MovieService movieServiceMock;
    @Mock
    MovieService movieService;

    // private MovieController controller;
    @InjectMocks // auto inject movieService
    private MovieController controller = new MovieController();

    private AutoCloseable closeable;

    // @Mock
    // private Model model;

    @BeforeEach
    void setUp() {
        closeable = openMocks(this);
        // controller = new MovieController(movieServiceMock);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void shouldGoListMovieAndGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie()); // Añadir
        movies.add(new Movie()); // Añadir

        // when(movieServiceMock.getAllMovies()).thenReturn(movies);
        when(movieService.getAllMovies()).thenReturn(movies);

        // String viewName = controller.getMoviesList(model);
        List<Movie> result = controller.getMoviesList();

        // assertEquals("movies/list", viewName);
        assertEquals(2, result.size());
    }

    // @Test
    // public void shouldInitializeMovie() {
    // String viewName = controller.newMovie(model);
    // assertEquals("movies/form", viewName);
    // verify(model).addAttribute("movie", new Movie());
    // verify(model).addAttribute("title", Messages.NEW_MOVIE_TITLE);
    // }

    // @Test
    // public void shouldSaveMovieWithNoErrors() {
    // Movie movie = new Movie();
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(false);
    // when(movieServiceMock.save(any(Movie.class))).thenReturn(movie);
    // String viewName = controller.saveMovie(movie, result, model);
    // assertEquals("movies/form", viewName);
    // verify(model).addAttribute("movie", movie);
    // verify(model).addAttribute("title", Messages.EDIT_MOVIE_TITLE);
    // verify(model).addAttribute("message", Messages.SAVED_MOVIE_SUCCESS);
    // }

    // @Test
    // public void shouldUpdateMovieWithNoErrors() {
    // Movie movie = new Movie();
    // movie.setId(1);
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(false);
    // when(movieServiceMock.save(any(Movie.class))).thenReturn(movie);
    // String viewName = controller.saveMovie(movie, result, model);
    // assertEquals("movies/form", viewName);
    // verify(model).addAttribute("movie", movie);
    // verify(model).addAttribute("title", Messages.EDIT_MOVIE_TITLE);
    // verify(model).addAttribute("message", Messages.UPDATED_MOVIE_SUCCESS);
    // }

    // @Test
    // public void shouldTrySaveMovieWithErrors() {
    // Movie movie = new Movie();
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(true);
    // String viewName = controller.saveMovie(movie, result, model);
    // assertEquals("movies/form", viewName);
    // verifyNoInteractions(model);
    // }

    @Test
    public void shouldGoToEditMovie() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Sample Movie"); // Añadido

        // List<Actor> actors = List.of(new Actor());
        // movie.setActors(actors);
        // when(movieServiceMock.getMovieById(movie.getId())).thenReturn(movie);
        when(movieService.getMovieById(movie.getId())).thenReturn(movie);

        // String viewName = controller.editMovie(movie.getId(), model);
        Movie result = controller.editMovie(1);

        // assertEquals("movies/form", viewName);
        assertEquals(1, result.getId());
        assertEquals("Sample Movie", result.getTitle());

        // verify(model).addAttribute("movie", movie);
        // verify(model).addAttribute("actors", actors);
        // verify(model).addAttribute("title", Messages.EDIT_MOVIE_TITLE);
    }

}