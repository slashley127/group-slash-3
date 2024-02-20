package com.slash3.travelapp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Activity")

public class ActivityLite {
    @Id
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
    @Column(name="indoor")
    private boolean isIndoor;
    public ActivityLite(Integer activityId, String name, String location, String description, boolean isIndoor) {
        this.activityId = activityId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.isIndoor = isIndoor;
    }

    public ActivityLite() {}

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public Integer getActivityId() {
        return activityId;
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
}