import { Routes, Route } from "react-router-dom";
import Home from "./Home";
import Weather from "./Weather";
import HomePageButton from "./components/HomePageButton";

function App() {
  return (
    <>
      <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/weather/:city" element={<Weather />} />
      
    </Routes>
    <HomePageButton/>
    </>
    
    
  );
}

export default App;