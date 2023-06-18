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
        <title>Quizerro</title>
    </head>
    <body>
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
                    <textarea name="content" rows="10" cols="50" style="overflow-y:scroll;" class="form-control" id="content"></textarea>
                </div>
                <br>
                <input type="submit" class="btn btn-primary" value="Submit">

            </form>
        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
