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

echo "<h1>Opsi</h1>";
while ($row = $result->fetch_assoc()) {
    echo "<a href='detailgame.php?game_id=".$row['game_id']."'>".$row['title']."</a> ";
    echo "<form method='post' action='' style='display:inline;'>";
    echo "<input type='hidden' name='game_id' value='".$row['game_id']."'>";
    echo "<button type='submit' name='delete'>Hapus</button>";
    echo "</form><br>";
}
?>

<a href="tambahgame.php">Tambah game</a>
<br> <br>
<a href="index.php">Kembali ke Home</a>
