<%-- 
    Document   : PracticeDetails
    Created on : May 30, 2023, 9:11:19 PM
    Author     : dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/PracticeDetails.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizerro</title>
    </head>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="practiceDetailForm">
            <form action="practiceDetails" method="POST">
                <h2>PRACTICE DETAILS</h2>
                <br>
                <label class="" for="subject">Subject:</label>
                <br>
                <select name="subject" id="subject" class="btn btn-secondary">
                    <option value="0">All</option>
                    <c:forEach items="${subjectCategoryList}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                <br>
                <label for="questions">Number of practicing questions</label>
                <br>
                <input name="questions" id="questions" type="number">
                <br>
                <label for="topic">Questions are selected by topic(s) or a specific dimension?</label>
                <br>
                <select name="topic" id=topic" class="btn btn-secondary">
                    <option value="0">All</option>
                    <c:forEach items="${DimensionList}" var="dimension">
                        <option value="${dimension.id}">${dimension.name}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" value="Practice" class="btn btn-primary">
            </form>
        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
