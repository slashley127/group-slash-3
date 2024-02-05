package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Integer> {
}
