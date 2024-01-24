package com.slash3.travelapp.data;

import com.slash3.travelapp.models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Integer> {
}
