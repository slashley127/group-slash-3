package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Models.Trip;
import com.slash3.travelapp.Repositories.ActivityRepository;
import com.slash3.travelapp.Repositories.TripRepository;
import com.slash3.travelapp.Repositories.UserRepository;
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

        @Autowired
        private ActivityRepository activityRepository;

        @Autowired
        private TripRepository tripRepository;

        @Autowired
        private UserRepository userRepository;

        @RequestMapping("/")
        public String index(Model model) {

            model.addAttribute("title", "TravelTribe");

            List activities = (List<Activity>) activityRepository.findAll();
            model.addAttribute("activities", activities);

            return "index";
        }

        @GetMapping("add")
        public String displayAddActivityForm(Model model) {
            model.addAttribute("title", "Add Activity");
            model.addAttribute(new Activity());

            List trips = (List<Trip>) tripRepository.findAll();
            model.addAttribute("trips", trips);
//
//            List locations = (List<Location>) locationRepository.findAll();
//            model.addAttribute("locations", locations);
            return "add";
        }

        @PostMapping("add")
        public String processAddActivityForm(@ModelAttribute @Valid Activity newActivity,
                                        Errors errors, Model model, @RequestParam List<Integer> trips) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Add Activity");
//                List locations = (List<Location>) locationRepository.findAll();
//                model.addAttribute("locations", locations);

                return "add";
            }

            //figure out how to get to Activity.getLocation through this way//
//            Optional<Activity.getLocation()> optLocation = locationRepository.findById(locationId);
//            if (optLocation.isPresent()) {
//                Location location = optLocation.get();
//                newActivity.setLocation(location);
//            }

            List<Trip> tripObjs = (List<Trip>) tripRepository.findAllById(trips);
            newActivity.setSelectedByTrips(tripObjs);

            activityRepository.save(newActivity);

            return "redirect:";
        }

        @GetMapping("view/{activityId}")
        public String displayViewActivity(Model model, @PathVariable int activityId) {

            return "view";
        }


}
