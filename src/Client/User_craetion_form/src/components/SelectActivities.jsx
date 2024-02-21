import React, { useState } from 'react';

function SelectActivities({ tripId, activities}) {
    const [activityId, setActivityId] = useState('');

    const handleAddActivityToTrip = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/trips/${tripId}/activities/${activityId}`, {
                method: 'POST'
            });
            if (!response.ok) {
                throw new Error('Failed to add activity to trip');
            }
            // Handle success
        } catch (error) {
            console.error('Error adding activity to trip:', error);
        }
    };

    return (
                   <div>
                       <h2>Select Activity to Add to Trip</h2>
                       {/* Dropdown or list to select activities */}
                       <select value={activityId} onChange={(e) => setActivityId(e.target.value)}>
                           {activities.map(activity => (
                               <option key={activity.activityId} value={activity.activityId}>{activity.name}</option>
                           ))}
                       </select>
                       <button onClick={handleAddActivityToTrip}>Add Activity to Trip</button>
                   </div>
               );
}

export default SelectActivities;