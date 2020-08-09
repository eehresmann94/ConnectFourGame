import React from 'react'
import "./index.scss"

interface propsType {
    pieceColor: string
};

const Square = (props: propsType) => {
    return (
        <div className="square-background">
            <div className="square-circle-background" style={{backgroundColor: props.pieceColor}}></div>
        </div>
    )
}

export default Square
