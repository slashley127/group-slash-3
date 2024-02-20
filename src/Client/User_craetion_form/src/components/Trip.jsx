import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import WeatherWidget from './WeatherWidget';
import AllActivities from './AllActivities';

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
               const response = await fetch('http://localhost:8080/api/activities/${tripData.tripLocation}');
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


     return (
       <>
         <div><h1> My Trip</h1></div>
         {tripData && (
           <>
             <p>Location: {tripData.tripLocation}</p>
             <p>Travelers: {tripData.traveler}</p>
             <p>TripId: {tripData.tripId}</p>
             <WeatherWidget weatherData={weatherData} />
             <AllActivities tripId={tripData.tripId} activities={activities} />
           </>
         )}
       </>
     );
   }

   export default Trip;

//     const fetchActivities = async () => {
//                 try {
//                   const response = await fetch('http://localhost:8080/api/activities');
//                    console.error('Response:', await response.text());
//                   if (!response.ok) {
//                     throw new Error('Failed to fetch activities');
//                   }
//                   const data = await response.json();
//                   setActivities(data);
//                 } catch (error) {
//                   console.error('Error fetching activities:', error);
//                 }
//               };
