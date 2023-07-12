<%-- 
    Document   : StudyingLesson
    Created on : Jul 12, 2023, 6:14:17 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="components/CusHeader.jsp"%>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <a style="text-decoration: none;" href="lessondetail?id=${subjectId}"><<< Get back</a>
                <h1>${lesson.name}</h1>
                <div class="row justify-content-between">
                <iframe width="70%" height="500px" src="${lesson.video_link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen ></iframe>
                </div>
                <p  class="text-justify">${lesson.html_content}</p>
            </div>
        </div>
        <script src="js/navBar.js" type="text/javascript"></script>

    </body>
</html>
