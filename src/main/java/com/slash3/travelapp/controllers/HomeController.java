package com.slash3.travelapp.controllers;

import com.slash3.travelapp.models.Activity;
import com.slash3.travelapp.models.Location;
import com.slash3.travelapp.models.Trip;
import com.slash3.travelapp.repositories.ActivityRepository;
//import com.slash3.travelapp.repositories.LocationRepository;
import com.slash3.travelapp.repositories.TripRepository;
//import com.slash3.travelapp.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    private LocationRepository locationRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private TripRepository tripRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyActivities");

        List activities = (List<Activity>) activityRepository.findAll();
        model.addAttribute("activities", activities);

        return "index";
    }

    @GetMapping("add")
    public String displayAddActivityForm(Model model) {
        model.addAttribute("title", "Add Activity");
        model.addAttribute(new Activity());

//        List locations = (List<Location>) locationRepository.findAll();
//        model.addAttribute("locations", locations);

        List trip = (List<Trip>) tripRepository.findAll();
        model.addAttribute("trips",trip );
        return "add";
    }

    @PostMapping("add")
    public String processAddActivityForm(@ModelAttribute @Valid Activity newActivity,
                                         Errors errors, Model model, @RequestParam int activityId, @RequestParam List<Integer> locations, double cost) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Activity");
//            List activities = (List<Location>) locationRepository.findAll();
//            model.addAttribute("locations", locations);

            return "add";
        }

//        Optional<Location> optLocation = locationRepository.findById(activityId);
//        if (optLocation.isPresent()) {
//            Location location = optLocation.get();
//            newActivity.setLocation(location);
//        }

//         cost = (List<Cost>) costRepository.findAllById(cost);
        newActivity.setCost(cost);

        activityRepository.save(newActivity);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewActivity(Model model, @PathVariable int activityId) {

        return "view";
    }

}