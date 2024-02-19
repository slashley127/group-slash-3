package com.slash3.travelapp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotNull
    @Column(name="isIndoor")
    private boolean isIndoor;

    @ManyToMany(mappedBy = "activities")
    private List<Trip> trips;

    @ManyToMany(mappedBy = "selectedActivities")
    private List<Trip> selectedByTrips;

    @ManyToMany(mappedBy = "likedActivities")
    private List<Trip> likedByTrips;


    public Activity(Integer activityId, String name, String location, String description, double cost, int rating,boolean isIndoor, List<Trip> selectedByTrips, List<Trip> likedByTrips) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.isIndoor = isIndoor;
        this.selectedByTrips = selectedByTrips;
        this.likedByTrips = likedByTrips;
    }

    public int getActivityId() {
        return activityId;
    }

    public Activity() {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean IsIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public List<Trip> getTrips() {
        return trips;}

    public List<Trip> getSelectedTrips() {
        return selectedByTrips;
    }

    public void setSelectedTrips(List<Trip> selectedByTrips) {
        this.selectedByTrips = selectedByTrips;
    }

    public List<Trip> getLikedTrips() {
        return likedByTrips;
    }

    public void setLikedTrips(List<Trip> likedByTrips) {
        this.likedByTrips = likedByTrips;
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
