<?php
// Pastikan user sudah login
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    include 'config.php';

    // Ambil data dari form
    $title = $_POST['title'];
    $deskripsi = $_POST['deskripsi'];
    $release_date = $_POST['release_date'];
    $genre = $_POST['genre'];

    // Upload gambar
    $target_dir = "uploads/";
    $target_file = $target_dir . basename($_FILES["image"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    // Validasi apakah file yang di-upload adalah gambar
    $check = getimagesize($_FILES["image"]["tmp_name"]);
    if($check !== false) {
        $uploadOk = 1;
    } else {
        echo "File bukan gambar.";
        $uploadOk = 0;
    }

    // Jika semua validasi lolos, upload gambar
    if ($uploadOk == 1) {
        if (move_uploaded_file($_FILES["image"]["tmp_name"], $target_file)) {
            // Insert game ke database
            $image_url = $target_file;
            $stmt = $conn->prepare("INSERT INTO games (title, deskripsi, release_date, genre, image_url) VALUES (?, ?, ?, ?, ?)");
            $stmt->bind_param("sssss", $title, $deskripsi, $release_date, $genre, $image_url);

            if ($stmt->execute()) {
                // Redirect ke halaman daftar game setelah berhasil
                header('Location: daftargame.php');
                exit;
            } else {
                echo "Error: " . $stmt->error;
            }
        } else {
            echo "Terjadi kesalahan saat mengupload gambar.";
        }
    }
}
?>

<!-- Form untuk menambah game -->
<form action="tambahgame.php" method="post" enctype="multipart/form-data">
    <label for="title">Title:</label>
    <input type="text" name="title" required><br><br>

    <label for="deskripsi">Deskripsi:</label>
    <textarea name="deskripsi" required></textarea><br><br>

    <label for="release_date">Release Date:</label>
    <input type="date" name="release_date" required><br><br>

    <label for="genre">Genre:</label>
    <input type="text" name="genre" required><br><br>

    <label for="image">Upload Gambar:</label>
    <input type="file" name="image" required><br><br>

    <input type="submit" value="Tambah Game">
</form>
