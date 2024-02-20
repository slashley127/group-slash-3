package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.ActivityLite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActivityLiteRepository extends CrudRepository<ActivityLite, Integer> {
    @Query("SELECT DISTINCT a  FROM ActivityLite a")
    public List<ActivityLite> findAllDistinctNamedActivities();
}
