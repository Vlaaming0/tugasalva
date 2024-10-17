<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php';

$id = $_GET['game_id'];
$sql = "SELECT * FROM games WHERE game_id=$id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    echo "<h1>".$row['title']."</h1>";
    echo "<p>".$row['deskripsi']."</p>";
    echo "<p>Release Date: ".$row['release_date']."</p>";
    echo "<p>Genre: ".$row['genre']."</p>";
} else {
    echo "Game tidak ditemukan!";
}
?>

<a href="daftargame.php">Kembali ke Daftar Game</a>
