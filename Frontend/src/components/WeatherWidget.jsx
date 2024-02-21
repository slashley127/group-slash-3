import React from 'react';

const WeatherWidget = ({ weatherData }) => {
  if (!weatherData) {
    return <div>Loading...</div>;
  }

  const { main, weather } = weatherData;

  return (
     <div>
          <h2>Weather in {weatherData.name}</h2>
          <p>Temperature: {main.temp}°F</p>
          <p>Description: {weather[0].description}</p>
          <div>
            {main.temp > 40 ? (
              <div>
              <h3>Based on current weather conditions at your destination, outdoor activities are recommended!</h3>


              </div>
            ) : (
              <div>
              <h3>Based on current weather conditions at your destination, indoor activities are recommended!</h3>


              </div>
            )}
          </div>
        </div>
      );
    };
export default WeatherWidget;