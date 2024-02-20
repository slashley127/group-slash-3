import React from 'react'
import { useLocation } from 'react-router-dom';


function Profile() {

const navigate = useNavigate();
const location = useLocation();
const userData = location.state.user;


const importData = async (dataList) => {
  try {
    const response = await fetch('http://localhost:8080/api/importData', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(dataList),
    });

    if (response.ok) {
      console.log('Data imported successfully');
    } else {
      console.error('Failed to import data');
    }
  } catch (error) {
    console.error('Error during data import:', error);
  }
};

  return (
 <div>

    <div><h1> My Profile</h1></div>
    <p>Username: {userData.userName}</p>
    <p>Email: {userData.email}</p>
    <p>First name: {userData.firstName}</p>
    <p>Last name: {userData.lastName}</p>
    </div>

  )
}

export default Profile