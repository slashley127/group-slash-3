package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.Traveler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends CrudRepository<Traveler, Integer> {
}
