package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.models.Activity;
import com.slash3.travelapp.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private final ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    @GetMapping("/testActivity")
    @ResponseBody
    public String tester(){return "test activity";}
    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return (List<Activity>) activityRepository.findAll();
    }

    @GetMapping("/{activityId}")
    public Activity getActivityById(@PathVariable Integer activityId) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);
        return optionalActivity.orElse(null);
    }

    @PostMapping("/createActivity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }

    @PutMapping ("update/{activityId}")
    @ResponseBody
    public Activity updateActivity(@PathVariable Integer activityId, Activity updatedActivity) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);

        if (optionalActivity.isPresent()) {
            Activity existingActivity = optionalActivity.get();
            existingActivity.setName(updatedActivity.getName());
            existingActivity.setLocation(updatedActivity.getLocation());
            existingActivity.setCost(updatedActivity.getCost());
            existingActivity.setRating(updatedActivity.getRating());
            existingActivity.setDescription(updatedActivity.getDescription());

            return activityRepository.save(existingActivity);
        }

        return null;
    }
    @DeleteMapping("delete/{activityId}")
    @ResponseBody
    public void deleteActivity(@PathVariable Integer activityId) {
        activityRepository.deleteById(activityId);
    }
}
