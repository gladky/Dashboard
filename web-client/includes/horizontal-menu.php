<ul class="horizontal-menu">
	<li class="horizontal-menu"><span class="round-style"> <a href="index.php">Menu</a></span></li>
	<li class="horizontal-menu"> <span class="round-style"><a href="main.php">Projekty</a></span></li>
	<li class="horizontal-menu"> <span class="round-style"><a href="add.php">Dodaj wpis</a></span></li>
	<li class="horizontal-menu"> <span class="round-style"><a href="login.php">Moje konto</a></span></li>
	<li class="horizontal-menu"> <?php echo ((isset($_COOKIE['dashboard_user']) && !empty($_COOKIE['dashboard_user']))? "zalogowano jako: ". $_COOKIE['dashboard_user'] : "") ;?></li>
</ul>