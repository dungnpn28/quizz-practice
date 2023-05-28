<%-- 
    Document   : ResetPassword
    Created on : May 22, 2023, 9:49:45 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/Emailresetpassword.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-white" style="box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);">
            <a class="navbar-brand" href="#">
                <img src="img/2.png" width="60" height="60" class="d-inline-block align-top" alt="">
            </a>
        </nav>
        <div class="card text-center" style="width: 300px">
            <div class="card-header h5 text-white">Reset your password</div>
            <div class="card-body px-5">

                <form action="resetpassword2" method="post" onsubmit="return validateForm()">
                    <div class="form-outline">
                        <input type="password" class="form-control my-3" id="password" name="password" placeholder="Input your new password" required oninput="validatePassword()" />
                        <div id="passwordError" class="text-danger"></div>
                    </div>
                    <div class="form-outline">
                        <input type="password" class="form-control my-3" id="repassword" name="repassword" placeholder="Re-enter your new password" required oninput="validateRepassword()" />
                        <div id="repasswordError" class="text-danger"></div>
                    </div>
                    <button type="submit" id="submitButton" class="btn btn-primary w-100" disabled>Reset password</button>
                </form>

            </div>
        </div>

        <script src="js/ValidatePassword.js" type="text/javascript"></script>

    </body>
</html>
