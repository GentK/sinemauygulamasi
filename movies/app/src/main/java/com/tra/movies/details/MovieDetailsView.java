package com.gent.movies.details;

import com.gent.movies.Movie;
import com.gent.movies.Review;
import com.gent.movies.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView {
    void showDetails(Movie movie);

    void showTrailers(List<Video> trailers);

    void showReviews(List<Review> reviews);

    void showFavorited();

    void showUnFavorited();
}
