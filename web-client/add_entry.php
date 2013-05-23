<?php 
	$user = $_GET["user"];
	$amount = $_GET["amount"];
	$project = $_GET["project"]; 
	$data = $_GET["data"]; 
	
	$address = "localhost";  
	$port = "6789";   
	$socket = socket_create(AF_INET, SOCK_STREAM, getprotobyname('tcp'));
	socket_connect($socket, $address, $port);
	$greetings = socket_read($socket, 256, PHP_NORMAL_READ);

	
	$request = 	"addEntry=" . $user . "@" . $project . "$" . $amount . "^" . $data . "\n";
	
	socket_write($socket, $request, 256);
	//socket_write($socket, "dupa", 256);
	$report = socket_read($socket, 256, PHP_NORMAL_READ);
	
	socket_shutdown($socket);
	socket_close($socket);
	
	
?> 
<html>
<head>

    <title>Dashboard</title>
    <link class="include" rel="stylesheet" type="text/css" href="jquery.jqplot.min.css" />
  
    <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="../excanvas.js"></script><![endif]-->
    <script class="include" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<link href="common.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div class="main">

<?php include("includes/horizontal-menu.php"); ?>
<div class="header">Dashboard</div>

<div class="round-style">
<h3>Podsumowanie</h3>
You (<?php echo $user;?>) have entered <?php echo $amount;?> of work to project <?php echo $project;?></br>
</div>
<div class="round-style">
<h3>Odpowiedź serwera</h3>
<?php echo $report;?></br>
</div>

</div>

</body>


</html>