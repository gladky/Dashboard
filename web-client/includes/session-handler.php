<?php
if(isset($_COOKIE['dashboard_user']) && !empty($_COOKIE['dashboard_user'])) {
	//logged user
	$user = $_COOKIE['dashboard_user'];
}
else {
	// not logged user
	header("Location: login.php");
}
?>
