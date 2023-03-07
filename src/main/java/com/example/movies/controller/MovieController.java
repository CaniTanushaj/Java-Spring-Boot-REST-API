package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    public MovieService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }

    @GetMapping
    public List<Movie> findAllMovies(){
        return service.findAllMovies();
    }


    @GetMapping("/dates/{date}")
    public List<Movie> findMovieByReleaseDate(@PathVariable int releaseDate){
        return service.getMovieByReleaseDate(releaseDate);
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable String movieId){
        return service.getMovieByMovieId(movieId);
    }

    @PutMapping
    public Movie modifyMovie(@RequestBody Movie movie){
        return service.updateMovie(movie);
    }

    @DeleteMapping("/{Id}")
    public String deleteMovie(@PathVariable String Id){
        return service.deleteMovie(Id);
    }
}
