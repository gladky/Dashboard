<!DOCTYPE html>

<?php include("includes/session-handler.php");?>
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
<form name="input" action="add_entry.php" method="get" class="round-style">
<h3>Dodaj wpis</h3>
<!--użytkownik:</br>-->
<input type="text" name="user" value=<?php echo $user; ?> hidden >
projekt: </br>

	<?php
			include ("includes/connect-create-socket.php");
			socket_write($socket, "getGoalTypeInfo=".$user."^%\n", 256);
			$projectNamesInfo = socket_read($socket, 256, PHP_NORMAL_READ);
			
			$projectNames = explode(",", $projectNamesInfo);
			echo "<select name=\"project\" style=\"width: 150px\">";
			for($i =0; $i<count($projectNames); $i++){
			echo '<option value="' . $projectNames[$i] . '">' . $projectNames[$i]  . '</option>';
		}
	?>
</select>
</br>
ilosc: </br><input type="text" name="amount"></br>
korekcja daty: </br><input type="text" name="data"></br></br>
<input type="submit" value="Submit">
</form>
	
</div>

</body>


</html>
