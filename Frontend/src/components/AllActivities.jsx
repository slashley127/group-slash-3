// import React, { useEffect } from 'react';
// import { useNavigate } from 'react-router-dom';
//
// function AllActivities({ tripId, activities }) {
//     const navigate = useNavigate();
//
//     useEffect(() => {
//     }, []);
//     const handleAddActivityToTrip = async (activityId) => {
//         try {
//             const response = await fetch(`http://localhost:8080/api/trips/${tripId}/activities/${activityId}`, {
//                 method: 'POST'
//             });
//             if (!response.ok) {
//                 throw new Error('Failed to add activity to trip');
//             }
//             console.log('Activity added to trip successfully');
//             navigate('/trip');
//         } catch (error) {
//             console.error('Error adding activity to trip:', error);
//         }
//     };

//     return (
//         <div>
//             <h3>Local Activities</h3>
//             <ul>
//                 {activities.map(activity => (
//                     <li key={activity.activityId}>
//                         {activity.name} - {activity.location} - {activity.description} - {activity.indoor ? "Indoor" : "Outdoor"}
//                     </li>
//                 ))}
//             </ul>
//         </div>
//     );
// }
//
// export default AllActivities;


import React, { useState, useEffect } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './AllActivities.css'

function AllActivities() {
 const [activities, setActivities] = useState([]);

  useEffect(() => {

    const fetchActivities = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/AllActivities');

        if (response.ok) {
          const data = await response.json();
          setActivities(data);
        } else {
          console.error('Failed to fetch activities. Server returned:', response.status);
        }
      } catch (error) {
        console.error('Error fetching activities:', error);
      }
    };


    fetchActivities();
  }, []);


   const handleDelete = async () => {

      try {
        const response = await fetch(`https://localhost:5173/api/activities/${activityId}`, {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json',
          },
        });

        if (response.ok) {
        setActivities((prevActivities) => prevActivities.filter((activity) => activity.id !== activityId));
        console.log('Activity deleted successfully');
        } else {
        console.error('Failed to delete activity. Server returned:', response.status);
      }
       } catch (error) {
        console.error('Error deleting activity:', error);
      }
    };


  return (

   <div>
    <div className="all-activities-title">All Activities</div>

     <div className="activity-group">
               {activities.map((activity) => (
         <div className="activity" key={activity.activityId}>
         <div className="activity-body">
           <h5 className="activity-title">{activity.name}</h5>
           <p>{activity.location}</p>
           <p>{activity.description}</p>
           <p>rating: {activity.rating}    ${activity.cost}</p>
           <p>{activity.isIndoor ? 'Indoor' : 'Outdoor'}</p>

           <p>
                <button onClick={() => handleDelete(`${activity.activityId}`)}>Delete</button>
           </p>
 </div>
 </div>
 ))}
       </div>
 </div>

 );
 }



export default AllActivities;