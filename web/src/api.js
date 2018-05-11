export const getLocation = function(address) {
    var req = $.getJSON('http://localhost:8080/geocode',
        {
            address: address
        });
    return req;
}

export const getWeather = function(latitude, longitude) {
    var req = $.getJSON('http://localhost:8080/weather',
        {
            lat: latitude,
            lon: longitude
        });
    return req;
}

export default getLocation;