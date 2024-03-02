import React, {useState, useContext} from 'react';
import {useNavigate} from "react-router-dom";
import './Login.css'
import Particle from "../Particle";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {AppContext} from "../../App";
import useLogin from "../../Hooks/useLogin";

function Login() {
    const navigate = useNavigate()
    const {login} = useLogin();
    const {
        isAuthenticated,
        setIsAuthenticated,
        email,
        setEmail,
        password,
        setPassword,
        userId,
        setUserId,
        role,
        setRole,
        firstname,
        setFirstname,
        lastname,
        setLastname
    } = useContext(AppContext)

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (email && password) {
            setIsAuthenticated(true);
            console.log(isAuthenticated);
            const response = await login(email, password);
            setUserId(response.userExternalId);
            setRole(response.role);
            setFirstname(response.firstname);
            setLastname(response.lastname);
            navigate("/home");
        }
    }

    return (
        <div className="login-container">
            <Particle/>
            <br/> <br/>
            <br/> <br/>
            <Form>
                <Form.Group>
                    <Form.Label className="login-label">Login</Form.Label>
                    <Form.Control
                        className="username-input"
                        type="text"
                        placeholder="Username"
                        onChange={(event) => setEmail(event.target.value)}
                    />
                    <br/> <br/>
                    <Form.Control
                        className="password-input"
                        type="password"
                        placeholder="Password"
                        onChange={(event) => setPassword(event.target.value)}
                    />
                    <br/> <br/>
                    <Button
                        className="submit-button"
                        variant="secondary"
                        size="lg"
                        onClick={handleSubmit}
                    >
                        Submit
                    </Button>
                </Form.Group>
            </Form>

            <br/> <br/>
            <br/> <br/>
        </div>
    );
}

export default Login;