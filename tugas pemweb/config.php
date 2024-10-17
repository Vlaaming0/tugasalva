<?php
$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'gamelist';

$conn = new mysqli($host, $user, $pass, $dbname, 3307);

if ($conn->connect_error) {
    die("Koneksi gagal: " . $conn->connect_error);
}
?>
