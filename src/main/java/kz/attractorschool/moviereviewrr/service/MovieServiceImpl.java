package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie findByTitle(String title) {
        var movie = movieRepository.findMovieByTitle(title);
        if (!movie.isPresent()) {
            throw new RuntimeException("no movie with title: " + title);
        }
        return movie.get();
    }

    @Override
    public List<Movie> findByReleaseYear(int releaseYear) {
        var movies = movieRepository.findMoviesByReleaseYear(releaseYear);
        if (!movies.isPresent()) {
            throw new RuntimeException("no movies with releaseYear: " + releaseYear);
        }
        return movies.get();
    }

    @Override
    public List<Movie> findByActor(String actor) {
        var movies = movieRepository.findMoviesByActorsContaining(actor);
        if (!movies.isPresent()) {
            throw new RuntimeException("no movies with actor: " + actor);
        }
        return movies.get();

    }

    @Override
    public List<Movie> findByRating(double rating) {
        var movies = movieRepository.findMoviesByRating(rating);
        if (!movies.isPresent()) {
            throw new RuntimeException("no movies with rating: " + rating);
        }
        return movies.get();
    }

    @Override
    public Page<Movie> findByPaginatedAndSorted(int pageNo, int pageSize,
                                                String sortField, String sortDirection) {

        Sort sort = sortDirection
                .equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pag = PageRequest.of(pageNo - 1, pageSize, sort);
        return movieRepository.findAll(pag);
    }
}
