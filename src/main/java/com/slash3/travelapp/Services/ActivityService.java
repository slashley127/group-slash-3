package com.slash3.travelapp.Services;
import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }
    public List<Activity> findAll() {
        return (List<Activity>) activityRepository.findAll();
    }

    public Activity getActivityById(Integer activityId) {
        return activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));
    }

    public void deleteActivity(Integer activityId) {
        if (!activityRepository.existsById(activityId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId);
        }
        activityRepository.deleteById(activityId);
    }

    public Activity updateActivity(Integer activityId, Activity activityDetails) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found with id " + activityId));

        activity.setName(activityDetails.getName());
        activity.setLocation(activityDetails.getLocation());
        activity.setCost(activityDetails.getCost());
        activity.setDescription(activityDetails.getDescription());
        activity.setRating(activityDetails.getRating());
        activity.setTrips(activityDetails.getTrips());


        return activityRepository.save(activity);
    }
}
