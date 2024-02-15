//
// const api = {
// key = "288d4ad1796edec11323fa49cd85ac1d",
// base = "https://api.openweathermap.org/data/2.5/",
// }
// weatherApp(){
// return
// <div classname = "App">
// <header classname = "App-Header"> </header>
//
// </div>
// }



import React from 'react';
import { useLocation } from 'react-router-dom';

function tripWeather {
const [tripData, setTripData] = useState({

    userName: '',
    email: '',
    password: '',
    firstName: '',
    lastName: ''
     });


const fetchWeatherData = (city) => {
const apiKey = '288d4ad1796edec11323fa49cd85ac1d'
const apiURL = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`;
fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      // Handle the weather data here
      console.log(data);
    })
    .catch(error => {

      console.error('There was a problem with the fetch operation:', error);
    });
};

}
