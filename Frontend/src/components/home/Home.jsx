import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './Home.css';
import img5 from "../../assets/img(5).jpg";
import img6 from "../../assets/img(6).jpg";
import img7 from "../../assets/img(7).jpg";
import data from "../../assets/Activites-Data.json";

const Home = () => {
  const [value, setValue] = useState("");

  const onChange = (event) => {
    setValue(event.target.value);
  };

  const onSearch = (searchTerm) => {
    setValue(searchTerm);
    // our api to fetch the search result
    console.log("search ", searchTerm);
  };

  return (
    <section id='home' className='home'>
    <div className="overlay"></div>
    <div data-aos="fade-down" className="homeContent container">
      <div className="textDiv">
        <span className="fst-italic">
          Welcome to our trip planner
        </span>
        <h3 className="text-center bg-primary text-white my-1 py-2 rounded-lg shadow-lg fst-italic" style={{ borderRadius: '1rem' }}>
  Search for Your Perfect Holiday
</h3>

      </div>
        <div className="input flex"
        >
          <input type="text" value={value} onChange={onChange} />
          <button type="button" className="btn btn-primary " data-mdb-ripple-init onClick={() => onSearch(value)}> Search </button>
        </div>
        <div className="dropdown">
          {data
            .filter((item) => {
              const searchTerm = value.toLowerCase();
              const location = item.location.toLowerCase();

              return (
                searchTerm &&
                location.startsWith(searchTerm) &&
                location !== searchTerm
              );
            })
            .slice(0, 10)
            .map((item) => (
              <div
                onClick={() => onSearch(item.location)}
                className="dropdown-row"
                key={item.id}
              >
                {item.name}
              </div>
            ))}
        </div>
</div>
</section>
  );
}

export default Home;
