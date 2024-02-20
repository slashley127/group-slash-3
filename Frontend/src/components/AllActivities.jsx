import React from 'react'
// import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './AllActivities.css';

function AllActivities() {

 const [activities, setActivities] = useState([]);

  useEffect(() => {
    const fetchActivities = async () => {
      try {
        const response = await fetch('http://localhost:3001/api/activities');

        if (response.ok) {
          const data = await response.json();
          setActivities(data);
        } else {
          console.error('Failed to fetch activities');
        }
      } catch (error) {
        console.error('Error fetching activities:', error);
      }
    };

    fetchActivities();
  }, []);

  return (
  <div>
     <div className="activities-title">All Activities</div>

      <div className="destinationInput">
    <div className="activity-group">
    <ul>
              {activities.map((activity) => (
         <li key={activity.id}>
        <div className="activity" key={activity.id}>
        <div className="card-body">
          <strong className="card-title">{activity.name}</strong>
          <p className="card-text">{activity.location}</p>
          <p className="card-text">{activity.description}</p>
          <p className="card-text">rating: {activity.rating}    ${activity.cost}</p>
          <p className="card-text">{activity.isIndoor ? 'Indoor' : 'Outdoor'}</p>
                </div>
          </div>
          </li>
          ))}
    </ul>
</div>

      </div>
</div>
);
}



export default AllActivities;