import React from "react";
import {Container, Row, Col} from "react-bootstrap";
import Particle from "../Particle";
import LearnerCard from "./LearnerCard";
import './Learners.css'
import johndoe from "../../Assets/johndoe.jpg"
import dale1 from "../../Assets/dale1.png"
import dale2 from "../../Assets/dale2.png"
import dale3 from "../../Assets/dale3.png"
import useLearners from "../../Hooks/useLearners";
import {useEffect, useState} from 'react'

function Learners() {

    const [learners, setLearners] = useState([])
    const {getLearners} = useLearners()
    const images = [johndoe, dale1, dale2, dale3]

    useEffect(() => {
        const getLearnersData = async () => {
            const learners = await getLearners();
            if (learners) {
                setLearners(learners)
            }
        }
        getLearnersData();
    }, [])

    return (
        <div>
            <Particle/>
            <Container fluid className="about-section">
                <Container>
                    <h1 style={{fontSize: "2.1em", paddingBottom: "20px"}}>
                        Know the Talents that <strong className="purple">ARE FORMED</strong>
                    </h1>
                    {learners.map((learner, index) => (
                        <Row style={{justifyContent: "center", padding: "10px"}}>
                            <Col
                                md={7}
                                style={{
                                    justifyContent: "center",
                                    paddingTop: "30px",
                                    paddingBottom: "50px",
                                }}
                            >
                                <LearnerCard surname={learner.firstname} name={learner.lastname} course="Course NO.121"/>
                            </Col>
                            <Col
                                md={5}
                                style={{paddingTop: "20px", paddingBottom: "40px"}}
                                className="about-img"
                            >
                                <img src={images[index % images.length]} alt="about" className="learner-img"/>
                            </Col>
                        </Row>
                    ))}
                </Container>
            </Container>
        </div>
    );
}

export default Learners;
