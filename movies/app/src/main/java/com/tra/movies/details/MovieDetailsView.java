package com.tra.movies.details;

import com.tra.movies.Movie;
import com.tra.movies.Review;
import com.tra.movies.Video;

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
