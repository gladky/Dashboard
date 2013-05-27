<!DOCTYPE html>

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
			<?php include("includes/horizontal-menu.php"); ?>
			<div class="header">Login</div>
			<?php
				if(isset($_COOKIE['dashboard_user']) && !empty($_COOKIE['dashboard_user'])) {
					//logged user
					echo '<div class="round-style">';
					echo "Jesteś zalogowany jako: " . $_COOKIE['dashboard_user'] ;
					echo '</br>';
					echo '<a href="logout.php">wyloguj</a>';
					echo '</div>';
				}
				else {
					// not logged user
					if(isset($_GET["message"])) echo '<span>Błędna nazwa użytkownika lub hasło</span>';
					include("includes/login-form.php");
				}
				?>

			
			
		</div>

	</body>


</html>
