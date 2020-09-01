import React from "react";
import Button from "react-bootstrap/esm/Button";
import Form from 'react-bootstrap/Form'
import Jumbotron from 'react-bootstrap/Jumbotron';
import "./index.scss"


const HomePage = () => {
    return (
        <Jumbotron className="homepagemain">
            <Form>
                <div>
                    <h3>Connect Four Battles!</h3>
                    <p>Take on your Friends in this Classic Game!</p>
                </div>
            </Form>
        </Jumbotron>
    )

}

export default HomePage;
