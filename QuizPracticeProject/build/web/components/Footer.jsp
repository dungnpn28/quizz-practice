<%-- 
    Document   : Footer
    Created on : May 23, 2023, 11:09:54 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Footer.css" rel="stylesheet" type="text/css"/>

        <title>JSP Page</title>
    </head>

    <body>
        <footer class="text-black text-center text-lg-start" style="background-color: #ccc">
            <!-- Grid container -->
            <div class="container p-4">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                        <h5 class="text-uppercase">ABOUT US</h5>

                        <p>
                            Level up your knowledge with our Quiz Practice System! Test yourself, 
                            improve your skills, and enjoy a fun learning experience. Join us now and start quizzing!
                        </p>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <c:if test= "${sessionScope.user != null}">
                            <h5 class="text-uppercase">INFO</h5>

                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="" class="text-black">Subjects</a>
                                </li>
                                <li>
                                    <a href="BlogListController" class="text-black">Posts</a>
                                </li>
                                <li>
                                    <a href="practiceList" class="text-black">Practice Lists</a>
                                </li>
                            </c:if>   
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0" >
                        <h5 class="text-uppercase mb-0">CONTACT US</h5>

                        <ul class="list-unstyled" style="z-index: -1;">
                            <li>
                                <img src='img/gmail.png' style='width: 13px'>
                                : Quizzeroproject@gmail.com
                            </li>
                            <li>
                                <img src='img/user.png' style='width: 15px'>
                                Nhóm trưởng: Nguyễn Phạm Nam Dũng
                            </li>
                            <li>
                                <img src='img/telephone.png' style='width: 15px'>
                                09123456789
                            </li>

                        </ul>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2023 MADE BY TEAM 4:
                <a class="text-white" href="Home.jsp">Let's go beyond zero to become a hero</a>
            </div>
            <!-- Copyright -->
        </footer>
    </body>
</html>
