<%-- 
    Document   : AccessDenied
    Created on : May 21, 2023, 1:58:18 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Access Denied</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta charset="UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/AccessDenied.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <div class="container">
            <div class="photo">
                <img src="img/1.png" alt="quiz-logo">
            </div>
            <div class="message">
                <h1>403 Error - No Permission</h1>
                <p>Uh oh, you are not allowed to access this page<br/>Maybe you mistyped in the url? Here's a button to go back to Home Page!</p>
            </div>
            <div class="btt">
                <form action="userauthorization" method="post">
                    <input type="submit" class="button" value="Go back Home">
                </form>
            </div>
        </div>
    </body>
</html>
