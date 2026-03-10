import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AdminProducts = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState("");
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [isManaged, setManaged] = useState(false);
  const navigate = useNavigate();
  const [productToDelete, setProductToDelete] = useState(null); 

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const token = localStorage.getItem("token");
      const res = await axios.get("http://localhost:8080/admin/all-products", {
        headers: { Authorization: `Bearer ${token}` },
      });
      setProducts(res.data);
      setLoading(false);
    } catch (err) {
      console.error("Error fetching products", err);
      setLoading(false);
    }
  };

  const handleOnDelete = async () => {
  if (!productToDelete) return;

  const token = localStorage.getItem("token");
  try {
    // Calling your @PostMapping("/delete-product/{id}")
    await axios.post(`http://localhost:8080/admin/delete-product/${productToDelete.id}`, {}, {
      headers: { Authorization: `Bearer ${token}` }
    });
    
    // Refresh the list and close modal
    setProducts(products.filter(p => p.id !== productToDelete.id));
    setProductToDelete(null); 
    alert("Product deleted successfully");
  } catch (err) {
    console.error("Delete failed", err);
    alert("Could not delete product");
  }
};

  const filteredProducts = products.filter(
    (p) =>
      p.title?.toLowerCase().includes(search.toLowerCase()) ||
      p.description?.toLowerCase().includes(search.toLowerCase())
  );

  if (loading) return <div className="p-8 text-slate-400">Loading products...</div>;

  // If a product is clicked, show Full Page View
  if (selectedProduct) {
    return (
      <div className="p-8 max-w-4xl mx-auto">
        <button 
          onClick={() => setSelectedProduct(null)}
          className="text-blue-600 font-bold text-sm mb-6 hover:underline"
        >
          ← Back to Inventory
        </button>
        <div className="bg-white border border-slate-200 p-8 rounded-sm shadow-sm">
          <div className="flex justify-between items-start mb-6">
            <div>
              <span className="text-[10px] font-bold text-slate-800 uppercase tracking-widest">Product ID: {selectedProduct.id}</span>
              <h1 className="text-3xl font-light text-slate-900 mt-1">{selectedProduct.name}</h1>
            </div>
            <div className="text-2xl font-semibold text-slate-900">${selectedProduct.price}</div>
          </div>
          <div className="border-t border-slate-100 pt-6">
            <h4 className="text-xs font-bold text-slate-800 uppercase mb-2">Description</h4>
            <p className="text-slate-600 leading-relaxed">{selectedProduct.description}</p>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="p-8 space-y-6">
      {/* TOP BAR */}
      <div className="flex justify-between items-center">
        <div>
          <h2 className="text-sm font-bold uppercase tracking-widest text-slate-400">Inventory Management</h2>
          <p className="text-xl font-light text-slate-900">{products.length} Total Items</p>
        </div>
        <div>
            <button onClick={()=>setManaged(!isManaged)} className="mx-5 bg-blue-600 text-white px-6 py-2 rounded text-sm font-bold hover:bg-blue-700 transition-colors">
          Manage Product
        </button>
        <button onClick={()=>navigate("/admin/add-product")} className="bg-blue-600 text-white px-6 py-2 rounded text-sm font-bold hover:bg-blue-700 transition-colors">
          Add New Product
        </button>
        </div>
        
      </div>

      {/* SEARCH & FILTERS */}
      <div className="bg-white border border-slate-200 p-4 rounded-sm shadow-sm">
        <input
          type="text"
          placeholder="Search by title or description..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          className="w-full border border-slate-200 rounded px-4 py-2 text-sm focus:border-blue-600 outline-none"
        />
      </div>

      {/* TABLE */}
      <div className="bg-white border border-slate-200 rounded-sm shadow-sm overflow-hidden">
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="border-b border-slate-100 bg-slate-50/50">
              <th className="px-6 py-3 text-[10px] font-bold text-black uppercase tracking-widest">ID</th>
              <th className="px-6 py-3 text-[10px] font-bold text-black uppercase tracking-widest">Product Name</th>
              <th className="px-6 py-3 text-[10px] font-bold text-black uppercase tracking-widest">Product Description</th>
              <th className="px-6 py-3 text-[10px] font-bold text-black uppercase tracking-widest">Price</th>
             {isManaged && (<th className="px-6 py-3 text-[10px] font-bold text-black uppercase tracking-widest text-right">Actions</th>)} 
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-50">
            {filteredProducts.map((p) => (
            <tr 
  key={p.id} 
  className="hover:bg-slate-50/50 cursor-pointer transition-colors group"
  onClick={() => setSelectedProduct(p)}
>
  {/* Uniform Dark Text for ID */}
  <td className="px-6 py-4 text-xs font-mono text-slate-800">
    #{p.id}
  </td>

  <td className="px-6 py-4">
    {/* Uniform Dark Text for Title */}
    <div className="text-sm font-semibold text-slate-800 group-hover:text-blue-600 transition-colors">
      {p.name}
    </div>
    {/* Description remains slightly lighter for hierarchy, but still legible */}
    {/* <div className="text-xs text-slate-500 truncate max-w-xs">
      {p.description}
    </div> */}
  </td>

<td className="px-6 py-4">
  <div className="text-sm font-semibold text-slate-800 group-hover:text-blue-600 transition-colors">
    {p.description?.length > 10 
      ? p.description.slice(0, 10) + "..." 
      : p.description}
  </div>
</td>

  {/* Uniform Dark Text for Price */}
  <td className="px-6 py-4 text-sm text-slate-800 font-bold">
    ₹{p.price}
  </td>
{isManaged && (
<td className="px-6 py-4 text-right space-x-2" onClick={(e) => e.stopPropagation()}>
    {/* Action Buttons with Solid Backgrounds */}
   <button 
  className="px-3 py-1 bg-blue-600 text-white text-[10px] font-bold uppercase rounded shadow-sm"
  onClick={(e) => {
    e.stopPropagation();
    navigate(`/admin/edit-product/${p.id}`);
  }}
>
  Edit
</button>
    
   <button 
  className="px-3 py-1 bg-red-600 text-white text-[10px] font-bold uppercase tracking-wider rounded hover:bg-red-700 transition-colors shadow-sm"
  onClick={(e) => {
    e.stopPropagation(); // Stop row click from opening product detail
    setProductToDelete(p); // 'p' is the product from your .map()
  }}
>
  Delete
</button>
  </td>

)}
  
</tr>
            ))}
          </tbody>
        </table>
        {filteredProducts.length === 0 && (
          <div className="p-12 text-center text-slate-400 text-sm">
            No products match your search.
          </div>
        )}
      </div>

        {/* DELETE CONFIRMATION MODAL */}
{productToDelete && (
  <div className="fixed inset-0 bg-slate-900/40 backdrop-blur-sm flex items-center justify-center z-50">
    <div className="bg-white border border-slate-200 p-8 max-w-sm w-full rounded-sm shadow-xl">
      <h3 className="text-sm font-bold uppercase tracking-widest text-red-600 mb-2">
        Confirm Deletion
      </h3>
      <p className="text-slate-600 text-sm mb-6 leading-relaxed">
        Are you sure you want to delete <span className="font-bold text-slate-900">"{productToDelete.title}"</span>? 
        This action cannot be undone.
      </p>
      
      <div className="flex gap-3">
        <button 
          onClick={handleOnDelete}
          className="flex-1 bg-red-600 text-white py-2 text-[10px] font-bold uppercase tracking-wider rounded hover:bg-red-700 transition-colors"
        >
          Yes, Delete
        </button>
        <button 
          onClick={() => setProductToDelete(null)}
          className="flex-1 bg-slate-100 text-slate-600 py-2 text-[10px] font-bold uppercase tracking-wider rounded hover:bg-slate-200 transition-colors"
        >
          Cancel
        </button>
      </div>
    </div>
  </div>
)}



    </div>
  );
};

export default AdminProducts;