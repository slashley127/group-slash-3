package com.slash3.travelapp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Integer tripId;
    @NotNull
    @Column(name = "trip_location")
    private String tripLocation;
    @NotNull
    @Column(name = "travelers")
    private List<AppUser> travelers;
    @ManyToMany
    @JoinTable(
            name = "trip_activities",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

// *add list of activities when activity model is merged in*

    public Trip(Integer tripId, String tripLocation, List<AppUser> travelers, List<Activity> activities) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.travelers = travelers;
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

    public List<AppUser> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<AppUser> travelers) {
        this.travelers = travelers;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}