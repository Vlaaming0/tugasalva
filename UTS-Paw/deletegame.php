<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php';

// Cek apakah ada ID game yang dikirim
if (isset($_GET['game_id'])) {
    $id = intval($_GET['game_id']); // Ambil game_id dari URL

    // Query untuk menghapus game berdasarkan ID
    $stmt = $conn->prepare("DELETE FROM games WHERE game_id = ?");
    $stmt->bind_param("i", $id);

    if ($stmt->execute()) {
        // Redirect ke halaman daftar game setelah berhasil dihapus
        header("Location: daftargame.php");
        exit();
    } else {
        // Tampilkan pesan kesalahan jika terjadi error
        echo "Error: " . $stmt->error;
    }
} else {
    echo "ID game tidak ditemukan.";
}
?>