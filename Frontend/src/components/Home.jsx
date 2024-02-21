import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './Home.css';

const Home = () => {
  const [searchQuery, setSearchQuery] = useState('');

  return (
    <section id='home' className='home'>
      <div className="overlay"></div>
      <div data-aos="fade-down" className="homeContent container">
        <div className="textDiv">
          <span className="fst-italic">
            Welcome to our Day Trip Planner
          </span>
          <h3 className="text-center bg-primary text-white my-1 py-1 rounded-lg shadow-lg  fst-italic">
            Search for Your Perfect Holiday
          </h3>
        </div>
        <div className="card-center bg-secondary text-white my-0 py-2">
          <div className="destinationInput">
            <label htmlFor="city" className="fst-italic">Search your destination:</label>
            <div className="input flex">
              <input type="text" onChange={(e) => setSearchQuery(e.target.value)} placeholder="Search..." />
            </div>
            <button type="button" className="btn btn-black-primary" data-mdb-ripple-init>Search</button>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Home;
