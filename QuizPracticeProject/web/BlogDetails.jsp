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
                        <h3 class="mb-3 mt-4">
                            Details
                        </h3>
                        <div class=" col-md-9">
                            <div class="row">
                                <div class="col-12">

                                    <p></p>
                                    <img src = "${blog.thumbnail}" alt="Can't display image" class="center" style="height:350px; width:750px">        
                                    <h2 class="left">
                                        Updated date: <c:choose>
                                            <c:when test="${blog.modified == null }">
                                                <c:out value="${blog.created}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${blog.modified}"/>
                                            </c:otherwise>
                                        </c:choose>
                                        Category: <c:out value="${category}"/>
                                        <br>    
                                        Author: <c:out value="${author}"/>
                                    </h2>
                                    <h3><p class="content" style="text-align: justify">
                                            <c:out value="${blog.content}"/>
                                        </p>
                                    </h3>
                                </div>
                            </div>
                        </div>

                    </div>
                    <%@include file = "Login.jsp"%> 

                </div>
            </div>
        </div>
        <script src="js/navBar.js"></script>

    </body>
    <%@include file="components/Footer.jsp" %>
</html>

