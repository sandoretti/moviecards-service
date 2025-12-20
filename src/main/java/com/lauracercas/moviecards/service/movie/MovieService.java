/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie save(Movie movie);

    Movie getMovieById(Integer movieId);

    //Añadido
    void registerActorInMovie (Integer idActor, Integer idMovie);
}
