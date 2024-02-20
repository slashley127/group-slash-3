import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import { Button } from 'react-bootstrap';

function Navbar() {
  const [click, setClick] = useState(false);
  const [button, setButton] = useState(true);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const showButton = () => {
    if (window.innerWidth <= 960) {
      setButton(false);
    } else {
      setButton(true);
    }
  };

  useEffect(() => {
    showButton();
  }, []);

  window.addEventListener('resize', showButton);

  return (
    <>
      <nav className='navbar'>
        <div className='navbar-container'>
          <Link to="/" className='navbar-logo fst-italic' onClick={closeMobileMenu}>
            TravelTribe
            <i className='fab fa-typo3' />
          </Link>
          <div className='menu-icon' onClick={handleClick}>
            <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
          </div>
            <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                <li className='nav-item'>
                    <Link
                    to='/Profile'
                    className='nav-links  fst-italic'
                    onClick={closeMobileMenu}  >
                My Profile
                    </Link>
                </li>
                <li className='nav-item'>
                   <Link to='/AllActivities' className='nav-links  fst-italic' onClick={closeMobileMenu}>
                All Activities
                   </Link>
                </li>
                <li>
                  <Link to='/other_page' className='nav-links-mobile  fst-italic' onClick={closeMobileMenu}>
                    About us
                  </Link>
                </li>
              <li className='nav-item'>
                <Link
                  to='/login'
                  className='nav-links  fst-italic'
                  onClick={closeMobileMenu}
                >
                  Log in 
                </Link>
              </li>
            </ul>
          {button && (
            <Link to='/create' className='btn-link' onClick={closeMobileMenu}>
              <Button variant='outline-primary  fst-italic'>Create Trip</Button>
            </Link>
          )}

          {button && (
                      <Link to='/addactivity' className='btn-link' onClick={closeMobileMenu}>
                        <Button variant='outline-primary  fst-italic'>Add Activity</Button>
                      </Link>
                    )}
        </div>
      </nav>
    </>
  );
}

export default Navbar;
