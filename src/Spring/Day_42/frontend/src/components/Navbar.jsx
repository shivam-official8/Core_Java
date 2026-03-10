import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {

  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  return (
    <div style={styles.navbar}>
      <h3>MyStore</h3>

      <div style={styles.links}>
        <Link to="/">Home</Link>

        {role === "ADMIN" && (
          <>
            <Link to="/manage-products">Manage Products</Link>
            <Link to="/manage-orders">Manage Orders</Link>
          </>
        )}

        {token ? (
          <Link to="/profile">Profile</Link>
        ) : (
          <>
            <Link to="/login">Login</Link>
            <Link to="/register">Signup</Link>
          </>
        )}
      </div>
    </div>
  );
};

const styles = {
  navbar: {
    display: "flex",
    justifyContent: "space-between",
    padding: "15px 40px",
    background: "#4f46e5",
    color: "white",
    alignItems: "center"
  },
  links: {
    display: "flex",
    gap: "20px"
  }
};

export default Navbar;