<%-- 
    Document   : Emailresetpassword
    Created on : May 20, 2023, 11:34:47 AM
    Author     : Dell
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

                <form action="resetpassword" method="post" onsubmit="return validateForm()">
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

        <script>
            function validatePassword() {
                var password = document.getElementById("password").value;
                var passwordError = document.getElementById("passwordError");

                if (password.length < 6) {
                    passwordError.textContent = "Password should be at least 6 characters long.";
                } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(password) && !/[A-Z]/.test(password)) {
                    passwordError.textContent = "Password should contain at least one special character or one uppercase letter.";
                } else {
                    passwordError.textContent = "";
                }

                enableOrDisableSubmitButton();
            }

            function validateRepassword() {
                var password = document.getElementById("password").value;
                var repassword = document.getElementById("repassword").value;
                var repasswordError = document.getElementById("repasswordError");

                if (repassword.length < 6) {
                    repasswordError.textContent = "Password should be at least 6 characters long.";
                } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(repassword) && !/[A-Z]/.test(repassword)) {
                    repasswordError.textContent = "Password should contain at least one special character or one uppercase letter.";
                } else if (password !== repassword) {
                    repasswordError.textContent = "Passwords do not match.";
                } else {
                    repasswordError.textContent = "";
                }

                enableOrDisableSubmitButton();
            }

            function enableOrDisableSubmitButton() {
                var passwordError = document.getElementById("passwordError").textContent;
                var repasswordError = document.getElementById("repasswordError").textContent;
                var submitButton = document.getElementById("submitButton");

                if (passwordError === "" && repasswordError === "") {
                    submitButton.disabled = false;
                } else {
                    submitButton.disabled = true;
                }
            }

            function validateForm() {
                var password = document.getElementById("password").value;
                var repassword = document.getElementById("repassword").value;
                var passwordError = document.getElementById("passwordError");
                var repasswordError = document.getElementById("repasswordError");

                if (password.length < 6) {
                    passwordError.textContent = "Password should be at least 6 characters long.";
                    return false;
                } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(password) && !/[A-Z]/.test(password)) {
                    passwordError.textContent = "Password should contain at least one special character or one uppercase letter.";
                    return false;
                } else {
                    passwordError.textContent = "";
                }

                if (repassword.length < 6) {
                    repasswordError.textContent = "Password should be at least 6 characters long.";
                    return false;
                } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(repassword) && !/[A-Z]/.test(repassword)) {
                    repasswordError.textContent = "Password should contain at least one special character or one uppercase letter.";
                    return false;
                } else if (password !== repassword) {
                    repasswordError.textContent = "Passwords do not match.";
                    return false;
                } else {
                    repasswordError.textContent = "";
                }

                return true;
            }
        </script>

    </body>
</html>
