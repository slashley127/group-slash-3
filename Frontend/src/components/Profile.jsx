import React, { useState, useEffect } from 'react';
import { useAuth0 } from '@auth0/auth0-react';

function Profile() {
    const { user, isAuthenticated, isLoading } = useAuth0();
    const [userData, setUserData] = useState(null);

    useEffect(() => {
        const fetchUserData = async () => {
            try {
                if (isAuthenticated) {
                    const response = await fetch(`http://localhost:8080/api/users/${user.sub}`);

                    if (response.ok) {
                        const data = await response.json();
                        setUserData(data);
                    } else {
                        console.error('Failed to fetch user profile. Server returned:', response.status);
                    }
                }
            } catch (error) {
                console.error('Error fetching user profile:', error);
            }
        };

        fetchUserData();
    }, [isAuthenticated, user]);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    return (
        isAuthenticated && (
            <div>
                <div className="profile-title">My Profile</div>
                {userData && (
                    <div className="profile-info">
                        <p>Name: {userData.firstName} {userData.lastName}</p>
                        <p>Username: {userData.userName}</p>
                        <p>Email: {userData.email}</p>
                        <p>Planned Trips: {userData.trips}</p>
                    </div>
                )}
            </div>
        )
    );
}

export default Profile;
