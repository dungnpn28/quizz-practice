<%-- 
    Document   : AddNewQuizDetails
    Created on : Jul 11, 2023, 10:19:32 AM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizzero</title>
    </head>
    <body>
        <%
           User u = null;
           if(session.getAttribute("user") != null) {
               u = (User) session.getAttribute("user");
           }
        %>

        <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1>QUIZ DETAILS</h1>
                <div class="quiz-detail">
                    <form class="form-wrapper" id="editQuiz" name="editQuiz" action="editNewQuizDetails" method="post"">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input name="name" type="text" class="form-control" id="name" value="${lExam.name}">
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <select name="selectedSubject" id="selectedSubject">
                                <c:forEach items="${lSubject}" var="subject">
                                    <option value="${subject.id}">${subject.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="level" class="form-label">Exam level</label>
                            
                                <select name="level" >
                                    <option>${lExam.level}</option>                                  
                                </select>
                            
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="duration" class="form-label">Duration(minutes)</label>
                            <input name="duration" type="text" class="form-control" id="duration" value="${lExam.duration}">
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="passrate" class="form-label">Pass Rate</label>
                            <input name="passrate" type="text" class="form-control" id="passrate" value="${lExam.pass_rate}">
                        </div>
                        <br>                
                        <div class="mb-3">
                            <label for="quizType" class="form-label">Quiz Type</label>
                            <input type="radio" name="quizType" value="1" />1
                            <input type="radio" name="quizType" value="0" />0
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea name="description" class="form-control" type="text" rows="10" cols="80" id="description" value="">${lExam.description}</textarea>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="questions" class="form-label">Number of questions</label>
                            <input name="questions" type="text" class="form-control" id="questions" value="${lExam.number_of_question}">      
                        </div>
                        <div class="mb-3">
                            <label for="questype" class="form-label">Question type</label>
                                <select name="questionType">
                                <c:forEach items="${lDimension}" var="type">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="button-group">
                            <input type="submit" class="btn btn-primary" value="Update" onclick ="return confirm('Are you sure you want to update?')">
                            <a href="javascript:history.go(-1)" class="btn btn-danger">Back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/navBar.js" type="text/javascript"></script>
</body>
</html>
