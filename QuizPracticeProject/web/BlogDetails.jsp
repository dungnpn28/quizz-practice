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
        <link rel="stylesheet" type="text/css" href="css/Blog.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <img src = "${blog.thumbnail}" alt="Can't display image" class="center">        
        <h2 class="left">
            Updated date: <c:out value="${blog.modified}"/>
            <br>
            Category: <c:out value="${blog.category}"/>
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
</body>
</html>
