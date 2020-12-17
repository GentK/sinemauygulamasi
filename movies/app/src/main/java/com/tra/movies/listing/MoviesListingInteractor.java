package com.gent.movies.listing;

import com.gent.movies.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor {
    boolean isPaginationSupported();

    Observable<List<Movie>> fetchMovies(int page);

    Observable<List<Movie>> searchMovie(String searchQuery);
}
