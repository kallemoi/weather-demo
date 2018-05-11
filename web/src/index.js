import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/main.css';
import { initMap, updateMap } from './map/map.js';
import { getLocation, getWeather } from './api.js';
import renderWeather from './weather/renderWeather.js';

window.initMap = initMap;

$('#search').click(userSearched);
$('#location').on('keyup', function (e) {
    if (e.keyCode == 13) {
        userSearched(e);
    }
});

function userSearched(e) {
    var address = $('#location').val();
    var q = getLocation(address);
    q.then((x) => getWeather(x.lat, x.lon))
        .then(displayWeather);
    q.then((x) => updateMap(x.lat, x.lon));
}

function displayWeather(weather) {
    $('#map-container').parent().removeClass('col-md-12').addClass('col-md-6');
    $('#weather-container').html(renderWeather(weather)).show();
    console.log(weather);
}