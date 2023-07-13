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
        <title>Quizzero</title>
    </head>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <div class="practiceDetailForm">
                    <form action="reviewpracticeDetails" method="POST">
                        <h2>PRACTICE DETAILS</h2>
                        <br>
                        <label class="" for="subject">Subject:</label>
                        <br>
                        <select name="subject" id="subject" class="btn btn-secondary">
                            <c:forEach items="${subjectCategoryList}" var="category">
                                <option value="${category.id}" disabled>${category.name}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <label for="ques">Number of practicing questions</label>
                        <br>
                        <input name="questions" id="ques" type="number" disabled>
                        <br>
                        <input type="submit" value="Practice Review" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/navBar.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <%@include file="components/Footer.jsp" %>
</html>
