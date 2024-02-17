import React, { useState } from 'react';
import './Bottom.css';
import { Card } from 'react-bootstrap/esm';


// Importing images
import img5 from "../../assets/img(5).jpg";
import img6 from "../../assets/img(6).jpg";
import img7 from "../../assets/img(7).jpg";

// Data array
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

function Bottom() {


  return (
    <section>
      <Card>
        <Card.Body className="text-center bg-secondary text-white my-2 py-2  fst-italic">
          Most visited destinations
        </Card.Body>
      </Card>

      <div className="card-group">
       {Data.map((item) => ( 
          <div className="card" key={item.id}>
            <img className="card-img-top" src={item.imgSrc} alt="Card cap" />
            <div className="card-body">
              <h5 className="card-title">{item.name}</h5>
              <p className="card-text">{item.location}</p>
              <p className="card-text">{item.description}</p>
              <p className="card-text">{item.cost}</p>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}

export default Bottom;
