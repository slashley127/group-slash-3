package com.slash3.travelapp.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapController {

    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your actual API key

    public static String getWeatherData(String city) throws IOException {
        String apiUrl = buildApiUrl(city);
        return makeApiRequest(apiUrl);
    }

    private static String buildApiUrl(String city) {
        return "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
    }

    private static String makeApiRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);

        try (HttpURLConnection connection = (HttpURLConnection) url.openConnection()) {
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    return response.toString();
                }
            } else {
                System.out.println("Error: " + responseCode);
                return null;
            }
        }
    }
}