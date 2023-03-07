package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    //READ
    @Autowired
    public MovieRepository repository;

    public Movie addMovie(Movie movie){
        movie.setId(UUID.randomUUID().toString());
        return repository.save(movie);
    }

    public List<Movie> findAllMovies(){
        return repository.findAll();
    }

    public Movie getMovieByMovieId(String movieId){
        return repository.findById(movieId).get();
    }

    public List<Movie> getMovieByReleaseDate(int releaseDate){
        return repository.findByDate(releaseDate);
    }

    //UPDATE
    public Movie updateMovie(Movie updatedMovie){
        Movie currentMovie = repository.findById(updatedMovie.getId()).get();
        currentMovie.setTitle(updatedMovie.getTitle());
        currentMovie.setGenres(updatedMovie.getGenres());
        currentMovie.setDate(updatedMovie.getDate());
        return repository.save(updatedMovie);
    }

    //DELETE
    public String deleteMovie(String Id){
        repository.deleteById(Id);
        return "Deleted succesfully!";
    }
}
