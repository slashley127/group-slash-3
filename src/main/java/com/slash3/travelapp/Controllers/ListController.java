package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.ActivityRepository;
import com.slash3.travelapp.Repositories.TripRepository;
import com.slash3.travelapp.data.ActivityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private TripRepository tripRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("activity", "Activity");
        columnChoices.put("trip", "Trip");
//        columnChoices.put("location", "Location");

    }

    @RequestMapping("")
    public String list(Model model) {
        List<Activity> activities = (List<Activity>) activityRepository.findAll();
        model.addAttribute("activities", activities);


        List<Trip> trips = (List<Trip>) tripRepository.findAll();
        model.addAttribute("trips", trips);
//
//            List<Activity> locations = (List<Location>) locationRepository.findAll();
//            model.addAttribute("locations", locations);

        return "list";
    }

    @RequestMapping(value = "activities")
    public String listActivitiesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Activity> activities;
        if (column.toLowerCase().equals("all")){
            activities = activityRepository.findAll();
//            model.addAttribute("activities", activities);
            model.addAttribute("title", "All Jobs");
        } else {
            activities = ActivityData.findByColumnAndValue(column, value, activityRepository.findAll());
            model.addAttribute("title", "Activities with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("activities", activities);

        return "list-activities";
    }
}

