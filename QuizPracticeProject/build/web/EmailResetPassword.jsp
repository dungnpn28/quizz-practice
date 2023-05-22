<%-- 
    Document   : EmailResetPassword
    Created on : May 22, 2023, 8:16:56 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
<<<<<<< HEAD
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
=======
=======
>>>>>>> 9691002def4d42048332bfc6f1ea1d14769bdd80
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/Emailresetpassword.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function handleInput() {
                var inputValue = document.getElementById("typeEmail").value;
                var submitButton = document.getElementById("submitButton");
                if (inputValue.trim() === "") {
                    submitButton.disabled = true;
                } else {
                    submitButton.disabled = false;
                }
            }
            function goBack() {
                window.history.go(-1);
            }

        </script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light bg-white d-flex align-items-center justify-content-center" style=" box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);height: 100px;">
            <a class="navbar-brand" href="#">
                <img src="img/2.png" width="90" height="90" class="d-inline-block align-top mb-8" alt="">

            </a>
        </nav>
        <div class="card text-center" style="width: 400px">
            <div class="card-header h5 text-white">Password Reset</div>
            <div class="card-body px-5">
                <p class="card-text py-2">
                    Enter your email address and we'll send you an email with instructions to reset your password.
                </p>
                <form  action="emailresetpassword" method="post">
                    <div class="form-outline">
                        <input type="email" id="typeEmail" class="form-control my-3" name="email" oninput="handleInput()"  placeholder="Input your email"/>
                    </div>
                    <button onclick="noti()" type="submit" id="submitButton" class="btn btn-primary w-100">   Send reset link</button>
                </form>
                <div class="d-flex justify-content-between mt-4">
                    <a class="" onclick="goBack()">Back to log in</a>

                </div>
            </div>
        </div>
        <script>
            document.getElementById("submitButton").disabled = true;
        </script>
<<<<<<< HEAD
>>>>>>> parent of ab65327 (del)
=======
>>>>>>> 9691002def4d42048332bfc6f1ea1d14769bdd80
    </body>
</html>
