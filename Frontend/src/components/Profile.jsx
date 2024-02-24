import React from 'react';
import { useLocation } from 'react-router-dom';
import { useState, useEffect } from 'react';

function Profile() {
        const location = useLocation();
    const [userData, setUserData] = useState(null);
//     const userData = location.state && location.state.user;

    useEffect(() => {
    const fetchUserData = async () => {
    try {
     const response = await fetch('http://localhost:8080/api/users');

     if (response.ok) {
     const data = await response.json();
     setUserData(data);
     } else {
     console.error('Failed to fetch user profile. Server returned:' ,response.status);
     }
     } catch (error) {
     console.error('Error fetching user profile:', error);
     }
     };

     fetchUserData();
     }, []);

     if (!userData) {
     return <div>Loading...</div>;
     }

  return (
    <div>
      <div className="profile-title">My Profile</div>
      {userData && (
            <div className="profile-info">
          <p>Name: {userData.firstName} {userData.lastName}</p>
          <p>Username: {userData.userName}</p>
          <p>Email: {userData.email}</p>
          <p>Planned Trips: {userData.trips}</p>
         </div>
         )}
    </div>
  );
}

export default Profile;