import React from 'react'
// import React, { useState } from 'react';
import { Card } from 'react-bootstrap';
import { FaSearch } from 'react-icons/fa';
import './All_activities.css';



function SearchActivities() {
    const [searchQuery, setSearchQuery] = useState('');
    const [filteredResults, setFilteredResults] = useState([]);

    useEffect(() => {

    fetch(`http://localhost:8080/api/items?search=${searchQuery}`)
    }, [searchQuery]);

    return (
    <div>
        <input
            type="text"
            placeholder="Search items..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            />

            <ul>
            {filteredResults.map((item) => (
                <li key={item.id}>{item.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default SearchActivities;