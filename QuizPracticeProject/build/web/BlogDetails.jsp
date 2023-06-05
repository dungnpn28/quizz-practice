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
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

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

    <body>
        <div class="blog_list">

            <div class="col-md-7">
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
                    Category: <c:out value="${category}"/>
                <br>    
                    Author: <c:out value="${author}"/>
                </h2>
                <br>
                <h1>
                    <c:out value="${blog.title}"/>
                </h1>
                <br>
                <h3><p class="content">
                        <c:out value="${blog.content}"/>
                    </p></h3>
            </div>    
            <div class="search">
                <form action="searchpost">
                    <input
                        value="${key}"

                        type="search"
                        placeholder="Search by exam name"
                        aria-label="Search"
                        name="keyword"
                        />
                    <button class="btn" type="submit">
                        Search
                    </button>
                    <select>
                        <c:forEach items="${listCategory}" var="Blog_Category">
                            <option>${Blog_Category.getName()}</option>
                        </c:forEach>
                    </select>
                    <div class="thumbnail_container">
                        <c:forEach varStatus="loop" items="${listBlog}" var="Blog">
                            <c:if test="${loop.index < 2}">
                                <div class="tn1"> 
                                    ${Blog.getTitle()}
                                    <div class="video">
                                        <a href="blogDetail?id=${Blog.getId()}"><img src="${Blog.getThumbnail()}" width="100%" height="100%" alt="Ảnh"></a>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <div class="contact">
                            <h3>Static<br><span>contacts/links</span></h3>


                        </div>
                    </div>          

            </div>
        </div>
        <%@include file = "Login.jsp"%>  
    </body>
    <%@include file="components/Footer.jsp" %>
</html>

