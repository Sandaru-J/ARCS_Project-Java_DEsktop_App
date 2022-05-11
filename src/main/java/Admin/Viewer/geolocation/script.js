//Sandaru Jayathilka
//03/03/2022
//Api Testing
var map, infoWindow;

function createMap () {
  var options = {
    center: { lat: 43.654, lng: -79.383 },
    zoom: 7,
    draggable:true,
    zoomable:true,
    mapTypeId:google.maps.MapTypeId.HYBRID
  };

  map = new google.maps.Map(document.getElementById('map'), options);
  infoWindow = new google.maps.InfoWindow;

  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function (p) {
      var position = {
        lat: p.coords.latitude,
        lng: p.coords.longitude
      };
      console.log(position);
      infoWindow.setPosition(position);
      infoWindow.setContent('Journey 07');
      infoWindow.open(map);
      map.setCenter(position);
    }, function () {
      handleLocationError('Geolocation service failed', map.getCenter());
    });
  } else {
    handleLocationError('No geolocation available.', map.getCenter());
  }
}

function handleLocationError (content, position) {
  infoWindow.setPosition(position);
  infoWindow.setContent(content);
  infoWindow.open(map);
 }