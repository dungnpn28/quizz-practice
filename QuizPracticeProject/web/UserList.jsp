<%-- 
    Document   : UserList
    Created on : Jun 4, 2023, 1:29:21 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="model.UserProfile"%>
<%@page import="dal.UserDAO"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import = "java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/UserList.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">       
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <style>


        </style>
    </head>
    <body>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <%@include file="components/CusHeader.jsp"%>
                <h1 style="font-size:35px">USER LIST</h1>
                <div class="topnav">

                    <div class="search-container">
                        <form action="/action_page.php">
                            <input type="text" placeholder="Search.." name="search">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>

                    </div>
                    <div class="search-container">
                        <div class="a1">
                            <select name="cars" id="cars">
                                <option value="volvo">Volvo</option>
                                <option value="saab">Saab</option>
                                <option value="mercedes">Mercedes</option>
                                <option value="audi">Audi</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-container">
                        <div class="a1">
                            <select name="cars" id="cars">
                                <option value="volvo">Volvo</option>
                                <option value="saab">Saab</option>
                                <option value="mercedes">Mercedes</option>
                                <option value="audi">Audi</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-container">
                        <div class="a1">
                            <select name="cars" id="cars">
                                <option value="volvo">Volvo</option>
                                <option value="saab">Saab</option>
                                <option value="mercedes">Mercedes</option>
                                <option value="audi">Audi</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-container">

                        <button>Clear filter</button>

                    </div>
                    
                </div>




                <br>
                <div class="header_fixed">
                    <table>
                        <thead>
                            <tr>
                                <th>id</th>

                                <th>Username</th>
                                <th>Gender</th>
                                <th>Email</th>
                                <th>Role</th>

                                <th>Created</th>
                                <th>Status</th>
                                <th>Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${list_user_profile}" var="userprofile">

                                <tr>
                                    <td>${userprofile.getUser().getId()}</td>

                                    <td>${userprofile.getFull_name()}</td>
                                    <c:choose>
                                        <c:when test="${userprofile.getGender() == 0}">
                                            <td>Female</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Male</td>
                                        </c:otherwise>

                                    </c:choose>

                                    <td>${userprofile.getUser().getAccount()}</td>
                                    <c:choose>
                                        <c:when test="${userprofile.getUser().getRole_id() == 1}">
                                            <td>Customer</td>
                                        </c:when>
                                        <c:when test="${userprofile.getUser().getRole_id() == 2}">
                                            <td>Marketing</td>
                                        </c:when>
                                        <c:when test="${userprofile.getUser().getRole_id() == 3}">
                                            <td>Sale</td>
                                        </c:when>
                                        <c:when test="${userprofile.getUser().getRole_id() == 4}">
                                            <td>Expert</td>
                                        </c:when>

                                        <c:otherwise>
                                            <td>Admin</td>
                                        </c:otherwise>

                                    </c:choose>

                                    <td>${userprofile.getCreated()}</td>
                                    <c:choose>
                                        <c:when test="${userprofile.getUser().getStatus() == 0}">
                                            <td><div class="activation1">Deactive</div></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><div  class="activation2">Active</div></td>
                                        </c:otherwise>
                                    </c:choose>



                                    <td><img src="img/search.jpg"></td>
                                </tr>

                            </c:forEach>



                        </tbody>
                    </table>
                </div>

            </div>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#sidebarCollapse').on('click', function () {
                        $('#sidebar').toggleClass('active');
                    });
                });
            </script>
    </body>


</html>
