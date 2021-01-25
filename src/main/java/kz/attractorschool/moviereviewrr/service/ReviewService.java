package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findReviewsByMovieId(String movieId);

    List<Review> findAllByReviewerId(String reviewerId);

    List<Review> findReviewByMovieIdOrReviewerId(String movieId,String reviewerId);

    Boolean existsReviewByReviewerId(String reviewerId);

}
