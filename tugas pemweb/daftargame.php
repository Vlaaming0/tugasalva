<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php';

$sql = "SELECT * FROM games";
$result = $conn->query($sql);

echo "<h1>Daftar Game</h1>";
while ($row = $result->fetch_assoc()) {
    echo "<a href='detailgame.php?game_id=".$row['game_id']."'>".$row['title']."</a><br>";
}
?>

<a href="home.php">Kembali ke Home</a>
