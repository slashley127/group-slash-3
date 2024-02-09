package com.slash3.travelapp.Controllers;
import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return (List<Activity>) activityService.findAll();
    }

    @GetMapping("/{activityId}")
    public Activity getActivityById(@PathVariable Integer activityId) {
        Activity activity = activityService.getActivityById(activityId);
        return activity;
    }

    @PostMapping("/createActivity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }


    @DeleteMapping("delete/{activityId}")
    @ResponseBody
    public void deleteActivity(@PathVariable Integer activityId) {
        activityService.deleteActivity(activityId);
    }
}
