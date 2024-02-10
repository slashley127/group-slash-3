package com.slash3.travelapp.DTO;

import com.slash3.travelapp.Models.Trip;

import java.util.List;

public class ActivityDTO {


    private Integer activityId;

    private String name;

    private String location;

    private String description;

    private double cost;

    private int rating;

    private List<Trip> trips;


    public ActivityDTO(Integer activityId, String name, String location, String description, double cost, int rating, List<Trip> trips) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.trips = trips;
    }
    public ActivityDTO(String name, String location, String description, double cost, int rating, List<Trip> trips) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.trips = trips;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public ActivityDTO() {
    }

    public void setActivityId(Integer activityId) {
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

    public Integer getRating() {
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

}
