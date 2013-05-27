<!DOCTYPE html>

<?php include("includes/session-handler.php");?>
<html>
<head>
   <title>Dashboard</title>
    <link class="include" rel="stylesheet" type="text/css" href="jquery.jqplot.min.css" />
    <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="../excanvas.js"></script><![endif]-->
    <script class="include" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<link href="common.css" rel="stylesheet" type="text/css" />
</head>
<body>
<?php
		include ("includes/connect-create-socket.php");
		
		socket_write($socket, "getUserInfo=".$user."\n", 256);
		$userInfo = socket_read($socket, 256, PHP_NORMAL_READ);
		$typesCount[0] = 0;
		$typesCount[1] = 0;
		$typesCount[2] = 0;
		$typesCount = explode(",", $userInfo);

		
?>


<div class="main">
<?php include("includes/horizontal-menu.php"); ?>
	<div class="index-section">
		<div class="goal-type-header">Index</div>
			<div class="index-element">
				<?php $name="gip"; $projectName="index";$width= 940; $height = 160; include("type-a1.php");?>
			</div>
	</div>
	<div class="a-goal-section">
		<div class="goal-type-header">A-type goals</div>
		
		<?php
			// getting info about a-type goals and generating appropriate html
			socket_write($socket, "getGoalTypeInfo=".$user."^a\n", 256);
			$projectNamesInfo = socket_read($socket, 256, PHP_NORMAL_READ);
			
			$projectNames = explode(",", $projectNamesInfo);
		
			for($i =0; $i<$typesCount[0]; $i++){
				echo '<div class="a-element">';
				$name = "chart-a" . $i;
				$projectName = trim($projectNames[$i]);
				
				$width= 470; $height = 180; 
				include("type-a1.php");
				echo '</div>';
			}
			
			if($typesCount[0] == 0){
				echo '<div class= "a-element">';
				echo '<img src="hoi.png"/>';
				echo '</div>';
			}
		?>
		
		
	</div>
	<div class="b-goal-section">
		<div class="goal-type-header">B-type gols</div>
		<?php
			// getting info about a-type goals and generating appropriate html
			socket_write($socket, "getGoalTypeInfo=".$user."^b\n", 256);
			$projectNamesInfo = socket_read($socket, 256, PHP_NORMAL_READ);
			
			$projectNames = explode(",", $projectNamesInfo);
		
			for($i =0; $i<$typesCount[1]; $i++){
				echo '<div class="b-element">';
				$name = "chart-b" . $i;
				$projectName = trim($projectNames[$i]);
				
				$width= 230; $height = 150; 
				include("type-a1.php");
				echo '</div>';
			}
			
			if($typesCount[1] == 0){
				echo '<div class= "b-element">';
				echo '<img src="hoi.png"/>';
				echo '</div>';
			}
		?>
	</div>	
	<div class="c-goal-section">
		<div class="goal-type-header">C-type gols</div>
		<?php
			// getting info about a-type goals and generating appropriate html
			socket_write($socket, "getGoalTypeInfo=".$user."^c\n", 256);
			$projectNamesInfo = socket_read($socket, 256, PHP_NORMAL_READ);
			
			$projectNames = explode(",", $projectNamesInfo);
		
		
			for($i =0; $i<$typesCount[2]; $i++){
				echo '<div class="c-element">';
				$name = "chart-c" . $i;
				$projectName = trim($projectNames[$i]);
				$width= 230; $height = 150; 
				include("type-a1.php");
				echo '</div>';
			}
			
			if($typesCount[2] == 0){
				echo '<div class= "c-element">';
				echo '<img src="hoi.png"/ height="100px">';
				echo '</div>';
			}
		?>
	</div>

</div>

<?php
	socket_shutdown($socket);
	socket_close($socket);
?>

<!-- Don't touch this! -->


    <script class="include" type="text/javascript" src="jquery.jqplot.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shCore.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shBrushJScript.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shBrushXml.min.js"></script>
<!-- End Don't touch this! -->

<!-- Additional plugins go here -->

    <!-- to render rotated axis ticks, include both the canvasText and canvasAxisTick renderers -->
    <script language="javascript" type="text/javascript" src="plugins/jqplot.canvasTextRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.dateAxisRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.cursor.min.js"></script>

<!-- End additional plugins -->

</body>



</html>
