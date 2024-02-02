import React, { useState, useEffect } from "react";
import { Link, useHistory, Redirect } from "react-router-dom";
import { useAuth } from "./Auth";

function Login() {
  const auth = useAuth(); // Rename this variable to avoid conflict
  const history = useHistory();
  const isLoggedIn = auth.isAuthenticated(); // Update this line to use the correct variable

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const [isError, setIsError] = useState(false);

  useEffect(() => {
    // Check if there's a remembered user in local storage
    const rememberedUser = localStorage.getItem("rememberedUser");
    if (rememberedUser) {
      setUsername(rememberedUser);
      setRememberMe(true);
    }
  }, []);

  const handleInputChange = (e) => {
    const { name, value, checked } = e.target;
    if (name === "username") {
      setUsername(value);
    } else if (name === "password") {
      setPassword(value);
    } else if (name === "rememberMe") {
      setRememberMe(checked);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!(username && password)) {
      setIsError(true);
      return;
    }

    try {
      // Replace the following line with the actual authentication function
      // const response = await authenticate(username, password);
      // Example:
      // const response = await myAuthService.authenticate(username, password);

      // After successful authentication, set the user data or token as needed
      // const { id, name, role } = response.data;
      // const authdata = window.btoa(username + ":" + password);
      // const authenticatedUser = { id, name, role, authdata };
      // auth.login(authenticatedUser); // Update this line to use the correct variable

      // Remember the user if the checkbox is checked
      if (rememberMe) {
        localStorage.setItem("rememberedUser", username);
      } else {
        localStorage.removeItem("rememberedUser");
      }

      setUsername("");
      setPassword("");
      setIsError(false);

      // Redirect to the Profile page after successful login
      history.push("/profile");
    } catch (error) {
      console.error("Authentication failed:", error);
      setIsError(true);
    }
  };

  if (isLoggedIn) {
    // Redirect to the Profile page if the user is already logged in
    return <Redirect to="/" />;
  }

  return (
    <div className="login template d-flex justify-content-center align-items-center vh-100 bg-primary" style={{backgroundImage: `url('https://i.pinimg.com/originals/33/f3/56/33f356a5c8a0a2a13e921f8e10ffb7b9.jpg')`, backgroundSize: "cover"}}>
      <div className="form-container p-5 rounded bg-white mx-auto">
        <form onSubmit={handleSubmit}>
          <h3 className="text-center">Sign In</h3>
          <div className="mb-2">
            <label htmlFor="email">Email</label>
            <input type="email" name="username" value={username} onChange={handleInputChange} placeholder="Enter Email" className="form-control" />
          </div>
          <div className="mb-2">
            <label htmlFor="password">Password</label>
            <input type="password" name="password" value={password} onChange={handleInputChange} placeholder="Enter Password" className="form-control" />
          </div>
          <div className="mb-2">
            <input type="checkbox" name="rememberMe" checked={rememberMe} onChange={handleInputChange} className="custom-control-input" id="check" />
            <label htmlFor="check" className="custom-control-label ms-2">
              Remember me
            </label>
          </div>
          <div className="d-grid">
            <button type="submit" className="btn btn-primary">
              Sign In
            </button>
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
