<%-- 
    Document   : Result.jsp
    Created on : Jun 8, 2023, 1:24:59 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your score: ${examscore}</h1>
        <a href="simulationExam"> Simulation Exam </a>
        <a href="reviewquiz?examId=${examId}&attId=${attId}"> Review attempt </a>
    </body>
</html>
