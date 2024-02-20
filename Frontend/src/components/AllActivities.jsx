
import React, { useState, useEffect } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';

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

  return (

   <div>
    <div className="all-activities-title">All Activities</div>

     <div className="activity-group">
               {activities.map((activity) => (
         <div className="activity" key={activity.activityId}>
         <div className="activity-body">
           <h5 className="activity-title">{activity.name}</h5>
           <p className="card-text">{activity.location}</p>
           <p className="card-text">{activity.description}</p>
           <p className="card-text">rating: {activity.rating}    ${activity.cost}</p>
           <p className="card-text">{activity.isIndoor ? 'Indoor' : 'Outdoor'}</p>
 </div>
 </div>
 ))}
       </div>
 </div>

 );
 }
//
//   <div>
//      <div>All Activities</div>
//     <ul>
//               {activities.map((activity) => (
//          <li key={activity.activityId}>
//         <div key={activity.activityId}>
//           <strong>{activity.name}</strong>
//           <p>{activity.location}</p>
//           <p>{activity.description}</p>
//           <p>rating: {activity.rating}    ${activity.cost}</p>
//           <p>{activity.isIndoor ? 'Indoor' : 'Outdoor'}</p>
//           </div>
//           </li>
//           ))}
//     </ul>
// </div>
// );
// }



export default AllActivities;