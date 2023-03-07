package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends MongoRepository<Movie,String> {
    List<Movie> findByDate(int date);
}
