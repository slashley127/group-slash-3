import React from 'react';

const WeatherWidget = ({ weatherData }) => {
  if (!weatherData) {
    return <div>Loading...</div>;
  }

  const { main, weather } = weatherData;
  const isRainy = weather.some(w => w.main === 'Rain');

  return (
     <div>
          <h2>Weather in {weatherData.name}</h2>
          <p>Temperature: {main.temp}°F</p>
          <p>Description: {weather[0].description}</p>
          <div>
            {main.temp > 40 && !isRainy ? (
              <div>
              <h5>Based on current weather conditions, outdoor activities are recommended!</h5>


              </div>
            ) : (
              <div>
              <h5>Based on current weather conditions, indoor activities are recommended!</h5>


              </div>
            )}
          </div>
        </div>
      );
    };
export default WeatherWidget;