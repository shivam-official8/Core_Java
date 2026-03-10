import { BrowserRouter, Routes, Route } from "react-router-dom";

import RegisterPage from "./pages/RegisterPage";
import Login from "./pages/Login";
import Home from "./pages/Home";
import AdminDashboard from "./components/AdminLayout";
import PublicHome from "./pages/PublicHome";

import AdminRoute from "./components/AdminRoute";
import AdminProducts from "./pages/AdminProducts";
import AdminHome from "./pages/AdminHome";
import AdminLayout from "./components/AdminLayout";
import EditProduct from "./pages/EditProduct";
import ProtectedRoute from "./components/ProtectedRoute";
import AddProduct from "./pages/AddProduct";

function App() {

  return (
    <BrowserRouter>

      <Routes>

        {/* Home decides Admin vs Public */}
        {/* <Route path="/" element={<Home />} /> */}

        {/* Auth routes */}
        <Route path="/signup" element={<RegisterPage />} />
        <Route path="/login" element={<Login />} />

        {/* Public products page */}
        <Route path="/" element={<PublicHome />} />
       
       {/* <Route path="/admin" element={<AdminLayout />}>
    <Route index element={<AdminHome />} />
    <Route path="products" element={<AdminProducts />} />
   
  <Route path="edit-product/:id" element={<EditProduct />} />
  </Route> */}

        



    <Route element={<ProtectedRoute />}>
        <Route path="/admin" element={<AdminLayout />}>
          <Route index element={<AdminHome />} />
          <Route path="products" element={<AdminProducts />} />
          <Route path="add-product" element={<AddProduct />} />
          {/* Any other admin routes added here are automatically protected */}
        </Route>
      </Route>



      </Routes>

    </BrowserRouter>
  );
}

export default App;