package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {
    Movie findByTitle(String title);

    List<Movie> findByReleaseYear(int releaseYear);

    List<Movie> findByActor(String actor);

    List<Movie> findByRating(double rating);

    Page<Movie> findByPaginatedAndSorted(int pageNo, int pageSize, String sortField, String sortDirection);
}
