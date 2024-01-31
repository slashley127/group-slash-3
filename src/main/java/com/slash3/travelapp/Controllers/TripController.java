package com.slash3.travelapp.controllers;

import com.slash3.travelapp.models.Trip;
import com.slash3.travelapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class TripController {
    @Autowired
    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping("/testTrip")
    @ResponseBody
    public String tripTester(){return "test trip";}
    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return (List<Trip>) tripRepository.findAll();
    }

    @GetMapping("/{tripId}")
    public Trip getTripById(@PathVariable Integer tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        return optionalTrip.orElse(null);
    }

    @PostMapping("/createTrip")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    @PostMapping("/{tripId}")
    public Trip updateTrip(Integer tripId, Trip updatedTrip) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);

        if (optionalTrip.isPresent()) {
            Trip existingTrip = optionalTrip.get();
            existingTrip.setTripLocation(updatedTrip.getTripLocation());
            existingTrip.setTraveler(updatedTrip.getTraveler());

            return tripRepository.save(existingTrip);
        }

        return null;
    }

    @DeleteMapping("delete/{tripId}")
    @ResponseBody
    public void deleteTrip(@PathVariable Integer tripId) {
        tripRepository.deleteById(tripId);
    }
}

