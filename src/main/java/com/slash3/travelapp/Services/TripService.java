
package com.slash3.travelapp.Services;
import com.slash3.travelapp.DTO.TripDTO;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public TripDTO createTrip(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setTripLocation(tripDTO.getTripLocation());
        trip.setTraveler(tripDTO.getTraveler());
        trip.setActivities(tripDTO.getActivities());

        Trip savedTrip = tripRepository.save(trip);

        return convertToTripDTO(savedTrip);
    }

    public List<TripDTO> findAll() {
        List<Trip> trips = (List<Trip>) tripRepository.findAll();
        return trips.stream().map(this::convertToTripDTO).collect(Collectors.toList());
    }

    public TripDTO getTripById(Integer tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));
        return convertToTripDTO(trip);
    }

    public void deleteTrip(Integer tripId) {
        if (!tripRepository.existsById(tripId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId);
        }
        tripRepository.deleteById(tripId);
    }

    public TripDTO updateTrip(Integer tripId, TripDTO tripDTO) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));

        trip.setTripLocation(tripDTO.getTripLocation());
        trip.setTraveler(tripDTO.getTraveler());
        trip.setActivities(tripDTO.getActivities());

        Trip updatedTrip = tripRepository.save(trip);

        return convertToTripDTO(updatedTrip);
    }

    private TripDTO convertToTripDTO(Trip trip) {
        return new TripDTO(
                trip.getTripId(),
                trip.getTripLocation(),
                trip.getTraveler(),
                trip.getActivities()
        );
    }
}