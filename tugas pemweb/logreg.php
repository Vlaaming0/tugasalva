<?php
session_start();
include 'config.php';

$login_error = '';
$register_error = '';
$register_success = '';

if (isset($_POST['login'])) {
    $username = trim($_POST['username']); 
    $password = trim($_POST['password']);

    $sql = "SELECT * FROM users WHERE username='$username'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        if (password_verify($password, $row['password'])) {
            $_SESSION['username'] = $username;
            header('Location: home.php');
            exit;
        } else {
            $login_error = "Password salah!";
        }
    } else {
        $login_error = "Username tidak ditemukan!";
    }
}




if (isset($_POST['register'])) {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT);

    $check_sql = "SELECT * FROM users WHERE username='$username' OR email='$email'";
    $check_result = $conn->query($check_sql);

    if ($check_result->num_rows > 0) {
        $register_error = "Username atau email sudah terdaftar!";
    } else {
        $sql = "INSERT INTO users (username, email, password) VALUES ('$username', '$email', '$password')";

        if ($conn->query($sql) === TRUE) {
            header('Location: logreg.php?registered=success');
            exit;
        } else {
            $register_error = "Terjadi kesalahan: " . $conn->error;
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login & Register</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <?php if (isset($_GET['registered']) && $_GET['registered'] == 'success'): ?>
                <p class="success">Pendaftaran berhasil! Silakan login.</p>
            <?php endif; ?>

            <div id="login-form">
                <h2>Login</h2>
                <form method="post" action="">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <button type="submit" name="login">Login</button>
                    <?php if ($login_error != ''): ?>
                        <p class="error"><?php echo $login_error; ?></p>
                    <?php endif; ?>
                </form>

                <div class="toggle-register">
                    <p>Belum punya akun?</p>
                    <button onclick="showRegister()">Register</button>
                </div>
            </div>

            <div id="register-form">
                <h2>Register</h2>
                <form method="post" action="">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="email" name="email" placeholder="Email" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <button type="submit" name="register">Register</button>
                    <?php if ($register_error != ''): ?>
                        <p class="error"><?php echo $register_error; ?></p>
                    <?php endif; ?>
                </form>

                <div class="toggle-login">
                    <p>Sudah punya akun?</p>
                    <button onclick="showLogin()">Login</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        function showLogin() {
            document.getElementById('login-form').style.display = 'block';
            document.getElementById('register-form').style.display = 'none';
        }

        function showRegister() {
            document.getElementById('login-form').style.display = 'none';
            document.getElementById('register-form').style.display = 'block';
        }

        <?php if (isset($_GET['registered']) && $_GET['registered'] == 'success'): ?>
            showLogin();
        <?php else: ?>
            showLogin();
        <?php endif; ?>
    </script>
</body>
</html>
