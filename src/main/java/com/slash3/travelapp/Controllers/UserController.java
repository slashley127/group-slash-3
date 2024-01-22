package com.slash3.travelapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping
    @ResponseBody
    public String displayHomePage(){
        return "WELCOME TO HOME PAGE! You can sign in or sign up!";
    }
    @GetMapping("/traveler")
    @ResponseBody
    public String displayTravelerPage(){
        return "This is your Traveler Profile!";
    }
    @GetMapping("/createNewTraveler")
    @ResponseBody
    public String NewTravelerProfileForm(){
        return "This is where you will create your traveler profile using a form!";
    }
}
