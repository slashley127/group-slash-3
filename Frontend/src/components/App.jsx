import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useAuth0 } from '@auth0/auth0-react';
import Navbar from './Navbar';
import Home from './Home';
import Login from './Login';
import Signup from './Signup';
import Profile from './Profile';
import Trip from './Trip';
import AddActivity from './AddActivity';
import AllActivities from './AllActivities';
import SelectActivities from './SelectActivities';
import CreateTrip from './CreateTrip';
import WeatherWidget from './WeatherWidget';
import "bootstrap/dist/css/bootstrap.min.css";
import Bottom from './Bottom';

const App = () => {
  const { isLoading, error } = useAuth0();
  const [user, setUser] = useState(null);

  useEffect(() => {
    if (!isLoading) {
      setUser(null); // Reset user state on loading to ensure updated data
    }
  }, [isLoading]);

  return (
    <main className="column">
      {error && <p>Authentication Error</p>}
      {!error && isLoading && <p>Loading...</p>}
      {!error && !isLoading && (
        <BrowserRouter>
          <Navbar />
          <Routes>
            <Route path='/' element={<div>  <Home />  <Bottom/> </div>} />
            <Route path='/signup' element={<Signup />} />
            <Route path='/weatherWidget' element={<WeatherWidget />} />
            <Route path='/profile' element={<Profile />} />
            <Route path='/trip' element={<Trip />} />
            <Route path='/create' element={<CreateTrip />} />
            <Route path='/AllActivities' element={<AllActivities />} />
            <Route path='/addactivity' element={<AddActivity />} />
            <Route path='/select' element={<SelectActivities />} />
            <Route path='/login' element={<Login />} />
          </Routes>
        </BrowserRouter>
      )}
    </main>
  );
}

export default App;
