import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './Home.css';
import img5 from "../../assets/img(5).jpg";
import img6 from "../../assets/img(6).jpg";
import img7 from "../../assets/img(7).jpg";

const Data = [
  {
    id: 1,
    imgSrc: img5,
    name: 'St Louis Zoo',
    location: 'St Louis',
    description: 'Amazing, large zoo with tons of animals far and wide',
    cost: "0 $",
    rating: 5,
    isIndoor: false
  },
  {
    id: 2,
    imgSrc: img6,
    name: 'The Gateway Arch',
    location: 'St Louis',
    description: 'A 630 foot tall stainless steel monument in the form of a weighted catenary arch and is the worlds tallest arch',
    cost: "18 $",
    rating: 4.6,
    isIndoor: false
  },
  {
    id: 3,
    imgSrc: img7,
    name: 'Missouri Botanical Gardens',
    location: 'St Louis',
    description: "A botanical garden known informally as Shaw's Garden for the founder and philanthropist Henry Shaw",
    cost: "16 $",
    rating: 4.6,
    isIndoor: false
  }
];

const Home = () => {
  const [searchQuery, setSearchQuery] = useState('');

  return (
    <section id='home' className='home'>
      <div className="overlay"></div>
      <div data-aos="fade-down" className="homeContent container">
        <div className="textDiv">
          <span className="fst-italic">
            Welcome to our trip planner
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
          <div className="card-group">
          {Data.filter((item) => {
  return searchQuery.toLowerCase() === '' ? item : item.location.toLowerCase().includes(searchQuery);
}).map((item) => (
  <div className="card" key={item.id}>
    <div className="card-body">
      <h5 className="card-title">{item.name}</h5>
      <p className="card-text">{item.location}</p>
      <p className="card-text">{item.description}</p>
    
    </div>
  </div>
))}
          </div>
        </div>
      </div>
    </section>
  );
}

export default Home;
