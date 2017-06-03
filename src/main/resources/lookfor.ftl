<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Look for a nice place for a drink</title>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 50%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 50%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<h1>Looking for a nice place to have a beer!</h1>

<form action="/beer" method="get" enctype="multipart/form-data">
    <input type="hidden" id="lat" name="lat" value="" />
    <input type="hidden" id="long" name="long" value="" />
    <input type="submit" value="Find beer!">
</form>
<div id="map" hidden="true"></div>
<script>
    function initNav() {
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                document.getElementById('lat').value = position.coords.latitude;
                document.getElementById('long').value = position.coords.longitude;
            }, function() {});
        }
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=${mapsapikey?js_string}&callback=initNav">
</script>
</body>
</html>