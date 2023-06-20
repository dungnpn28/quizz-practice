<%-- 
    Document   : BlogDetails
    Created on : May 22, 2023, 8:19:23 AM
    Author     : Acer
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/BlogList.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/BlogDetail.css" rel="stylesheet" type="text/css"/>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>

    </head>



    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
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
        <div class="wrapper">
            <%
            if (session.getAttribute("user") != null) {
            %>
            <%@include file="components/navbar.jsp" %>
            <%
            } 
            %>
            <div id="content">
                <div class="container row d-flex">
                    <div class="container row d-flex justify-content-between">
                        <div class="header-container">
                            <h1><a href="BlogListController">Blog list </a></h1>  
                            <h1> / </h1>
                            <h1><a href="blogDetail?id=${id}">Details </a></h1>
                        </div>
                        <div class="row">
                            <div class="col-md-9">
                                <div class="col-12">
                                    <c:if test="${not empty notificationMessage}">
                                        <div id="notification">${notificationMessage}</div>
                                    </c:if>
                                    <c:if test="${sessionScope.user.getRole_id() == 2}">
                                        <a href="changeBlogDetail?id=${id}" class="btn btn-primary mb-3 mt-4 custom-button">
                                            Change detail
                                        </a>
                                    </c:if>
                                    <p></p>
                                    <c:if test="${blog.flag eq '1'}">
                                        <img src="img/icons8-flame.gif" alt="Animated GIF">
                                        <h3 style="display: inline;">Featured</h3>
                                    </c:if>
                                    <h1 style="font-weight: bold">${blog.title}</h1>
                                    <div class ="header-container">
                                        <h2>Category:</h2>
                                        <h2>
                                            <a class="blogAtribute" href="BlogListController?selectedCategory=${categoryId}">  <c:out value="${category}"/> </a>
                                        </h2>
                                        <p> </p>
                                    </div>
                                    <h3>
                                        <p class="content"> 
                                            <c:out value="${blog.brief_info}"/>
                                        </p>
                                    </h3>
                                    <img src = "uploads/${blog.thumbnail}" alt="Can't display image" class="center" style="height:19%; width:67%">        

                                    <div class ="header-container">
                                        <h2></h2>
                                    </div>
                                    <h3>
                                        <p class="content">
                                            <c:out value="${blog.content}"/>
                                        </p>
                                    </h3>
                                    <div class ="header-container-right">
                                        <div class="author-value-container">
                                            <h2 class="author-value">Author:
                                                <a class="blogAtribute" href="BlogListController?authorId=${authorId}">  <c:out value="${author}"/></a>
                                                </h2>
                                        </div>
                                    </div>
                                    <div class ="header-container-right">
                                        <div class="author-value-container">
                                            <h2 class="author-value"> Updated date:
                                                <c:choose>
                                                    <c:when test="${blog.modified == null }">
                                                        <c:out value="${blog.created}"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="${blog.modified}"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </h2>
                                        </div>         
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="sticky-table-container">
                                    <div class="row d-flex justify-content-center">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Updated blog</th>
                                                    
                                                </tr>

                                            </thead>
                                            <tbody>

                                                <c:forEach var="blog" items="${updatedBlogList}" begin="0" end="2">

                                                    <tr onclick="window.location.href = 'blogDetail?id=${blog.getId()}'">
                                                        <td>
                                                            <div class="table-image">
                                                                <img src="uploads/${blog.thumbnail}" alt="Image">
                                                            </div>
                                                        </td>
                                                        <td class="card-title" style="font-size: 10px; text-align: left">${blog.title}
                                                            <br/>
                                                            <div class="card-date" style="font-size: 10px; font-weight: normal">Updated date: ${blog.modified}</div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <%@include file = "Login.jsp"%> 

                </div>
            </div>
        </div>
        <script src="js/navBar.js"></script>
        <script>
                                                        // Hiển thị thông báo
                                                        document.getElementById("notification").style.display = "block";

                                                        // Ẩn thông báo sau 5 giây
                                                        setTimeout(function () {
                                                            document.getElementById("notification").style.display = "none";
                                                        }, 5000);
        </script>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>

