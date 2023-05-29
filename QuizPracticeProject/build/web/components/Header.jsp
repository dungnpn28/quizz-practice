<%-- 
    Document   : Header
    Created on : May 22, 2023, 8:28:37 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Header.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/Login.css">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/Register.css">

        <title>JSP Page</title>
    </head>
    <link href="css/Home.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="header_content">
            <div class="header_logo">
                <a href="home"><img src="img\2.png"></a>
            </div>

            <div class="header_menu">

                <ul>                
                    <li><a href="BlogListController">Post</a></li>
                    <li><a href="">Subject</a></li>
                    <li><a href="#" id='popUpLink'>Login</a></li>
                    <li><a href="#" id="popUpLink2" data-toggle="modal">Register</a></li>
                </ul>
            </div>
        </div>
        <script>
            var closeBtn = document.querySelector('.close-popup');
            var popUpModal = document.getElementById('popUpModal');

            closeBtn.addEventListener('click', function () {
                popUpModal.style.display = 'none';
            });

        </script>
        <script>
            var closeBtn2 = document.querySelector('.close-popup2');
            var popUpModal2 = document.getElementById('popUpModal2');

            closeBtn2.addEventListener('click', function () {
                popUpModal2.style.display = 'none';
            });

        </script>
        <script src="js/PopUp.js" type="text/javascript"></script>
    </body>  
</html>
