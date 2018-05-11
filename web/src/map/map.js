let map;
let currentMarker;

export const initMap = function() {
    var initialCenter = { lat: 60, lng: 30 };
    map = new google.maps.Map(document.getElementById('map-container'), {
        zoom: 3,
        center: initialCenter
    });
}

export const updateMap = function(latitude, longitude) {
    if (currentMarker) currentMarker.setMap(null);
    var newPosition = { lat: latitude, lng: longitude };
    var center = new google.maps.LatLng(latitude, longitude);
    map.panTo(center);
    map.setZoom(6);
    currentMarker = new google.maps.Marker({
        position: newPosition,
        map: map
    });
}

export default initMap;