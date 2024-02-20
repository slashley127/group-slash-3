import React from 'react';

const WeatherWidget = ({ weatherData }) => {
  if (!weatherData) {
    return <div>Loading...</div>;
  }

  const { main, weather } = weatherData;

  return (
    <div>
      <h2>Weather in {weatherData.name}</h2>
      <p>Temperature: {main.temp}°C</p>
      <p>Description: {weather[0].description}</p>
    </div>
  );
};

export default WeatherWidget;

// import React, { useState, useEffect } from 'react';
//
// const WeatherWidget = ({ location }) => {
//   const [weatherData, setWeatherData] = useState(null);
//   const [isLoading, setIsLoading] = useState(true);
//   const apiKey = '68cbf853b47ee9fec36896495fc006d2';
//
//   useEffect(() => {
//     const fetchWeatherData = async () => {
//       try {
//         const response = await fetch(
//           `https://api.openweathermap.org/data/2.5/weather?q=${location}&appid=${apiKey}&units=metric`
//         );
//         if (!response.ok) {
//           throw new Error('Failed to fetch weather data');
//         }
//         const data = await response.json();
//         setWeatherData(data);
//         setIsLoading(false);
//       } catch (error) {
//         console.error('Error fetching weather data:', error);
//         setIsLoading(false);
//       }
//     };
//
//     if (location) {
//       fetchWeatherData();
//     }
//   }, [location, apiKey]);
//
//   if (isLoading) {
//     return <div>Loading...</div>;
//   }
//
//   if (!weatherData) {
//     return <div>No weather data available.</div>;
//   }
//
//   const { main, weather } = weatherData;
//
//   return (
//     <div>
//       <h2>Weather in {location}</h2>
//       <p>Temperature: {main.temp}°C</p>
//       <p>Description: {weather[0].description}</p>
//     </div>
//   );
// };
//
// export default WeatherWidget;

//
// import React, { useState, useEffect } from 'react';
//
// const WeatherWidget = ({ tripLocation }) => {
// const [weatherData, setWeatherData] = useState(null);
// const city = tripLocation;
//   const [isLoading, setIsLoading] = useState(true);
//   const apiKey = '288d4ad1796edec11323fa49cd85ac1d'
//
//   useEffect(() => {
//     const fetchWeatherData = async () => {
//       try {
//         const response = await fetch(
//           `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`
//         );
//         if (!response.ok) {
//           throw new Error('Failed to fetch weather data');
//         }
//         const tripData = await response.json();
//         setWeatherData(data);
//         setIsLoading(false);
//       } catch (error) {
//         console.error('Error fetching weather data:', error);
//         setIsLoading(false);
//       }
//     };
//
//     if (city) {
//       fetchWeatherData();
//     }
//   }, [city]);
//
//   if (isLoading) {
//     return <div>Loading...</div>;
//   }
//
//   if (!weatherData) {
//     return <div>No weather data available.</div>;
//   }
//
//   const { main, weather } = weatherData;
//
//   return (
//     <div>
//       <h2>Weather in {city}</h2>
//       <p>Temperature: {main.temp}°C</p>
//       <p>Description: {weather[0].description}</p>
//       {/* Display indoor or outdoor activities based on weather */}
//       {main.temp > 20 ? (
//         <div>
//           <h3>Outdoor Activities:</h3>
//           {/* Display outdoor activities */}
//         </div>
//       ) : (
//         <div>
//           <h3>Indoor Activities:</h3>
//           {/* Display indoor activities */}
//         </div>
//       )}
//     </div>
//   );
// };
//
// export default WeatherWidget;