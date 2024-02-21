package com.slash3.travelapp.Services;
import com.slash3.travelapp.DTO.ActivityDTO;
import com.slash3.travelapp.DTO.TripDTO;
import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.ActivityLite;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.ActivityLiteRepository;
import com.slash3.travelapp.Repositories.ActivityRepository;
import com.slash3.travelapp.Repositories.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private ActivityLiteRepository activityLiteRepository;

    public ActivityDTO createActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setName(activityDTO.getName());
        activity.setLocation(activityDTO.getLocation());
        activity.setDescription(activityDTO.getDescription());
        activity.setCost(activityDTO.getCost());
        activity.setRating(activityDTO.getRating());
        activity.setSelectedByTrips(activityDTO.getSelectedTrips());
        activity.setLikedByTrips(activityDTO.getLikedTrips());
        activity.setIndoor(activityDTO.isIndoor());


        Activity savedActivity = activityRepository.save(activity);

        return convertToActivityDTO(savedActivity);
    }

    @Transactional
    public void addActivityToTrip(Integer activityId, Integer tripId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));
        trip.addActivity(activity);
    }

    @Transactional
    public void removeActivityFromTrip(Integer activityId, Integer tripId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found with id " + tripId));
        trip.removeActivity(activity);
    }


    public List<ActivityDTO> findAll() {
        List<ActivityLite> activities = activityLiteRepository.findAllDistinctNamedActivities();
        return activities.stream().map(this::convertToActivityDTO).collect(Collectors.toList());
    }
    public List<ActivityDTO> getActivitiesByLocation(String location) {
        List<Activity> activities = activityRepository.findAllByLocation(location);
        return activities.stream()
                .map(this::convertToActivityDTO)
                .collect(Collectors.toList());
    }


    public ActivityDTO getActivityById(Integer activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));
        return convertToActivityDTO(activity);
    }

    public void deleteActivity(Integer activityId) {
        if (!activityRepository.existsById(activityId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId);
        }
        activityRepository.deleteById(activityId);
    }

    public ActivityDTO updateActivity(Integer activityId, ActivityDTO activityDTO) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));

        activity.setName(activityDTO.getName());
        activity.setLocation(activityDTO.getLocation());
        activity.setDescription(activityDTO.getDescription());
        activity.setCost(activityDTO.getCost());
        activity.setRating(activityDTO.getRating());
        activity.setSelectedByTrips(activityDTO.getSelectedTrips());
        activity.setLikedByTrips(activityDTO.getLikedTrips());
        activity.setIndoor(activityDTO.isIndoor());

        Activity updatedActivity = activityRepository.save(activity);

        return convertToActivityDTO(updatedActivity);
    }

    private Activity convertToEntity(ActivityDTO activityDTO) {
        return new Activity(
                activityDTO.getActivityId(),
                activityDTO.getName(),
                activityDTO.getLocation(),
                activityDTO.getDescription(),
                activityDTO.getCost(),
                activityDTO.getRating(),
                activityDTO.getSelectedTrips(),
                activityDTO.getLikedTrips(),
                activityDTO.isIndoor()
        );
    }

    private ActivityDTO convertToActivityDTO(Activity activity) {
        return new ActivityDTO(
                activity.getActivityId(),
                activity.getName(),
                activity.getLocation(),
                activity.getDescription(),
                activity.getCost(),
                activity.getRating(),
                activity.getSelectedByTrips(),
                activity.getLikedByTrips(),
                activity.isIndoor()
        );
    }

    private ActivityDTO convertToActivityDTO(ActivityLite activity) {
        return new ActivityDTO(
                activity.getActivityId(),
                activity.getName(),
                activity.getLocation(),
                activity.getDescription());
    }
}