<%-- 
    Document   : LessonDetail
    Created on : Jul 12, 2023, 12:16:34 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/LessonDetail.css" type="text/css"/>

    </head>
    <body>
        <%@include file="components/CusHeader.jsp"%>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <div class="subject-name">
                    <div class="font-only"><h1>${subject.name}</h1></div>
                    <p>${subject.description}</p>
                </div>
                <c:forEach var="list_lesson" items="${list_lesson}">
                    <c:if test="${list_lesson.type_id == 1}">
                        <div class="subject-topic font-only"><h2>${list_lesson.name}</h2></div>
                        <br>
                    </c:if>
                    <c:if test="${list_lesson.type_id == 2}">
                        <div class="lesson-detail row">

                            <div class="card col-md-12 p-3">
                                <div class="row ">
                                    <div class="col-md-4">
                                        <iframe width="100%" height="100%" src="${list_lesson.video_link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-block">
                                            <h6 class="card-title">${list_lesson.name}</h6>
                                            <div class="lesson-content-container">
                                                <p class="card-text text-justify lesson-content-class" id="lesson-content">${list_lesson.html_content}</p>
                                            </div>
                                            <a href="studylesson?lessonId=${list_lesson.id}&subjectId=${list_lesson.subject_id}" class="btn btn-primary">Study now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>                   
                        </div>
                    </c:if>
                    <c:if test="${list_lesson.type_id == 3}">
                        <div class="row">

                            <div class="lesson-detail card col-md-12 p-3">
                                <div class="row ">
                                    <div class="col-md-4">
                                        <img class="w-100" src="img/quiztime.jpg">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-block">
                                            <h6 class="card-title">${list_lesson.name}</h6>
                                            <!--                                            <p class="card-text text-justify" id="lesson-content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>-->
                                            <a href="https://www.google.com" class="btn btn-primary">Do quiz</a>
                                        </div>
                                    </div>
                                </div>
                            </div>                   
                        </div>     
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <script src="js/lessonDetail.js" type="text/javascript"></script>
        <script src="js/navBar.js" type="text/javascript"></script>

    </body>
</html>
