import React from "react";
import { HashRouter as Router, Switch, Route, NavLink } from "react-router-dom";
import "./style2.css";
import App2 from "./App2";
import App3 from "./App3";

export default function BasicExample() {
  return (
    <Router>
      <div>
        <Header />
        <hr />
        <div className="content">
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/about">
              <About />
            </Route>
            <Route path="/dashboard">
              <Dashboard />
            </Route>
            <Route path="/app2">
              <App2 />
            </Route>
            <Route path="/app3">
              <App3 />
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );

  function Header() {
    return (
      <ul className="header">
        <li>
          <NavLink exact activeClassName="selected" to="/">
            Home
          </NavLink>
        </li>
        <li>
          <NavLink exact activeClassName="selected" to="/About">
            About
          </NavLink>
        </li>
        <li>
          <NavLink exact activeClassName="selected" to="/Dashboard">
            Dashboard
          </NavLink>
        </li>
        <li>
          <NavLink exact activeClassName="selected" to="/app2">
            App2
          </NavLink>
        </li>
        <li>
          <NavLink exact activeClassName="selected" to="/app3">
            App3
          </NavLink>
        </li>
      </ul>
    );
  }
}

// You can think of these components as "pages"
// in your app.

function Home() {
  return (
    <div>
      <h2>Home</h2>
    </div>
  );
}

function About() {
  return (
    <div>
      <h2>About</h2>
    </div>
  );
}

function Dashboard() {
  return (
    <div>
      <h2>Dashboard</h2>
    </div>
  );
}
