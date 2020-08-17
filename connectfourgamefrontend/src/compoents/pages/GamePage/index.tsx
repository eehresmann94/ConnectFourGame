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

    useInterval(async () => {
        axios.get("http://localhost:8080/games/game/" + gameInfo.gameId).then((data: getData) => {
            console.log(data);
            if (board.gameBoard[data.data.gameBoard.gamePieces[data.data.gameBoard.gamePieces.length - 1].xaxisLocation][data.data.gameBoard.gamePieces[data.data.gameBoard.gamePieces.length - 1].yaxisLocation -1] === "white") {
                const newBoardState = {
                    ...board,
                }
                newBoardState.gameBoard[5 - (data.data.gameBoard.gamePieces[data.data.gameBoard.gamePieces.length - 1].yaxisLocation -1)][data.data.gameBoard.gamePieces[data.data.gameBoard.gamePieces.length - 1].xaxisLocation -1] = data.data.gameBoard.gamePieces[data.data.gameBoard.gamePieces.length - 1].pieceColor;
                setBoard(newBoardState);
            }
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
