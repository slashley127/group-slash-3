import React from 'react';
import ReactDOM from 'react-dom/client'; // Import ReactDOM directly
import App from './components/App'; 
import './index.css';
import './components/App.css'
import { Auth0Provider } from '@auth0/auth0-react';

const domain = 'dev-dpzvow35gt3bidq1.us.auth0.com'

const clientId = 'wBf7IHOKUqpB5bJzxWQyfuUfFWHv7dVD'


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode  >
    < Auth0Provider
  domain={domain}
  clientId={clientId}
  redirectUri={window.location.origin}
> 
    <App />
    </Auth0Provider>
  </React.StrictMode>
);