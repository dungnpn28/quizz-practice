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
                            <img src="uploads/${subject.getIllustration()}" alt="img" class="img-fluid">
                        </div>
                        <h1>${subject.name}</h1>
                        <p> <strong>Price: ${subject.min_price} </strong></p>
                        <p>  <strong>Sale: ${subject.min_sale}</strong></p>
                        <p><strong> Detail: ${subject.description}</strong></p>
<!--                        <p><strong>Status:</strong> ${subject.status ? "Enrolled" : "Unenroll" }</p>-->
                        <c:if test="${subject.status}">
                            <div>
                            <form  method="POST" action="subjectDetails">
                                <input type="hidden" name="subjectId" value="${SubjectDetails.subjectId}">
                                <button class="btn btn-primary" type="submit" ${SubjectDetails.status ? "disabled" : ""} onclick="return confirm('Are you sure you want to enroll?')">Enroll</button>
                            </form>     
                        </div>
                        </c:if> 
                        
                    </div>
                    <div class="col-md-6 sidebar">
                        <div class="searchBox">
                                        <form action="subjectListPublic" method="get">
                                            <div class="input-group">
                                                <input
                                                    class="form-control"
                                                    value="${key}"
                                                    type="search"
                                                    placeholder="Search by exam name"
                                                    aria-label="Search"
                                                    name="keyword"
                                                    />
                                                <button class="btn btn-primary" type="submit">
                                                    Search
                                                </button>
                                            </div>
                                        </form>
                                        <c:if test="${key!= mull}" >
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.checkFeatured}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from featured subject</h3>
                                                </c:when>
                                                <c:when test="${not empty sessionScope.checkRegisted}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from registed subject</h3>
                                                </c:when>
                                                <c:when test="${not empty sessionScope.checkNotRegisted}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from not registed subject</h3>
                                                </c:when>
                                                <c:otherwise>
                                                    <h3 class="mb-3 mt-4">Search "${key}" from all subject</h3>
                                                </c:otherwise>
                                            </c:choose>            
                                        </c:if>
                                    </div>
                        <div class="widget">
<!--                            <h2 class="widget-title">List</h2>
                            <form action="sort" method="POST">
                                <p>Sorting type:
                                <p>
                                    <input type="radio" name="sortType" value="ASC" checked="" /> Ascendingly
                                <p>
                                    <input type="radio" name="sortType" value="DESC" /> Descendingly
                                <p>
                                    <input type="submit" class="btn btn-success" value="Sort">
                            </form>-->
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
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Featured Subject</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        top 3 most recent featured subject
                                    </td>
                                </tr>
                                <c:forEach var="item" items="${featuredSubjectList}" begin="0" end="2">

                                    <tr onclick="window.location.href = 'subjectDetailS?id=${item.getId()}'">
                                        <td>
                                            <div class="table-image">
                                                <img src="uploads/${item.getIllustration()}" alt="Image">
                                            </div>
                                        </td>
                                        <td class="card-title">${item.getName()}
                                            <br/>
                                            <div class="card-date">Updated date: ${item.getModified()}</div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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