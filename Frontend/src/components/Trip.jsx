import React from 'react';
import { useLocation } from 'react-router-dom';

function Trip() {
  const location = useLocation();
  const tripData = location.state && location.state.trip;
  fetch('/api/trips/{tripId}', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      console.log('Trip details:', data);
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });

  return (
    <>
      <div><h1> My Trip</h1></div>
      {tripData && (
        <>
          <p>Location: {tripData.tripLocation}</p>
          <p>Travelers: {tripData.traveler}</p>
          <WeatherWidget location = {tripData.tripLocation}/>
        </>
      )}
    </>
  );
}

export default Trip;