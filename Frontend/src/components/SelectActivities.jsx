import React, { useState } from 'react';


function SelectActivities({ tripId, activities }) {
    const [activityId, setActivityId] = useState('');
    const [message, setMessage] = useState('');

    const handleAddActivityToTrip = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/trips/${tripId}/activities/${activityId}`, {
                method: 'POST'
            });
            if (!response.ok) {
                throw new Error('Failed to add activity to trip');
            }
            setMessage('This activity was saved to your trip!');
        } catch (error) {
            console.error('Error adding activity to trip:', error);
            setMessage('Failed to save activity to your trip');
        }
    };

    return (
                   <div>
                       <h2>Select Local Activity to Add to Trip</h2>
                       <select value={activityId} onChange={(e) => setActivityId(e.target.value)}>
                           {activities.map(activity => (
                               <option key={activity.activityId} value={activity.activityId}>{activity.name}</option>
                           ))}
                       </select>
                       <button onClick={handleAddActivityToTrip}>Add Activity to Trip</button>
                       <p>{message}</p>
                   </div>
               );
}

export default SelectActivities;