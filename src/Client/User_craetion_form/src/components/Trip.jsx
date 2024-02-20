import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import WeatherWidget from './WeatherWidget';

function Trip() {
   const location = useLocation();
    const tripData = location.state && location.state.tripData;
    const [activities, setActivities] = useState([]);
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
       const fetchActivities = async () => {
             try {
               const response = await fetch('/api/activities');
               if (!response.ok) {
                 throw new Error('Failed to fetch activities');
               }
               const data = await response.json();
               setActivities(data);
             } catch (error) {
               console.error('Error fetching activities:', error);
             }
           };

       if (tripData) {
         fetchWeatherData();
         fetchActivities();
       }
     }, [tripData]);

     const filteredActivities = activities.filter(activity => {
         if (weatherData && weatherData.main && weatherData.main.temp) {
           if (weatherData.main.temp >= 40) {
             return !activity.isIndoor; // Display outdoor activities if temperature is 40°F or warmer
           } else {
             return activity.isIndoor; // Display indoor activities if temperature is below 40°F
           }
         }
         return false;
       });


     return (
       <>
         <div><h1> My Trip</h1></div>
         {tripData && (
           <>
             <p>Location: {tripData.tripLocation}</p>
             <p>Travelers: {tripData.traveler}</p>
             <WeatherWidget weatherData={weatherData} />
             <h2>Recommended Activities:</h2>
                       <ul>
                         {filteredActivities.map(activity => (
                           <li key={activity.id}>{activity.name}</li>
                         ))}
                       </ul>
           </>
         )}
       </>
     );
   }

   export default Trip;