import React from "react";
import Button from "react-bootstrap/esm/Button";
import Form from 'react-bootstrap/Form'
import Container from 'react-bootstrap/Container';
import "./index.scss"


const HomePage = () => {
    return (
        
        <Container className="homePageContainer" fluid>
            <Form>
                <div>
                    <h3>Connect Four Battles!</h3>
                    <p>Take on your Friends in this Classic Game!</p>
                </div>
            </Form>
        </Container>
        
    )

}

export default HomePage;
