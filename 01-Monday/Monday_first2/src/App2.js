import React from "react";
import "./App.css";
import file2, { males, females } from "./file2.js";

let { firstName, email } = file2;

export default function App() {
  console.log([...males, ...females]);
  console.log([...males, "Kurt", "Helle", ...females, "Tina"]);
  return (
    <div className="App">
      <h3>App 2</h3>
      <p>
        {firstName}, {email}
      </p>
    </div>
  );
}
