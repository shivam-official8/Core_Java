import { useState, useEffect } from "react";
import axios from "axios";

async function fetchStats() {
  return { users: 1284, orders: 473, products: 96 };
}

async function fetchProducts() {
  const token = localStorage.getItem("token");
  const res = await axios.get("http://localhost:8080/admin/all-products", {
    headers: { Authorization: `Bearer ${token}` }
  });
  return res.data;
}

export default function AdminHome() {
  const [stats, setStats] = useState(null);
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState("");

  useEffect(() => {
    (async () => {
      const [s, p] = await Promise.all([fetchStats(), fetchProducts()]);
      setStats(s);
      setProducts(p);
      setLoading(false);
    })();
  }, []);

  const filtered = products.filter(p =>
    p.name.toLowerCase().includes(search.toLowerCase()) ||
    p.category.toLowerCase().includes(search.toLowerCase())
  );

  if (loading) return <div className="text-slate-400">Loading Stats...</div>;

  return (
    <div className="space-y-8">
      {/* STATS CARDS */}
      <div className="grid grid-cols-3 gap-6">
        {[
          { label: "Total Users", value: stats.users },
          { label: "Total Orders", value: stats.orders },
          { label: "Total Products", value: stats.products }
        ].map((stat, i) => (
          <div key={i} className="bg-white border border-slate-200 p-6 rounded-sm shadow-sm">
            <div className="text-[10px] font-bold text-slate-400 uppercase tracking-widest mb-1">
              {stat.label}
            </div>
            <div className="text-3xl font-light text-slate-900">
              {stat.value.toLocaleString()}
            </div>
          </div>
        ))}
      </div>

      {/* RECENT PRODUCTS TABLE */}
      <div className="bg-white border border-slate-200 rounded-sm shadow-sm overflow-hidden">
        <div className="px-6 py-4 border-b border-slate-100 flex justify-between items-center bg-slate-50/50">
          <h3 className="font-bold text-slate-900 text-sm tracking-tight">Recent Inventory</h3>
          <input
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            placeholder="Filter..."
            className="border border-slate-200 rounded px-3 py-1.5 text-xs focus:border-blue-600 outline-none w-48"
          />
        </div>
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="border-b border-slate-100">
              <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Product</th>
              <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Price</th>
              <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Stock</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-50">
            {filtered.slice(0, 5).map(p => ( // Showing only top 5 on dashboard
              <tr key={p.id}>
                <td className="px-6 py-4 text-sm font-semibold text-slate-700">{p.name}</td>
                <td className="px-6 py-4 text-sm text-slate-900">₹{p.price}</td>
                <td className="px-6 py-4 text-sm text-slate-500">{p.stock}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}