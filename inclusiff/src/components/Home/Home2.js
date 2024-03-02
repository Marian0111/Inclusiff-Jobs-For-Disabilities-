import React from "react";
import {Container, Row, Col} from "react-bootstrap";
import myImg from "../../Assets/grup1-01.svg";
import Tilt from "react-parallax-tilt";
import {
    AiFillGithub,
    AiOutlineTwitter,
    AiFillInstagram,
} from "react-icons/ai";
import {FaLinkedinIn} from "react-icons/fa";

function Home2() {
    return (
        <Container fluid className="home-about-section" id="about">
            <Container>
                <Row>
                    <Col md={8} className="home-about-description">
                        <h1 style={{fontSize: "2.6em"}}>
                            ALLOW US <span className="purple"> TO INTRODUCE </span> OURSELVES
                        </h1>

                        <p className="home-about-body">
                            HELLO
                            <br/><br/>

                            At Inclusiff, we are dedicated to creating employment opportunities
                            for individuals with disabilities, providing comprehensive training to build your career.

                            <br/><br/><br/><br/>
                            Join our events to hear <strong className="purple">PEOPLE</strong>'s stories.
                        </p>
                    </Col>
                    <Col md={4} className="myAvtar">
                        <Tilt>
                            <img src={myImg} className="img-fluid" alt="avatar"/>
                        </Tilt>
                    </Col>
                </Row>
                <Row>
                    <Col md={12} className="home-about-social">
                        <h1>FIND US ON</h1>
                        <p>
                            Feel free to <span className="purple">connect </span>with us
                        </p>
                        <ul className="home-about-social-links">
                            <li className="social-icons">
                                <a
                                    href="https://github.com/inclusiff"
                                    target="_blank"
                                    rel="noreferrer"
                                    className="icon-colour  home-social-icons"
                                >
                                    <AiFillGithub/>
                                </a>
                            </li>
                            <li className="social-icons">
                                <a
                                    href="https://twitter.com/inclusiff"
                                    target="_blank"
                                    rel="noreferrer"
                                    className="icon-colour  home-social-icons"
                                >
                                    <AiOutlineTwitter/>
                                </a>
                            </li>
                            <li className="social-icons">
                                <a
                                    href="https://www.linkedin.com/in/inclusiff/"
                                    target="_blank"
                                    rel="noreferrer"
                                    className="icon-colour  home-social-icons"
                                >
                                    <FaLinkedinIn/>
                                </a>
                            </li>
                            <li className="social-icons">
                                <a
                                    href="https://www.instagram.com/inclusiff"
                                    target="_blank"
                                    rel="noreferrer"
                                    className="icon-colour home-social-icons"
                                >
                                    <AiFillInstagram/>
                                </a>
                            </li>
                        </ul>
                    </Col>
                </Row>
            </Container>
        </Container>
    );
}

export default Home2;
