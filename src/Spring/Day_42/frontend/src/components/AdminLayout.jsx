
// import { jwtDecode } from "jwt-decode";
// import { useState, useEffect, use } from "react";
// import axios from "axios";
// import { useNavigate } from "react-router-dom";

// async function fetchStats() {
//   return { users: 1284, orders: 473, products: 96 };
// }

// async function fetchProducts() {
//   const token = localStorage.getItem("token");
//   const res = await axios.get("http://localhost:8080/admin/all-products", {
//     headers: { Authorization: `Bearer ${token}` }
//   });
//   return res.data;
// }



// const NAV_ITEMS = [
//   { id: "dashboard", label: "Dashboard" },
//   { id: "products", label: "Manage Products" },
//   { id: "orders", label: "Manage Orders" },
//   { id: "categories", label: "Manage Categories" },
//   { id: "profile", label: "Profile" }
// ];

// export default function AdminDashboard() {
//   const [activeNav, setActiveNav] = useState("dashboard");
//   const [stats, setStats] = useState(null);
//   const [products, setProducts] = useState([]);
//   const [auth, setAuth] = useState(null);
//   const [loading, setLoading] = useState(true);
//   const [search, setSearch] = useState("");
//     const navigate = useNavigate();

// async function checkAuth() {
//     const token = localStorage.getItem("token");
//     if(token==null)navigate("/login")
//      const decoded = jwtDecode(token);
//     const role = decoded.role;
//     if(role!=="ROLE_ADMIN")navigate("/")
   
//   return { isLoggedIn: true, name: "Alex Morgan", role: "Admin", avatar: "AM" };
// }

//   useEffect(() => {
//     (async () => {
//       const [s, p, a] = await Promise.all([
//         fetchStats(),
//         fetchProducts(),
//         checkAuth()
//       ]);
//       setStats(s);
//       setProducts(p);
//       setAuth(a);
//       setLoading(false);
//     })();
//   }, []);

//   const filtered = products.filter(p =>
//     p.name.toLowerCase().includes(search.toLowerCase()) ||
//     p.category.toLowerCase().includes(search.toLowerCase())
//   );

//   if (loading) {
//     return (
//       <div className="flex items-center justify-center h-screen bg-white">
//         <div className="text-slate-400 font-medium tracking-tight">Loading...</div>
//       </div>
//     );
//   }

//   return (
//     <div className="flex h-screen bg-white text-slate-900 font-sans">
      
//       {/* SIDEBAR */}
//       <aside className="w-64 bg-white border-r border-slate-100 flex flex-col">
//         <div className="h-16 flex items-center px-6 border-b border-slate-100">
//           <h1 className="font-bold text-lg tracking-tight">
//             Admin<span className="text-blue-600">OS</span>
//           </h1>
//         </div>

//         <nav className="flex-1 p-4 space-y-1">
//           {NAV_ITEMS.map(item => (
//             <button
//               key={item.id}
//               onClick={() => navigate("/admin/products")}
//               className={`w-full text-left px-4 py-2.5 rounded text-sm font-medium transition-colors
//               ${activeNav === item.id
//                 ? "bg-blue-600 text-white"
//                 : "text-slate-500 hover:bg-slate-50 hover:text-slate-900"
//               }`}
//             >
//               {item.label}
//             </button>
//           ))}
//         </nav>

//         {auth?.isLoggedIn && (
//           <div className="p-4 border-t border-slate-100 flex items-center gap-3">
//             <div className="w-9 h-9 bg-slate-900 text-white rounded flex items-center justify-center text-xs font-bold">
//               {auth.avatar}
//             </div>
//             <div>
//               <div className="text-sm font-bold text-slate-900">{auth.name}</div>
//               <div className="text-[11px] text-slate-400 uppercase font-bold tracking-wider">{auth.role}</div>
//             </div>
//           </div>
//         )}
//       </aside>

//       {/* MAIN */}
//       <main className="flex-1 flex flex-col min-w-0">
        
//         {/* HEADER */}
//         <header className="h-16 bg-white border-b border-slate-100 px-8 flex justify-between items-center">
//           <h2 className="text-sm font-bold uppercase tracking-widest text-slate-400">
//             {NAV_ITEMS.find(n => n.id === activeNav)?.label}
//           </h2>
//           <div className="text-sm font-medium text-slate-500">
//             {new Date().toLocaleDateString()}
//           </div>
//         </header>

//         {/* CONTENT */}
//         <div className="p-8 overflow-y-auto">
          
//           {activeNav === "dashboard" && (
//             <div className="space-y-8">
              
//               {/* STATS */}
//               <div className="grid grid-cols-3 gap-6">
//                 {[
//                   { label: "Total Users", value: stats.users },
//                   { label: "Total Orders", value: stats.orders },
//                   { label: "Total Products", value: stats.products }
//                 ].map((stat, i) => (
//                   <div key={i} className="bg-white border border-slate-200 p-6 rounded-sm shadow-sm">
//                     <div className="text-[10px] font-bold text-slate-400 uppercase tracking-widest mb-1">
//                       {stat.label}
//                     </div>
//                     <div className="text-3xl font-light text-slate-900">
//                       {stat.value.toLocaleString()}
//                     </div>
//                   </div>
//                 ))}
//               </div>

//               {/* TABLE */}
//               <div className="bg-white border border-slate-200 rounded-sm shadow-sm overflow-hidden">
//                 <div className="px-6 py-4 border-b border-slate-100 flex justify-between items-center bg-slate-50/50">
//                   <h3 className="font-bold text-slate-900 text-sm tracking-tight">Recent Products</h3>
//                   <div className="flex gap-2">
//                     <input
//                       value={search}
//                       onChange={(e) => setSearch(e.target.value)}
//                       placeholder="Filter by name..."
//                       className="border border-slate-200 rounded px-3 py-1.5 text-xs focus:border-blue-600 outline-none w-48"
//                     />
//                     <button
//                       onClick={() => setActiveNav("products")}
//                       className="bg-blue-600 text-white px-4 py-1.5 rounded text-xs font-bold hover:bg-blue-700 transition-colors"
//                     >
//                       New Product
//                     </button>
//                   </div>
//                 </div>

//                 <div className="overflow-x-auto">
//                   <table className="w-full text-left border-collapse">
//                     <thead>
//                       <tr className="border-b border-slate-100">
//                         <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Product</th>
//                         <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Category</th>
//                         <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Price</th>
//                         <th className="px-6 py-3 text-[10px] font-bold text-slate-400 uppercase tracking-widest">Stock</th>
//                       </tr>
//                     </thead>
//                     <tbody className="divide-y divide-slate-50">
//                       {filtered.map(p => (
//                         <tr key={p.id} className="hover:bg-slate-50/50">
//                           <td className="px-6 py-4 text-sm font-semibold text-slate-700">{p.name}</td>
//                           <td className="px-6 py-4 text-sm text-slate-500">{p.category}</td>
//                           <td className="px-6 py-4 text-sm text-slate-900 font-medium">${p.price}</td>
//                           <td className="px-6 py-4 text-sm text-slate-500">{p.stock}</td>
//                         </tr>
//                       ))}
//                     </tbody>
//                   </table>
//                 </div>
//               </div>
//             </div>
//           )}

//           {/* OTHER VIEWS */}
//           {activeNav !== "dashboard" && (
//             <div className="flex items-center justify-center py-24 border border-slate-200 border-dashed rounded bg-slate-50/30">
//               <div className="text-center">
//                 <div className="text-slate-900 font-bold mb-1 italic">Module: {activeNav.toUpperCase()}</div>
//                 <div className="text-slate-400 text-sm">Waiting for content input.</div>
//               </div>
//             </div>
//           )}

//         </div>
//       </main>
//     </div>
//   );
// }




import { Outlet, useNavigate, useLocation } from "react-router-dom";
import { useState, useEffect } from "react";
import { jwtDecode } from "jwt-decode";

const NAV_ITEMS = [
  { id: "dashboard", label: "Dashboard", path: "/admin" },
  { id: "products", label: "Inventory", path: "/admin/products" },
  { id: "orders", label: "Manage Orders", path: "/admin/orders" },
  { id: "categories", label: "Manage Categories", path: "/admin/categories" },
  { id: "profile", label: "Profile", path: "/admin/profile" }
];

export default function AdminLayout() {
  const navigate = useNavigate();
  const location = useLocation();
  const [auth, setAuth] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (!token) {
      navigate("/login");
      return;
    }
    try {
      const decoded = jwtDecode(token);
      if (decoded.role !== "ROLE_ADMIN") {
        navigate("/");
        return;
      }
      setAuth({ name: "Alex Morgan", role: "Admin", avatar: "AM", isLoggedIn: true });
      setLoading(false);
    } catch (err) {
      navigate("/login");
    }
  }, [navigate]);

  if (loading) return <div className="h-screen flex items-center justify-center">Loading...</div>;

  return (
    <div className="flex h-screen bg-white text-slate-900 font-sans">
      {/* STICKY SIDEBAR */}
      <aside className="w-64 bg-white border-r border-slate-100 flex flex-col shrink-0">
        <div className="h-16 flex items-center px-6 border-b border-slate-100">
          <h1 className="font-bold text-lg tracking-tight">Admin<span className="text-blue-600">OS</span></h1>
        </div>
        <nav className="flex-1 p-4 space-y-1">
          {NAV_ITEMS.map(item => (
            <button
              key={item.id}
              onClick={() => navigate(item.path)}
              className={`w-full text-left px-4 py-2.5 rounded text-sm font-medium transition-colors ${
                location.pathname === item.path ? "bg-blue-600 text-white" : "text-slate-500 hover:bg-slate-50"
              }`}
            >
              {item.label}
            </button>
          ))}
        </nav>
        <div className="p-4 border-t border-slate-100 flex items-center gap-3">
          <div className="w-9 h-9 bg-slate-900 text-white rounded flex items-center justify-center text-xs font-bold">{auth?.avatar}</div>
          <div className="text-sm font-bold">{auth?.name}</div>
        </div>
      </aside>

      {/* MAIN SECTION */}
      <main className="flex-1 flex flex-col min-w-0 overflow-hidden">
        <header className="h-16 bg-white border-b border-slate-100 px-8 flex justify-between items-center shrink-0">
          <h2 className="text-sm font-bold uppercase tracking-widest text-slate-400">
            {NAV_ITEMS.find(n => n.path === location.pathname)?.label || "Admin"}
          </h2>
          {/* <div className="text-sm font-medium text-slate-500">{new Date().toLocaleDateString()}</div> */}
        </header>

        {/* CONTENT AREA - THIS PART CHANGES */}
        <div className="p-8 overflow-y-auto flex-1 bg-white">
          <Outlet /> 
        </div>
      </main>
    </div>
  );
}