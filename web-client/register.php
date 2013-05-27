<!DOCTYPE html>

<html>
	<head>
		<title>Dashboard register</title>
		<link class="include" rel="stylesheet" type="text/css" href="jquery.jqplot.min.css" />
	  
		<!--[if lt IE 9]><script language="javascript" type="text/javascript" src="../excanvas.js"></script><![endif]-->
		<script class="include" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<link href="common.css" rel="stylesheet" type="text/css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	
	<body>

		<div class="main">
			<?php include("includes/horizontal-menu.php"); ?>
			<div class="header">Register</div>
			<?php if(isset($_GET["message"]) && $_GET["message"] == "ERR") echo '<span>Istneje użytkonik o podanej nazwie</span>'; ?>
			<?php if(isset($_GET["message"]) && $_GET["message"] == "ERR2") echo '<span>Podane hasła się różnią</span>'; ?>
			<form name="input" action="register_process.php" method="get" class="round-style">
				<h3>Załóż konto</h3>
				nazwa użytkownika:</br> <input type="text" name="user"></br>
				hasło: </br><input type="password" name="password"></br>
				powtórz hasło: </br><input type="password" name="password2"></br></br>
				<input type="submit" value="Załóż konto"></br>
			</form>

			
			
		</div>

	</body>


</html>
