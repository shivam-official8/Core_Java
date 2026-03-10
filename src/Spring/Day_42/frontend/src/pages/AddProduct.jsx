import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AddProduct = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [formData, setFormData] = useState({
    name: "",
    description: "",
    stock: 0,
    price: 0,
    category: ""
  });
  const [categories, setCategories] = useState([]);


  useEffect(() => {
  const fetchCategories = async () => {
    const token = localStorage.getItem("token");
    try {
      const res = await axios.get("http://localhost:8080/admin/all-categories", {
        headers: { Authorization: `Bearer ${token}` }
      });
      setCategories(res.data);
    } catch (err) {
      console.error("Error fetching categories", err);
    }
  };
  fetchCategories();
}, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    const token = localStorage.getItem("token");

    try {
      // Calling your @PostMapping("/add-product")
      await axios.post("http://localhost:8080/admin/add-product", formData, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert("Product added successfully!");
      navigate("/admin/products"); // Redirect back to inventory
    } catch (err) {
      console.error("Error adding product", err);
      alert("Failed to add product. Please check your inputs.");
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: name === "stock" || name === "price" ? Number(value) : value,
    }));
  };

  return (
    <div className="max-w-3xl mx-auto p-8">
      {/* HEADER */}
      <div className="mb-10">
        <button 
          onClick={() => navigate("/admin/products")}
          className="text-blue-600 font-bold text-xs uppercase tracking-widest mb-4 hover:underline"
        >
          ← Back to Inventory
        </button>
        <h2 className="text-sm font-bold uppercase tracking-widest text-slate-400">Inventory Management</h2>
        <h1 className="text-3xl font-light text-slate-900 mt-1">Add New Product</h1>
      </div>

      {/* FORM CARD */}
      <div className="bg-white border border-slate-200 p-10 rounded-sm shadow-sm">
        <form onSubmit={handleSubmit} className="space-y-8">
          
          {/* PRODUCT NAME */}
          <div>
            <label className="text-[10px] font-bold text-slate-800 uppercase tracking-widest block mb-2">Product Name</label>
            <input
              type="text"
              name="name"
              required
              value={formData.name}
              onChange={handleChange}
              placeholder="e.g. Minimalist Leather Watch"
              className="w-full border-b border-slate-200 py-3 text-sm outline-none focus:border-blue-600 transition-colors bg-transparent text-slate-800"
            />
          </div>

          {/* CATEGORY */}
          <div>
  <label className="text-[10px] font-bold text-slate-800 uppercase tracking-widest block mb-2">
    Category
  </label>
  <div className="relative">
    <select
      name="category"
      required
      value={formData.category}
      onChange={handleChange}
      className="w-full border-b border-slate-200 py-3 text-sm outline-none focus:border-blue-600 transition-colors bg-transparent text-slate-800 appearance-none cursor-pointer"
    >
      <option value="" disabled>Select a category</option>
      {categories.map((cat) => (
        <option key={cat.id} value={cat.name} className="text-slate-800">
          {cat.name}
        </option>
      ))}
    </select>
    
    {/* Custom Dropdown Arrow (Since appearance-none hides the default) */}
    <div className="absolute right-0 top-1/2 -translate-y-1/2 pointer-events-none text-slate-400">
      <svg xmlns="http://www.w3.org/2000/svg" className="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M19 9l-7 7-7-7" />
      </svg>
    </div>
  </div>
</div>

          {/* PRICE & STOCK GRID */}
          <div className="grid grid-cols-2 gap-10">
            <div>
              <label className="text-[10px] font-bold text-slate-800 uppercase tracking-widest block mb-2">Price (INR)</label>
              <input
                type="number"
                name="price"
                required
                min="0"
                value={formData.price}
                onChange={handleChange}
                className="w-full border-b border-slate-200 py-3 text-sm outline-none focus:border-blue-600 transition-colors bg-transparent text-slate-800"
              />
            </div>
            <div>
              <label className="text-[10px] font-bold text-slate-800 uppercase tracking-widest block mb-2">Initial Stock</label>
              <input
                type="number"
                name="stock"
                required
                min="0"
                value={formData.stock}
                onChange={handleChange}
                className="w-full border-b border-slate-200 py-3 text-sm outline-none focus:border-blue-600 transition-colors bg-transparent text-slate-800"
              />
            </div>
          </div>

          {/* DESCRIPTION */}
          <div>
            <label className="text-[10px] font-bold text-slate-800 uppercase tracking-widest block mb-2">Description</label>
            <textarea
              name="description"
              required
              rows="4"
              value={formData.description}
              onChange={handleChange}
              placeholder="Provide a detailed product overview..."
              className="w-full border border-slate-200 rounded-sm p-4 text-sm outline-none focus:border-blue-600 transition-colors text-slate-800 leading-relaxed"
            />
          </div>

          {/* ACTIONS */}
          <div className="flex gap-4 pt-6">
            <button
              type="submit"
              disabled={loading}
              className={`cursor-pointer flex-1 bg-blue-600 text-white py-4 rounded text-xs font-bold uppercase tracking-widest hover:bg-blue-700 transition-all shadow-sm ${loading ? 'opacity-70 cursor-not-allowed' : ''}`}
            >
              {loading ? "Processing..." : "Add Product"}
            </button>
            <button
              type="button"
              onClick={() => navigate("/admin/products")}
              className="cursor-pointer px-8 bg-white border border-slate-200 text-slate-500 py-4 rounded text-xs font-bold uppercase tracking-widest hover:bg-slate-50 transition-all"
            >
              Cancel
            </button>
          </div>

        </form>
      </div>
    </div>
  );
};

export default AddProduct;