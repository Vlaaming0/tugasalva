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
    $target_dir = "uploads/"; 
    $target_file = $target_dir . basename($_FILES["image"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    $check = getimagesize($_FILES["image"]["tmp_name"]);
    if($check !== false) {
        $uploadOk = 1;
    } else {
        echo "File bukan gambar.";
        $uploadOk = 0;
    }

    if ($_FILES["image"]["size"] > 500000) {
        echo "Ukuran file terlalu besar.";
        $uploadOk = 0;
    }

    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
    && $imageFileType != "gif" ) {
        echo "Hanya format JPG, JPEG, PNG, dan GIF yang diperbolehkan.";
        $uploadOk = 0;
    }

    if ($uploadOk == 1) {
        if (move_uploaded_file($_FILES["image"]["tmp_name"], $target_file)) {
            $id = $_GET['game_id']; 
            
            $image_url = $target_file;
    
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

    if (!empty($row['image_url'])) {
        echo "<img src='".$row['image_url']."' alt='".$row['title']."' style='max-width: 300px;'>";
    } else {
        echo "<p>No image available for this game.</p>";
    }
} else {
    echo "Game tidak ditemukan!";
}
?>

<form action="" method="post" enctype="multipart/form-data">
    Pilih gambar untuk diupload:
    <input type="file" name="image" id="image">
    <input type="submit" value="Upload Gambar" name="submit">
</form>

<form action="updategame.php" method="get">
    <input type="hidden" name="game_id" value="<?php echo $id; ?>"> 
    <input type="submit" value="Update Game">
</form>


<form action="deletegame.php" method="get">
    <input type="hidden" name="game_id" value="<?php echo $id; ?>"> 
    <input type="submit" value="Hapus Game" onclick="return confirm('Apakah Anda yakin ingin menghapus game ini?');">
</form>

<br> <br>
<a href="daftargame.php">Kembali ke Daftar Game</a>
