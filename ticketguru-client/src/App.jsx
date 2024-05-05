import './styles/bootstrap.min.css';
<<<<<<< HEAD
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Login from './components/Login';
import Events from './components/Events';
import GetTicket from './components/GetTicket'
import CheckTicket from './components/CheckTicket'

const App = () => {

=======
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Login from './components/Login';
import Events from './components/Events';
import CheckTicket from './components/CheckTicket';

const App = () => {
>>>>>>> 9f02a4744106953f554737d5cf7e872e0ad8e998
  return (
    <Router>
        <div className="App" style={{ paddingTop: '4rem', width: '100vw' }}> 
          <nav className="navbar navbar-expand navbar-light bg-light fixed-top">
            <div className="container-fluid">
              <a className="navbar-brand" href="#">Ticketguru</a>
              <div className="navbar-nav mx-auto">
                <Link className="nav-link" to="/login">Kirjaudu</Link>
                <Link className="nav-link" to="/events">Tapahtumat</Link>
<<<<<<< HEAD
                <Link className="nav-link" to="/get">Hae lippu</Link>
=======
>>>>>>> 9f02a4744106953f554737d5cf7e872e0ad8e998
                <Link className="nav-link" to="/check">Tarkista lippu</Link>
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
<<<<<<< HEAD
                    <Route path="/get" element={<GetTicket />} />
                    <Route path='/check/' element={<CheckTicket/>} />
=======
                    <Route path="/check" element={<CheckTicket />} />
>>>>>>> 9f02a4744106953f554737d5cf7e872e0ad8e998
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
