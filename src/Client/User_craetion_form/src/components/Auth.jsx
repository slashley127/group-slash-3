import React, { useState, useEffect } from 'react';

function Auth() {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  // Simulate user authentication (replace with actual authentication logic)
  useEffect(() => {
    // Check if user data exists in localStorage
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      setUser(JSON.parse(storedUser));
    }
    setLoading(false);
  }, []);

  // Login function
  const login = (userData) => {
    setUser(userData);
    // Store user data in localStorage
    localStorage.setItem('user', JSON.stringify(userData));
  };

  // Logout function
  const logout = () => {
    setUser(null);
    // Remove user data from localStorage
    localStorage.removeItem('user');
  };

  // Check if user is authenticated
  const isAuthenticated = () => {
    return !!user;
  };

  // Return user authentication state and functions
  return { user, loading, login, logout, isAuthenticated };
}

export default Auth;

