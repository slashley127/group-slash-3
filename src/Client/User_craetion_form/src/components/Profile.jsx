import React from 'react'

function Profile({user}) {
  return (
  <>
    <div><h1> My Profile</h1></div>
    <p>Username: {user.userName}</p>
    <p>Email: {user.email}</p>
    <p>First name: {user.firstName}</p>
    <p>Last name: {user.lastName}</p>
    </>
  )
}

export default Profile

// function Profile() {
//   return (
//     <div> My Profile</div>
//   )
// }
//
// export default Profile