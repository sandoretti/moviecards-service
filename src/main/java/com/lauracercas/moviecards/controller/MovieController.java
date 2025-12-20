/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.controller;

//import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
//import com.lauracercas.moviecards.util.Messages;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

//Imports añadidos
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
@RestController
public class MovieController {

    // private final MovieService movieService;
    // public MovieController(MovieService movieService) {
    // this.movieService = movieService;
    // }
    @Autowired
    MovieService movieService;

    // @GetMapping("movies")
    // public String getMoviesList(Model model) {
    // model.addAttribute("movies", movieService.getAllMovies());
    // return "movies/list";
    // }
    @GetMapping("/movies")
    public List<Movie> getMoviesList() {
        return (movieService.getAllMovies());
    }

    // @GetMapping("movies/new")
    // public String newMovie(Model model) {
    // model.addAttribute("movie", new Movie());
    // model.addAttribute("title", Messages.NEW_MOVIE_TITLE);
    // return "movies/form";
    // }
    @PostMapping("/movies")
    public void newMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    // @PostMapping("saveMovie")
    // public String saveMovie(@ModelAttribute Movie movie, BindingResult result,
    // Model model) {
    // if (result.hasErrors()) {
    // return "movies/form";
    // }
    // Movie movieSaved = movieService.save(movie);
    // if (movieSaved.getId() != null) {
    // model.addAttribute("message", Messages.UPDATED_MOVIE_SUCCESS);
    // } else {
    // model.addAttribute("message", Messages.SAVED_MOVIE_SUCCESS);
    // }
    // model.addAttribute("movie", movieSaved);
    // model.addAttribute("title", Messages.EDIT_MOVIE_TITLE);
    // return "movies/form";
    // }
    @PutMapping("/movies")
    public void saveMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    // @GetMapping("editMovie/{movieId}")
    // public String editMovie(@PathVariable Integer movieId, Model model) {
    // Movie movie = movieService.getMovieById(movieId);
    // List<Actor> actors = movie.getActors();
    // model.addAttribute("movie", movie);
    // model.addAttribute("actors", actors);
    // model.addAttribute("title", Messages.EDIT_MOVIE_TITLE);
    // return "movies/form";
    // }
    @GetMapping("movies/{movieId}")
    public Movie editMovie(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

    // Añadido
    @GetMapping("/movies/insc/{idActor}/{idMovie}")
    public void registerCard(@PathVariable("idActor") Integer idActor, @PathVariable("idMovie") Integer idMovie) {
        movieService.registerActorInMovie(idActor, idMovie);
    }

}
