package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
    Optional<List<Review>> findReviewsByMovieId(String movieId);

    Optional<List<Review>> findAllByReviewerId(String reviewerId);

    Optional<List<Review>> findReviewsByStars(int star);

    Optional<List<Review>> findReviewByMovieIdOrReviewerId(String movieId,String reviewId);

    Boolean existsReviewByReviewerId(String reviewerId);

}
