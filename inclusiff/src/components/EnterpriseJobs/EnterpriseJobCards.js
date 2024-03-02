import React from "react";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

function EnterpriseJobCards(props) {
    return (
        <Card className="job-card-view" style={{ display: 'flex', flexDirection: 'column', height: '100%' }}>
            {props.imgPath ? (
                <Card.Img variant="top" src={props.imgPath} alt="card-img" />
            ) : (
                <div className="icon-container" style={{ textAlign: 'center', paddingTop: '20px' }}>
                    <i className="bi bi-briefcase-fill" style={{ fontSize: '2rem', color: 'black' }}></i>
                </div>
            )}
            <Card.Body style={{ flex: 1, display: 'flex', flexDirection: 'column' }}>
                <div style={{ flex: 1, display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                    <Card.Text style={{ textAlign: "justify", color: "black" }}>
                        {props.description}
                        <br /> <br />
                    </Card.Text>
                </div>
                <Button variant="primary" style={{ alignSelf: 'center' }}>
                    Apply
                </Button>
            </Card.Body>
        </Card>
    );
}

export default EnterpriseJobCards;
