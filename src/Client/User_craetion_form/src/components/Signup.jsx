import React, { useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import Profile from './Profile';
import Login from './Login';
import App from './App';

function Signup() {
const [firstName, setFirstName] = useState("");
const [lastName, setLastName] = useState("");
const [email, setEmail] = useState("");
const [password, setPassword] = useState("");
const history = useHistory();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("api/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });
      if (response.ok) {

        const userData = await response.json();

        localStorage.setItem("userData", JSON.stringify(userData));

        history.push("/profile");
      } else {

        console.error("Login failed");
      }
    } catch (error) {
      console.error("Error logging in:", error);
    }
  };
//   return (
//     <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
//       <div className='form-container p-5 rounded bg-white mx-auto'>
//         <form onSubmit={handleSubmit}>
//           <h3 className="text-center"> Sign In</h3>
//           <div className='mb-2'>
//             <label htmlFor="first name">Last Name</label>
//             <input type="text" placeholder='First Name' className='form-control'
//             onChange={(e) => setFirstName(e.target.value)}/>
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="last name">First Name</label>
//             <input type="text" placeholder='Last Name' className='form-control'
//             onChange={(e) => setLastName(e.target.value)}/>
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="email">Email</label>
//             <input type="email" placeholder='Enter Email' className='form-control'
//             onChange={(e) => setEmail(e.target.value)}/>
//           </div>
//           <div className='mb-2'>
//             <label htmlFor="Password">Password</label>
//             <input type="Password" placeholder='Enter Password' className='form-control'
//             onChange={(e) => setPassword(e.target.value)}/>
//           </div>
//           <div className='mb-2'>
//             <input type="checkbox" className='custom-control custom-checkbox' id="check" />
//             <label htmlFor="check" className='custom-input-label ms-2 />
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
return (
    <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
      <div className='form-container p-5 rounded bg-white mx-auto'>
        <form onSubmit={handleSubmit}>
          <h3 className="text-center"> Sign Up</h3>
          <div className='mb-2'>
            <label htmlFor="first name">First Name</label>
            <input type="text" placeholder='First Name' className='form-control' onChange={(e) => setFirstName(e.target.value)} />
          </div>
          <div className='mb-2'>
            <label htmlFor="last name">Last Name</label>
            <input type="text" placeholder='Last Name' className='form-control' onChange={(e) => setLastName(e.target.value)} />
          </div>
          <div className='mb-2'>
            <label htmlFor="email">Email</label>
            <input type="email" placeholder='Enter Email' className='form-control' onChange={(e) => setEmail(e.target.value)} />
          </div>
          <div className='mb-2'>
            <label htmlFor="Password">Password</label>
            <input type="Password" placeholder='Enter Password' className='form-control' onChange={(e) => setPassword(e.target.value)} />
          </div>
          <div className='mb-2'>
            <input type="checkbox" className='custom-control custom-checkbox' id="check" />
            <label htmlFor="check" className='custom-input-label ms-2'>Remember me</label>
          </div>
          <div className='d-grid'>
            <button type="submit" className='btn btn-primary'>Sign Up</button>
            <p className='text-end mt-2'>
              Already Registered?
              <Link to="/Login" className="ms-2">Sign in</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Signup