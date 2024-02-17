import { Link, useNavigate } from 'react-router-dom';
import React, { useState } from 'react';



function CreateTrip() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    tripLocation: '',
    travelers: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/trips/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });
      if (response.ok) {
        const tripData = await response.json();

        navigate("/Trip", { state: { trip: tripData } });
      } else {
        throw new Error('Failed to create trip');
      }
    } catch (error) {
      console.error('Error creating trip:', error);
    }
  };

  return (
     <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
              <div className='form-container p-5 rounded bg-white mx-auto'>
                <form onSubmit={handleSubmit}>
                  <h3 className="text-center">Create Trip</h3>
                   <div className='mb-2'>
                       <label htmlFor="location">Trip Location</label>
                          <input
                            type="text"
                            name="location"
                            placeholder='Enter trip location'
                            className='form-control'
                            value={formData.location}
                             onChange={handleChange}
                          />
                        </div>
                  <div className='mb-2'>
                    <label htmlFor="travelers">Travelers</label>
                    <input
                      type="text"
                      name="travelers"
                      placeholder='Travelers'
                      className='form-control'
                      value={formData.travelers}
                      onChange={handleChange}
                    />
                  </div>
                  <div className='d-grid'>
                   <button type="submit" className='btn btn-primary'>Create Trip</button>
                  </div>
                </form>
              </div>
            </div>
  );
}

export default CreateTrip;
