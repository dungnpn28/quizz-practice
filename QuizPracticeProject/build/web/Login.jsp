<%-- 
    Document   : Register
    Created on : May 22, 2023, 8:16:17 AM
    Document   : Login
    Created on : May 22, 2023, 8:16:07 AM
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
        <div id="popUpModal" class="modal_popUp">
            <div class="modal-content_popUp " style='width: 1200px'>
                <div class="row g-0">
                    <div class="col-lg-6">
                        <div class="card-body p-md-5 mx-md-4 p-0 m-0 h-100">
                            <a href="home" class="close">&times;</a>
                            <div class="text-center">
                                <img src="img/2.png"
                                     style="width: 185px;" alt="logo">

                            </div>

                            <form action="login" method="post" id='loginform'>


                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form2Example11">Username</label>
                                    <input type="email" id="form2Example11" class="form-control" name="account"
                                           placeholder="Email address" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form2Example22">Password</label>
                                    <input type="password" id="form2Example22" class="form-control" name="password" placeholder="Password" />

                                </div>

                                <div class="text-center pt-1 mb-5 pb-1">
                                    <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Log
                                        in</button>
                                    <div id="errorMessage" class="error-message text-danger"></div>

                                    <a class="text-muted" href="emailresetpassword">Reset password?</a>
                                </div>

                                <div class="d-flex align-items-center justify-content-center pb-4">
                                    <p class="mb-0 me-2">Don't have an account?</p>
                                    <button type="button" class="btn btn-outline-danger"><a href="register">Create new</a></button>
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
        <!--        <section class="h-100 gradient-form">
                    <div class="container py-5 h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-xl-10">
                                <div class="card rounded-3 text-black">
                                    <div class="row g-0">
                                        <div class="col-lg-6">
                                            <div class="card-body p-md-5 mx-md-4">
                                                <a href="home" class="close">&times;</a>
                                                <div class="text-center">
                                                    <img src="img/2.png"
                                                         style="width: 185px;" alt="logo">
        
                                                </div>
        
                                                <form action="login" method="post">
        
        
                                                    <div class="form-outline mb-4">
                                                        <label class="form-label" for="form2Example11">Username</label>
                                                        <input type="email" id="form2Example11" class="form-control" name="account"
                                                               placeholder="Email address" />
        
                                                    </div>
        
                                                    <div class="form-outline mb-4">
                                                        <label class="form-label" for="form2Example22">Password</label>
                                                        <input type="password" id="form2Example22" class="form-control" name="password" placeholder="Password" />
        
                                                    </div>
        
                                                    <div class="text-center pt-1 mb-5 pb-1">
                                                        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Log
                                                            in</button>
                                                        <div class="text-danger">${mess}</div>
                                                        <a class="text-muted" href="emailresetpassword">Reset password?</a>
                                                    </div>
        
                                                    <div class="d-flex align-items-center justify-content-center pb-4">
                                                        <p class="mb-0 me-2">Don't have an account?</p>
                                                        <button type="button" class="btn btn-outline-danger"><a href="register">Create new</a></button>
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
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>-->
    </body>
</html>
