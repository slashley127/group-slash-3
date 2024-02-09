
package com.slash3.travelapp.Services;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }
    public List<Trip> findAll() {
        return (List<Trip>) tripRepository.findAll();
    }

    public Trip getTripById(Integer tripId) {
        return tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));
    }

    public void deleteTrip(Integer tripId) {
        if (!tripRepository.existsById(tripId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId);
        }
        tripRepository.deleteById(tripId);
    }

    public Trip updateTrip(Integer tripId, Trip tripDetails) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));

        trip.setTripLocation(tripDetails.getTripLocation());
        trip.setTraveler(tripDetails.getTraveler());
        trip.setActivities(tripDetails.getActivities());



        return tripRepository.save(trip);
    }
}
