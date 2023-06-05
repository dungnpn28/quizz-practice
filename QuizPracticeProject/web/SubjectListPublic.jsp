<%-- 
    Document   : SubjectListPublic
    Created on : Jun 5, 2023, 7:20:56 AM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import= "model.User"%>
<%@page import= "model.UserProfile"%>
<%@page import= "model.Subject"%>
<%@page import= "dal.SubjectDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject List Public Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/SubjectListPublic.css" rel="stylesheet" type="text/css"/>


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
            <div class="container row d-flex">
                <div class="container row d-flex justify-content-between">
                    <div class=" col-md-8">
                        <div class="row">
                            <div class="col-6">
                                <div class="gif-and-heading d-flex">
                                    <h3 class="mb-3 mt-4">All Subject</h3>
                                </div>
                            </div>
                            <div class="col-12">
                                <div id="carouselExampleIndicators3" class="carousel slide" data-bs-ride="carousel">
                                    <div class="carousel-inner">
                                        <c:forEach items="${subjectList}" var="item" varStatus="status">
                                            <div class="row">
                                                <div class="col-md-12 mb-3">
                                                    <div class="card" style="height:200px">
                                                        <div class="row g-0">
                                                            <div class="col-md-4">
                                                                <img src="${item.getIllustration()}" class="card-img-left zoom-image" style="height:250px; width:250px" alt="...">
                                                            </div>
                                                            <div class="col-md-8">
                                                                <div class="card-body">
                                                                    <h5 class="card-title">${item.getName()}</h5>

                                                                    <div class="card-date">${item.getDescription()}</div>
                                                                </div>
                                                                <span class="multicolor-blink">
                                                                    <c:if test="${item.featured}">
                                                                        <img src="img/icons8-flame.gif" alt="Animated GIF">
                                                                        <p style="display: inline;">Featured subject</p>
                                                                    </c:if>
                                                                </span>
                                                                <c:choose>
                                                                    <c:when test="${empty sessionScope.user}">
                                                                        <%-- Nếu không có user trong session --%>
                                                                        <%-- Hiển thị nút Register --%>
                                                                        <span class="registerButton">
                                                                            <button href="">Register</button>
                                                                        </span>

                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <%-- Nếu có user trong session --%>
                                                                        <% User user = (User) session.getAttribute("user"); %>
                                                                        <% int userId = user.getId(); %>
                                                                        
                                                                        <%-- Kiểm tra xem người dùng đã tham gia subject nào hay chưa --%>
                                                                        
                                                                        <c:set var="subjectListByUserId" value="${requestScope.subjectListByUserId}" />
                                                                        <%-- Kiểm tra xem subject hiện tại có trong danh sách userSubjects hay không --%>
                                                                        <c:choose>
                                                                            <c:when test="${subjectListByUserId != null}">
                                                                                
                                                                                
                                                                                <c:set var="isRegistered" value="false" />
                                                                                <c:forEach var="subject" items="${subjectListByUserId}">
                                                                                    <c:if test="${subject.getId() == item.getId()}">
                                                                                        
                                                                                        <%-- Nếu người dùng đã tham gia môn học này --%>
                                                                                        <%-- Hiển thị nút không bấm được --%>
                                                                                        <span class="alreadyRegistedButton">
                                                                                            <button disabled>Already registed</button>
                                                                                        </span>
                                                                                        <%-- Gán giá trị true cho biến isRegistered và thoát khỏi vòng lặp --%>
                                                                                        <c:set var="isRegistered" value="true" />
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <%-- Kiểm tra biến isRegistered để hiển thị nút Register nếu không tìm thấy subject trùng khớp --%>
                                                                                <c:if test="${!isRegistered}">
                                                                                    
                                                                                    <span class="registerButton">
                                                                                        <button href="">Register</button>
                                                                                    </span>
                                                                                </c:if>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <%-- Nếu người dùng chưa tham gia môn học này --%>
                                                                                <%-- Hiển thị nút Register --%>
                                                                                <span class="registerButton">
                                                                                    <button href="">Register</button>
                                                                                </span>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <p>120412040124</p>
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
                                        <form action="subjectListPublic" method="GET" id="postForm">
                                            <input type="hidden" name="page" value="${page-1}">
                                            <a href="#" onclick="document.getElementById('postForm').submit(); return false;">Previous</a>
                                        </form>
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
                    <div class="col-md-4 ">
                        <div class="sticky-table-container">
                            <div class="row d-flex justify-content-center">
                                <table class="filterTable">
                                    <div class="searchBox">
                                        <form action="subjectListPublic" method="post">
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
                                        </form>
                                        <br/>
                                        <form action="subjectListPublic" method="get">
                                            <input type="hidden" name="checkAll" value="true">
                                            <button type="submit">All Subject</button>
                                        </form>
                                        <br/>
                                        <form action="subjectListPublic" method="get">
                                            <input type="hidden" name="checkFeatured" value="true">
                                            <button type="submit">Feature Subject</button>
                                        </form>
                                    </div>
                                </table>
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
