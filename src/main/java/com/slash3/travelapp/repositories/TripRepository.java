package com.slash3.travelapp.repositories;

import com.slash3.travelapp.models.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Integer> {
}
