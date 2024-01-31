package com.slash3.travelapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Trip extends AbstractEntity {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "TripId")
//    private Integer tripId;
    @NotNull
    @Column(name = "Trip_Location")
    private String tripLocation;
    @NotNull
    @Column(name = "Traveler")
    private String traveler;

// *add list of activities when activity model is merged in*

    public Trip(Integer tripId, String tripLocation, String traveler) {
//        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.traveler = traveler;
    }
    public Trip(){}
//
//    public Integer getTripId() {
//        return tripId;
//    }
//
//    public void setTripId(Integer tripId) {
//        this.tripId = tripId;
//    }

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
}