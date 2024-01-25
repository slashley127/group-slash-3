package com.slash3.travelapp.Controllers;

import com.slash3.travelapp.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TripController {
    @Autowired
    private final TripRepository tripRepository;
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;

    }
}
