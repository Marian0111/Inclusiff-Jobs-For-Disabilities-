import React from "react";
import Card from "react-bootstrap/Card";
import {useContext} from "react";
import {AppContext} from "../../App";
import Button from "react-bootstrap/Button";
import useRegisterForTraining from "../../Hooks/useRegisterForTraining";
import {useNavigate} from "react-router-dom";

function TrainingCard(props) {
    const navigate = useNavigate();
    const {register} = useRegisterForTraining();
    const {userId} = useContext(AppContext);

    const registerForTraining = async () => {
        await register(userId, props.trainingExternalId);
        navigate("/home");
        alert("You successfully subscribed to this course. You will be contacted for further information.");
    }

    return (
        <Card className="quote-card-view">
            <Card.Body>
                <blockquote className="blockquote mb-0">
                    <p style={{
                        textAlign: "justify",
                    }}>
                        <span className="purple">{props.description}</span>
                    </p>
                </blockquote>

                <br />
                <br />

                <Button
                    variant="primary"
                    onClick={registerForTraining}
                >
                    Register for training
                </Button>

            </Card.Body>
        </Card>
    );
}

export default TrainingCard;