import React from 'react';
//import axios from 'axios';
//import { useInterval } from '../../hooks/useInterval';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/esm/Button';
import axios from 'axios';



const CreateGamePage = (props:any) => {
  const [createGame, setCreateGame] = React.useState({
    gameCreateInfo: {
      gameId: null,
      showModal: false
    },
    info: {
      name: "",
      email: "",
      password: "",
      confirmPassword: ""
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
  const handleCreateGameForm = (e: any) => {
    e.preventDefault()
    const payload = {
      playerName: createGame.info.name, 
      playerPassword: createGame.info.password,
      playerEmail: createGame.info.email,
    }
      
    axios.post("http://localhost:8080/games/creategame", payload).then((res) => {
    setCreateGame({
        gameCreateInfo: { gameId: res.data, showModal: true },
        info: { ...createGame.info, }
      })
      props.changePlayerOneInfo({info: {
        name: createGame.info.name,
        email: createGame.info.email,
        password: createGame.info.password,
        gameId: createGame.gameCreateInfo.gameId,
        playerTurnName: "",
        gameWon: false
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

            <Modal.Footer>
              {/* <Button variant="secondary">Close</Button> */}
              <Button type="submit" variant="primary">Create Game</Button>
            </Modal.Footer>

          </Form>

        </Modal.Body>
      </Modal.Dialog>

      <Modal show={createGame.gameCreateInfo.showModal} onHide={() => null}>
        <Modal.Header>
          <Modal.Title>Use this Game Id to have your friend play with you!</Modal.Title>
        </Modal.Header>
        <Modal.Body>Game Id:{createGame.gameCreateInfo.gameId}</Modal.Body>
      </Modal>
    </div>
  )

}

export default CreateGamePage;
