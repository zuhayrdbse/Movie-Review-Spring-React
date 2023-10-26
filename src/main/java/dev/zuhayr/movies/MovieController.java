/*
There are multiple layers in REST APIs, one of the layer is the API layer of controller, its only concern is about the task of getting request from user and returning response
   |
   v
   this is exactly what happened, uses a service class and tailgating the task of fetching all the movies from the DB and giving it back to the API layer, it has no idea whats going on the service class
 */

package dev.zuhayr.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies") //this is to map it at this address and not local host 8080

public class MovieController {  // first REST API controller (prev was in dev.zuhayr.movies.MoviesApplication but this is intense)
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {  // @PathVariable is used to let the framework know that we are passing the info we got in the mapping as a path variable
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
