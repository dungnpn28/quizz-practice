<%-- 
    Document   : demoPopUp
    Created on : May 17, 2023, 6:39:44 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <body>
        <style>
            form input {
                padding: 10px;
                margin:20px;
            }  
        </style>
        <a href="#" id="forgotPasswordLink">Thay đổi mật khẩu</a>

        <div id="forgotPasswordModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Change password</h2>

                <form id="forgotPasswordForm" method="post" action="changePassword">

                    Old password<input type="password" name="oldPass" placeholder="Old password" required><br/>
                    New password<input type="password" name="pass1" placeholder="new password" required><br/>
                    New password again<input type="password" name="pass2" placeholder="new password again" required>
                    <br/>
                    <button type="submit">Change</button>
                </form>
            </div>
        </div>
        <div id="popupMessage"></div>

    </body>
    <%@include file="components/footer.jsp" %>
    <script src="js/popUpjs.js" type="text/javascript"></script>
</html>
