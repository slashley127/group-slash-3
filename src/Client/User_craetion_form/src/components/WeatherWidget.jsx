
import React, { useState, useEffect } from 'react';

const WeatherWidget = ({ tripLocation }) => {
  const [weatherData, setWeatherData] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const apiKey = '288d4ad1796edec11323fa49cd85ac1d'

  useEffect(() => {
    const fetchWeatherData = async () => {
      try {
        const response = await fetch(
          `https://api.openweathermap.org/data/2.5/weather?q=${tripLocation}&appid=${apiKey}&units=metric`
        );
        if (!response.ok) {
          throw new Error('Failed to fetch weather data');
        }
        const data = await response.json();
        setWeatherData(data);
        setIsLoading(false);
      } catch (error) {
        console.error('Error fetching weather data:', error);
        setIsLoading(false);
      }
    };

    if (tripLocation) {
      fetchWeatherData();
    }
  }, [tripLocation]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (!weatherData) {
    return <div>No weather data available.</div>;
  }

  const { main, weather } = weatherData;

  return (
    <div>
      <h2>Weather in {tripLocation}</h2>
      <p>Temperature: {main.temp}°C</p>
      <p>Description: {weather[0].description}</p>
      {/* Display indoor or outdoor activities based on weather */}
      {main.temp > 20 ? (
        <div>
          <h3>Outdoor Activities:</h3>
          {/* Display outdoor activities */}
        </div>
      ) : (
        <div>
          <h3>Indoor Activities:</h3>
          {/* Display indoor activities */}
        </div>
      )}
    </div>
  );
};

export default WeatherWidget;