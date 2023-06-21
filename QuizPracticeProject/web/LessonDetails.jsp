<%-- 
    Document   : LessonDetails
    Created on : Jun 15, 2023, 1:16:27 PM
    Author     : dai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import= "model.*"%>
<%@page import= "dal.*"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/LessonDetails.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="ckeditor/ckeditor.js"></script>
        <script src="ckfinder/ckfinder.js"></script>

        <title>Quizerro</title>
    </head>
    <%
        String str = "add";
        User u = (User) request.getSession().getAttribute("user");
        if(u.getRole_id() != 4 && u.getRole_id() != 5){
            response.sendRedirect("AccessDenied.jsp");
        }
    %>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h2>Lesson Details</h2>
                <div class="lesson-detail">
                    <form class="form-wrapper" id="addLesson" name="addLesson" action="addNewLessonDetails" method="post" onsubmit="return ValidateLessonDetail(<%=str%>)">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input name="name" type="text" class="form-control" id="name">
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="type" class="form-label">Type</label>
                            <select name="selectedType">
                                <c:forEach items="${lessonTypeList}" var="type">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="topic" class="form-label">Topic</label>
                            <select name="selectedTopic">
                                <c:forEach items="${lessonTopicList}" var="topic">
                                    <option value="${topic.id}">${topic.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="order" class="form-label">Order</label>
                            <input name="order" type="text" class="form-control" id="order" >
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="link" class="form-label">Link</label>
                            <input name="link" type="text" placeholder="Youtube link" class="form-control" id="link">
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="editor" class="form-label">HTML Content</label>
                            <textarea name="editor" id="editor" class="form-control" rows="10" cols="80"></textarea>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="status" class="form-label">Status</label>
                            <input type="radio" name="status" value="1" checked=""> Active
                            <input type="radio" name="status" value="0"> Deactive       
                        </div>
                        <input type="hidden" name="subjectId" value="${subjectId}">

                        <input type="submit" class="btn btn-primary" value="Submit" onclick ="return confirm('Are you sure you want to add new?')">
                        <a href="javascript:history.go(-1)" class="btn btn-danger">Back</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
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
    <script src="js/Validation.js"></script>
    <script src="js/CKeditor.js"></script>
</html>
