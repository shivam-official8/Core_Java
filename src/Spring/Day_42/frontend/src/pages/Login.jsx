import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
const Login = () => {

  const [email,setEmail] = useState("");
  const [password,setPassword] = useState("");
  const [message,setMessage] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try{

      const res = await axios.post(
        "http://localhost:8080/auth/login",
        {email,password}
      );

      const token = res.data;

      // store token
      localStorage.setItem("token",token);

      setMessage("Login successful");

      // redirect to home page
    const decoded = jwtDecode(token);

    console.log(decoded);
    
    const role = decoded.role;

    console.log("role: "+role);
    
      console.log(role==="ROLE_ADMIN");
      
      if(role==="ROLE_ADMIN"){console.log("yaaaa");
       navigate("/admin");}
       else{
        console.log("yaaa 2222");
        
      navigate("/");}

    }
    catch(err){
      setMessage(err.response?.data || "Invalid username or password");
    }

  }

  return (
    <div style={styles.container}>

      <h2 style={{ color:"#4b5563" }}>Login</h2>

      <form onSubmit={handleLogin} style={styles.form}>

        <input
          type="text"
          placeholder="Email"
          value={email}
          onChange={(e)=>setEmail(e.target.value)}
          required
          style={styles.input}
        />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e)=>setPassword(e.target.value)}
          required
          style={styles.input}
        />

        <button type="submit" style={styles.button}>
          Login
        </button>

      </form>
      <p>Don't have an account? <Link to="/signup">Signup</Link> </p>

      {message && (
        <p style={{marginTop:"10px",color:"#2563eb"}}>
          {message}
        </p>
      )}

    </div>
  )
}

const styles = {
  container:{
    maxWidth:"400px",
    margin:"50px auto",
    padding:"30px",
    borderRadius:"12px",
    backgroundColor:"#f3f4f6",
    boxShadow:"0 4px 12px rgba(0,0,0,0.1)",
    fontFamily:"Arial, sans-serif",
    textAlign:"center"
  },

  form:{
    display:"flex",
    flexDirection:"column",
    gap:"12px"
  },

  input:{
    padding:"10px",
    fontSize:"15px",
    borderRadius:"6px",
    border:"1px solid #d1d5db",
    outline:"none"
  },

  button:{
    padding:"10px",
    fontSize:"16px",
    borderRadius:"6px",
    border:"none",
    backgroundColor:"#3b82f6",
    color:"#fff",
    cursor:"pointer"
  }
}

export default Login