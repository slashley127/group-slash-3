package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
//import lombok.Data;
import com.slash3.travelapp.models.Activity;
import jdk.jfr.DataAmount;

import java.util.List;


@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Integer tripId;

    @NotNull
    @Column(name = "trip_location")
    private String tripLocation;

    @NotNull
    @Column(name = "traveler")
    private String traveler;

    @ManyToMany
    @JoinTable(
            name = "trip_activities",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

// *add list of activities when activity model is merged in*

    public Trip(Integer tripId, String tripLocation, String traveler, List<Activity> activities) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.traveler = traveler;
        this.activities = activities;
    }
    public Trip(){}

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripLocation() {
        return tripLocation;
    }

    public void setTripLocation(String tripLocation) {
        this.tripLocation = tripLocation;
    }

    public String getTraveler() {
        return traveler;
    }

    public void setTraveler(String traveler) {
        this.traveler = traveler;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}