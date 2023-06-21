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
        <%@include file="/components/CusHeader.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <link rel="stylesheet" href="css/Result.css">
        <div>
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
            <a href="simulationExam"> Simulation Exam </a>
            <a href="reviewquiz?examId=${examId}&attId=${attId}&page=1"> Review attempt </a> 
        </div>
        <%@include file="/components/Footer.jsp" %>
    </body>
</html>
