import {BrowserRouter,Routes,Route} from 'react-router-dom'
import Login from './Login'
import Signup from './Signup'
import "bootstrap/dist/css/bootstrap.min.css"
import Profile from './Profile'
import React from 'react'


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<Login/>}> </Route>
            <Route path='/signup' element={<Signup/>}> </Route>
            <Route path='/profile' element={<Profile/>}> </Route>
            


        </Routes>



    </BrowserRouter>
  )
}

export default App