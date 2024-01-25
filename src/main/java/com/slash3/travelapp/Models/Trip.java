package com.slash3.travelapp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
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
}