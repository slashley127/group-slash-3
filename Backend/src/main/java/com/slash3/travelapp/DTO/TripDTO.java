package com.slash3.travelapp.DTO;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.AppUser;

import java.util.List;

public class TripDTO {
    private Integer tripId;
    private String tripLocation;
    private List<AppUser> travelers;
    private List<Activity> activities;

    public TripDTO(Integer tripId, String tripLocation, List<AppUser> travelers, List<Activity> activities) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.travelers = travelers;
        this.activities = activities;
    }
    public TripDTO(String tripLocation, List<AppUser> travelers, List<Activity> activities) {

        this.tripLocation = tripLocation;
        this.travelers = travelers;
        this.activities = activities;
    }
    public TripDTO(){};

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

    public void setTraveler(List<AppUser> travelers) {
        this.travelers = travelers;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
