<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php'; 

if (isset($_GET['game_id'])) {
    $id = intval($_GET['game_id']);

    $stmt = $conn->prepare("SELECT * FROM games WHERE game_id = ?");
    $stmt->bind_param("i", $id);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc(); 
    } else {
        echo "Game tidak ditemukan.";
        exit;
    }
} else {
    echo "ID game tidak ditemukan.";
    exit;
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $title = $_POST['title'];
    $deskripsi = $_POST['deskripsi'];
    $release_date = $_POST['release_date'];
    $genre = $_POST['genre'];

    $stmt = $conn->prepare("UPDATE games SET title = ?, deskripsi = ?, release_date = ?, genre = ? WHERE game_id = ?");
    $stmt->bind_param("ssssi", $title, $deskripsi, $release_date, $genre, $id);

    if ($stmt->execute()) {
        header("Location: detailgame.php?game_id=$id");
        exit();
    } else {
        echo "Error: " . $stmt->error;
    }
}
?>

<form action="" method="post">
    <label for="title">Judul:</label>
    <input type="text" id="title" name="title" value="<?php echo $row['title']; ?>" required><br>

    <label for="deskripsi">Deskripsi:</label>
    <textarea id="deskripsi" name="deskripsi" required><?php echo $row['deskripsi']; ?></textarea><br>

    <label for="release_date">Tanggal Rilis:</label>
    <input type="date" id="release_date" name="release_date" value="<?php echo $row['release_date']; ?>" required><br>

    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre" value="<?php echo $row['genre']; ?>" required><br>

    <input type="submit" value="Update Game">
</form>

<a href="detailgame.php?game_id=<?php echo $id; ?>">Batal</a>
