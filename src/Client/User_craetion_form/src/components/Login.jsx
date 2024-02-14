import "./App.css";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import React, {useState} from "react";

function Login() {
const navigate = useNavigate();
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
            navigate("/Profile", { state: { user: userData } });
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
        <form action="">
          <h3 className="text-center"> Sign In</h3>
          <div className='mb-2'>
            <label htmlFor="email">Email</label>
            <input type="email" placeholder='Enter Email' className='form-control' value={email}
            onChange={(e) => setEmail(e.target.value)}
             required />
          </div>
          <div className='mb-2'>
            <label htmlFor="Password">Password</label>
            <input type="Password" placeholder='Enter Password' className='form-control' value={password}
             onChange={(e) => setPassword(e.target.value)}
              required />
          </div>
          <div className='mb-2'>
            <input type="checkbox" className='custom-control custom-checkbox' id="check" />
            <label htmlFor="check" className='custom-input-label ms-2 '>
              Remember me
            </label>
          </div>
          <div className='d-grid'>
            <button className='btn btn-primary' onClick={handleSubmit}> Sign In</button>
            <p className='text-end mt-2'>
              Forgot <a href=""> Password?</a>
              <Link to="/signup" className="ms-2"> Sign Up</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
    );
}

export default Login;
