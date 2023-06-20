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
        <link rel="stylesheet" href="css/Home.css" />

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
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
                        <div class=" col-md-9">
                            <div class="row">
                                <div class="col-12">
                                    <a href="BlogListController" class="mb-3 mt-4 custom-button">
                                        All Blog
                                    </a>

                                    <p></p>
                                    <c:if test="${not empty categoryName}">
                                        <h3>List Blog by category: ${categoryName}</h3>
                                    </c:if>
                                    <p></p>
                                    <c:if test="${not empty authorId}">
                                        <h3>List Blog by author: ${authorName}</h3>
                                    </c:if>
                                    <p></p>
                                    <div id="carouselExampleIndicators3" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-inner">
                                            <c:if test="${listBlog == null || listBlog.size() == 0}">
                                                Not found
                                            </c:if>
                                            <c:forEach items="${listBlog}" var="Blog" varStatus="status">
                                                <div class="row">
                                                    <div class="col-md-12 mb-3">
                                                        <div class="card" style="height:200px" onclick="window.location.href = 'blogDetail?id=${Blog.getId()}'">
                                                            <div class="row g-0">
                                                                <div class="col-md-4">

                                                                    <a href="blogDetail?id=${Blog.getId()}"><img src="uploads/${Blog.getThumbnail()}" width="100%" height="100%" alt="Ảnh"></a>

                                                                </div>
                                                                <div class="col-md-8">
                                                                    <div class="card-body">
                                                                        <h5 class="card-title">${Blog.getTitle()}</h5>
                                                                        <div class="card-date"> ${Blog.getBrief_info()}</div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <ul class="pagination" style="display: flex; justify-content: center;">
                                        <c:if test="${page > 1}">
                                            <li><a href="subjectListPublic?page=${page-1}">Previous</a></li>
                                            </c:if>
                                            <c:forEach begin="1" end="${totalPage}" var="i">
                                            <li><a href="subjectListPublic?page=${i}">${i}</a></li>
                                            </c:forEach>
                                            <c:if test="${page < totalPage}">
                                            <li><a href="subjectListPublic?page=${page+1}">Next</a></li>
                                            </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="sticky-table-container">
                                <div class="row d-flex justify-content-center">

                                    <div class="searchBox">
                                        <form action="searchpost">
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
                                            <h3 class="mb-3 mt-4">Search for "${key}"</h3>
                                        </c:if>
                                        <form action="BlogListController" method="get">
                                            <select name="selectedCategory">
                                                <option value="0">All</option>
                                                <c:forEach items="${listCategory}" var="category">
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                            <button type="submit">Confirm</button>
                                        </form>

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
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
