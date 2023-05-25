<%-- 
    Document   : practiceList
    Created on : May 16, 2023, 10:47:01 PM
    Author     : dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizerro</title>
    </head>
    <body>
        <%@include file="components/CusHeader.jsp" %>
        <h1>Practice List</h1>
        <div class="button">
            <div class="left-button">
                <select name="subjects">
                    <option value="1">All subjects</option>
                </select>
            </div>
            <div class="right-buttons">
                <button type="button">
                    <a href="PracticeDetails.jsp">New Practice</a>
                </button>
                <button type="button" >
                    <a href="simulationExam">Simulation Exam</a>
                </button>
            </div>
        </div>
        <div class="table" >
            <table border="2">
                <tbody>
                    <tr>
                        <td>Subject name<br> Exam name  </td>
                        <td>10/09/2019<br> Date taken</td>
                        <td>xx Correct <br> yy Questions</td>
                        <td>50% <br> Correct</td>
                        <td>
                            <a href="PracticeDetails.jsp">View Details</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">Test type: Put the test name here</td>
                    </tr>
                    <tr>
                        <td>Subject name<br> Focused Test</td>
                        <td>10/09/2019<br> Date taken</td>
                        <td>xx Correct <br> yy Questions</td>
                        <td>50% <br> Correct</td>
                        <td>
                            <a href="PracticeDetails.jsp">View Details</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">Keyword/Lesson: Keyword/Lesson/Domain</td>
                    </tr>
                    <tr>
                        <td>Subject name<br> Focused Test</td>
                        <td>10/09/2019<br> Date taken</td>
                        <td>xx Correct <br> yy Questions</td>
                        <td>50% <br> Correct</td>
                        <td>
                            <a href="PracticeDetails.jsp">View Details</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">Keyword/Lesson: Keyword/Lesson/Domain</td>
                    </tr>
                    <tr>
                        <td>Subject name<br> Exam name  </td>
                        <td>10/09/2019<br> Date taken</td>
                        <td>xx Correct <br> yy Questions</td>
                        <td>50% <br> Correct</td>
                        <td>
                            <a href="PracticeDetails.jsp">View Details</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">Test type: Put the test name here</td>
                    </tr>
                    <tr>
                        <td>Subject name<br> Exam name  </td>
                        <td>10/09/2019<br> Date taken</td>
                        <td>xx Correct <br> yy Questions</td>
                        <td>50% <br> Correct</td>
                        <td>
                            <a href="PracticeDetails.jsp">View Details</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">Test type: Put the test name here</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <%@include file="components/Footer.jsp" %>
    </body>
</html>
