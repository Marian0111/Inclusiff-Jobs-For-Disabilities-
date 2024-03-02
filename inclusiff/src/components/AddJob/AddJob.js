import React, { useState, useContext } from "react";
import Particle from "../Particle";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import './AddJob.css'
import useAddJob from "../../Hooks/useAddJobs";
import { AppContext } from "../../App";
import {useNavigate} from "react-router-dom";

function AddJob() {

  const navigate = useNavigate();
  const {email, password, userId} = useContext(AppContext);
  const [jobDescription, setJobDescription] = useState('');
  const { addJobs } = useAddJob();

  const handleSubmit = async (event) => {
      if (jobDescription) {
        await addJobs(jobDescription, userId);
        navigate("/home");
      }
  }

  return (
    <div className="addjob-container">
      <Particle />
      <Form>
        <br /> <br /> <br /> <br />
        <Form.Group>
          <Form.Label className="add-job-label">Add a Job</Form.Label>
          <Form.Control
              className="addjob-input"
              as="textarea"
              placeholder="Job Description"
              onChange={(event) => setJobDescription(event.target.value)}
          />
          <br /> <br />
          <Button
              className="addjob-button"
              variant="secondary"
              size="lg"
              onClick={handleSubmit}
          >
            Add Job
          </Button>
        </Form.Group>
      </Form>
    </div>
  );
}

export default AddJob;
