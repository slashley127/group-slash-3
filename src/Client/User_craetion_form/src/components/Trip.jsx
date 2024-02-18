import React from 'react';
import { useLocation } from 'react-router-dom';

function Trip() {
  const location = useLocation();
  const tripData = location.state && location.state.trip;

  return (
    <>
      <div><h1> My Trip</h1></div>
      {tripData && (
        <>
          <p>Location: {tripData.tripLocation}</p>
          <p>Travelers: {tripData.traveler}</p>
        </>
      )}
    </>
  );
}

export default Trip;