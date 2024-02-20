package com.slash3.travelapp.Controllers;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
//
//    @Value("${openweathermap.apiKey}")
//    private String apiKey = "d62897568a117f140ee9e2cdee163b4b";

    private final RestTemplate restTemplate;

    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=d62897568a117f140ee9e2cdee163b4b";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}