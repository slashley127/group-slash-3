package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Table
@Entity
@Data
public class Trip {

    @Id
    @GeneratedValue
    @Column(name = "TripId")
    private Integer tripId;

    @NotNull
    @Column(name = "Trip_Location")
    private String tripLocation;
    @NotNull
    @Column(name = "Traveler")
    private String traveler;

// *add list of activities when activity model is merged in*

    public Trip(Integer tripId, String tripLocation, String traveler) {
        this.tripId = tripId;
        this.tripLocation = tripLocation;
        this.traveler = traveler;
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
}