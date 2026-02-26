import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";

const API_KEY = "a0842c058971708f222519232eebf556";

function Weather() {
  const { city } = useParams();
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState("");
const navigate = useNavigate();
  

  useEffect(() => {
    fetch(
      `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`
    )
      .then((res) => {
        if (!res.ok) throw new Error("City not found");
        return res.json();
      })
      .then((data) => setWeather(data))
      .catch((err) => setError(err.message));
  }, [city]);

  if (error) return <h3>{error}</h3>;
  if (!weather) return <h3>Loading...</h3>;

  return (
    <div style={{ textAlign: "center", marginTop: "80px" }}>
      <h2>Weather in {weather.name}</h2>

      <h3>hello world</h3>
      <p>🌡️ Temperature: {weather.main.temp} °C</p>
      <p>☁️ Condition: {weather.weather[0].description}</p>
      <p>💨 Wind: {weather.wind.speed} m/s</p>
      <button onClick={()=>navigate("/")}>Home</button>
    </div>
    
  );
}

export default Weather;