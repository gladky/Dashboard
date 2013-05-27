<?php
$wygasniecie = time() - 120;
$cookie_domain = "127.0.0.1";

setcookie('dashboard_user', '', $wygasniecie, "/Dashboard", $cookie_domain);
header("Location: index.php");
?>