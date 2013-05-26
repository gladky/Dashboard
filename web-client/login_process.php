<!DOCTYPE html>
<?php 

$user = $_GET["user"];
$password = $_GET["password"];



$wygasniecie = time() + 120;
$cookie_domain = "127.0.0.1";

setcookie('dashboard_user', $user, $wygasniecie, "/Dashboard", $cookie_domain);

header("Location: index.php");
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
