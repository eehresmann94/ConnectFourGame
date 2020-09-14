import React from 'react';
import Board from '../../subcompoents/Board';
import { BoardStateType } from '../../../types/types';
import axios from 'axios';
import { useInterval } from '../../hooks/useInterval';
import Jumbotron from 'react-bootstrap/esm/Jumbotron';
import "./index.scss"
import Container from 'react-bootstrap/esm/Container';


interface pieceData {
    gameBoardId: number,
    pieceColor: string,
    yaxisLocation: number,
    xaxisLocation: number
}

interface getData {
    data: {
        gameBoard: {
            gamePieces: [
                {
                    gameBoardId: number,
                    pieceColor: string,
                    xaxisLocation: number,
                    yaxisLocation: number
                }
            ]
        }
    }
}


const GamePage = (props: any) => {

    var GameInfo = {

        //Information about the current game independant of both players
        currentgameID: props.playerOneInformation.info.gameId,
        currentGameWon: props.playerOneInformation.info.gameWon,
        currentGameIsPlayerOnesTurn: props.playerOneInformation.info.playerTurnName,

        //Information about current game Player One
        currentplayerOneName: props.playerOneInformation.info.name,


        //Information about current game Player 2 
        currentplayerTwoName: props.playerTwoInformation.info.name,

    }

    // const [gameInfo, setGameInfo] = React.useState<any>({
    //     gameId: props.playerInformation.info.gameId,
    //     name: props.playerInformation.info.name,
    //     playersTurn: props.playerInformation.info.playerTurnName,
    //     gameWon: props.playerInformation.info.gameWon



    // })

    const [board, setBoard] = React.useState<BoardStateType>({
        gameBoard: [
            ["white", "white", "white", "white", "white", "white", "white"],
            ["white", "white", "white", "white", "white", "white", "white"],
            ["white", "white", "white", "white", "white", "white", "white"],
            ["white", "white", "white", "white", "white", "white", "white"],
            ["white", "white", "white", "white", "white", "white", "white"],
            ["white", "white", "white", "white", "white", "white", "white"],
        ]
    });

    const setNewBoard = (data: getData) => {
        console.log(data);
        const newState = board;
        data.data.gameBoard.gamePieces.forEach(piece => {
            newState.gameBoard[piece.xaxisLocation - 1][piece.yaxisLocation - 1] = piece.pieceColor;
        });
        setBoard(newState);

    }

    useInterval(async () => {
        axios.get("http://localhost:8080/games/game/" + GameInfo).then((data: getData) => {

        }).catch((err) => {
            console.log(err);
        })
    }, 2000)

    return (
        <div>

            <Board gameBoard={board} />

            <h3>Player Stats</h3>
            <Jumbotron >
                <p> Current Game information</p>
                <Container> Your Current Game ID is: {GameInfo.currentgameID}</Container>
                <Container> Is Game won?: {String(GameInfo.currentGameWon)}</Container>
                <p>Player One</p>
                <Container> Player One Name: {String(GameInfo.currentplayerOneName)}</Container>
                <p>Player Two</p>
                <Container> Player Two Name: {String(GameInfo.currentplayerTwoName)}</Container>
            </Jumbotron>



        </div>
    )
}

export default GamePage;
