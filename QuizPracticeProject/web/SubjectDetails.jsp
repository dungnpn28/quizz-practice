<%@page import= "java.util.List" %>
<%@page import = "model.Subject" %>
<%@page import = "model.Price_Package" %>
<%@page import = "java.util.*" %>
<%@page import = "dal.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/SubjectDetails.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Details</title>
    </head>

    <body>
        <%
if (session.getAttribute("user") != null) {
// Nếu có user, bao gồm trang cusheader.jsp
        %>
        <%@ include file="components/CusHeader.jsp" %>
        <%
    } else {
        // Nếu không có user, bao gồm trang header.jsp
        %>
        <%@ include file="components/Header.jsp" %>
        <%
    }
        %>
        <h1>Subject Details</h1>
        <div class="wrapper">
            <%
            if (session.getAttribute("user") != null) {
            %>
            <%@include file="components/navbar.jsp" %>
            <%
            } 
            %>
            <div id="content">

                <div class="container row">

                    <div class="col-md-6 post">
                        <div class="post-image">
                            <img src="${subject.illustration}" alt="img" class="img-fluid">
                        </div>
                        <h1>${subject.name}</h1>
                        <p> <strong>Price:</strong></p>
                        <p>  <strong>Sale:</strong></p>
                        <p><strong> Detail: ${subject.description}</strong></p>
                        <p><strong>Status:</strong> ${subject.status ? "Enroll" : "Unenroll" }</p>

                        <div>
                            <form  method="POST" action="submit">
                                <input type="hidden" name="subjectId" value="${SubjectDetails.subjectId}">
                                <button class="btn btn-primary" type="submit" ${SubjectDetails.status ? "disabled" : ""} onclick="return confirm('Are you sure you want to enroll?')">Enroll</button>
                            </form>     
                        </div>
                    </div>
                    <div class="col-md-6 sidebar">
                        <div class="search-box">
                            <form action="SearchSubjectName" method="POST">
                                <input type="text" name="SubjectName" placeholder="Enter subject name">
                                <button type="submit" class="btn btn-secondary">Search</button>
                            </form>
                        </div>
                        <div class="widget">
                            <h2 class="widget-title">List</h2>
                            <form action="sort" method="POST">
                                <p>Sorting type:
                                <p>
                                    <input type="radio" name="sortType" value="ASC" checked="" /> Ascendingly
                                <p>
                                    <input type="radio" name="sortType" value="DESC" /> Descendingly
                                <p>
                                    <input type="submit" class="btn btn-success" value="Sort">
                            </form>
                            <form action="subjectListPublic" method="get">
                                <select name="selectedCategory">
                                    <option value="0">All</option>
                                    <c:forEach items="${subjectCategoryList}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                    </div>
                    <%@include file = "Login.jsp"%> 
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script>
                                    $(document).ready(function () {
                                        $('#carouselExampleIndicators2').carousel();
                                    });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>
        <!--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    <%@include file="components/Footer.jsp" %>

</html>