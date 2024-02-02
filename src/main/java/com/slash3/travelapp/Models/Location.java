package com.slash3.travelapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


public class Location {

    @OneToMany(mappedBy="location")
    @JsonBackReference
    private final List<Activity> activities = new ArrayList<>();

}
