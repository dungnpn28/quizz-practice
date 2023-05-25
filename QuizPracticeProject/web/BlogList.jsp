<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 8:19:09 AM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="blog_list">
            <div class="boxContainer col-md-7">
                <div class="box">
                    <div class="video">
                        <video></video>
                    </div>
                    <div class="content">
                        <h4>TITLE</h4>
                        <p>brief-info</p>
                    </div>
                </div>

                <div class="box">
                    <div class="video">
                        <video></video>
                    </div>
                    <div class="content">
                        <h4>TITLE</h4>
                        <p>brief-info</p>
                    </div>
                </div>

                <div class="box">
                    <div class="video">
                        <video></video>
                    </div>
                    <div class="content">
                        <h4>TITLE</h4>
                        <p>brief-info</p>
                    </div>
                </div>

                <div class="box">
                    <div class="video">
                        <video></video>
                    </div>
                    <div class="content">
                        <h4>TITLE</h4>
                        <p>brief-info</p>
                    </div>
                </div>
            </div>

            <div class="search">
                <form>
                    <input type="text" name="search" placeholder="search..." class="search_box">
                    <select>
                        <c:forEach items="${BlogCategory}" var="BlogCategory">
                            <option value="${BlogCategory.id}">${BlogCategory.getName()}</option>
                        </c:forEach>
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

        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
