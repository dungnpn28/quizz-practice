<%-- 
    Document   : LessonDetails
    Created on : Jun 15, 2023, 1:16:27 PM
    Author     : dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/LessonDetails.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="ckeditor/ckeditor.js"></script>

        <title>Quizerro</title>
    </head>
    <%
        String str = "";
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
                    <form class="form-wrapper">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input name="name" type="text" class="form-control" id="name">
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="type" class="form-label">Type</label>
                            <select class="form-control" id="type" name="type">
                                <option>Subject topic</option>
                                <option>Lesson</option>
                                <option>Quiz</option>
                            </select>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="topic" class="form-label">Topic</label>
                            <select class="form-control" id="topic" name="topic" >
                                <option>Subject topic</option>
                                <option>Lesson</option>
                                <option>Quiz</option>
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
                            <label for="content" class="form-label">HTML Content</label>                 
                            <br>
                            <textarea name="editor" rows="10" cols="50" style="overflow-y:scroll;" class="form-control" id="editor"></textarea>
                        </div>
                        <br>
                        <input type="submit" class="btn btn-primary" value="Submit">

                    </form>
                    <script>
                        ClassicEditor
                                .create(document.querySelector('#editor'))
                                .catch(error => {
                                    console.error(error);
                                });
                    </script>
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
                </div>
            </div>
        </div>
    </body>

</html>
