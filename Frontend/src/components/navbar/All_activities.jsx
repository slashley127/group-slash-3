import React from 'react'
// import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './All_activities.css';

const activityData = [{id: 1,
                       name: 'Venice Cafe',
                       location: 'St Louis',
                       description: 'Beautiful mosaic dive bar with music every single night and artwork you need to see to believe',
                       cost: 0,
                       rating: 4.6,
                       isIndoor: true
                       },
                       {id: 2,
                       name: 'St Louis Zoo',
                       location: 'St Louis',
                       description: 'Amazing, large zoo with tons of aniamls far and wide',
                       cost: 0,
                       rating: 5,
                         isIndoor: false
                       },
                       {id: 3,
                       name: 'Play at the Fox Theatre',
                       location: 'St Louis',
                       description: 'Amazing plays thrown in a gorgeous old theatre from 1929 and restored in 1982',
                       cost: 150,
                       rating: 5,
                         isIndoor: true
                       },
                       {id: 4,
                       name: 'St Louis Science Center',
                       location: 'St Louis',
                       description: 'Outstanding Science Center for children and teens alike',
                       cost: 0,
                       rating: 4.7,
                         isIndoor: true
                       },
                       {id: 5,
                       name: 'Missouri Botanical Gardens',
                       location: 'St Louis',
                       description: "A botanical garden lknown informally as Shaw's Garden for the founder and philanthropist Henry Shaw",
                       cost: 16,
                       rating: 4.6,
                         isIndoor: false
                       },
                       {id: 6,
                       name: 'The Gateway Arch',
                       location: 'St Louis',
                       description: ' A 630 foot tall stainless steel monument in the form of a weighted catenary arch and is the worlds tallest arch',
                       cost: 18,
                       rating: 4.7,
                         isIndoor: false
                       },
                       {id: 7,
                       name: 'Millennium Park',
                       location: 'Chicago',
                       description: ' a public park jam packed with public art exhibits and sculptures, most notably "the bean" located in the Loop community area of Chicago with a dog park, skateboarding area and picnic area',
                       cost: 0,
                       rating: 4.8,
                         isIndoor: false
                       },
                       {id: 8,
                       name: 'Private Helicopter Ride',
                       location: 'Chicago',
                       description: '45 minute private helicopter ride around the city of Chicago',
                       cost: 849,
                       rating: 4.5,
                         isIndoor: false
                       },
                       {id: 9,
                       name: 'City Museum',
                       location: 'St Louis',
                       description: 'a museum whose exhibits consist largely of repurposed architectural and industrial objects turned into a fun unbelievable play area fro children and adults alike housed in the former international Shoe building',
                       cost: 24,
                       rating: 4.8,
                         isIndoor: true
                       },
                       {id: 10,
                       name: 'Nascar Go Bowling at the Glen',
                       location: 'Watkins Glen',
                       description: 'The drivers of the NASCAR Cup Series continue to battle it out around the historic New York road course!',
                       cost: 100,
                       rating: 4.7,
                         isIndoor: false
                       },
                       {id: 11,
                       name: 'Six Flags St Louis',
                       location: 'St Louis',
                       description: 'An amusement park featuring characters and rides from many Warner Bros films and Tv shows',
                       cost: 45,
                       rating: 4.2,
                         isIndoor: false
                       },
                       {id: 12,
                       name: 'Grants Farm',
                       location: 'St Louis',
                       description: 'A historic farm and long-standing landmark in Grantwood Village, Missouri built by Ulysses S. Grant on land given to him and his wife by his father in law Frederick Fayette Dent shortly after they became married in 1848',
                       cost: 40,
                       rating: 4.2,
                         isIndoor: false
                       },
                       {id: 13,
                       name: 'Kansas City Zoo & Aquarium',
                       location: 'Kansas City',
                       description: 'A 202-acre zoo founded in 1909, located in Swope Park and is a home to nearly 10,000 animal.',
                       cost: 22,
                       rating: 4.3,
                         isIndoor: false
                       },
                       {id: 14,
                       name: 'Worlds of Fun',
                       location: 'Kansas City',
                       description: 'An entertainment complex with more than 235 acres, founded by American businessman Lamar Hunt and Jack Steadman.',
                       cost: 90,
                       rating: 4.3,
                         isIndoor: false
                       },
                       {id: 15,
                       name: 'Laumeier Sculpture Park',
                       location: 'St Louis',
                       description: 'An 105-acre open-air museum and sculpture park located near St. Louis and houses over 60 outdoor sculptures and features a 1.4-mile walking trail, and educational programs.',
                       cost: 0,
                       rating: 4.7,
                         isIndoor: false
                       },
                       {id: 16,
                       name: 'Ryze Adventure Park',
                       location: 'St Louis',
                       description: 'St Louis ropes course, zip line, mini golf and more',
                       cost: 60,
                       rating: 4.8,
                         isIndoor: false
                       },
                       {id: 17,
                       name: 'Vertical Voyages',
                       location: 'St Louis',
                       description: 'a rock and tree climbing',
                       cost: 150,
                       rating: 5.0,
                         isIndoor: false
                       },
                       {id: 18,
                       name: 'Meramec Caverns',
                       location: 'St Louis',
                       description: 'the largest commercial cave in the state and one of the most awe-inspiring caves on the planet, which were formed from the erosion of large limestone deposits over millions of years',
                       cost: 25,
                       rating: 4.6,
                         isIndoor: false
                       },
                       {id: 19,
                       name: 'Victory Raceway',
                       location: 'St Louis',
                       description: 'A 56,000 square foot indoor go kart race track with electric karts reaching speeds up to 45mph',
                       cost: 26,
                       rating: 4.5,
                         isIndoor: true
                       },
                       {id: 20,
                       name: 'Top Notch Axe Throwing',
                         location: 'St Louis',
                         description: 'An hour and a half axe throwing experience that lets you bring your own alcohol and light snacks',
                         cost: 35,
                         rating: 4.9,
                         isIndoor: true
                       }
                       ];


function AllActivities() {

//     const [searchQuery, setSearchQuery] = useState('');

//     const handleSearch = () => {
//     console.log('Search Results:');
//     };

// importData(activityData);


  return (
  <div>
   <div className="all-activities-title">All Activities</div>
{/*      <div className="destinationInput"> */}
    <div className="activity-group">
              {activityData.map((item) => (
        <div className="activity" key={item.id}>
        <div className="activity-body">
          <h5 className="activity-title">{item.name}</h5>
          <p className="card-text">{item.location}</p>
          <p className="card-text">{item.description}</p>
          <p className="card-text">rating: {item.rating}    ${item.cost}</p>
          <p className="card-text">{item.isIndoor ? 'Indoor' : 'Outdoor'}</p>
</div>
</div>
))}
      </div>
</div>
//       </div>

);
}



export default AllActivities;