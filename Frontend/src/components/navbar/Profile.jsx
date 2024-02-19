import React from 'react'
import { useLocation } from 'react-router-dom';

function Profile() {

const navigate = useNavigate();
const location = useLocation();
const userData = location.state.user;


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