<%@page import="com.klef.ep.models.Employee"%>
<%@page import="com.klef.ep.models.Car"%>
<%@page import="com.klef.ep.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.klef.ep.service.EmployeeService"%>
<%@page import="com.klef.ep.service.CarService"%>
<%@page import="com.klef.ep.service.UserService"%>
<%@page import="javax.naming.InitialContext"%>
<%

// JSP with JPA Integration, you can do like in Servlet service() method as well

InitialContext contextemp = new InitialContext();
EmployeeService EmployeeService = (EmployeeService)contextemp.lookup("java:global/carmanagement/EmployeeServiceImpl!com.klef.ep.service.EmployeeService");

List<Employee> emplist = EmployeeService.viewallemps();

%>

<%

// JSP with JPA Integration, you can do like in Servlet service() method as well

InitialContext contextcar = new InitialContext();
CarService Car = (CarService)contextcar.lookup("java:global/carmanagement/CarServiceImpl!com.klef.ep.service.CarService");

List<Car> carlist = Car.viewallcars();

double sum=0;
for(int i=0;i<carlist.size();i++)
{
	sum=sum+carlist.get(0).getPrice();
}

%>

<%

// JSP with JPA Integration, you can do like in Servlet service() method as well

InitialContext contextuser = new InitialContext();
UserService user = (UserService)contextuser.lookup("java:global/carmanagement/UserServiceImpl!com.klef.ep.service.UserService");

List<User> userlist = user.viewallusers();

%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="resources/css/admincss.css">
    <title>Admin panel</title>
    
</head>

<body>
    <div class="container">
        <div class="topbar">
            <div class="logo">
                <div class="navbar-brand"><i class="ri-steering-line"></i>
            RideMasters</div>
            </div>
            <div class="search">
                <input type="text" name="search" placeholder="search here">
                <label for="search"><i class="fas fa-search"></i></label>
            </div>
            <i class="fas fa-bell"></i>
            <div class="user">
                <img src="resources/images/user.png" alt="">
            </div>
        </div>
        <div class="sidebar">
            <ul>
                <li>
                    <a href="adminhome.jsp">
                        <i class="fas fa-th-large"></i>
                        <div>Home</div>
                    </a>
                </li>
                <li>
                    <a href="carhome.jsp">
                        <i class="fas fas fa-car"></i>
                        <div>Cars</div>
                    </a>
                </li>
                <li>
                    <a href="sellerhome.jsp">
                        <i class="fas fa-user"></i>
                        <div>Sellers</div>
                    </a>
                </li>
                <li>
                    <a href="viewallusers.jsf">
                        <i class="fas fa-users"></i>
                        <div>Users</div>
                    </a>
                </li>
                
            </ul>
        </div>
        <div class="main">
            <div class="cards">
                <div class="card">
                    <div class="card-content">
                        <div class="number"><%=emplist.size()%></div>
                        <div class="card-name">Sellers</div>
                    </div>
                    <div class="icon-box">
                        <i class="fas fa-user"></i>
                    </div>
                </div>
                <div class="card">
                    <div class="card-content">
                        <div class="number"><%=carlist.size() %></div>
                        <div class="card-name">Cars</div>
                    </div>
                    <div class="icon-box">
                        <i class="fas fa-car"></i>
                    </div>
                </div>
                <div class="card">
                    <div class="card-content">
                        <div class="number"><%=userlist.size()%></div>
                        <div class="card-name">Users</div>
                    </div>
                    <div class="icon-box">
                        <i class="fas fa-users"></i>
                    </div>
                </div>
                <div class="card">
                    <div class="card-content">
                        <div class="number">$<%=sum %></div>
                        <div class="card-name">Value</div>
                    </div>
                    <div class="icon-box">
                        <i class="fas fa-dollar-sign"></i>
                    </div>
                </div>
            </div>
            <div class="charts">
                <div class="chart">
                    <h2>Earnings (past 12 months)</h2>
                    <div>
                        <canvas id="lineChart"></canvas>
                    </div>
                </div>
                <div class="chart doughnut-chart">
                    <h2>Members</h2>
                    <div>
                        <canvas id="doughnut"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    <script src="resources/js/chart1.js"></script>
    <script src="resources/js/chart2.js"></script> 
</body>

</html>
