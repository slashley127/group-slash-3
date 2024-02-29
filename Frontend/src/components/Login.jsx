import "./App.css";
import React, { useState } from "react";
import { useAuth0 } from '@auth0/auth0-react';

function Login() {
  const { loginWithRedirect } = useAuth0();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/api/email", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        const userData = await response.json();
        localStorage.setItem("userData", JSON.stringify(userData));
        // No need to use <Link> here, just navigate programmatically
        window.location.href = "/Profile"; // Redirect to the Profile page
      } else {
        console.error("Login failed");
      }
    } catch (error) {
      console.error("Error logging in:", error);
    }
  };

  return (
    <div className='login template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
      <div className='form-container p-5 rounded bg-white mx-auto'>
        <form onSubmit={handleSubmit}> {/* Use onSubmit to handle form submission */}
          <h3 className="text-center"> Sign In</h3>
          <div className='mb-2'>
            <label htmlFor="name">your name</label>
            <input type="name" placeholder='Enter Your  Name' className='form-control' value={email}
              onChange={(e) => setEmail(e.target.value)}
              required />
          </div>
          <div className='mb-2'>
            <input type="checkbox" className='custom-control custom-checkbox' id="check" />
            <label htmlFor="check" className='custom-input-label ms-2 '>
              Remember me
            </label>
          </div>
          <div className='d-grid'>
            <button  className='btn btn-primary'  onClick={() => loginWithRedirect()}>Sign In</button> {/* Use type="submit" to submit the form */}
            <p className='text-end mt-2'>
              Forgot <a href=""> Password?</a>
              <a href="/signup" className="ms-2"> Sign Up</a> {/* Use anchor tags for navigation */}
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;