package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Integer> {

    List<Activity> findAllByNameContainingIgnoreCase(String name);
}
