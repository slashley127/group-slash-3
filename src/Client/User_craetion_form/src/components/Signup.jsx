import React from 'react'
import { Link } from 'react-router-dom'
import Profile from './Profile'
import Login from './Login'

function Signup() {
  return (
    <div className='signup template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'
       style={{
        backgroundImage: `url('https://4.bp.blogspot.com/-TrQ_PEyE1F0/T4d9VmIsP-I/AAAAAAAAHnc/-qREJB_54ko/s1600/DSC01359.jpg')`,
        backgroundSize: "cover",
      }}>
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
               className='btn btn-primary'
              <div className="d-grid">
               <Link to="/Profile" className="btn btn-primary">
              Sign UP
               </Link>
               </div>
          
          </div>
        </form>
      </div>
    </div>
  )
}

export default Signup