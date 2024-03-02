import React, {useContext} from "react";
import { Container, Row, Col } from "react-bootstrap";
import homeLogo from "../../Assets/poza-main-oameni.svg";
import Particle from "../Particle";
import Home2 from "./Home2";
import Type from "./Type";
import {AppContext} from "../../App";

function Home() {
  const {isAuthenticated, firstname, lastname, role} = useContext(AppContext);

  return (
    <div style={{color:"#d0d0d0"}}>
      <Container fluid className="home-section no-padding" id="home">
        <Particle />
        <Container className="home-content">
          {isAuthenticated && <Row>
            <Col md={7} className="home-header">
              <h1 className="heading">
                HI, {firstname} {lastname}
              </h1>
              <br/> <br/>
              <h3 className="heading-but-little">
                Practice gratitude today <br/> <br/>
                Drink your water
              </h3>
              <br /> <br/> <br/>
            </Col>
          </Row>
          }

          <Row>
            <Col md={7} className="home-header">
              <h1 style={{ paddingBottom: 15, position: "relative" }} className="heading">
                Empowering Abilities{" "}
              </h1>

              <h1 className="heading-name">
                Your Skills
                <strong className="main-name"> Matter Here!</strong>
              </h1>

              <div style={{ padding: 40, textAlign: "left", position: "relative" }}>
                <Type />
              </div>
            </Col>

            <Col md={5} style={{ paddingBottom: 20, position: "relative" }}>
              <img
                  src={homeLogo}
                  alt="home pic"
                  className="img-fluid"
                  style={{ maxWidth: "100%" }} // Removed maxHeight constraint
              />
            </Col>
          </Row>
        </Container>
      </Container>
      <Home2 />
    </div>
  );
}

export default Home;
