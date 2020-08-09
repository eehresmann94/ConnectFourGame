import { type } from "os";

export type BoardStateType = {
    gameBoard: string[][]
}

export type Piece = {
    gameBoardId?: number,
    xAxisLocation: number,
    yAxisLocation: number,
    pieceColor: string
}

export type Game = {
    gameId: number,
    gameWon: boolean,
    playerTurnName: boolean,
    gameBoard: Board,
    player1: Player,
    player2: Player
}

export type Player = {
    playerId: number,
    playerName: string,
    playerPassword: string,
    playerEmail: string
}

export type Board = {
    gameBoardId: number,
    gamePieces: Piece[],

}