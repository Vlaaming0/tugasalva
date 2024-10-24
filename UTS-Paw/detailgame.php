<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php';
?>

<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $target_dir = "uploads/"; // Folder tempat menyimpan gambar
    $target_file = $target_dir . basename($_FILES["image"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    // Check apakah file yang diupload benar-benar gambar
    $check = getimagesize($_FILES["image"]["tmp_name"]);
    if($check !== false) {
        $uploadOk = 1;
    } else {
        echo "File bukan gambar.";
        $uploadOk = 0;
    }

    // Check ukuran file
    if ($_FILES["image"]["size"] > 500000) {
        echo "Ukuran file terlalu besar.";
        $uploadOk = 0;
    }

    // Check tipe file (hanya JPG, PNG, GIF)
    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
    && $imageFileType != "gif" ) {
        echo "Hanya format JPG, JPEG, PNG, dan GIF yang diperbolehkan.";
        $uploadOk = 0;
    }

    // Jika semua pengecekan lolos, upload file
    if ($uploadOk == 1) {
        if (move_uploaded_file($_FILES["image"]["tmp_name"], $target_file)) {
            // Pastikan id sudah didefinisikan
            $id = $_GET['game_id']; // Sesuaikan dengan sumber ID
            
            // Simpan path gambar ke database
            $image_url = $target_file;
    
            // Gunakan prepared statement untuk keamanan dan validasi
            $stmt = $conn->prepare("UPDATE games SET image_url = ? WHERE game_id = ?");
            $stmt->bind_param("si", $image_url, $id);
    
            if ($stmt->execute()) {
                ;
            } else {
                echo "Error: " . $stmt->error;
            }
        } else {
            echo "Terjadi kesalahan saat mengupload gambar.";
        }
    }
    
    
}

$id = isset($_GET['game_id']) ? intval($_GET['game_id']) : 0;
$sql = "SELECT * FROM games WHERE game_id=$id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    echo "<h1>".$row['title']."</h1>";
    echo "<p>".$row['deskripsi']."</p>";
    echo "<p>Release Date: ".$row['release_date']."</p>";
    echo "<p>Genre: ".$row['genre']."</p>";

    // Tampilkan gambar jika ada
    if (!empty($row['image_url'])) {
        echo "<img src='".$row['image_url']."' alt='".$row['title']."' style='max-width: 300px;'>";
    } else {
        echo "<p>No image available for this game.</p>";
    }
} else {
    echo "Game tidak ditemukan!";
}
?>

<!-- Form untuk mengupload gambar -->
<form action="" method="post" enctype="multipart/form-data">
    Pilih gambar untuk diupload:
    <input type="file" name="image" id="image">
    <input type="submit" value="Upload Gambar" name="submit">
</form>

<!-- Tombol untuk mengupdate game -->
<form action="updategame.php" method="get">
    <input type="hidden" name="game_id" value="<?php echo $id; ?>"> <!-- Kirim ID game ke updategame.php -->
    <input type="submit" value="Update Game">
</form>


<!-- Form untuk menghapus game -->
<form action="deletegame.php" method="get">
    <input type="hidden" name="game_id" value="<?php echo $id; ?>"> <!-- Kirim ID game ke hapusgame.php -->
    <input type="submit" value="Hapus Game" onclick="return confirm('Apakah Anda yakin ingin menghapus game ini?');">
</form>

<br> <br>
<a href="daftargame.php">Kembali ke Daftar Game</a>
