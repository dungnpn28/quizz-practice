<%-- 
    Document   : navbar
    Created on : May 31, 2023, 4:02:11 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/Home.css" type="text/css"/>
        <link rel="stylesheet" href="css/Style.css" type="text/css"/>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>MENU</h3>
            </div>

            <ul class="list-unstyled components">
                <c:choose>
                    <c:when test="${sessionScope.user.getRole_id() == 1}">
                        <li>
                            
                            <a href="cusHome">HOME</a>                  
                        </li>
                        <li>
                            
                            <a href="blogList">POST</a>
                        </li>
                        <li>
                            
                            <a href="practiceList">PRACTICE LIST</a>

                        </li>
                        <li>
                            
                            <a href="subjectListPublic">SUBJECT</a>
                        </li>

                    </c:when>
                    <c:when test="${sessionScope.user.getRole_id() == 2}">
                        <li>
                            
                            <a href="cusHome">HOME</a>                  
                        </li>
                        <li>
                            
                            <a href="blogList">POST LIST</a>
                        </li>
                        <li>
                            
                            <a href="sliderList">SLIDER LIST</a>

                        </li>                      

                    </c:when>
                    <c:when test="${sessionScope.user.getRole_id() == 3}">
                        <li>
                            
                            <a href="cusHome">HOME</a>                  
                        </li>
                       
                        <li>
                            
                            <a href="#">SALE LIST</a>

                        </li>
                        

                    </c:when>
                    <c:when test="${sessionScope.user.getRole_id() == 4}">
                        <li>
                            
                            <a href="cusHome">HOME</a>                  
                        </li>
                        <li>
                            
                            <a href="SubjectListAE.jsp">SUBJECT LIST</a>
                        </li>
                        <li>
                            
                            <a href="#">QUESTION LIST</a>

                        </li>     
                        <li>
                            
                            <a href="#">EXAM LIST</a>

                        </li>    

                    </c:when>
                    <c:otherwise>

                        <li>
                            
                            <a href="#">HOME</a>                  
                        </li>
                        <li>
                            
                            <a href="#">DASHBOARD</a>
                        </li>
                        <li>
                       
                            <a href="userlist">USER LIST</a>

                        </li>
                        <li>
                            
                            <a href="subjectlistae">SUBJECT LIST</a>
                        </li>
                        <li>
                            
                            <a href="#">POST LIST</a>
                        </li>
                        <li>
                            
                            <a href="#">SlIDER LIST</a>
                        </li>
                        <li>
                            
                            <a href="questionList">QUESTION BANKS</a>
                        </li>
                        <li>
                            
                            <a href="#">SETTING LIST</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>

            <!--            <ul class="list-unstyled CTAs">
                            <li>
                                <a href="#" class="download">Download source</a>
                            </li>
                            <li>
                                <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                            </li>
                        </ul>-->
        </nav>

    </body>
</html>
