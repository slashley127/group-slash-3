import {BrowserRouter,Routes,Route} from 'react-router-dom'
import Login from './Login'
import Signup from './Signup'
import "bootstrap/dist/css/bootstrap.min.css"
import React, { useEffect, useState } from 'react';

const App = () => {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('api/users')
      .then(response => response.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<Login/>}> </Route>
            <Route path='/signup' element={<Signup/>}> </Route>


        </Routes>



    </BrowserRouter>
  )
}

export default App