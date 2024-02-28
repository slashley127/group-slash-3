import React from "react";
import "./App.css";
import { Link } from "react-router-dom";
import Profile from "./Profile";

function Login() {
  return (
    <div
      className="login template d-flex justify-content-center align-items-center vh-100 bg-primary"
      style={{
        backgroundImage: `url('https://cxeffect.com/wp-content/uploads/2021/12/Services_Header-2.png')`,
        backgroundSize: "cover",
      }}
    >
      <div className="form-container p-5 rounded bg-white mx-auto">
        <form action="">
          <h3 className="text-center">Sign In</h3>
          <div className="mb-2">
            <label htmlFor="email">Email</label>
            <input type="email" placeholder="Enter Email" className="form-control" />
          </div>
          <div className="mb-2">
            <label htmlFor="password">Password</label>
            <input type="password" placeholder="Enter Password" className="form-control" />
          </div>
          <div className="mb-2">
            <input type="checkbox" className="custom-control-input" id="check" />
            <label htmlFor="check" className="custom-control-label ms-2">
              Remember me
            </label>
          </div>
          <div className="d-grid">
            <Link to="/Profile" className="btn btn-primary">
              Sign In
            </Link>
            <p className="text-end mt-2">
              Forgot <a href="/">Password?</a>
              <Link to="/signup" className="ms-2">
                Sign Up
              </Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;