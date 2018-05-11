import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/main.css';
import initMap from './map/map.js';

window.initMap = initMap;

$('#search').click(getWeather);
var req = $.getJSON('http://localhost:3000/weather');

function getWeather() {
    console.log($);
    var req = $.getJSON('http://localhost:8080/weather',
        {
        lat: 24,
        lon: 65
        });
    req.then(x => console.log(x));
    console.log($);
}