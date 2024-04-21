import './styles/bootstrap.min.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Login from './components/Login';
import Events from './components/Events';

const App = () => {
  return (
    <Router>
        <div className="App" style={{ paddingTop: '4rem', width: '100vw' }}> 
          <nav className="navbar navbar-expand navbar-light bg-light fixed-top">
            <div className="container-fluid">
              <a className="navbar-brand" href="#">Ticketguru</a>
              <div className="navbar-nav mx-auto">
                <Link className="nav-link" to="/login">Kirjaudu</Link>
                <Link className="nav-link" to="/events">Tapahtumat</Link>
              </div>
            </div>
          </nav>

          <div className="d-flex" style={{ height: '100vh', paddingTop: '50px', width: '100vw' }}>
            <div className="container-fluid">
              <div className="row justify-content-center">
                {/* Keskitetty kolumni, joka sisältää reitit ja komponentit */}
                <div className="col-12">
                  <Routes>
                    <Route path="/login" element={<Login />} />
                    <Route path="/events" element={<Events />} />
                  </Routes>
                </div>
              </div>
            </div>
          </div>
        </div>
      </Router>
    );
}

export default App;