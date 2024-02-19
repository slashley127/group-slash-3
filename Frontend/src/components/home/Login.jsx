import "../App.css";
import { Link, useNavigate } from "react-router-dom";
import React, {useState} from "react";
import Home from "./Home"
import Navbar from "../navbar/Navbar";
import '../navbar/Profile'




function Login() {


const navigate = useNavigate();
const [email, setEmail] = useState("");
const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/api/users", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, userName, password }),
      });
      if (response.ok) {

        const userData = await response.json();

        localStorage.setItem("userData", JSON.stringify(userData));

        navigate("/Profile");
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
            <label htmlFor="check" className='custom-input-label ms-2 '>Remember me
            </label>
          </div>


{/*       <Form onSubmit={handleSubmit}> */}
{/*             <Form.Group controlId="formUsername"> */}
{/*                 <Form.Label>Username</Form.Label> */}
{/*                 <Form.Control type="text" placeholder="Enter username" value={username} onChange={(e) => setUsername(e.target.value)} /> */}
{/*             </Form.Group> */}

{/*             <Form.Group controlId="formPassword"> */}
{/*                 <Form.Label>Password</Form.Label> */}
{/*                 <Form.Control type="password" placeholder="Enter password" value={password} onChange={(e) => setPassword(e.target.value)} /> */}
{/*             </Form.Group> */}

{/*             <Button variant="primary" type="submit"> */}
{/*                 Submit */}
{/*             </Button> */}
{/*         </Form> */}


          <div className='d-grid'>

            <button className='btn btn-primary' onClick={handleSubmit}><Link to="/home" className='btn btn-primary'>Sign In</Link> </button>
            <p className='text-end mt-2'>
{/*               Forgot <a href=""> Password?</a> */}
              <Link to="/signup" className="ms-2"> Sign Up</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;

// import React from "react";
// import "./App.css";
// import { Link } from "react-router-dom";
// import Profile from "./Profile";
//
// function Login() {
//   return (
//     <div
//       className="login template d-flex justify-content-center align-items-center vh-100 bg-primary"
//       style={{
//         backgroundImage: `url('https://cxeffect.com/wp-content/uploads/2021/12/Services_Header-2.png')`,
//         backgroundSize: "cover",
//       }}
//     >
//       <div className="form-container p-5 rounded bg-white mx-auto">
//         <form action="">
//           <h3 className="text-center">Sign In</h3>
//           <div className="mb-2">
//             <label htmlFor="email">Email</label>
//             <input type="email" placeholder="Enter Email" className="form-control" />
//           </div>
//           <div className="mb-2">
//             <label htmlFor="password">Password</label>
//             <input type="password" placeholder="Enter Password" className="form-control" />
//           </div>
//           <div className="mb-2">
//             <input type="checkbox" className="custom-control-input" id="check" />
//             <label htmlFor="check" className="custom-control-label ms-2">
//               Remember me
//             </label>
//           </div>
//           <div className="d-grid">
//             <Link to="/Profile" className="btn btn-primary">
//               Sign In
//             </Link>
//             <p className="text-end mt-2">
//               Forgot <a href="/">Password?</a>
//               <Link to="/signup" className="ms-2">
//                 Sign Up
//               </Link>
//             </p>
//           </div>
//         </form>
//       </div>
//     </div>
//   );
// }
//
// export default Login;