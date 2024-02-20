package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.DTO.ActivityDTO;
import com.slash3.travelapp.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/addactivity")
    public ResponseEntity<ActivityDTO> addActivity(@RequestBody ActivityDTO activityDTO) {
        try {
            ActivityDTO newActivityDTO = activityService.addActivity(activityDTO);
            return ResponseEntity.ok(newActivityDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/activities")
    public List<ActivityDTO> getAllActivities() {
        return activityService.findAll();
    }

    @GetMapping("/activities/{activityId}")
    public ActivityDTO getActivityById(@PathVariable Integer activityId) {
        return activityService.getActivityById(activityId);
    }

    @PostMapping("/trips/{tripId}/activities/{activityId}")
    public void addActivityToTrip(
            @PathVariable Integer tripId,
            @PathVariable Integer activityId
    ) {
        activityService.addActivityToTrip(activityId, tripId);
    }
    @PostMapping("/trips/{tripId}/activities/{activityId}/remove")
    public void removeActivityFromTrip(
            @PathVariable Integer tripId,
            @PathVariable Integer activityId
    ) {
        activityService.removeActivityFromTrip(activityId, tripId);
    }


//    @PostMapping("/activities")
//    public ActivityDTO createActivity(@RequestBody ActivityDTO activityDTO) {
//        return activityService.createActivity(activityDTO);
//    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable Integer activityId) {
        activityService.deleteActivity(activityId);
    }
}