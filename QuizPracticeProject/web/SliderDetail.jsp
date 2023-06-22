<%-- 
    Document   : SliderDetail.jsp
    Created on : Jun 15, 2023, 1:30:06 PM
    Author     : LENOVO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Slider detail Page</title>
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
                        <div class="header-container">
                            <h1><a href="sliderList">Slider list </a></h1>  
                            <h1> / </h1>
                            <h1><a href="sliderDetail?sliderId=${sliderId}">Details </a></h1>
                        </div>
                        <c:if test="${not empty mess}">
                            <p id="notification"> ${mess}</p>
                        </c:if>
                        <div class="row">
                            <div class="col-12">
                                <c:if test="${not empty notificationMessage}">
                                    <div id="notification">${notificationMessage}</div>
                                </c:if>

                                <form action="sliderList" method="post">
                                    <button type="submit" name="btnEdit" class="btn btn-primary mb-3 mt-4 custom-button">EDIT</button>
                                    <input hidden name="sid" value="${sid}">
                                </form>
                                <p></p>


                                <div class ="header-container">
                                    <h3>Last updated date: </h3>

                                    <c:if test="${slider.modified != null}">
                                        <h3>${slider.modified}</h3>
                                    </c:if>

                                    <p> </p>
                                </div>
                                <div class ="header-container">
                                    <h3>Status: </h3>
                                    <h3>
                                        ${slider.status?"Active":"Inactive"}
                                    </h3>
                                    <p> </p>
                                </div>

                                <h1 style="font-weight: bold">${slider.title}</h1>


                                <img src = "uploads/${slider.image}" alt="Can't display image" class="center" style="height:350px; width:750px">        

                                <div class ="header-container">
                                    <h2></h2>
                                </div>
                                <div class ="header-container-right">
                                    <div class="author-value-container">
                                        <h2 class="author-value"> Updated date:
                                            <c:choose>
                                                <c:when test="${blog.modified == null }">
                                                    <c:out value="${slider.created}"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="${slider.modified}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </h2>
                                    </div>         
                                </div>
                                <div class ="header-container">
                                    <h2>Backlink: </h2>
                                    <h2><a href="${slider.backlink}">${slider.backlink}</a></h2>
                                    <p> </p>
                                </div>
                                <div class ="header-container">
                                    <h2>Notes:  </h2>
                                    <h2>${slider.note}</h2>
                                    <p> </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file = "Login.jsp"%> 
                </div>
            </div>
        </div>
        <script src="js/navBar.js"></script>
        <script>
            document.getElementById("notification").style.display = "block";

// Ẩn thông báo sau 5 giây
            setTimeout(function () {
                document.getElementById("notification").style.display = "none";
            }, 5000);

        </script>
    </body>
</html>
