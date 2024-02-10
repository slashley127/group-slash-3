package com.slash3.travelapp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    @Column(name="activity_id")
    private Integer activityId;
    @NotNull
    @Column(name="name")
    private String name;
    @NotNull
    @Column(name="location")
    private String location;
    @NotNull
    @Column(name="description")
    private String description;
    @NotNull
    @Column(name="cost")
    private double cost;
    @NotNull
    @Column(name="rating")
    private int rating;
    @ManyToMany(mappedBy = "activities")
    private List<Trip> trips;


    public Activity(Integer activityId, String name, String location, String description, double cost, int rating, List<Trip> trips) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.trips = trips;
    }

    public int getActivityId() {
        return activityId;
    }

    public Activity() {
    }

    public void setActivityId(Integer activityIdd) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
        return activityId == activity.activityId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
