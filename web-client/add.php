<!DOCTYPE html>

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
<div class="header">Dashboard</div>
<form name="input" action="add_entry.php" method="get">
Użytkownik: <input type="text" name="user">
Projekt: <input type="text" name="project">
Ilosc: <input type="text" name="amount">
<input type="submit" value="Submit">
</form>
	
</div>

</body>


</html>
