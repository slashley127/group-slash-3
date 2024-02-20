package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.DTO.TripDTO;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class TripController {
    @Autowired
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public List<TripDTO> getAllTrips() {
        return tripService.findAll();
    }
    @GetMapping("/trips/{travelerName}")
    public ResponseEntity<TripDTO> getTripByTravelerName(@PathVariable String travelerName) {
        TripDTO tripDTO = tripService.getTripByTravelerName(travelerName);
        return ResponseEntity.ok(tripDTO);
    }

    @GetMapping("/trips/{tripId}")
    public ResponseEntity<TripDTO> getTripById(@PathVariable Integer tripId) {
        TripDTO tripDTO = tripService.getTripById(tripId);
        return ResponseEntity.ok(tripDTO);
    }

    @PostMapping("/trips/create")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO) {
        TripDTO newTripDTO = tripService.createTrip(tripDTO);
        return ResponseEntity.ok(newTripDTO);
    }

    @PutMapping("/trips/{tripId}")
    public ResponseEntity<TripDTO> updateTrip(@PathVariable Integer tripId, @RequestBody TripDTO tripDTO) {
        TripDTO updatedTripDTO = tripService.updateTrip(tripId, tripDTO);
        return ResponseEntity.ok(updatedTripDTO);
    }

    @DeleteMapping("/trips/{tripId}")
    @ResponseBody
    public void deleteTrip(@PathVariable Integer tripId) {
        tripService.deleteTrip(tripId);
    }
}