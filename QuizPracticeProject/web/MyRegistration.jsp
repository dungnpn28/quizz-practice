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
<%@page import="dal.RoleDAO"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import = "java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="dal.LessonDAO"%>
<%@page import="model.Question"%>
<%@page import="model.Lesson"%>
<%@page import="model.Lesson_Topic"%>
<%@page import="model.Lesson_Type"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="css/MyRegistration.css" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <!--<link href="css/Style.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <% } %>
        <%@include file="components/CusHeader.jsp"%>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">               
                <h1 style="font-size:35px">My Registration</h1>
                <div class="topnav">
                    <div class="left-container">
                        <div class="search-bar-container">
                            <input type="text" id="search-bar" placeholder="Search..." value="${search}">
                            <button id="search-icon" onclick="applyFilters()">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                                </svg>
                            </button>
                        </div>
                        <div class="filter-container">
                            <select name="category" id="filter1" onchange="applyFilters()">
                                <option value= "all" >All</option>
                                <c:forEach var="categoryList" items="${categoryList}">
                                    <option value="${categoryList.getId()}" ${categoryList.getId().toString() eq category ? "selected" : ""} >${categoryList.getName()}</option>
                                </c:forEach>
                            </select>

                            <button class="clear-filter" id="clear-filter" onclick="clearFilters()">Clear</button>
                        </div>
                    </div>

                </div>

                <div class="header_fixed">
                    <table>
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Subject</th>
                                <th>Category</th>
                                <th>Registration time</th>
                                <th>Price</th>
                                <th>expiry</th>
                                <th>action</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${mrList == null || mrList.size()==0}">
                            <h3>Not found</h3>
                            </c:if>
                            <c:forEach items="${mrList}" var="mrList">

                                <tr>
                                    <c:forEach items="${subjectList}" var="subjectList">
                                        <c:if test="${mrList.subjectId == subjectList.id}">
                                            <td> <img src="uploads/${subjectList.illustration}" width="10%" height="10%" alt="Ảnh"></td>

                                        </c:if>
                                    </c:forEach>
                                    <c:forEach items="${subjectList}" var="subjectList">
                                        <c:if test="${subjectList.id == mrList.subjectId}">
                                            <td>${subjectList.name}</td>
                                            <c:forEach items="${categoryList}" var="categoryList">
                                                <c:if test="${subjectList.category_id == categoryList.id}">
                                                    <td>${categoryList.name}</td>

                                                </c:if>

                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                    <td>${mrList.created}</td>
<!--                                        <td>${mrList.pricePackageId}</td>-->
                                    <c:forEach items="${pL}" var="pL">
                                        <c:if test="${pL.id == mrList.pricePackageId}">
                                            <td>${pL.price}</td>
                                        </c:if>
                                    </c:forEach>
                                    <td>${questionList.getLevel()}</td>
                                    <td>
                                        <a class="dialog-btn" href="subjectDetails?id=${mrList.subjectId}">View detail</a>

                                    </td>
                                </tr>
                            <div class="dialog overlay" id="my-dialog2-${userprofile.getUser().getId()}">
                                <!--                            <a href="#" class="overlay-close"></a>-->
                                <div class="dialog-body">
                                    <a class="dialog-close-btn" href="">&times;</a>
                                    <div class="container">
                                        <br>
                                        <form action="addnew" method="post">
                                            <div class="add row">
                                                <label class="form-label">Email</label>


                                                <input type="text" value="${userprofile.getUser().getAccount()}" readonly>

                                                <label class="form-label">name</label>
                                                <input type="text" value="${userprofile.getFull_name()}"readonly>
                                                <div>
                                                    <label class="form-label">Gender</label> &nbsp&nbsp
                                                    <input type="radio" name="gender" value="0" ${userprofile.getGender() == 0 ? "checked":""} disabled>Female &nbsp;&nbsp;
                                                    <input type="radio" name="gender" value="1" ${userprofile.getGender() == 1 ? "checked":""} disabled >Male
                                                </div>
                                                <label class="form-label">Phone</label>
                                                <input type="text" value="${userprofile.phone_number()}" readonly>
                                                <label class="form-label">Role</label>
                                                <select class="select">                                               
                                                    <c:forEach var="list_role" items="${list_role}">
                                                        <option value="${list_role.getId()}" ${userprofile.getUser().getRole_id() == list_role.getId() ? "selected" : ""}>${list_role.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <br>
                                                <label class="form-label">Status</label>
                                                <select name="status" id="status">
                                                    <option value="0" ${userprofile.getUser().getStatus() == 0 ? "selected" : ""}>Deactive</option>
                                                    <option value="1" ${userprofile.getUser().getStatus() == 1 ? "selected" : ""}>Active</option>
                                                </select>

                                                <br><br><br>
                                                <button>Change update</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                        </tbody>
                    </table>
                    <div class="pagination">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <a class="${tag == i?"active":""}" href="myRegistration?index=${i}&category=${category}&search=${search}"">${i}</a>
                        </c:forEach>
                    </div>

                </div>

            </div>
            <%@include file = "Login.jsp"%>  

        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
                                function clearFilters() {
                                    var subjectId = '<%= session.getAttribute("subjectId") %>';
                                    window.location.href = "myRegistration";
                                }
                                function applyFilters() {
                                    var categorySelect = document.getElementById("filter1");
                                    var search_bar = document.getElementById("search-bar");
                                    var category = categorySelect.options[categorySelect.selectedIndex].value;
                                    var search = search_bar.value;

                                    // Build your base URL
                                    var baseUrl = "myRegistration?";

                                    if (category !== "all") {
                                        baseUrl += "category=" + category + "&";
                                    }
                                    if (search.trim() !== "") {
                                        baseUrl += "search=" + encodeURIComponent(search.trim()) + "&";
                                    }

                                    baseUrl = baseUrl.slice(0, -1);
                                    localStorage.setItem("category", category);
                                    localStorage.setItem("search", search);
                                    // Redirect to the filtered URL
                                    window.location.href = baseUrl;
                                }


    </script>
    <script src="js/PopUp.js"></script>
    <script src="js/navBar.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


</body>


</html>