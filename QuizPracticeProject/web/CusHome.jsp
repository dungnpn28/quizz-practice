<%-- 
    Document   : Home.jsp
    Created on : May 22, 2023, 8:13:13 AM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Slider" %>
<%@page import = "model.Blog" %>
<%@page import = "java.util.*" %>
<%@page import= "model.UserProfile"%>
<%@page import= "dal.UserProfileDAO"%>
<%@page import= "model.User"%>

<!DOCTYPE html>
<html>
    <head>
    <div>
        <link rel="stylesheet" href="css/Home.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
    </div>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<body>
    <%
            User u = null;
            if(session.getAttribute("user") != null) {
                u = (User) session.getAttribute("user");
            }
            UserProfileDAO upd = new UserProfileDAO();
            UserProfile up = upd.getUserProfile(u.getId());
            session.setAttribute("up", up);
    %>
    <%@include file="components/CusHeader.jsp"%>

    <!-- SLIDER -->
    <div class="imageSlider">
        <button class="prevButton">Previous</button>
        <c:forEach items="${listSlider}" var="slider">
            <img src="${slider.getImage()}" alt="Image">
        </c:forEach>
        <button class="nextButton">Next</button>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/slider.js" type="text/javascript"></script>


    <h4> Featured subjects <a href="">View all subjects</a></h4>
    <div class="row">
        <div class="boxContainer col-md-7 mb-5">
            <c:forEach varStatus="loop" items="${listSubject}" var="listSubject">
                <c:if test="${loop.index < 9}">
                    <div class="box">
                        <div class="boxImage">
                            <img src="${listSubject.getIllustration()}" width="100px" height="125px" alt="Ảnh">
                        </div>
                        <div class="boxContent">
                            <h4>${listSubject.getName()}</h4>
                            <p></p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="thumbnail_container col-md-4">
            <c:forEach varStatus="loop" items="${listBlog}" var="Blog">
                <c:if test="${loop.index < 2}">
                    <div class="tn">
                        ${Blog.getTitle()}
                        <div class="boxImage">
                            <img src="${Blog.getThumbnail()}" width="150px" height="125px" alt="Ảnh">
                            <br/>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
            <div class="contact">
                FACEBOOK: <a href="">Links</a><br>
                CONTACT: <a href="">Links</a>
            </div>   

        </div>
    </div>

    <h4>Hot posts <a href="">View all posts</a></h4>

    <div class="post_Container">
        <c:forEach varStatus="loop" items="${listBlog}" var="Blog">
            <c:if test="${loop.index < 2}">
                <div class="post_box ">
                    <div class="ti_da">
                        <h3>${Blog.getTitle()}</h3>
                        <h5>${Blog.getCreated()}</h5>
                    </div>

                    <div class="content">
                        <div class="th_cnt">
                            <a href="BlogDetails.jsp"><img src="${Blog.getThumbnail()}" width="200px" height="125px" alt="Ảnh"></a>
                            <p class="title">
                                ${Blog.getContent()}
                            </p>

                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <%@include file = "Login.jsp"%>  
</body>
<%@include file="components/Footer.jsp" %>
</html>
