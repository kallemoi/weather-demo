export default function renderWeather(weather) {
    var innerHtml = "<h2>Weather</h2>"
    innerHtml += "<div>Description: " + weather.description + "</div>";
    // Temperature is in Kelvins
    innerHtml += "<div>Temperature: " + (weather.temperature - 272.15) + "&deg;C</div>";
    return innerHtml;
}