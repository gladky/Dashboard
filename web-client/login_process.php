<!DOCTYPE html>
<?php 

$user = $_GET["user"];
$password = $_GET["password"];

// sprawdz uzytkownika
include("includes/connect-create-socket.php");
socket_write($socket, "loginUser=".$user.":".$password."\n", 256);
$result = socket_read($socket, 256, PHP_NORMAL_READ);

	//jesli zgadza sie zaloguj
		if(trim($result) == "OK"){

		$wygasniecie = time() + 120;
		$cookie_domain = "127.0.0.1";

		setcookie('dashboard_user', $user, $wygasniecie, "/Dashboard", $cookie_domain);

		header("Location: index.php");
		}
		else {
		header("Location: login.php?message=ERR");
		}

	//jesli nie zgadza sie powroc do strony logowania
?>

<html>
<head>

    <title>Dashboard login</title>
    <link class="include" rel="stylesheet" type="text/css" href="jquery.jqplot.min.css" />
  
    <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="../excanvas.js"></script><![endif]-->
    <script class="include" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<link href="common.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div class="main">
processing request
	
</div>

</body>


</html>
