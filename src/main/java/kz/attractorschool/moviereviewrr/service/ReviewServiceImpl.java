package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findReviewsByMovieId(String movieId) {
        if (reviewRepository.findReviewsByMovieId(movieId).isEmpty()) {
            throw new RuntimeException("no reviews");
        }
        return reviewRepository.findReviewsByMovieId(movieId).get();
    }

    @Override
    public List<Review> findAllByReviewerId(String reviewerId) {
        if (reviewRepository.findAllByReviewerId(reviewerId).isEmpty()) {
            throw new RuntimeException("no review with reviewer Id: " + reviewerId);
        }
        return reviewRepository.findAllByReviewerId(reviewerId).get();
    }


    @Override
    public List<Review> findReviewByMovieIdOrReviewerId(String movieId, String reviewerId) {
        if (reviewRepository.findReviewByMovieIdOrReviewerId(movieId, reviewerId).isEmpty()) {
            throw new RuntimeException("no review");
        }
        return reviewRepository.findReviewByMovieIdOrReviewerId(movieId, reviewerId).get();
    }

    @Override
    public Boolean existsReviewByReviewerId(String reviewerId) {
        return reviewRepository.existsReviewByReviewerId(reviewerId);
    }
}
