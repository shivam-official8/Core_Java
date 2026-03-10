import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const EditProduct = () => {
  const { id } = useParams(); // Gets the ID from the URL (/admin/edit-product/123)
  const navigate = useNavigate();
  const [formData, setFormData] = useState({ title: "", description: "", price: 0 });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchSingleProduct = async () => {
      const token = localStorage.getItem("token");
      try {
        // Assuming you have a GET API for a single product
        const res = await axios.get(`http://localhost:8080/admin/product/${id}`, {
          headers: { Authorization: `Bearer ${token}` }
        });
        setFormData(res.data);
        setLoading(false);
      } catch (err) {
        console.error("Could not fetch product details", err);
      }
    };
    fetchSingleProduct();
  }, [id]);

  const handleUpdate = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");
    try {
      // Your Spring Boot @PostMapping("/edit-product/{id}")
      await axios.post(`http://localhost:8080/admin/edit-product/${id}`, formData, {
        headers: { Authorization: `Bearer ${token}` }
      });
      alert("Updated successfully");
      navigate("/admin/products"); // Go back to table
    } catch (err) {
      alert("Error updating product");
    }
  };

  if (loading) return <div className="p-8 text-slate-400">Loading product details...</div>;

  return (
    <div className="max-w-2xl mx-auto p-8 bg-white border border-slate-200 rounded-sm shadow-sm mt-10">
      <h2 className="text-sm font-bold uppercase tracking-widest text-slate-400 mb-8 text-center">Edit Product Listing</h2>
      
      <form onSubmit={handleUpdate} className="space-y-6">
        <div>
          <label className="text-[10px] font-bold text-slate-800 uppercase tracking-tighter">Product Title</label>
          <input 
            className="w-full border-b border-slate-200 py-2 text-sm outline-none focus:border-blue-600 transition-colors"
            value={formData.name} 
            onChange={(e) => setFormData({...formData, name: e.target.value})} 
          />
        </div>

        <div>
          <label className="text-[10px] font-bold text-slate-800 uppercase tracking-tighter">Price (USD)</label>
          <input 
            type="number"
            className="w-full border-b border-slate-200 py-2 text-sm outline-none focus:border-blue-600 transition-colors"
            value={formData.price} 
            onChange={(e) => setFormData({...formData, price: e.target.value})} 
          />
        </div>

        <div>
          <label className="text-[10px] font-bold text-slate-800 uppercase tracking-tighter">Description</label>
          <textarea 
            rows="4"
            className="w-full border border-slate-200 rounded p-3 text-sm outline-none focus:border-blue-600 mt-2"
            value={formData.description} 
            onChange={(e) => setFormData({...formData, description: e.target.value})} 
          />
        </div>

        <div className="flex gap-4 pt-4">
          <button type="submit" className="flex-1 bg-blue-600 text-white py-3 rounded text-xs font-bold uppercase hover:bg-blue-700 transition-all">
            Save Changes
          </button>
          <button type="button" onClick={() => navigate("/admin/products")} className="flex-1 bg-slate-50 text-slate-500 py-3 rounded text-xs font-bold uppercase hover:bg-slate-100 transition-all">
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default EditProduct;