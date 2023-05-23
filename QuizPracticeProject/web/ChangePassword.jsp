<%-- 
    Document   : ChangePassword
    Created on : May 22, 2023, 8:15:43 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    <link href="css/Home.css" rel="stylesheet" type="text/css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <body>
        <%@include file="components/Header.jsp" %>
        <a href="#" id="popUpLink">Thay đổi mật khẩu</a>

        <div id="popUpModal" class="modal">
            <div class="modal-content">
                <span class="close">X</span>
                <h2>Change password</h2>

                <form id="changePasswordForm" method="POST" action="changePassword">
                    Old password<input type="password" name="oldPass" placeholder="Old password" required><br/>
                    New password<input type="password" name="pass1" placeholder="new password" required><br/>
                    New password again<input type="password" name="pass2" placeholder="new password again" required>
                    <br/>
                    <button type="submit">Change</button>
                </form>
                <div id="errorMessage" class="error-message"></div>
            </div>
        </div>
        <script src="js/PopUp.js" type="text/javascript"></script>

    </body>
    <%@include file="components/Footer.jsp" %>

</html>
