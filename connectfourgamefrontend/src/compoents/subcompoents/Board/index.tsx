import React from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'
import { BoardStateType } from '../../../types/types'
import Square from '../Square';
import "./index.scss";

interface PropsType {
    gameBoard: BoardStateType;
}

const Board = (props: PropsType) => {

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
            </Container>
        </div>
    )
}

export default Board
