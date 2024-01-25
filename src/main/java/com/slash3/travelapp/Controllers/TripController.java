package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TripController {
    @Autowired
    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return (List<Trip>) tripRepository.findAll();
    }

    @GetMapping("/{tripId}")
    public Trip getTripById(@PathVariable Integer tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        return optionalTrip.orElse(null);
    }

    @PostMapping
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
}

