import React from 'react';
import ReactDOM from 'react-dom/client'; // Import ReactDOM directly
import App from './components/App'; 
import './index.css';
import './components/App.css'


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);