package com.slash3.travelapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


public class Location {

    @Id
    @GeneratedValue
    @Column(name = "LocationId")
    private int locationId;

//    public int nextId = 1;

    @NotNull(message = "City Name is required")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    @Column(name = "City")
    private String city;

    @NotNull(message = "State Name is required")
    @Size(min = 2, max = 100, message = "State must be between 2 and 100 characters")
    @Column(name = "State")
    private String state;

}
