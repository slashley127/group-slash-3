import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import WeatherWidget from './WeatherWidget';

function Trip() {
   const location = useLocation();
    const tripData = location.state && location.state.tripData;

    const [weatherData, setWeatherData] = useState(null);
    const apiKey = '68cbf853b47ee9fec36896495fc006d2';

   useEffect(() => {
       const fetchWeatherData = async () => {
         try {
           const response = await fetch(
             `https://api.openweathermap.org/data/2.5/weather?q=${tripData.tripLocation}&appid=${apiKey}&units=imperial`
           );
           if (!response.ok) {
             throw new Error('Failed to fetch weather data');
           }
           const data = await response.json();
           setWeatherData(data);
         } catch (error) {
           console.error('Error fetching weather data:', error);
         }
       };

       if (tripData) {
         fetchWeatherData();
       }
     }, [tripData]);

     return (
       <>
         <div><h1> My Trip</h1></div>
         {tripData && (
           <>
             <p>Location: {tripData.tripLocation}</p>
             <p>Travelers: {tripData.traveler}</p>
             <WeatherWidget weatherData={weatherData} />
           </>
         )}
       </>
     );
   }

   export default Trip;