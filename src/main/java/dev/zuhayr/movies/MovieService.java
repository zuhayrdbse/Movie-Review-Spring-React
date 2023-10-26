/*
What this service class does is uses the repository class and talks to the db, get a list of the movies and returns to the API (most logic goes in the service)
 */
package dev.zuhayr.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired     //it lets the framework know that we want to instantiate this class for us, the one below
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}
