import React from 'react';
import './App.css';
import GamePage from "./compoents/pages/GamePage/index"
import PlayerLoginPage from './compoents/pages/PlayerLoginPage';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import NavBar from './compoents/subcompoents/NavBar';
import HomePage from './compoents/pages/HomePage';

function App() {
  return (
     <Router>
     <div>
     <NavBar />

     <Route path="/login" component={PlayerLoginPage} />
     <Route path="/games/game/2" component={GamePage} />
     <Route path="/home" component={HomePage} />
  
    </div>
    </Router>
  );
}

export default App;
