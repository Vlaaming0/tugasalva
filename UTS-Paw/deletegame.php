<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: logreg.php');
    exit;
}

include 'config.php';

if (isset($_GET['game_id'])) {
    $id = intval($_GET['game_id']); 

    $stmt = $conn->prepare("DELETE FROM games WHERE game_id = ?");
    $stmt->bind_param("i", $id);

    if ($stmt->execute()) {
        header("Location: daftargame.php");
        exit();
    } else {
        echo "Error: " . $stmt->error;
    }
} else {
    echo "ID game tidak ditemukan.";
}
?>
