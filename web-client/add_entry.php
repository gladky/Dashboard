<?php 
	$user = $_GET["user"];
	$amount = $_GET["amount"];
	$project = $_GET["project"]; 
	
	$address = "localhost";  
	$port = "6789";   
	$socket = socket_create(AF_INET, SOCK_STREAM, getprotobyname('tcp'));
	socket_connect($socket, $address, $port);
	$greetings = socket_read($socket, 256, PHP_NORMAL_READ);
	echo $greetings . "</br>";
	
	$request = 	"addEntry=" . $user . "@" . $project . "$" . $amount . "\n";
	
	socket_write($socket, $request, 256);
	//socket_write($socket, "dupa", 256);
	$report = socket_read($socket, 256, PHP_NORMAL_READ);
	
	socket_shutdown($socket);
	socket_close($socket);
	
	
?> 
You (<?php echo $user;?>) have entered <?php echo $amount;?> of work to project <?php echo $project;?></br>

<a href="index.php">Home</a></br>
<a href="add.php">Dodaj kolejne</a>