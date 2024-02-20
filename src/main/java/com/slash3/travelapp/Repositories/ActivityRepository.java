package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Integer> {
    public Activity findAllByLocation(String location);
}
