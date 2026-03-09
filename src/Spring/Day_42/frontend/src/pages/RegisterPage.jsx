import React, { useState, useEffect } from "react";
import axios from "axios";

const RegisterPage = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [usernameAvailable, setUsernameAvailable] = useState(null);
  const [message, setMessage] = useState("");

  // Check username availability with debounce
  useEffect(() => {
    if (!username) {
      setUsernameAvailable(null);
      return;
    }

    const timeoutId = setTimeout(() => {
      axios
        .get(`http://localhost:8080/auth/check-username?username=${username}`)
        .then(res => setUsernameAvailable(res.data.available))
        .catch(err => console.error(err));
    }, 500);

    return () => clearTimeout(timeoutId);
  }, [username]);

  const handleRegister = async (e) => {
    e.preventDefault();
    if (usernameAvailable === false) {
      setMessage("Username is already taken!");
      return;
    }

    try {
      const res = await axios.post("http://localhost:8080/auth/register", { username, email, password });
      setMessage(res.data);
      setUsername("");
      setEmail("");
      setPassword("");
      setUsernameAvailable(null);
    } catch (err) {
      setMessage(err.response?.data || "Error registering user");
    }
  };

  return (
    <div style={styles.container}>
      <h2 style={{ color: "#4b5563" }}>Create Account</h2>
      <form onSubmit={handleRegister} style={styles.form}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={e => setUsername(e.target.value)}
          required
          style={styles.input}
        />
        {username && (
          <span style={{ color: usernameAvailable ? "#16a34a" : "#dc2626", fontSize: "14px" }}>
            {usernameAvailable === null ? "" : usernameAvailable ? "Username available" : "Username taken"}
          </span>
        )}
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          required
          style={styles.input}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          required
          style={styles.input}
        />
        <button type="submit" style={styles.button}>Register</button>
      </form>
      {message && <p style={{ color: "#2563eb", marginTop: "10px" }}>{message}</p>}
    </div>
  );
};

const styles = {
  container: {
    maxWidth: "400px",
    margin: "50px auto",
    padding: "30px",
    borderRadius: "12px",
    backgroundColor: "#f3f4f6", // soft gray
    boxShadow: "0 4px 12px rgba(0,0,0,0.1)",
    fontFamily: "Arial, sans-serif",
    textAlign: "center"
  },
  form: { display: "flex", flexDirection: "column", gap: "12px" },
  input: {
    padding: "10px",
    fontSize: "15px",
    borderRadius: "6px",
    border: "1px solid #d1d5db",
    outline: "none"
  },
  button: {
    padding: "10px",
    fontSize: "16px",
    borderRadius: "6px",
    border: "none",
    backgroundColor: "#3b82f6", // blue button
    color: "#fff",
    cursor: "pointer",
    transition: "background-color 0.3s" 
  }
};

export default RegisterPage;