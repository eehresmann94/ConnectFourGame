import React, { ChangeEvent } from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'
import { BoardStateType } from '../../../types/types'
import Square from '../Square';
import "./index.scss";
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import axios from 'axios'

interface PropsType {
    gameBoard: BoardStateType;
}

const Board = (props: PropsType) => {

    const [rowChoice, setRowChoice] = React.useState<string|null>(null);
    const [errorMessage, setErrorMessage] = React.useState<string|undefined>(undefined);
   
    const submitPiece =() =>{ 
        axios.get("http://localhost:8080/games/game/2/" + rowChoice).then((res) => {
            if(res.status === 418){
                // setErrorMessage(res.data.err);
            }
        
        }).catch((err: any) => {
            console.log(err);
        })
    }
    const changeNumber =(e: ChangeEvent) =>{
        // @ts-ignore
        // @ts-suppress
            setRowChoice(e.target.value);
    }
    return (
        <div>
            <Container>
                {
                    props.gameBoard.gameBoard.map((row, rowindex) => {
                        return (
                            <Row key={rowindex} >
                                {
                                    row.map((pieceColor, colindex) => {
                                        return (
                                            <Col bsPrefix="deSpacer" key={colindex}>
                                                <Square pieceColor={pieceColor} />
                                            </Col>
                                        )
                                    })
                                }
                            </Row>
                        )
                    })
                }
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Control onChange={changeNumber} type="number" placeholder="Enter your row number" min="1" max="6" />
                        <Form.Text className="text-danger">
                            { errorMessage }
                        </Form.Text>
                    </Form.Group>
                    <Button onClick={submitPiece}>Submit</Button> 
            

                </Form>
            </Container>
        </div>
    )
}

export default Board
