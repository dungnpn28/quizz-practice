<%-- 
    Document   : PracticeDetails
    Created on : May 30, 2023, 9:11:19 PM
    Author     : dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/PracticeDetails.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizerro</title>
        <script>
            window.onload = function () {
                // If the page is read-only, disable input fields
                if (document.getElementById("readOnly").value === "true") {
                    document.getElementById("subject").disabled = true;
                    document.getElementById("description").readOnly = true;
                    document.getElementById("practiceBtn").value = "Practice Review";
                }
            };
        </script>
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
                    <option value="math">Math</option>
                    <option value="english">English</option>
                    <option value="science">Science</option>
                </select>
                <br>
                <label for="questions">Number of practicing questions</label>
                <br>
                <input name="questions" id="questions" type="number">
                <br>
                <label for="topic">Questions are selected by topic(s) or a specific dimension?</label>
                <br>
                <select name="topic" id=topic" class="btn btn-secondary">
                    <option value="math">Math</option>
                    <option value="english">English</option>
                    <option value="science">Science</option>
                </select>
                <br>
                <input type="hidden" name="readOnly" id="readOnly" value="<%= request.getParameter("readOnly") %>">
                <br>
                <input type="submit" value="Practice" id="practiceBtn" class="btn btn-primary">
            </form>
        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
