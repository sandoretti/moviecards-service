/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.repositories.MovieJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Imports añadidos
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.repositories.ActorJPA;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    // private final MovieJPA movieJPA;
    // public MovieServiceImpl(MovieJPA movieJPA) {
    // this.movieJPA = movieJPA;
    // }
    @Autowired
    MovieJPA movieJPA;
    @Autowired
    ActorJPA actorJPA;

    @Override
    public List<Movie> getAllMovies() {
        return movieJPA.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieJPA.save(movie);
    }

    // @Override
    // public Movie getMovieById(Integer movieId) {
    // return movieJPA.getById(movieId);
    // }
    @Override
    public Movie getMovieById(Integer movieId) {
        Optional<Movie> optional = movieJPA.findById(movieId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    // Añadido
    @Override
    public void registerActorInMovie(Integer idActor, Integer idMovie) {
        Optional<Movie> optionalMovie = movieJPA.findById(idMovie);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            Optional<Actor> optionalActor = actorJPA.findById(idActor);
            if (optionalActor.isPresent()) {
                movie.addActor(optionalActor.get());
                movieJPA.save(movie);
            }
        }
    }

}
