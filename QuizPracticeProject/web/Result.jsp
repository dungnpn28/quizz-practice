<%-- 
    Document   : Result.jsp
    Created on : Jun 8, 2023, 1:24:59 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel="stylesheet" href="css/Result.css">

    </head>
    <body>
        <%@include file="components/CusHeader.jsp"%>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <div>
                    <h1>Exam Result Page</h1>
                    <table>
                        <tr>
                            <th>Exam Name</th>
                            <th>Attempt Number</th>
                            <th>Mark</th>
                            <th>State</th>
                        </tr>
                        <tr>
                            <td>${examname}</td>
                            <td>${attId}</td>
                            <td>${examscore}</td>
                            <td><span class="${examscore < 5 ? 'not-passed' : 'passed'}">${examscore < 5 ? 'Not Passed' : 'Passed'}</span></td>
                        </tr>
                    </table>
                    <table>
                        <thead>
                            <tr>
                                <th>Order</th>
                                <th>Question ID</th>
                                <th>Answer</th>
                                <th>State</th>
                                <th>Score</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="question" items="${allQuestionL}">
                                <tr>
                                    <td>${question.questionOrder}</td>
                                    <td>${question.id}</td>
                                    <td>${question.score == 1 ? 'Correct' : 'Incorrect'}</td>
                                    <td>${question.marked ? 'Marked' : 'Not Marked'}</td>
                                    <td>${question.score}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="button-div">
                        <a class="button" href="simulationExam">Simulation Exam </a>
                        <a class="button" href="reviewquiz?examId=${examId}&attId=${attId}&page=1"> Review attempt </a>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/navBar.js" type="text/javascript"></script>

    </body>
    <%@include file="/components/Footer.jsp" %>

</html>