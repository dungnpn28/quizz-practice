<%-- 
    Document   : login
    Created on : May 17, 2023, 4:41:07 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="login">
            <input type="text" name="account" placeholder="Enter email"><br>
            <input type="password" name="password" placeholder="Enter password"><br>
            <input type="submit" name="login" value="Login">
        </form>
    </body>
</html>
