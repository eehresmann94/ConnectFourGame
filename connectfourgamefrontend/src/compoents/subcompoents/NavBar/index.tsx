import React from 'react'
import Container from 'react-bootstrap/Container'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import NavDropdown from 'react-bootstrap/NavDropdown'
import Form from 'react-bootstrap/Form'
import FormControl from 'react-bootstrap/FormControl'
import "./index.scss"
import Button from 'react-bootstrap/esm/Button'



function NavBar() {
    return (
        <Container className="navbar">
            <Navbar bg="light" expand="lg">
                <Navbar.Brand href="/home">Connect Four Battles!</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="/home">Home</Nav.Link>
                        <Nav.Link href="/creategame">Create Game</Nav.Link>
                        <NavDropdown title="Games in Progress" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/games/game/2">Games</NavDropdown.Item>
                            <NavDropdown.Item href="/joingame">Join A Game</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
                <Form>
                    <Nav.Link href="/login">Login</Nav.Link>
                </Form>
            </Navbar>
        </Container>
    )
}

export default NavBar; 