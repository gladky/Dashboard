<?php
$address = "localhost";  
		$port = "6789";   
		$socket = socket_create(AF_INET, SOCK_STREAM, getprotobyname('tcp'));
		socket_connect($socket, $address, $port);
		$greetings = socket_read($socket, 256, PHP_NORMAL_READ);
?>