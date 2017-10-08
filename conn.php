<?php

// Report simple running errors
error_reporting(E_ERROR | E_WARNING | E_PARSE);

// Reporting E_NOTICE can be good too (to report uninitialized
// variables or catch variable name misspellings ...)
error_reporting(E_ERROR | E_WARNING | E_PARSE | E_NOTICE);

// Report all errors except E_NOTICE
error_reporting(E_ALL & ~E_NOTICE);

// Report all PHP errors (see changelog)
error_reporting(E_ALL);

// Report all PHP errors
error_reporting(-1);

class conn {

  function conn(){
    $serverName = "myo-server.database.windows.net";
    $connectionOptions = array(
        "Database" => "myo",
        "Uid" => "ParkinBand",
        "PWD" => "SDPD*007"
    );
    //Establishes the connection
    $conn = sqlsrv_connect($serverName, $connectionOptions);

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    return $conn;
  }
  
   function checkAuth($request){
    $username = $request['username'];
    $pass = $request['pass'];

    $conn = $this->conn();
    
    $sql = "SELECT * FROM myo WHERE username='".$username."'";
    $result = mysqli_query($conn, $sql);
    
    $row = $result->fetch_assoc();

    $db_pass = $row['pass'];

    if($pass == $db_pass){
      $res = array(
        "success"=>true, 
        "verified"=> true, 
        "username"=> $row['username']
         );
         $conn->upload($request);
    }
    else
    {
      $res = array("success"=>false, "verified"=> false);
      $conn->close();
    }
  }

  function upload($request){
    $conn = $this->conn();
    $Gyro = $request['gyro'];
    $EMG = $request['emg'];

    

    $sql = "INSERT INTO myo SET Gyro='".$Gyro."', EMG='".$EMG."'";
    echo $Gyro;
    echo $EMG;
    if ($conn->query($sql) === TRUE) {
      echo "YEAH BOI";
  } else {
      echo "NOOO BOI: " . $conn->error;
  }
    $conn->close();
  }
  
 
  
}//end class

$conn = new conn; 

$fn = $_REQUEST['fn'];

if(isset($fn)){
  if($fn == 'upload'){
    $conn->checkAuth($_REQUEST);
  }
}



?>