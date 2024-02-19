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

    private boolean isIndoor;

    private List<Trip> selectedTrips;

    private List<Trip> likedTrips;

    public ActivityDTO(Integer activityId, String name, String location, String description, double cost, int rating, List<Trip> trips, boolean isIndoor) {

    public ActivityDTO(Integer activityId, String name, String location, String description, double cost, int rating, List<Trip> selectedTrips, List<Trip> likedTrips) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.selectedTrips = selectedTrips;
        this.likedTrips = likedTrips;
        this.trips = trips;
        this.isIndoor = isIndoor;
    }
    public ActivityDTO(String name, String location, String description, double cost, int rating, List<Trip> selectedTrips, List<Trip> likedTrips) {
    public ActivityDTO(String name, String location, String description, double cost, int rating, List<Trip> trips, boolean isIndoor) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.trips = trips;
        this.isIndoor = isIndoor;
        this.selectedTrips = selectedTrips;
        this.likedTrips = likedTrips;
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

    public List<Trip> getSelectedTrips() {
        return selectedTrips;
    }

    public void setSelectedTrips(List<Trip> selectedTrips) {
        this.selectedTrips = selectedTrips;
    }

    public List<Trip> getLikedTrips() {
        return likedTrips;
    }

    public void setLikedTrips(List<Trip> likedTrips) {
        this.likedTrips = likedTrips;
    }
    public boolean getIsIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
}
