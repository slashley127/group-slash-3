import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';

const SelectActivities = ({ { tripId, activities } }) => {
  const [activities, setActivities] = useState([]);
  const [selectedActivityIds, setSelectedActivityIds] = useState([]);
  const history = useHistory();

  useEffect(() => {
    fetchActivities();
  }, []);

  const fetchActivities = async () => {
    try {
      const response = await fetch(`/api/activities?tripId=${tripId}`);
      const data = await response.json();
      setActivities(data);
    } catch (error) {
      console.error('Error fetching activities:', error);
    }
  };

  const handleCheckboxChange = (event) => {
    const { checked, value } = event.target;
    if (checked) {
      setSelectedActivityIds([...selectedActivityIds, value]);
    } else {
      setSelectedActivityIds(selectedActivityIds.filter(id => id !== value));
    }
  };

  const handleAddToTrip = async () => {
    try {
      await Promise.all(selectedActivityIds.map(activityId => addActivityToTrip(activityId, tripId)));
      history.push(`/trip/${tripId}/activities`); // Navigate to TripActivities component
    } catch (error) {
      console.error('Error adding activities to trip:', error);
    }
  };

  const addActivityToTrip = async (activityId, tripId) => {
    try {
      await fetch(`/api/trips/${tripId}/activities/${activityId}`, {
        method: 'POST'
      });
    } catch (error) {
      console.error('Error adding activity to trip:', error);
    }
  };

  return (
    <div>
      <h2>Select Activities</h2>
      {activities.map(activity => (
        <div key={activity.id}>
          <input
            type="checkbox"
            id={`activity-${activity.id}`}
            value={activity.id}
            onChange={handleCheckboxChange}
          />
          <label htmlFor={`activity-${activity.id}`}>{activity.name}</label>
        </div>
      ))}
      <button onClick={handleAddToTrip}>Add to Trip</button>
    </div>
  );
};

export default SelectActivities;