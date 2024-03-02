import React, { useState, useContext } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Container from "react-bootstrap/Container";
import logo from "../Assets/logo-mare.png";
import {Link, useNavigate} from "react-router-dom";

import {
  AiOutlineHome,
  AiOutlineFundProjectionScreen,
  AiOutlineUser,
} from "react-icons/ai";
import { AppContext} from "../App";
import { CgFileDocument } from "react-icons/cg";

function NavBar() {
  const navigate = useNavigate();
  const [expand, updateExpanded] = useState(false);
  const [navColour, updateNavbar] = useState(false);
  const { isAuthenticated, setIsAuthenticated } = useContext(AppContext);
  const { role } = useContext(AppContext);
  function scrollHandler() {
    if (window.scrollY >= 20) {
      updateNavbar(true);
    } else {
      updateNavbar(false);
    }
  }

  window.addEventListener("scroll", scrollHandler);

  return (
    <Navbar
      expanded={expand}
      fixed="top"
      expand="md"
      className={navColour ? "sticky" : "navbar"}
    >
      <Container>
        <Navbar.Brand href="/" className="d-flex">
          <img src={logo} className="img-fluid logo" alt="brand" />
        </Navbar.Brand>
        <Navbar.Toggle
          aria-controls="responsive-navbar-nav"
          onClick={() => {
            updateExpanded(expand ? false : "expanded");
          }}
        >
          <span></span>
          <span></span>
          <span></span>
        </Navbar.Toggle>
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="ms-auto" defaultActiveKey="#home">
            <Nav.Item>
              <Nav.Link as={Link} to="/" onClick={() => updateExpanded(false)}>
                <AiOutlineHome style={{ marginBottom: "2px" }} /> Home
              </Nav.Link>
            </Nav.Item>

            {isAuthenticated && role === 'COMPANY' && <Nav.Item>
              <Nav.Link
                as={Link}
                to="/learners"
                onClick={() => updateExpanded(false)}
              >
                <AiOutlineUser style={{ marginBottom: "2px" }} /> Learners
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && role === 'PEOPLE' && <Nav.Item>
              <Nav.Link
                as={Link}
                to="/jobs"
                onClick={() => updateExpanded(false)}
              >
                <AiOutlineFundProjectionScreen
                  style={{ marginBottom: "2px" }}
                />{" "}
                Jobs
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && role === 'COMPANY' && <Nav.Item>
              <Nav.Link
                  as={Link}
                  to="/our-jobs"
                  onClick={() => updateExpanded(false)}
              >
                <AiOutlineFundProjectionScreen
                    style={{ marginBottom: "2px" }}
                />{" "}
                Jobs
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && role === 'COMPANY' && <Nav.Item>
              <Nav.Link
                as={Link}
                to="/addjob"
                onClick={() => updateExpanded(false)}
              >
                <CgFileDocument style={{ marginBottom: "2px" }} /> Add job
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && role === 'PEOPLE' && <Nav.Item>
              <Nav.Link
                  as={Link}
                  to="/trainings"
                  onClick={() => updateExpanded(false)}
              >
                <AiOutlineUser style={{ marginBottom: "2px" }} /> Trainings
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && role === 'PEOPLE' && <Nav.Item>
              <Nav.Link
                  as={Link}
                  to="/my-trainings"
                  onClick={() => updateExpanded(false)}
              >
                <AiOutlineUser style={{ marginBottom: "2px" }} />  My Trainings
              </Nav.Link>
            </Nav.Item>}

            {!isAuthenticated && <Nav.Item>
              <Nav.Link
                  as={Link}
                  to="/login"
                  onClick={() => updateExpanded(false)}
              >
                <CgFileDocument style={{ marginBottom: "2px" }} /> Login
              </Nav.Link>
            </Nav.Item>}

            {isAuthenticated && <Nav.Item>
              <Nav.Link
                  as={Link}
                  to="/home"
                  onClick={() => {
                    setIsAuthenticated(false);
                  }}
              >
                <CgFileDocument style={{ marginBottom: "2px" }} /> Logout
              </Nav.Link>
            </Nav.Item>}

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavBar;
