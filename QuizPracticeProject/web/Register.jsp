<%-- 
    Document   : Register
    Created on : May 22, 2023, 8:16:17 AM
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
        <link rel="stylesheet" type="text/css" href="css/Register.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <section class="h-100 gradient-form">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body mx-md-4">
                                        <a href="#" class="close">&times;</a>
                                        <div class="text-center">
                                            <img src="img/2.png"
                                                 style="width: 150px;" alt="logo">

                                        </div>

                                        <form action="register" method="post" >


                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="Name">Full name: </label>
                                                <input type="text" id="Name" class="form-control"
                                                       name="Name" value="" required = "required"
                                                       placeholder="Full name" />

                                            </div>

                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="Email">Email: </label>
                                                <input type="email" id="Email" class="form-control"
                                                       name="Email" value="" required = "required"
                                                       placeholder="Email address" />

                                            </div>

                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="Mobile">Mobile: </label>
                                                <input type="tel" id="Mobile" class="form-control"
                                                       name="Mobile" value="" required = "required"
                                                       pattern="0[0-9]{9}"
                                                       placeholder="Mobile number" />

                                            </div>

                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="Gender">Gender: </label>

                                                <input type="radio" name="Gender" id="Gender" 
                                                       value=1 required = "required"/>Male
                                                <input type="radio" name="Gender" id="Gender" 
                                                       value=0 required = "required"/>Female
                                            </div>

                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="dob">Date of birth: </label>
                                                <input type="date" id="dob" class="form-control"
                                                       name="dob" value="" required = "required"
                                                       placeholder="dob" />

                                            </div>
                                            
                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="Pass">Password: </label>
                                                <input type="password" id="Pass" class="form-control"
                                                       name="Pass" value="" required = "required"
                                                       placeholder="Password" />

                                            </div>

                                            <div class="form-outline mb-3">
                                                <label class="inputLabel" for="rePass">Retype Password: </label>
                                                <input type="password" id="rePass" class="form-control"
                                                       name="rePass" value="" required = "required"
                                                       placeholder="Retype Password" />

                                            </div>

                                            <div class="text-center pt-1 mb-3 pb-1">
                                                <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">
                                                Register</button>
                                            </div>


                                            <div class="d-flex align-items-center justify-content-center pb-4">
                                                <p class="mb-0 me-2">Already have an account?</p>
                                                <button type="button" class="btn btn-outline-danger">Login</button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                        <h4 class="mb-4">Let's go from zero to hero</h4>
                                        <p class="small mb-0">Level up your knowledge with our Quiz Practice System! Test yourself, 
                                            improve your skills, and enjoy a fun learning experience. Join us now and start quizzing!</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>


