package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ActivityId")
    private int id;

    @Valid
    @NotNull
    @Column(name="Activity_Name")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @ManyToOne
    @NotNull(message = "Activity must have a location")
    @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
    @JoinColumn(name = "Activity_Location")
    private Location location;

    @NotNull
    @Column(name="Activity_Description")
    @Size(min = 10, message = "Description must be minimum 10 characters")
    private String description;

    @NotNull
    @Column(name="Cost")
    private double cost;

    @NotNull
    @Column(name="Rating")
    private int rating;

    @ManyToMany(mappedBy = "activities")
    private List<Trip> trips;


    public Activity(String name, Location location, String description, double cost, int rating, List<Trip> trips) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.trips = trips;
    }

    public int getId() {
        return id;
    }

    public Activity() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
