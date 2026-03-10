import React from "react";
// import AdminDashboard from "./AdminDashboard";
import AdminDashboard from "../components/AdminLayout.jsx";
import PublicHome from "./PublicHome.jsx";

const Home = () => {

  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  if (token) {
    return <AdminDashboard />;
  }

  return <PublicHome />;
};

export default Home;