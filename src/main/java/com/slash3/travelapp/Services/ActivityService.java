package com.slash3.travelapp.Services;
import com.slash3.travelapp.DTO.ActivityDTO;
import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityDTO createActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setName(activityDTO.getName());
        activity.setLocation(activityDTO.getLocation());
        activity.setDescription(activityDTO.getDescription());
        activity.setCost(activityDTO.getCost());
        activity.setRating(activityDTO.getRating());
        activity.setTrips(activityDTO.getTrips());
        activity.setIndoor(activityDTO.getIsIndoor());
        activity.setSelectedByTrips(activityDTO.getSelectedTrips());
        activity.setLikedByTrips(activityDTO.getLikedTrips());

        Activity savedActivity = activityRepository.save(activity);

        return convertToActivityDTO(savedActivity);
    }

    public List<ActivityDTO> findAll() {
        List<Activity> activities = (List<Activity>) activityRepository.findAll();
        return activities.stream().map(this::convertToActivityDTO).collect(Collectors.toList());
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
        activity.setTrips(activityDTO.getTrips());
        activity.setIndoor(activityDTO.getIsIndoor());
        activity.setSelectedByTrips(activityDTO.getSelectedTrips());
        activity.setLikedByTrips(activityDTO.getLikedTrips());

        Activity updatedActivity = activityRepository.save(activity);

        return convertToActivityDTO(updatedActivity);
    }

    // Helper method to convert Activity to ActivityDTO
    private ActivityDTO convertToActivityDTO(Activity activity) {
        return new ActivityDTO(
                activity.getActivityId(),
                activity.getName(),
                activity.getLocation(),
                activity.getDescription(),
                activity.getCost(),
                activity.getRating(),
                activity.getTrips(),
                activity.getIsIndoor()
                activity.getSelectedByTrips(),
                activity.getLikedByTrips()
        );
    }
}