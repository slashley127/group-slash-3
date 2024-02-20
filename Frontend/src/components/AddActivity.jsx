  import React, { useState } from 'react'
  // import React, { useState } from 'react';
  import { Link, useNavigate } from 'react-router-dom';
  import { Card } from 'react-bootstrap';
  import { FaSearch } from 'react-icons/fa';


function AddActivity() {
const navigate = useNavigate();
const [activityForm, setActivity] = useState({
    name: '',
    location: '',
    description: '',
    cost: '',
    isIndoor: '',
    rating: ''
    });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setActivity({ ...activityForm, [name]: value });
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/addactivity', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(activityForm)
      });
      if (response.ok) {
               const newActivityDTO = await response.json();

               navigate("/AllActivities", {state: { newActivityDTO: activityForm}});

      } else {
        throw new Error('Failed to submit activity');
      }
    } catch (error) {
      console.error('Error submitting activity:', error);
    }
  };

  return (

   <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
                <div className='form-container p-5 rounded bg-white mx-auto'>
                  <form onSubmit={handleSubmit}>
                    <h3 className="text-center">Add Activity</h3>
                     <div className='mb-2'>
                         <label htmlFor="name">Activity Name:</label>
                            <input
                              type="text"
                              name="name"
                              placeholder='Enter Activity name'
                              className='form-control'
                              value={activityForm.name}
                               onChange={handleChange}
                            />
                          </div>
                    <div className='mb-2'>
                      <label htmlFor="location">Location:</label>
                      <input
                        type="text"
                        name="location"
                        placeholder='City Name'
                        className='form-control'
                        value={activityForm.location}
                        onChange={handleChange}
                      />
                    </div>
                    <div className='mb-2'>
                      <label htmlFor="description">Description:</label>
                      <input
                        type="text"
                        name="description"
                        placeholder='Explain the Activity for others!'
                        className='form-control'
                        value={activityForm.description}
                        onChange={handleChange}
                      />
                    </div>
                    <div className='mb-2'>
                      <label htmlFor="cost">Cost:</label>
                      <input
                        type="number"
                        id="cost"
                        name="cost"
                        min="0"
                        max="9999"
                        className='form-control'
                        value={activityForm.cost}
                        onChange={handleChange}
                      />
                    </div>
                    <div className='mb-2'>
                      <label htmlFor="rating">Rating: (1-5)</label>
                      <input
                        type="number"
                        id="rating"
                        name="rating"
                        min="0"
                        max="5"
                        className='form-control'
                        value={activityForm.rating}
                        onChange={handleChange}
                      />
                    </div>
                    <div>
                        <p>Indoor or Outdoor Activity</p>

                      <input
                        type="radio"
                        id="indoor"
                        name="isIndoor"
                        value="true"
                        checked={activityForm.isIndoor === 'true'}
                        onChange={handleChange} />
                      <label htmlFor="indoor">Indoor</label>

                      <input
                        type="radio"
                        id="outdoor"
                        name="isIndoor"
                        value="false"
                        checked={activityForm.isIndoor === 'false'}
                        onChange={handleChange} />
                      <label htmlFor="outdoor">Outdoor</label>
                    </div>

                    <div className='d-grid'>
                     <button type="submit" className='btn btn-primary'>Add Activity</button>
                    </div>
                  </form>
                </div>
              </div>

    );
  }


export default AddActivity;