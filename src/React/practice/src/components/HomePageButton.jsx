import React from 'react'
import { useNavigate } from 'react-router-dom'
function HomePageButton() {
    const navigate = useNavigate("/");
  return (
   <button onClick={()=>navigate("/")}>Home</button>
  )
}

export default HomePageButton