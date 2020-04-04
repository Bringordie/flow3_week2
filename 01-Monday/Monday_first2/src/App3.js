import React from "react";
import { names } from "./file2.js";

function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

function WelcomePerson(props) {
  let { firstName, lastName, email } = props.person;
  return (
    <h1>
      Hello, {firstName} {lastName}, email: {email}
    </h1>
  );
}

function App() {
  return (
    <div>
      <Welcome name="Sara" />
      <Welcome name="Cahal" />
      <Welcome name="Edite" />
      <Welcome />
      <Welcome name={45} />

      <WelcomePerson person={names[0]} />
      <WelcomePerson person={names[1]} />
      <WelcomePerson person={names[2]} />
    </div>
  );
}

export default App;
