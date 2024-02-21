import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function AllActivities({ tripId, activities }) {
    const navigate = useNavigate();

    useEffect(() => {

    }, []); // Ensure this effect runs only once when the component mounts

    const handleAddActivityToTrip = async (activityId) => {
        try {
            const response = await fetch(`http://localhost:8080/api/trips/${tripId}/activities/${activityId}`, {
                method: 'POST'
            });
            if (!response.ok) {
                throw new Error('Failed to add activity to trip');
            }
            console.log('Activity added to trip successfully');
            navigate('/trip');
        } catch (error) {
            console.error('Error adding activity to trip:', error);
        }
    };

    return (
        <div>
            <h1>Local Activities</h1>
            <ul>
                {activities.map(activity => (
                    <li key={activity.activityId}>
                        {activity.name} - {activity.location} - {activity.description} - {activity.indoor ? "indoor" : "outdoor"}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AllActivities;