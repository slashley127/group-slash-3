package com.slash3.travelapp.Controllers;

import java.io.IOException;

public class TripWeatherController {

    public static void main(String[] args) {
        String city = "SAINT_LOUIS";  // Replace with the desired city name

        try {
            String jsonResponse = OpenWeatherMapController.getWeatherData(city);

            // Parse and use the JSON data (implement a proper JSON parser here)

            System.out.println(jsonResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}