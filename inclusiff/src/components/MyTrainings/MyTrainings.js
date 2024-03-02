import React, {useState, useEffect, useContext} from 'react'
import useTrainings from "../../Hooks/useTrainings";
import {AppContext} from "../../App";
import Particle from "../Particle";
import {Col, Container, Row} from "react-bootstrap";
import MyTrainingCard from "./MyTrainingCard";
function MyTrainings() {
    const [myTrainings, setMyTrainings] = useState([])
    const { getLearnerTrainings } = useTrainings()
    const { userId } = useContext(AppContext)

    useEffect(() => {
        const getLearnerTrainingsData = async () => {
            const myTrainings = await getLearnerTrainings(userId)
            if (myTrainings) {
                setMyTrainings(myTrainings)
            }
        }
        getLearnerTrainingsData()
    }, [])

    const chunckArray = (array, size) => {
        let result = [];
        for (let i = 0; i < array.length; i += size) {
            let chunk = array.slice(i, i + size);
            result.push(chunk);
        }
        return result;
    }

    const myTrainingsRows = chunckArray(myTrainings, 3)

    return (
        <div>
            <Particle />
            <Container fluid className="project-section">
                <Container>
                    <h1 className="project-heading">
                        List of posted<strong className="purple"> Jobs </strong>
                    </h1>
                        <p style={{ color: "white" }}>
                            All your personalized trainings.
                        </p>

                    {myTrainingsRows.map((row, rowIndex) => (
                        <Row key={rowIndex} style={{ justifyContent: "center", paddingBottom: "10px" }}>
                            {row.map((traininig, index) => (
                                <Col key={index} md={4} className="project-card">
                                    <MyTrainingCard
                                        isBlog={false}
                                        title={traininig.title} // Replace with appropriate property
                                        description={traininig.description} // Replace with appropriate property
                                        ghLink={traininig.ghLink} // Replace with appropriate property
                                        demoLink={traininig.demoLink} // Replace with appropriate property
                                    />
                                </Col>
                            ))}
                        </Row>
                    ))}
                </Container>
            </Container>
        </div>
    )

}
export default MyTrainings