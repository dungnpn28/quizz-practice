<%-- 
    Document   : practiceList
    Created on : May 16, 2023, 10:47:01 PM
    Author     : dai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.Exam" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/PracticeList.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizerro</title>
    </head>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1>Practice List</h1>
                <div class="button">
                    <div class="left-button">
                        <select name="subject" id="subject" class="btn btn-secondary">
                            <option value="" disabled selected hidden>All subjects</option>
                            <c:forEach items="${mr}" var="mr">
                                <option value="${mr.subjectId}">${mr.subject_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="right-buttons">
                        <a href="practiceDetails" class="btn btn-outline-primary">New Practice</a>
                        <a href="simulationExam" class="btn btn-outline-primary">Simulation Exam</a>
                    </div>
                </div>
                <div class="table" >
                    <table border="2">
                        <tbody>
                            <c:forEach var="a" items="${attemptlist}">
                                <tr>
                                    <td>Exam name: ${a.examName} </td>
                                    <td>xx Correct <br> ${a.numberOfQuestion} Questions</td>
                                    <td>50% <br> Correct</td>
                                    <td>
                                        <a href="reviewquiz?examId=${a.exam_id}&attId=${a.attemptId}&page=1">View Details</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="5">Duration: ${a.duration}</td>
                                </tr>
                            </c:forEach>        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/navBar.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <%@include file="components/Footer.jsp" %>
</html>
