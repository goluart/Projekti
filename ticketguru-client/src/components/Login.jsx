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
