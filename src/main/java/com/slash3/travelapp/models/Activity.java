package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private int id;

//    public int nextId = 1;

    @Valid
    @NotNull(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Activity must have a location")
    private String location;

    @Size(min = 10, message = "Description must be minimum 10 characters")
    private String description;

    @NotNull(message = "Activity must have a price even if zero")
    private double cost;

    @NotNull(message = "Activity must have a rating")
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
        return id == activity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Activity(String location, String description, double cost, int rating) {
        super();
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

    public Integer getId() {
        return id;
    }


//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Activity activity = (Activity) o;
//        return id == activity.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
