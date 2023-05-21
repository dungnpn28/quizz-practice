<%-- 
    Document   : BlogDetails.jsp
    Created on : May 18, 2023, 2:41:36 PM
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
        <link rel="stylesheet" type="text/css" href="css/Blog.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>
            <c:out value="${blog.thumbnail}"/>
        </h1>
        
        <h2>
            <c:out value="${blog.created}"/>
        </h2>
        <p class="format_post">
            <h3>
            <c:out value="${blog.content}"/>
            </h3>
        </p>
    </body>
</html>
