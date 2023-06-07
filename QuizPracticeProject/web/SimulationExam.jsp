<%-- 
    Document   : SimulationExam
    Created on : May 22, 2023, 8:17:26 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.Exam" %>
<%@page import = "dal.ExamQuestionDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="css/SimulationExam.css" rel="stylesheet" type="text/css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Simulation Exam</title>
    </head>

    <%@include file="components/CusHeader.jsp" %>
    <body>
        <h1> existing exams </h1>
        <div class="row">
            <div class="col-md-8">
                <table id="examTable" border="1">
                    <tr>
                        <td> ID </td>
                        <td> subject </td>
                        <td> simulation exam </td>
                        <td> Level </td>
                        <td> #question</td>
                        <td> duration </td>
                        <td> pass rate </td>
                    </tr>
                    <c:forEach var="Exam" items="${examList}">
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

                </table>
                <div id="popUpDetailModal" class="modal_popUp">
                    <div class="modal-content_popUp">
                        <button class="close-popupDetailExam">&times;Close</button>
                        <p id="examIdText"></p>
                        <br/>
                        <a href="#" id="startExamButton">Quiz Handle</a>
                    </div>
                </div>
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
            <div id="popUpDetailModal" class="modal_popUp">
                <div class="modal-content_popUp">
                    <button class="close-popupDetailExam">&times;Close</button>
                    <h2>Exam Detail</h2>
                    <p id="examIdText"></p>
                    <br/>
                    <a href="#" id="startExamButton">Quiz Handle</a>
                </div>
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
                    <button onclick="sortTable(3, true)">Sort by level</button>
                    <br/>
                    <button onclick="sortTable(6, false)">Sort by pass rate</button>
                    <br/>
                    <button onclick="sortTable(0, true)">Sort by id</button>

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

            function sortTable(columnIndex, isNumeric) {
                var table, rows, switching, i, x, y, shouldSwitch;
                table = document.getElementById("examTable");
                switching = true;
                while (switching) {
                    switching = false;
                    rows = table.rows;
                    for (i = 1; i < (rows.length - 1); i++) {
                        shouldSwitch = false;
                        x = rows[i].getElementsByTagName("TD")[columnIndex];
                        y = rows[i + 1].getElementsByTagName("TD")[columnIndex];
                        if (isNumeric) {
                            if (parseFloat(x.innerHTML) > parseFloat(y.innerHTML)) {
                                shouldSwitch = true;
                                break;
                            }
                        } else {
                            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }
                    if (shouldSwitch) {
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        switching = true;
                    }
                }
            }
        </script>
        <%@include file="Login.jsp" %>

    </body>
    <%@include file="components/Footer.jsp" %>
    <script src="js/PopUp.js" type="text/javascript"></script>

</html>
