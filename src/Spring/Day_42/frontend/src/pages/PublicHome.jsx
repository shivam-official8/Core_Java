import React, { useEffect, useState } from "react";
import axios from "axios";

const PublicHome = () => {

  const [products,setProducts] = useState([]);

  useEffect(()=>{
    axios.get("http://localhost:8080/admin/all-products")
    .then(res => setProducts(res.data))
    .catch(err => console.log(err));
  },[])

  return (
    <div style={{padding:"40px"}}>

      <h2>All Products</h2>

      <div style={{display:"flex",flexWrap:"wrap",gap:"20px"}}>

        {products.map(p => (
          <div key={p.id} style={styles.card}>
            <h3>{p.name}</h3>
            <p>₹ {p.price}</p>
          </div>
        ))}

      </div>

    </div>
  )
}

const styles={
  card:{
    padding:"20px",
    background:"#f3f4f6",
    borderRadius:"10px",
    width:"200px"
  }
}

export default PublicHome