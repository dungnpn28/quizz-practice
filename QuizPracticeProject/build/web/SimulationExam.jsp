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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="css/SimulationExam.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/MyRegistration.css" type="text/css"/>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Simulation Exam</title>
    </head>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1 style="font-size:35px"> EXISTING EXAMS </h1>
                <div class="topnav">
                    <div class="left-container">
                        <div class="search-bar-container">
                            <form action="searchByExamName">
                                <input type="text" id="search-bar" placeholder="Search..." value="${key}" name="keyword">
                                <button id="search-icon">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                                    </svg>
                                </button>
                            </form>

                        </div>
                        <div class="filter-container">
                            <select name="category" id="filter1" onchange="applyFilters()">
                                <option value= "all" >All</option>
                                <c:forEach var="subjectList" items="${subjectList}">
                                    <option value="${subjectList.getId()}" ${subjectList.getId().toString() eq category ? "selected" : ""} >${subjectList.getName()}</option>
                                </c:forEach>
                            </select>

                            <a href="simulationExam" class="clear-filter" id="clear-filter" style="text-decoration: none">Clear</a>
                        </div>
                    </div>

                </div>
                <div class="header_fixed">
                    <table>
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> subject </th>
                                <th> simulation exam </th>
                                <th> Level </th>
                                <th> #question</th>
                                <th> duration </th>
                                <th> pass rate </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${examList}" var="Exam">
                                <tr>
                                    <td>${Exam.getId()}</td>
                                    <td>${Exam.getSubjectName()}</td>
                                    <td><a href="quizhandle?id=${Exam.getId()}" class="popUpDetailExam" data-exam-id="${Exam.getId()}">${Exam.getName()}</a></td>
                                    <td>${Exam.getLevel() }</td>
                                    <td>${Exam.getNumber_of_question()}</td>
                                    <td>${Exam.getDuration() }</td>
                                    <td>${Exam.getPass_rate() }</td>
                                </tr>
                            </c:forEach>
                        </tbody>


                    </table>
                    <ul class="pagination" style="display: flex; justify-content: center;">
                            <c:if test="${page > 1}">
                                <li><a href="simulationExam?page=${page-1}">Previous</a></li>
                                </c:if>
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                <li><a href="simulationExam?page=${i}">${i}</a></li>
                                </c:forEach>
                                <c:if test="${page < totalPage}">
                                <li><a href="simulationExam?page=${page+1}">Next</a></li>
                                </c:if>
                        </ul>


                </div>
                <a href="practiceList" class="btn btn-primary">Back to Practice list</a>

                <div id="popUpDetailModal" class="modal_popUp">
                    <div class="modal-content_popUp">
                        <button class="close-popupDetailExam">&times;Close</button>
                        <h2>Exam Detail</h2>
                        <p id="examIdText"></p>
                        <br/>
                        <a href="#" id="startExamButton">Quiz Handle</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br/>

    <script>
        var popUpDetailExams = document.getElementsByClassName("popUpDetailExam");
        for (var i = 0; i < popUpDetailExams.length; i++) {
            popUpDetailExams[i].addEventListener("click", function (event) {
                event.preventDefault();

                var examId = this.getAttribute("data-exam-id");

                var examIdText = document.getElementById("examIdText");
                examIdText.textContent = "Exam ID: " + examId;
                // Đặt examId vào URL của nút "Start Exam"
                var startExamButton = document.getElementById("startExamButton");
                startExamButton.href = "quizhandle?id=" + examId + "&page=1";

                // Hiển thị popup   
                var popUpDetailModal = document.getElementById("popUpDetailModal");
                popUpDetailModal.style.display = "block";
            });
        }
        var closePopupDetailExam = document.getElementsByClassName("close-popupDetailExam")[0];
        closePopupDetailExam.addEventListener("click", function () {
            var popUpDetailModal = document.getElementById("popUpDetailModal");
            popUpDetailModal.style.display = "none";
        });


    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>        
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%@include file="Login.jsp" %>
    <script src="js/navBar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
<%@include file="components/Footer.jsp" %>
<script src="js/PopUp.js" type="text/javascript"></script>
</html>
