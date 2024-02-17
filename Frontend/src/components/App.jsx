
import { BrowserRouter as Router, Route,Routes } from 'react-router-dom';

import Login from './home/Login';
import Signup from './home/Signup';
import Home from './home/Home';
import All_activites from './navbar/All_activites';

import Create_Trip from './navbar/Create_Trip';
import About_us from './navbar/About_us';
import "bootstrap/dist/css/bootstrap.min.css";
import React, { useEffect, useState } from 'react';
import Navbar from './navbar/Navbar';
import Profile from './navbar/Profile';
import Bottom from './home/Bottom';
import {AuthProvider} from './context/AuthContext'
import { Navigate } from 'react-router-dom';
import PrivateRoute from '../PrivateRoute';

import './navbar/Profile'



const App = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/users');
      if (!response.ok) {
        throw new Error('Failed to fetch users');
      }
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      console.error('Error fetching users:', error);
    } finally {
      setLoading(false); // Set loading to false regardless of success or failure
    }
  };

  const createUser = async (userData) => {
    try {
      const response = await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
      });
      if (!response.ok) {
        throw new Error('Failed to create user');
      }
      const updatedUsers = await response.json();
      setUsers(updatedUsers);
    } catch (error) {
      console.error('Error creating user:', error);
    }
  };

  return (
    <>
    <AuthProvider>
      <Router>
        <Navbar />
       


        <Routes>
          <Route index element={ <Home/>}/>
          <Route path='/login' element={<Login />} />
          <Route path='/signup' element={<Signup />} />
          <Route path="/all_activites" element={<All_activites/>} />
          <Route path="/create_trip" element={<Create_Trip />} />
          <Route path="/create_trip" element={<Profile />} />
          <Route path="/about_us" element={<About_us />} />
        </Routes>
        < Bottom/>
      </Router>
    </AuthProvider>


</>

  );
}
export default App;
