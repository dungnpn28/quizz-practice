<%-- 
    Document   : SimulationExam
    Created on : May 22, 2023, 8:17:26 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.Exam" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulation Exam</title>
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    <link href="css/Home.css" rel="stylesheet" type="text/css"/>
    <link href="css/SimulationExam.css" rel="stylesheet" type="text/css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <%@include file="components/Header.jsp" %>
    <body>
        <h2> existing exams </h2>
        <div class="row">
            <div class="col-md-8">
                <table border="1">
                    <tr>
                        <td> ID </td>
                        <td> subject </td>
                        <td> simulation exam </td>
                        <td> level </td>
                        <td> #question </td>
                        <td> duration </td>
                        <td> pass rate </td>
                    </tr>
                    <c:forEach var="Exam" items="${examList}">
                        <tr>
                            <td>${Exam.getId()}</td>
                            <td>${Exam.getSubjectName()}</td>
                            <td>
                                <a href="#" id="popUpLink">${Exam.getName()}</a>
                            </td>
                            <td>${Exam.getLevel() }</td>
                            <td>${Exam.getNumber_of_question()}</td>
                            <td>${Exam.getDuration() }</td>
                            <td>${Exam.getPass_rate() }</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-4">

                <div class="rectangle-box">
                    <div>
                        <form action="searchBySubject" method="GET">
                            <label for="selectedSubject">Choose subject</label>
                            <select name="subjectId">
                                <option value="0">All</option>
                                <c:forEach items="${subjectList}" var="Subject">
                                    <option value="${Subject.id}">${Subject.name}</option>
                                </c:forEach>
                            </select>
                            <button type="submit">Choose</button>
                        </form>

                    </div>
                    <form action="searchByExamName">
                        <input
                            value="${key}"

                            type="search"
                            placeholder="Search by exam name"
                            aria-label="Search"
                            name="keyword"
                            />
                        <button class="btn" type="submit">
                            Search
                        </button>
                    </form>


                </div>
            </div>
        </div>
        <div id="popUpModal" class="modal_popUp">
            <div class="modal-content_popUp">
                <span class="close">&times;</span>
                <h2>Exam Detail</h2>
                <br/>
                <a href="QuizHandlePage.jsp">Quiz Handle</a>
            </div>
        </div>
    </body>
    <%@include file="components/Footer.jsp" %>
    <script src="js/PopUp.js" type="text/javascript"></script>

</html>
