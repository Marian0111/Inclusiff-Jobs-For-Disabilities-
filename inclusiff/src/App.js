import React, { useState, useEffect, createContext } from "react";
import Preloader from "../src/components/Pre";
import Navbar from "./components/Navbar";
import Home from "./components/Home/Home";
import Learners from "./components/Learners/Learners";
import Jobs from "./components/Jobs/Jobs";
import Footer from "./components/Footer";
import Login from "./components/Login/Login"
import AddJob from "./components/AddJob/AddJob";

import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate
} from "react-router-dom";
import ScrollToTop from "./components/ScrollToTop";
import "./style.css";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Trainings from "./components/Trainings/Trainings";
import EnterpriseJobs from "./components/EnterpriseJobs/EnterpriseJobs";
import MyTrainings from "./components/MyTrainings/MyTrainings";

export const AppContext = createContext();

function App() {
  const [load, updateLoad] = useState(true);
  const [isAuthenticated, setIsAuthenticated] = useState(false)
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [userId, setUserId] = useState('');
  const [role, setRole] = useState('');
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');

  useEffect(() => {
    const timer = setTimeout(() => {
      updateLoad(false);
    }, 1200);

    return () => clearTimeout(timer);
  }, []);

  return (
    <Router>
      <Preloader load={load} />
      <div className="App" id={load ? "no-scroll" : "scroll"}>
        <AppContext.Provider  value = {{
          isAuthenticated,
          setIsAuthenticated,
          email,
          setEmail,
          password,
          setPassword,
          userId,
          setUserId,
          role,
          setRole,
          firstname,
          setFirstname,
          lastname,
          setLastname
        }}>
        <Navbar />
        <ScrollToTop />
        <div className="content">
          <Routes>
            <Route path="/login" element = {<Login />} />
            <Route path="/" element={<Home />} />
            <Route path="/jobs" element={<Jobs />} />
            <Route path="/our-jobs" element={<EnterpriseJobs />} />
            <Route path="/learners" element={<Learners />} />
            <Route path="/addjob" element={<AddJob />} />
            <Route path="/trainings" element={<Trainings />} />
            <Route path="/my-trainings" element={<MyTrainings />} />
            <Route path="*" element={<Navigate to="/"/>} />
          </Routes>
        </div>
        <Footer />
        </AppContext.Provider>
      </div>
    </Router>
  );
}

export default App;
