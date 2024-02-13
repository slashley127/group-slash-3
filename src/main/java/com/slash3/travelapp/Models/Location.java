package com.slash3.travelapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationId")
    private int locationId;

//    public int nextId = 1;

    @NotNull(message = "Location name is required")
    @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
    @Column(name = "location")
    private String locationName;

    @OneToMany(mappedBy = "location")
    private List<Activity> activities;
//
//    @NotNull(message = "State Name is required")
//    @Size(min = 2, max = 100, message = "State must be between 2 and 100 characters")
//    @Column(name = "State")
//    private String state;


    public String getLocationName() {
        return locationName;
    }

    public void setLocation(String location) {
        this.locationName = locationName;
    }
}