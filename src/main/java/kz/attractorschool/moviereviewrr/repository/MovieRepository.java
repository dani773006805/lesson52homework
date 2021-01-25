package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> , PagingAndSortingRepository<Movie,String> {
    Optional<Movie> findMovieByTitle(String title);

    Optional<List<Movie>> findAllByPoster(String poster);

    Optional<List<Movie>> findMoviesByReleaseYear(int year);

    Optional<List<Movie>> findAllByReleaseYearBetween(int start, int end);

    Optional<List<Movie>> findMoviesByActorsContaining(String actor);

    Optional<List<Movie>> findMoviesByDirectorsContaining(String director);

    Optional<List<Movie>> findMoviesByRating(Double rating);

    @Query("{'title':{'$regex':'?0','$options':'i'}}")
    Optional<List<Movie>> findByRegex(String regex);

}
