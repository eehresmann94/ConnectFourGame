import React from 'react';
import './App.css';
import GamePage from "./compoents/pages/GamePage/index"
import PlayerLoginPage from './compoents/pages/PlayerLoginPage';
import { BrowserRouter as Router,  Route,  } from 'react-router-dom';
import NavBar from './compoents/subcompoents/NavBar';
import HomePage from './compoents/pages/HomePage';
import CreateGamePage from './compoents/pages/CreateGamePage';
import JoinGamePage from './compoents/pages/JoinGamePage';



//To do as of 09/13/2020
// Fix input button for game play so players can submit a piece( Need a way to pass the game Id to the board compoent)
// For Now I am using Game ID 3 as a place holder


//Game 
// Setup Axios Polling after player 1 joins the game and gets a response from player 2
// Refactor 2 states in to one "current game players" states for easier access?


function App() {

  const [playerOneInfo, setPlayerOneInfo] = React.useState({

    info: {
      name: "",
      email: "",
      password: "",
      gameId: "",
      playerTurnName: "",
      gameWon: ""
    }
  })

  const [playerTwoInfo, setPlayerTwoInfo] = React.useState({

    info: {
      name: "",
      email: "",
      password: "",
      gameId: "",
      playerTurnName: "",
      gameWon: ""
    }
  })

  const [currentGameInfo, setCurrentGameInfo] = React.useState({
    info: {
      gameId: 0,
      playerNumber: 0,
      playerTurn: false,
      isGameWon: false
    }
  })


  return (
    <Router>
      <div>
        <NavBar />


        <Route path="/login" component={PlayerLoginPage} />
        {/* <Route path="/game" component={GamePage} /> */}

        <Route path="/game" render={(props) => (
          <GamePage  {...props}
            changePlayerOneInfo={setPlayerOneInfo}
            changePlayerTwoInfo={setPlayerTwoInfo}
            setCurrentGameInfo={setCurrentGameInfo}
            playerOneInformation={playerOneInfo}
            playerTwoInformation={playerTwoInfo}
            currentGameInfo={currentGameInfo}
            />
        )} />
        <Route path="/home" component={HomePage} />

        <Route path="/creategame" render={(props) => (
          <CreateGamePage  {...props} changePlayerOneInfo={setPlayerOneInfo} setCurrentGameInfo={setCurrentGameInfo} currentGameInfo={currentGameInfo}/>

        )} />

        <Route path="/joingame" render={(props) => (
          <JoinGamePage  {...props} changePlayerTwoInfo={setPlayerTwoInfo} setCurrentGameInfo={setCurrentGameInfo}
            changePlayerOneInfo={setPlayerOneInfo}
          />
        )} />



      </div>
    </Router>
  );
}

export default App;
