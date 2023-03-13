package com.surojit.moviebookingapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.surojit.moviebookingapp.models.Cinema;

public interface CinemaRepo extends CrudRepository<Cinema, Integer> {
}