package com.slash3.travelapp.DTO;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.AppUser;

import java.util.List;

public class TripDTO {
    private Integer tripId;
    private String tripLocation;
    private String traveler;
    private List<Activity> selectedActivities;
    private List<Activity> likedActivities;

    public TripDTO(Integer tripId, String tripLocation, String traveler, List<Activity> selectedActivities, List<Activity> likedActivities) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.traveler = traveler;
        this.selectedActivities = selectedActivities;
        this.likedActivities = likedActivities;
    }
    public TripDTO(String tripLocation, String traveler, List<Activity> selectedActivities, List<Activity> likedActivities) {

        this.tripLocation = tripLocation;
        this.traveler = traveler;
        this.selectedActivities = selectedActivities;
        this.likedActivities = likedActivities;
    }

    public TripDTO(String tripLocation, String traveler) {
        this.tripLocation = tripLocation;
        this.traveler = traveler;
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

    public String getTraveler() {
        return traveler;
    }

    public void setTraveler(String traveler) {
        this.traveler = traveler;
    }

    public List<Activity> getSelectedActivities() {
        return selectedActivities;
    }

    public void setSelectedActivities(List<Activity> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    public List<Activity> getLikedActivities() {
        return likedActivities;
    }

    public void setLikedActivities(List<Activity> likedActivities) {
        this.likedActivities = likedActivities;
    }
}
