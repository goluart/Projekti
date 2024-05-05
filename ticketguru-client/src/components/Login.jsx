<<<<<<< HEAD
import React, { useState } from "react";
import { SERVER_URL } from "../constants/Constants";
import { Button, TextField, Alert, Stack, Paper, Typography } from "@mui/material";
import { useNavigate } from "react-router";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState('');
  const base64Credentials = btoa(username + ":" + password);
  const url = SERVER_URL;


  const requestOptions = {
    method: "GET",
    headers: {
      Authorization: `Basic ${base64Credentials}`,
    }
  };

  const handleChangeUsername = (event) => {
    setUsername(event.target.value);
  };

  const handleChangePassword = (event) => {
    setPassword(event.target.value);
  };

  const authorize = async (event) => {
    event.preventDefault();
    try {
      const response = await fetch(`${url}/tarkastukset`, requestOptions);
      console.log(response.status)
      if (response.status == 401) {
        setMessage(<Alert severity="error">Käyttäjätunnus tai salasana ei kelpaa</Alert>);
      }
      if (response.status == 200) {
        sessionStorage.setItem("credentials", base64Credentials);
        if (username == 'lipuntarkastaja') {
          sessionStorage.setItem("role", "lipuntarkastaja")
        } if (username == 'myyja') {
          sessionStorage.setItem("role", "myyja")
        } if (username == 'hallinto') {
          sessionStorage.setItem("role", "hallinto")
        }
        setMessage(<Alert severity="success">Kirjautuminen onnistui</Alert>)
      }
    } catch (error) {
      console.error("There was a network error:", error);
    }
  };

  return (
    <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
      <Typography variant="h5">Sinun on ensin kirjauduttava sisään</Typography>
      <Stack container spacing={2}>
        <TextField label="Käyttäjä" variant="standard" onChange={handleChangeUsername} name="username" />
        <TextField label="Salasana" variant="standard" onChange={handleChangePassword} name="password" />
        <Button variant="contained" onClick={authorize}>Kirjaudu</Button>
        {message}
      </Stack>
    </Paper>
  );
}

export default Login;
=======
import React, { useState } from "react";
import { SERVER_URL } from "../constants/Constants";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    const url = SERVER_URL;

    const base64Credentials = btoa(username + ":" + password);
    sessionStorage.setItem("credentials", base64Credentials);

    try {
      const response = await fetch(url, {
        method: "GET",
        headers: {
          Authorization: `Basic ${base64Credentials}`,
        },
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      if (response.ok) {
        navigate("/tickets");
        console.log("Login success", response.status);
      }
      const contentType = response.headers.get("Content-Type");
      if (!contentType || !contentType.includes("application/json")) {
        throw new Error("Expected JSON response but received: " + contentType);
      }
      const result = await response.json();
      console.log("Login", result);
    } catch (error) {
      console.error("There was a network error:", error);
    }
  };

  return (
    <div className="card card-body">
      <h2 className="mb-3">Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">
            Username:
          </label>
          <input
            type="text"
            id="username"
            className="form-control"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">
            Password:
          </label>
          <input
            type="password"
            id="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Login
        </button>
      </form>
    </div>
  );
}

export default Login;
>>>>>>> 9f02a4744106953f554737d5cf7e872e0ad8e998
