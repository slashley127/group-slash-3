package com.slash3.travelapp.controllers;

import com.slash3.travelapp.data.ActivityRepository;
import com.slash3.travelapp.models.Activity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        activityRepository.findAll();
        model.addAttribute(new Activity());
        return "activities/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Activity());
        return "skills/add";
    }


    @PostMapping("add")
    public String processAddActivityForm(@ModelAttribute @Valid Activity newActivity, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("activity", "New Activity");
            return "activities/add";
        }
        activityRepository.save(newActivity);
        return "redirect";
    }

    @GetMapping("view/{activityId}")
    public String displayViewActivity(Model model, @PathVariable int activityId) {

        Optional<Activity> optActivity = activityRepository.findById(activityId);
        if (optActivity.isPresent()) {
            Activity activity = optActivity.get();
            model.addAttribute("activity", activity);
            return "activitiess/view";
        } else {
            return "redirect:../";
        }

    }
}
