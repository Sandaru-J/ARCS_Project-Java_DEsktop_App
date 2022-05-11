<?php
$serverName = "DESKTOP-7Q4KGEP"; //MMW SERVER
$connectionInfo = array("Database"=>"TAMDatabase", "UID"=>"Admin", "PWD"=>"Admin@12345");
$conn = sqlsrv_connect($serverName, $connectionInfo);
if($conn) {
echo "Connection established </br>";
$stmt = sqlsrv_prepare($conn, "SELECT * FROM AccidentTypes WHERE AccidentID = 1");
echo $stmt;
$row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC);
print_r($row);
}



?>
<!DOCTYPE html>
<html>
<head>
  <title>Track Driver</title>
  <meta name="viewport" content="initial-scale=1.0">
  <meta charset="utf-8">

  <!-- Stylesheets. -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="style.css">
</head>
<body>

  <div class="container-fluid">
    <div class="row">
      <div class="col">
        <h1 class="display-4">My Map</h1>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <div id="map"></div>
      </div>
    </div>
  </div>
 
  <!-- Bootstrap scripts. -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
  <!-- Google Maps scripts. -->
  <script src="script.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCgRon_soVUJpNUR6hnBJDOOdDKAlmMvg&callback=createMap" async defer></script>
</body>
</html>