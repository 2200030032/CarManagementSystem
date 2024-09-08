<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/style.css"> <!-- Your main CSS file -->
    <link href="https://fonts.googleapis.com/css2?family=Exo:wght@400;500;600&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon"> <!--favicon-->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet"/> <!-- Remix icon font -->
    <title>Welcome to RideMasters</title>
    <style>
       
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: #000;
            overflow: hidden;
        }

        .welcome-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        .welcome-text {
            font-size: 2.5rem;
            margin-bottom: 20px;
            color: #FEFEFE;
        }

        .btn-login {
            background-color: #00f7ff;
            color: #000;
            border: none;
            padding: 10px 20px;
            font-size: 1rem;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }

        .btn-login:hover {
            background-color: #00c4e5;
        }

      
        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.1);
            }
            100% {
                transform: scale(1);
            }
        }

        .logo {
            font-size: 3rem;
            color: #00f7ff;
            animation: pulse 2s infinite;
            margin-bottom: 20px;
        }

        /* Navbar styles */
        .navbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #191919;
            padding: 15px 0;
            z-index: 1000;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            color: #fff;
            margin-left: 20px;
        }

        .navbar .btn-login {
            margin-right: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="navbar-brand"><i class="ri-steering-line"></i>
            RideMasters</div>
        
        <a href="userlogin.jsf" class="btn-login">Login</a>
    </nav>

    <div class="welcome-container">
        <h1 class="logo"><i class="ri-car-line"></i></h1>
        <h2 class="welcome-text">Welcome to our Car Showroom</h2>
        <a href="userlogin.jsf" class="btn-login">Login</a>
    </div>

    

</body>
</html>
