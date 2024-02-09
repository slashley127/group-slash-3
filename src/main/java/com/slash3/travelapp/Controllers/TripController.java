package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TripController {
    @Autowired
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return (List<Trip>) tripService.findAll();
    }


    @GetMapping("/{tripId}")
    public ResponseEntity<Trip> getTripById(@PathVariable Integer tripId) {
        Trip trip = tripService.getTripById(tripId);
        return ResponseEntity.ok(trip);
    }
    @PostMapping("/createTrip")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }
    @PutMapping("/{tripId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Integer tripId, @RequestBody Trip tripDetails) {
        Trip updatedTrip = tripService.updateTrip(tripId, tripDetails);
        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping("delete/{tripId}")
    @ResponseBody
    public void deleteTrip(@PathVariable Integer tripId) {
        tripService.deleteTrip(tripId);
    }
}

