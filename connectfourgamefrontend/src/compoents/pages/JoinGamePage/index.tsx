import React from 'react';
//import axios from 'axios';
//import { useInterval } from '../../hooks/useInterval';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/esm/Button';
import axios from 'axios';
import { Redirect } from 'react-router-dom';


const JoinGamePage = (props:any) => {
  const [createGame, setCreateGame] = React.useState({
    gameCreateInfo: {
      redirect: false
    },
    info: {
      name: "",
      email: "",
      password: "",
      confirmPassword: "",
      gameId: ""
    }
  })
  const handleNameChange = (e: any) => {
    setCreateGame({
      gameCreateInfo: { ...createGame.gameCreateInfo },
      info: {
        ...createGame.info,
        name: e.target.value
      }
    })
  }

  const handleEmailChange = (e: any) => {
    setCreateGame({
      gameCreateInfo: { ...createGame.gameCreateInfo },
      info: {
        ...createGame.info,
        email: e.target.value
      }
    })
  }
  

  const handlePasswordChange = (e: any) => {
    setCreateGame({
      gameCreateInfo: { ...createGame.gameCreateInfo },
      info: {
        ...createGame.info,
        password: e.target.value
      }
    })
  }

  const handleConfirmPasswordChange = (e: any) => {
    setCreateGame({
      gameCreateInfo: { ...createGame.gameCreateInfo },
      info: {
        ...createGame.info,
        confirmPassword: e.target.value
      }
    })
  }

  const handleGameIdChange = (e: any) => {
    setCreateGame({
      gameCreateInfo: { ...createGame.gameCreateInfo },
      info: {
        ...createGame.info,
        gameId: e.target.value
      }
    })
  }
  

  const handleCreateGameForm = (e: any) => {
    e.preventDefault()
    const payload = {
      playerName: createGame.info.name,
      playerPassword: createGame.info.password,
      playerEmail: createGame.info.email
    }

    axios.put("http://localhost:8080/games/creategame/" + createGame.info.gameId, payload).then((res) => {
     console.log(res) 
     setCreateGame({
        gameCreateInfo: {  redirect: true },
        info: { ...createGame.info, }
      })
      props.changePlayerTwoInfo({info: {
        name: res.data.player2.playerName,
        email: createGame.info.email,
        password: createGame.info.password,
        gameId: createGame.info.gameId,
        playerTurnName: res.data.playerTurnName,
        gameWon: res.data.gameWon
      }})
      props.setCurrentGameInfo({info: {
        gameId: res.data.gameId,
        playerNumber: 2,
        playerTurn: res.data.playerTurnName,
        isGameWon: res.data.gameWon
      }})
      props.changePlayerOneInfo({info:{
        gameWon: res.data.gameWon,
        gameId: res.data.gameId,
        name: res.data.player1.playerName
        
      }})
      
    }).catch((err) =>{
      console.log(err)
    })
  }

  return (
    <div>
      <Modal.Dialog>
        <Modal.Header >
          <Modal.Title>Enter Player Information</Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <Form onSubmit={handleCreateGameForm}>
            <Form.Label>Player Name</Form.Label>
            <Form.Control value={createGame.info.name} onChange={handleNameChange} type="text" placeholder="Please Enter Your Name!" />
            <Form.Label>Player Email</Form.Label>
            <Form.Control value={createGame.info.email} onChange={handleEmailChange} type="Email" placeholder="Please Enter Your Email" />
            <Form.Label>Player Password</Form.Label>
            <Form.Control value={createGame.info.password} onChange={handlePasswordChange} type="Password" placeholder="Please Enter a Unique Password" />
            <Form.Label>Confirm Password</Form.Label>
            <Form.Control value={createGame.info.confirmPassword} onChange={handleConfirmPasswordChange} type="Password" placeholder="Please Confirm Your Unique Password" />
            <Form.Label>Game Id</Form.Label>
            <Form.Control   value={createGame.info.gameId} onChange={handleGameIdChange} type="number" placeholder="Enter the Game Id of the game you wish to Join" />
            <Modal.Footer>
              {/* <Button variant="secondary">Close</Button> */}
              <Button type="submit" variant="primary">Create Game</Button>
            </Modal.Footer>

          </Form>

        </Modal.Body>
      </Modal.Dialog>

      {createGame.gameCreateInfo.redirect && <Redirect to="/game"/>}
    </div>
  )

}

export default JoinGamePage;
