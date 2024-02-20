package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.Models.Activity;
import com.slash3.travelapp.Repositories.ActivityRepository;
import com.slash3.travelapp.data.ActivityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.slash3.travelapp.Controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

        @Autowired
        private ActivityRepository activityRepository;

        @RequestMapping("")
        public String search(Model model) {
            model.addAttribute("columns", columnChoices);
            return "search";
        }

        @PostMapping("results")
        public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
            Iterable<Activity> activities;
            if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
                activities = activityRepository.findAll();
            } else {
                activities = ActivityData.findByColumnAndValue(searchType, searchTerm, activityRepository.findAll());
            }
            model.addAttribute("columns", columnChoices);
            model.addAttribute("title", "Activities with " + columnChoices.get(searchType) + ": " + searchTerm);
            model.addAttribute("activities", activities);

            return "search";
        }
    }

