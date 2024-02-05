package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Table
@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "ActivityId")
    private int activityId;

//    public int nextId = 1;

    @Valid
    @NotNull(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "Activity_Name")
    private String name;

    @NotNull(message = "Activity must have a location")
    @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
    @Column(name = "Activity_Location")
    private Location location;

//    @ManyToOne
//    @NotNull(message = "Location is required.")
//    @Column(name= "Activity_Location")
//    @JsonManagedReference
//    private Location location;

    @Size(min = 10, message = "Description must be minimum 10 characters")
    @Column(name = "Activity_Description")
    private String description;

    @NotNull(message = "Activity must have a price even if zero")
    @Column(name = "Cost")
    private double cost;

    @NotNull(message = "Activity must have a rating")
    @Column(name = "Rating")
    private int rating;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return activityId == activity.activityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId);
    }


    public Activity(String name, Location location, String description, double cost, int rating) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
    }

    public Activity() {
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

    public int getId() {
        return activityId;
    }

}
