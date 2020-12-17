package com.gent.movies.favorites;

import com.gent.movies.Movie;

import java.util.List;

/**
 * @author arun
 */
public interface FavoritesInteractor {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
