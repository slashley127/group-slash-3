import { Link, useNavigate } from 'react-router-dom'
import React, { useState } from 'react';
import Profile from './Profile'
import Login from './Login'

function Signup() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    firstName: '',
    lastName: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });
      if (response.ok) {
        const userData = await response.json();

        navigate("/Profile", { user: userData });
      }

      if (!response.ok) {
        throw new Error('Failed to sign up');
      }

    } catch (error) {
      console.error('Error signing up:', error);

    }
  };

  return (
     <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
          <div className='form-container p-5 rounded bg-white mx-auto'>
            <form onSubmit={handleSubmit}>
              <h3 className="text-center">Sign Up</h3>
              <div className='mb-2'>
                <label htmlFor="first name">First Name</label>
                <input
                  type="text"
                  name="firstName"
                  placeholder='First Name'
                  className='form-control'
                  value={formData.firstName}
                  onChange={handleChange}
                />
              </div>
              <div className='mb-2'>
                <label htmlFor="last name">Last Name</label>
                <input
                  type="text"
                  name="lastName"
                  placeholder='Last Name'
                  className='form-control'
                  value={formData.lastName}
                  onChange={handleChange}
                />
              </div>
              <div className='mb-2'>
                <label htmlFor="email">Email</label>
                <input
                  type="email"
                  name="email"
                  placeholder='Enter Email'
                  className='form-control'
                  value={formData.email}
                  onChange={handleChange}
                />
              </div>
              <div className='mb-2'>
                <label htmlFor="Password">Password</label>
                <input
                  type="password"
                  name="password"
                  placeholder='Enter Password'
                  className='form-control'
                  value={formData.password}
                  onChange={handleChange}
                />
              </div>
              <div className='d-grid'>
               <Link to="/Profile" className='btn btn-primary'>Sign Up</Link>
                <p className='text-end mt-2'>
                   Already Registered
                  <Link to="/" className="ms-2">Sign in</Link>
                </p>
              </div>
            </form>
          </div>
        </div>
      );
    }

export default Signup;


// function Signup() {
//   return (
//     <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
//       <div className='form-container p-5 rounded bg-white mx-auto'>
//         <form action="">
//           <h3 className="text-center"> Sign In</h3>
//           <div className='mb-2'>
//             <label htmlFor="first name">Last Name</label>
//             <input type="text" placeholder='First Name' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="last name">First Name</label>
//             <input type="text" placeholder='Last Name' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="email">Email</label>
//             <input type="email" placeholder='Enter Email' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="Password">Password</label>
//             <input type="Password" placeholder='Enter Password' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <input type="checkbox" className='custom-control custom-checkbox' id="check" />
//             <label htmlFor="check" className='custom-input-label ms-2 '>
//               Remember me
//             </label>
//           </div>
//           <div className='d-grid'>
//             <button className='btn btn-primary'> Sign Up</button>
//             <p className='text-end mt-2'>
//               Already Registered
//               <Link to="/" className="ms-2"> Sign in</Link>
//             </p>
//           </div>
//         </form>
//       </div>
//     </div>
//   )
// }
//
// export default Signup

// import React from 'react'
// import { Link } from 'react-router-dom'
// import Profile from './Profile'
// import Login from './Login'
//
// function Signup() {
//   return (
//     <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
//       <div className='form-container p-5 rounded bg-white mx-auto'>
//         <form action="">
//           <h3 className="text-center"> Sign In</h3>
//           <div className='mb-2'>
//             <label htmlFor="first name">Last Name</label>
//             <input type="text" placeholder='First Name' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="last name">First Nam</label>
//             <input type="text" placeholder='Last Name' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="email">Email</label>
//             <input type="email" placeholder='Enter Email' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="Password">Password</label>
//             <input type="Password" placeholder='Enter Password' className='form-control' />
//           </div>
//           <div className='mb-2'>
//             <input type="checkbox" className='custom-control custom-checkbox' id="check" />
//             <label htmlFor="check" className='custom-input-label ms-2 '>
//               Remember me
//             </label>
//           </div>
//           <div className='d-grid'>
//           <button className='btn btn-primary'>  <Link to="/Profile" className="ms-2"> Sign Up</Link></button>
//             <p className='text-end mt-2'>
//               Already Registered
//               <Link to="/" className="ms-2"> Sign in</Link>
//             </p>
//           </div>
//         </form>
//       </div>
//     </div>
//   )
// }
//
// export default Signup