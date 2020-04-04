import React, { useState } from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams,
  NavLink,
} from "react-router-dom";
import "./style2.css";

function App({ bookFacade }) {
  const [loginStatus, setLoginStatus] = useState(false);

  const login = (loginState) => {
    setLoginStatus(loginState);
  };

  return (
    <div>
      <Header loginStatus={loginStatus} />
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route path="/products">
          <Products bookFacade={bookFacade} />
        </Route>
        <Route path="/add-book">
          <AddBook bookFacade={bookFacade} />
        </Route>
        <Route path="/company">
          <Company />
        </Route>
        <Route path="/login">
          <Login loginStatus={loginStatus} login={login} />
        </Route>
        <Route path="/:area">
          <NoMatch />
        </Route>
      </Switch>
    </div>
  );
}

function Header({ loginStatus }) {
  return (
    <ul className="header">
      <li>
        <NavLink exact activeClassName="active" to="/">
          Home
        </NavLink>
      </li>
      <li>
        <NavLink activeClassName="active" to="/products">
          Products
        </NavLink>
      </li>
      <li>
        <NavLink activeClassName="active" to="/company">
          Company
        </NavLink>
      </li>
      {loginStatus ? (
        <>
          <li>
            <NavLink activeClassName="active" to="/add-book">
              Add Book
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName="active" to="/login">
              Logout
            </NavLink>
          </li>
        </>
      ) : (
        <li>
          <NavLink activeClassName="active" to="/login">
            Login
          </NavLink>
        </li>
      )}
    </ul>
  );
}

function Login({ loginStatus, login }) {
  function submitHandle(evt) {
    evt.target.id === "login" ? login(true) : login(false);
  }

  return (
    <p>
      {!loginStatus ? (
        <>
          Click here to log in:{" "}
          <Link to="/">
            <button id="login" onClick={submitHandle}>
              Login
            </button>
          </Link>
        </>
      ) : (
        <>
          Click here to log out:{" "}
          <Link to="/">
            <button id="logout" onClick={submitHandle}>
              Logout
            </button>
          </Link>
        </>
      )}
    </p>
  );
}

function Home() {
  return (
    <div>
      <h2>Home</h2>
    </div>
  );
}

function Products({ bookFacade }) {
  return (
    <div>
      <p>There are {bookFacade.getBooks().length} books</p>
      <ul>
        {bookFacade.getBooks().map((book) => {
          return <li key={book.id}>{book.title} </li>;
        })}
      </ul>
    </div>
  );
}

function AddBook({ bookFacade }) {
  const initialBook = { id: "", title: "", info: "" };
  const [book, setBook] = useState(initialBook);

  function updateBook(evt) {
    let t = evt.target;
    let updatedBook = { ...book };
    updatedBook[t.id] = t.value;
    setBook(updatedBook);
  }

  function saveBook(evt) {
    evt.preventDefault();
    bookFacade.addBook(book);
    setBook(initialBook);
  }

  return (
    <div>
      <h2>Add Book</h2>
      <form onSubmit={saveBook}>
        <input
          id="title"
          type="text"
          placeholder="Title"
          value={book.title}
          onChange={updateBook}
        />
        <br />
        <input
          id="info"
          type="text"
          placeholder="Info"
          value={book.info}
          onChange={updateBook}
        />
        <br />
        <input type="submit" value="Save" />
      </form>
    </div>
  );
}

function Company() {
  return (
    <div>
      <h2>Company</h2>
    </div>
  );
}

function NoMatch() {
  let { area } = useParams();
  return (
    <div>
      <p>
        No site matching: <b>/{area}</b>
      </p>
    </div>
  );
}

export default App;
