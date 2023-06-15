<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 8:19:09 AM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.Blog" %>
<%@page import = "model.Blog_Category" %>
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
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <% } %>
        <div class="blog_list">
            <div class="boxContainer col-md-7">
                <c:forEach items="${listBlog}" var="Blog">
                    <div class="box">
                        <div class="video">
                            <a href="blogDetail?id=${Blog.getId()}"><img src="${Blog.getThumbnail()}" width="100%" height="100%" alt="Ảnh"></a>
                        </div>
                        <div class="content">
                            <h4>${Blog.getTitle()}</h4>
                            <p>${Blog.getContent()}</p>
                        </div>

                    </div>
                </c:forEach>
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
                </form>
            </div>
        </div>
        <%@include file = "Login.jsp"%>  
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
