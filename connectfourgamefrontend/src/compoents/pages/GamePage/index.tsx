import React from 'react';
import Board from '../../subcompoents/Board';
import { BoardStateType } from '../../../types/types';

const GamePage = () => {
    const [board, setBoard] = React.useState<BoardStateType>({
        gameBoard: [["white","white","white","white","white","white","white"],
        ["white","white","white","white","white","white","white"],
        ["red","white","white","white","white","white","white"],
        ["red","white","white","white","white","white","white"],
        ["red","green","white","white","white","white","white"],
        ["red","black","white","white","white","white","white"],
        ] 
      });

    return (
        <div>
            <Board gameBoard={board}/>
        </div>
    )
}

export default GamePage;
