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
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/BlogDetail.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <%@include file="components/Header.jsp"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <body>
        <img src = "${blog.thumbnail}" alt="Can't display image" class="center">        
        <h2 class="left">
            Updated date: <c:choose>
                <c:when test="${blog.modified == null }">
                    <c:out value="${blog.created}"/>
                </c:when>
                <c:otherwise>
                    <c:out value="${blog.modified}"/>
                </c:otherwise>
            </c:choose>
            <br>
            Category: <c:out value="${category}"/>
            <br>
            Author: <c:out value="${author}"/>
        </h2>
        <h1>
            <br>
            <c:out value="${blog.title}"/>
        </h1>
        <br>

        <h3><p class="content">
                <c:out value="${blog.content}"/>
            </p></h3>
        <div class="search">
            <form>
                <input type="text" name="search" placeholder="search..." class="search_box">
                <select>
                    <option>${Category}</option>
                </select>
            </form>
            <div class="thumbnail_container">
                <div class="tn1"> 
                    Title
                    <iframe width="150px" height="100px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>

                </div>

                <div class="tn2">
                    Title
                    <iframe width="150px" height="100px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>

                </div>
                <div class="contact">
                    <h3>Static<br><span>contacts/links</span>
                    </h3>

                </div>          
            </div>
        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>

