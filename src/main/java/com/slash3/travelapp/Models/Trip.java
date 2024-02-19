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
    @Column(name = "traveler")
    private String traveler;


    @ManyToMany
    @JoinTable(
            name = "trip_activities",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> selectedActivities;

    @ManyToMany
    @JoinTable(
            name = "trip_liked_activities",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> likedActivities;

    public Trip(Integer tripId, String tripLocation, String traveler, List<Activity> selectedActivities,  List<Activity> likedActivities) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.traveler = traveler;
        this.selectedActivities = selectedActivities;
        this.likedActivities = likedActivities;
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