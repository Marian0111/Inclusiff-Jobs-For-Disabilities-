import React, {useContext} from "react";
import { Container, Row, Col } from "react-bootstrap";
import JobCards from "./JobCards";
import Particle from "../Particle";
import { useState, useEffect } from 'react'
import useGetJobOffers from "../../Hooks/useGetJobOffers";
import {AppContext} from "../../App";


function Jobs() {

  const [jobs, setJobs] = useState([])
  const { getJobOffers } = useGetJobOffers()
  const { role } = useContext(AppContext);

  useEffect(() => {
    const getJobs = async () => {
      const jobs = await getJobOffers();
      if (jobs) {
        setJobs(jobs)
        console.log(jobs)
      }
    }
    getJobs();
  },[])

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
            {role === 'PEOPLE' &&
              <p style={{ color: "white" }}>
                All the jobs that will ease your life.
              </p>
            }
            {role === 'COMPANY' &&
                <p style={{ color: "white" }}>
                  All the jobs that your company created are displayed here.
                </p>
            }

            {jobRows.map((row, rowIndex) => (
                <Row key={rowIndex} style={{ justifyContent: "center", paddingBottom: "10px" }}>
                  {row.map((job, index) => (
                      <Col key={index} md={4} className="project-card">
                        <JobCards
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
  );
}

export default Jobs;
