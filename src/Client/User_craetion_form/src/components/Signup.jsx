import React from 'react'
import { Link } from 'react-router-dom'
import Profile from './Profile'
import Login from './Login'

function Signup() {
  return (
    <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
      <div className='form-container p-5 rounded bg-white mx-auto'>
        <form action="">
          <h3 className="text-center"> Sign In</h3>
          <div className='mb-2'>
            <label htmlFor="first name">Last Name</label>
            <input type="text" placeholder='First Name' className='form-control' />
          </div>
          <div className='mb-2'>
            <label htmlFor="last name">First Nam</label>
            <input type="text" placeholder='Last Name' className='form-control' />
          </div>
          <div className='mb-2'>
            <label htmlFor="email">Email</label>
            <input type="email" placeholder='Enter Email' className='form-control' />
          </div>
          <div className='mb-2'>
            <label htmlFor="Password">Password</label>
            <input type="Password" placeholder='Enter Password' className='form-control' />
          </div>
          <div className='mb-2'>
            <input type="checkbox" className='custom-control custom-checkbox' id="check" />
            <label htmlFor="check" className='custom-input-label ms-2 '>
              Remember me
            </label>
          </div>
          <div className='d-grid'>
          <button className='btn btn-primary'>  <Link to="/Profile" className="ms-2"> Sign Up</Link></button>
            <p className='text-end mt-2'>
              Already Registered
              <Link to="/" className="ms-2"> Sign in</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Signup