<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}
?>

<h1>Selamat datang, <?php echo $_SESSION['username']; ?>!</h1>
<a href="daftargame.php">Lihat Daftar Game</a>
<a href="logout.php">Logout</a>
