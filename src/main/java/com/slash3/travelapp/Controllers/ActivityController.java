package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.DTO.ActivityDTO;
import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ActivityController {


    @Autowired
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/search")
    public List<Activity> searchActivities(@RequestParam String search) {

        return activityService.searchActivities(search);
    }


    @GetMapping("/activities")
    public List<ActivityDTO> getAllActivities() {
        return activityService.findAll();
    }

    @GetMapping("/activities/{activityId}")
    public ActivityDTO getActivityById(@PathVariable Integer activityId) {
        return activityService.getActivityById(activityId);
    }

    @PostMapping("/activities")
    public ActivityDTO createActivity(@RequestBody ActivityDTO activityDTO) {
        return activityService.createActivity(activityDTO);
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable Integer activityId) {
        activityService.deleteActivity(activityId);
    }
}
