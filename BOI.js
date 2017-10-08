/* Nodejs method to retrieve data from MySQL Workbench database */
 
var mysql = require('mysql');
var gyroWeek = {};
var emgWeek = {};
var gyroCsvWeek = {};
var emgCsvWeek = {};
var myoSize = 0;
 
/*
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database: "myo"
});
*/

// database connection details
$serverName = "myo-server.database.windows.net";
    $connectionOptions = array(
        "Database" => "myo",
        "Uid" => "ParkinBand",
        "PWD" => "SDPD*007"
    );

 

con.connect(function(err) {
  if (err) throw err;
  con.query("SELECT gyro FROM myo", function (err, result, fields) {
    if (err) throw err;
    gyroWeek = result;

  	});

	con.query("SELECT EMG FROM myo", function (err, result, fields) {
    if (err) throw err;
    emgWeek = result;
	
  	});

	con.query("SELECT GyroCSV FROM myo", function (err, result, fields) {
    if (err) throw err;
    gyroCsv = result;
	
  	});

	con.query("SELECT EMGCSV FROM myo", function (err, result, fields) {
    if (err) throw err;
    emgCsv = result;

  	});

	/* Gets number of columns */
	con.query("SHOW COLUMNS FROM myo", function (err, result, fields) {
    if (err) throw err;
    myoSize = result;

  	});




	// Determine whether a tremor is present & analyze if it is.
	function weekOne(var gyroWeek) {

		var tremor = false

		var i = 0
		var gSum = 0
		for (i < gyroWeek.length()) {
			gSum += gyroWeek[i]
		}

		var j = 0
		var eSum = 0
		for (i < emgWeek.length()) {
			eSum += emgWeek[i]
		}


		var gSum = gyroWeek/gyroWeek.length()
		var eSum = emgWeek/emgWeek.length()

		if (gyroAvg > 1.7 && emgAvg > 1.4) {
			tremor = true
		}


		// Only if the tremor threshold is met do we analyze the individual data (below)
		if (tremor) {

		var weekTemp = [6]
		var i = 0 
		var comparison = 0

		while (i < input.length()) {
			comparison = (((input[0] - input[i])/input[0]) * 100)
			weekTemp[i] = comparison
			i++
		}
		return weekOne;

		}
	}



	/*
	
	//given index x will return diff between it and the value at next index
	function diff(int x) {
		if (myo[x+1] != null) {
			return myo[x+1] - myo[x];
		}
	}

	function monthOne(var input) {
		var monthTemp
	}


	*/


	
});

