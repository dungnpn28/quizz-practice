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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </div>
</head>



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
    <!--    SIDEBAR-->
    <div class="wrapper">
        <%@include file="components/navbar.jsp" %>
        <div id="content">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">

                <div class="carousel-indicators">
                    <c:forEach var="image" items="${listSlider}" varStatus="status">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${status.index}" class="${status.first ? 'active' : ''}" aria-current="${status.first ? 'true' : 'false'}" aria-label="Slide ${status.index + 1}"></button>
                    </c:forEach>
                </div>
                <div class="carousel-inner">
                    <c:forEach items="${listSlider}" var="slider" varStatus="status">
                        <div class="carousel-item ${status.first ? 'active' : ''}">
                            <a href="${slider.getBacklink()}">
                                <img src="${slider.getImage()}" class="d-block w-100 carousel-image" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>${slider.getTitle()}</h5>
                                    <p>Some representative placeholder content for the first slide.</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>                  
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>



            <div class="container row d-flex">
                <div class="col-md-8">
                    <br>
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <div class="gif-and-heading d-flex">
                                    <img src="img/icons8-flame.gif" alt="Animated GIF">
                                    <h3 class="mb-3 mt-4">FEATURED SUBJECTS</h3>
                                </div>
                                <a href="subjectListPublic">VIEW ALL SUBJECTS</a>
                            </div>
                            <div class="col-6 text-right">
                                <a class="mb-3 me-1" href="#carouselExampleIndicators2" role="button" data-bs-slide="prev">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-left-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M10.205 12.456A.5.5 0 0 0 10.5 12V4a.5.5 0 0 0-.832-.374l-4.5 4a.5.5 0 0 0 0 .748l4.5 4a.5.5 0 0 0 .537.082z"/>
                                    </svg>
                                </a>
                                <a class="mb-3" href="#carouselExampleIndicators2" role="button" data-bs-slide="next">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M5.795 12.456A.5.5 0 0 1 5.5 12V4a.5.5 0 0 1 .832-.374l4.5 4a.5.5 0 0 1 0 .748l-4.5 4a.5.5 0 0 1-.537.082z"/>
                                    </svg>
                                </a>
                            </div>
                            <div class="col-12">
                                <div id="carouselExampleIndicators2" class="carousel slide" data-bs-ride="carousel">

                                    <div class="carousel-inner">
                                        <c:forEach items="${listSubject}" var="item" varStatus="status">
                                            <c:if test="${status.index % 3 == 0}">
                                                <div class="carousel-item${status.first ? ' active' : ''}">
                                                    <div class="row">
                                                    </c:if>
                                                    <div class="col-md-4">
                                                        <div class="card">
                                                            <img src="${item.getIllustration()}" class="card-img-top zoom-image" alt="...">
                                                            <div class="card-body">
                                                                <h5 class="card-title">${item.getName()}</h5>
                                                                <p class="card-text">${item.getDescription()}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <c:if test="${status.index % 3 == 2 || status.last}">
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="post_Container">

                        <div class="row">
                            <div class="col-6">
                                <div class="gif-and-heading d-flex">
                                    <img src="img/icons8-flame.gif" alt="Animated GIF">
                                    <h3 class="mb-3 mt-4">HOT POSTS</h3>
                                </div>

                                <a href="#">VIEW ALL POST</a>
                            </div>
                            <div class="col-6 text-right">
                                <a class="mb-3 me-1" href="#carouselExampleIndicators3" role="button" data-bs-slide="prev">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-left-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M10.205 12.456A.5.5 0 0 0 10.5 12V4a.5.5 0 0 0-.832-.374l-4.5 4a.5.5 0 0 0 0 .748l4.5 4a.5.5 0 0 0 .537.082z"/>
                                    </svg>
                                </a>
                                <a class="mb-3" href="#carouselExampleIndicators3" role="button" data-bs-slide="next">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M5.795 12.456A.5.5 0 0 1 5.5 12V4a.5.5 0 0 1 .832-.374l4.5 4a.5.5 0 0 1 0 .748l-4.5 4a.5.5 0 0 1-.537.082z"/>
                                    </svg>
                                </a>
                            </div>
                            <div class="col-12">
                                <div id="carouselExampleIndicators3" class="carousel slide" data-bs-ride="carousel">
                                    <div class="carousel-inner">
                                        <c:forEach items="${listBlog}" var="item" varStatus="status">
                                            <c:if test="${status.index % 3 == 0}">
                                                <div class="carousel-item${status.first ? ' active' : ''}">
                                                    <div class="row">
                                                    </c:if>
                                                    <div class="col-md-12 mb-3">
                                                        <div class="card" style="height:200px">
                                                            <div class="row g-0">
                                                                <div class="col-md-4">
                                                                    <img src="${item.getThumbnail()}" class="card-img-left zoom-image" style="height:250px; width:250px" alt="...">
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <div class="card-body">
                                                                        <h5 class="card-title">${item.getTitle()}</h5>
                                                                        <p class="card-text">${item.getContent()}</p>
                                                                        <div class="card-date">${item.getCreated()}</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <c:if test="${status.index % 3 == 2 || status.last}">
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>                        </div>

                    </div>
                </div>

                <div class="latest col-md-4">
                    <div class="sticky-table-container">
                        <div class="row justify-content-center">
                            <h5 style="font-size: 30px">LATEST POST</h5>
                            <div class="col-lg-10">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Image</th>
                                            <th scope="col">Content</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${listBlog}">
                                            <tr>
                                                <td>
                                                    <div class="table-image">
                                                        <img src="${item.getThumbnail()}" alt="Image">
                                                    </div>
                                                </td>
                                                <td>
                                                    <p style="font-weight: bold">${item.getTitle()}</p>
                                                    <a href="#"> Read more</a>
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
        </div>
    </div>




    <%@include file = "Login.jsp"%> 
</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $('#carouselExampleIndicators2').carousel();
    });
</script>
<!--<script>
    $(document).ready(function () {
        $('#carouselExampleIndicators2').carousel();
    });
</script>-->
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
