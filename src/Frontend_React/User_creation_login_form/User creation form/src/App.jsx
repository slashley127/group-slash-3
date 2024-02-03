import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
import Profile from './Profile';
import "bootstrap/dist/css/bootstrap.min.css";
import React, { useEffect, useState } from 'react';

const App = () => {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('http://localhost:8080/api/users')
      .then(response => response.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }
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
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<Login/>}> </Route>
            <Route path='/signup' element={<Signup/>}> </Route>
            <Route path='/profile' element={<Profile user={user}/>} />
        </Routes>
    </BrowserRouter>
  )
}

export default App
