package com.slash3.travelapp.Repositories;

//import com.slash3.travelapp.Models.ActivityLite;
import com.slash3.travelapp.Models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
    public Trip findAllByTraveler(String traveler);
}
