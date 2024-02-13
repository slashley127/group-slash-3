package com.slash3.travelapp.repositories;

import com.slash3.travelapp.models.Activity;
import com.slash3.travelapp.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
}