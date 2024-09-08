<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Showroom Management System</title>
    <link rel="stylesheet" href="resources/css/carhomestyle.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet"/>
    <style>
        .sidebar {
            position: fixed;
            top: 0;
            width: 260px;
            height: 100%;
            background: #424242;
            overflow-x: hidden;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            z-index: 2;
        }

        .sidebar ul {
            margin-top: 20px;
        }

        .sidebar ul li {
            width: 100%;
            list-style: none;
        }

        .sidebar ul li:hover {
            background: #616161;
        }

        .sidebar ul li:hover a {
            color: #2a9df4; /* Adjusted HSL value */
        }

        .sidebar ul li a {
            width: 100%;
            text-decoration: none;
            color: #e0e0e0;
            height: 60px;
            display: flex;
            align-items: center;
        }

        .sidebar ul li a i {
            min-width: 60px;
            font-size: 24px;
            text-align: center;
        }
    </style>
</head>
<body>
   <div class="sidebar">
        <ul>
            <li>
                <a href="adminhome.jsp">
                    <i class="fas fa-th-large"></i>
                    <div>Home</div>
                </a>
            </li>
            <li>
                <a href="empadd.jsf">
                    <i class="fas fas fa-user"></i>
                    <div>Add Seller</div>
                </a>
            </li>
            <li>
                <a href="viewallemps.jsf">
                    <i class="fas fas fa-user"></i>
                    <div>View All Seller</div>
                </a>
            </li>
            <li>
                <a href="updateemp.jsf">
                    <i class="fas fas fa-user"></i>
                    <div>Update Seller</div>
                </a>
            </li> 
        </ul>
    </div>
    <section id="home">
        <h1>Welcome to the Car Showroom Management System</h1>
        <p>Use the navigation bar to manage Sellers.</p>
        <img src="https://www.carpro.com/hs-fs/hubfs/image-5-1404x1112-1.jpg?width=2040&name=image-5-1404x1112-1.jpg" alt="Car Showroom" width="300px" height="200px" >
    </section>
    
</body>
</html>
