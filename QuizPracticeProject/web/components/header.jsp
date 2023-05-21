<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Quizzero</title>
    </head>
    <body>
        <div class="header_content">
            <div class="header_logo">
                <a href="Home.jsp"><img src="img\2.png"></a>
            </div>

            <div class="header_menu">

                <ul>                
                    <li><a href="BlogList.jsp">Post</a></li>
                    <li><a href="">Subject</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                    <li><a href="">Register</a></li>
                </ul>
            </div>
        </div>
    </body>
    <style>
        .header_content{
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header_logo img {
            width: 20%;
        }
        .header_menu ul{
            display: flex;
        }
        .header_menu ul li{
            margin: 12px;
            list-style-type: none;
            display: flex;
        }
        .header_menu ul li a {
            font-size: 20px;
            text-decoration: none;
            color: rgb(52, 178, 201);
            font-weight: bold;
            padding: 10px;
        }
    </style>
</html>
