import React from 'react';
import Board from '../../subcompoents/Board';
import { BoardStateType } from '../../../types/types';
import axios from 'axios';
import { useInterval } from '../../hooks/useInterval';


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

const GamePage = () => {



    const [gameInfo, setGameInfo] = React.useState<any>({
        gameId: 2
    })

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
        axios.get("http://localhost:8080/games/game/" + gameInfo.gameId).then((data: getData) => {
            
        }).catch((err) => {
            console.log(err);
        })
    }, 2000)

    return (
        <div>
            
            <Board gameBoard={board} />
        </div>
    )
}

export default GamePage;
