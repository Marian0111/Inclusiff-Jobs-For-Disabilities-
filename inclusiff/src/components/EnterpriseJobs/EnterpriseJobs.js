import React, {useEffect, useState, useContext} from "react";
import useGetJobOffers from "../../Hooks/useGetJobOffers";
import Particle from "../Particle";
import {Col, Container, Row} from "react-bootstrap";
import EnterpriseJobCards from "./EnterpriseJobCards";
import {AppContext} from "../../App";

function EnterpriseJobs() {

    const [jobs, setJobs] = useState([])
    const {getEnterpriseJobOffers} = useGetJobOffers()
    const {userId} = useContext(AppContext)

    useEffect(() => {
        const getJobs = async () => {
            const jobs = await getEnterpriseJobOffers(userId);
            if (jobs) {
                setJobs(jobs)
                console.log(jobs)
            }
        }
        getJobs();
    }, [])

    const chunckArray = (array, size) => {
        let result = [];
        for (let i = 0; i < array.length; i += size) {
            let chunk = array.slice(i, i + size);
            result.push(chunk);
        }
        return result;
    }

    const jobRows = chunckArray(jobs, 3)

    return (
        <div>
            <Particle />
            <Container fluid className="project-section">

                <Container>
                    <h1 className="project-heading">
                        List of posted<strong className="purple"> Jobs </strong>
                    </h1>
                    <p style={{ color: "white" }}>
                        All the jobs that your company created are displayed here.
                    </p>
                    {jobRows.map((row, rowIndex) => (
                        <Row key={rowIndex} style={{ justifyContent: "center", paddingBottom: "10px" }}>
                            {row.map((job, index) => (
                                <Col key={index} md={4} className="project-card">
                                    <EnterpriseJobCards
                                        isBlog={false}
                                        title={job.title} // Replace with appropriate property
                                        description={job.jobDescription} // Replace with appropriate property
                                        ghLink={job.ghLink} // Replace with appropriate property
                                        demoLink={job.demoLink} // Replace with appropriate property
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

export default EnterpriseJobs;