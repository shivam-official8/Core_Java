const apiKey = "a0842c058971708f222519232eebf556";
function getWeather() {
    const city = document.getElementById("cityInput").value;
    if (!city) {
        alert("Please enter a city name");
        return;
    }
    fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`)
        .then(res => res.json())
        .then(data => {
            console.log(data); 
            document.getElementById("weatherResult").innerHTML = `
                <h3>${data.name}, ${data.sys.country}</h3>
                <div class="temp">${data.main.temp}°C</div>
                <p>${data.weather[0].main} - ${data.weather[0].description}</p>
                <p>Feels Like: ${data.main.feels_like}°C</p>
                <p>Humidity: ${data.main.humidity}%</p>
                <p>Wind Speed: ${data.wind.speed} m/s</p>
            `;
        })
        .catch(err => {
            console.error(err);
            alert("City not found");
        });
}
