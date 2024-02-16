package com.slash3.travelapp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="activity_id",columnDefinition = "INT(11) NOT NULL UNIQUE INDEX")
    @Column(name="activity_id")
    private Integer activityId;
    @NotNull
    @Column(name="name")
    private String name;

//    @ManyToOne
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

    @ManyToMany(mappedBy = "selectedActivities")
    private List<Trip> selectedByTrips;

    @ManyToMany(mappedBy = "likedActivities")
    private List<Trip> likedByTrips;


    public Activity(Integer activityId, String name, String location, String description, double cost, int rating, List<Trip> selectedByTrips, List<Trip> likedByTrips) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
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

    public List<Trip> getSelectedByTrips() {
        return selectedByTrips;
    }

    public void setSelectedByTrips(List<Trip> selectedByTrips) {
        this.selectedByTrips = selectedByTrips;
    }

    public List<Trip> getLikedByTrips() {
        return likedByTrips;
    }

    public void setLikedByTrips(List<Trip> likedByTrips) {
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
