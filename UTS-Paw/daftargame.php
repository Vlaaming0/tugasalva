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


// if (isset($_POST['delete'])) {
//     $delete_id = $_POST['game_id'];
//     $sql = "DELETE FROM games WHERE game_id=$delete_id";
//     if ($conn->query($sql) === TRUE) {
//         echo "Game berhasil dihapus!";
//     } else {
//         echo "Terjadi kesalahan: " . $conn->error;
//     }
// }

?>
<a href="tambahgame.php">Tambah game</a>
<br> <br>
<a href="home.php">Kembali ke Home</a>
