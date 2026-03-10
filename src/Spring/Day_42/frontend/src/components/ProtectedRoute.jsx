import { Navigate, Outlet } from "react-router-dom";
import { jwtDecode } from "jwt-decode";

const  ProtectedRoute = () => {
  const token = localStorage.getItem("token");

  if (!token) return <Navigate to="/login" replace />;

  try {
    // 1. Decode the token
    const decoded = jwtDecode(token);
    
    // 2. Check Expiration (exp is in seconds, Date.now() in ms)
    const isExpired = decoded.exp * 1000 < Date.now();
    if (isExpired) {
      localStorage.removeItem("token");
      return <Navigate to="/login" replace />;
    }

    // 3. Check Role (Matches your @PreAuthorize("hasRole('ADMIN')"))
    if (decoded.role !== "ROLE_ADMIN") {
      return <Navigate to="/" replace />; // Send non-admins to the home page
    }

    // If all checks pass, show the admin pages
    return <Outlet />;
    
  } catch (error) {
    // If the token is "abc", jwtDecode will throw an error
    console.error("Invalid token format");
    localStorage.removeItem("token");
    return <Navigate to="/login" replace />;
  }
};

export default ProtectedRoute;