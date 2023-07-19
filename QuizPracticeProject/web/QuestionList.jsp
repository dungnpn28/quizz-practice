<%-- 
    Document   : UserList
    Created on : Jun 4, 2023, 1:29:21 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="model.UserProfile"%>
<%@page import="dal.UserDAO"%>
<%@page import="dal.RoleDAO"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import = "java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="dal.LessonDAO"%>
<%@page import="model.Question"%>
<%@page import="model.Lesson"%>
<%@page import="model.Lesson_Topic"%>
<%@page import="model.Lesson_Type"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="css/UserList.css" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="css/QuestionImport.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <% } %>
        <%@include file="components/CusHeader.jsp"%>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">               
                <h1 style="font-size:35px">QUESTION LIST</h1>
                <div class="topnav">
                    <form action="questionList" method="get">
                        <div class="search-container">
                            <input type="text" placeholder="Search by content" name="search" id="searchInput" value="${search}" style="margin-top: 14px">
                            <button type="submit" style="margin-top: 14px"><i class="fa fa-search"></i></button>
                        </div>
                        <div class="search-container">
                            <div class="a1">

                                <select name="subject" id="role" style="margin-right: 5px">
                                    <option value= "all" >All</option>
                                    <c:forEach items="${subjectList}" var="subjectList">
                                        <option value="${subjectList.id}" ${subjectList.id.toString() eq subject ? "selected" : ''}>${subjectList.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="search-container">
                            <div class="a1">

                                <select name="lesson" id="role" style="margin-right: 5px">
                                    <option value= "all" >All</option>
                                    <c:forEach items="${lessonList}" var="lessonList">
                                        <option value="${lessonList.id}" ${lessonList.id.toString() eq lesson ? "selected" : ''}>${lessonList.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="search-container">
                            <div class="a1">

                                <select name="level" id="status" style="margin-right: 5px">
                                    <option value="all" ${level eq "all" ? "selected" : ''}>All</option>
                                    <option value="easy" ${level eq "easy" ? "selected" : ''}>Easy</option>
                                    <option value="medium" ${level eq "medium" ? "selected" : ''}>Medium</option>
                                    <option value="hard" ${level eq "hard" ? "selected" : ''}>Hard</option>
                                </select>
                            </div>
                        </div>

                    </form>
                    <div class="search-container">
                        <button><a href="questionList" style="background-color: #4CAF50; padding: 7px 16px; text-decoration: none; color: #ffffff">Clear filter</a></button>
                    </div>
                    <div class="search-container">

                        <button onclick="openPopup();" style="background-color: #755bea; padding: 7px 16px; text-decoration: none; color: #ffffff">Question Import</button>

                        <div id="question-import" class="question-import-overlay">
                            <div class="question-import-content" >

                                <h1 style="font-weight: bold;" class="d-flex justify-content-center">Question Import</h1>
                                <div class="question-import-button">
                                    <form class="d-flex justify-content-between" action="questionimport" method="post" enctype='multipart/form-data'>
                                        <div class="question-import-left d-flex flex-column">                                       
                                            <h2>Upload Excel file</h2>
                                            <input name="xlsxfile" type="file" id="fileInput" onchange="handleFileSelect(event)" />
                                            <h3 style="color: red; font-weight: bold;" id="resultContainer"></h3>
                                        </div>
                                        <div class="question-import-right d-flex flex-column">
                                            <h2>Haven't got template?</h2>
                                            <button><a href="questionimport">Download Excel file</a></button>
                                        </div>
                                        <input style="display: none" id="submit" type="submit" name="submit" value="submit">
                                    </form>
                                    <div class="d-flex justify-content-center">
                                        <button onclick="closePopup();">Close</button>
                                    </div>

                                </div>

                            </div>
                            </form>
                        </div>
                    </div>

                    <div class="header_fixed">
                        <table>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Subject</th>
                                    <th>Lesson</th>
                                    <th>Content</th>
                                    <th>Level</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${questionList == null || questionList.size() == 0}"> 
                                <h3>Not found </h3>
                            </c:if>
                            <c:forEach items="${questionList}" var="questionList">

                                <tr>
                                    <td>${questionList.getId()}</td>
                                    <c:forEach items="${subjectList}" var="subjectList">
                                        <c:if test="${subjectList.id == questionList.subjectId}">
                                            <td>${subjectList.name}</td>
                                        </c:if>
                                    </c:forEach>
                                    <c:forEach items="${lessonList}" var="lessonList">
                                        <c:if test="${lessonList.id == questionList.lessonId}">
                                            <td>${lessonList.name}</td>
                                        </c:if>

                                    </c:forEach>

                                    <td>${questionList.getContent()}</td>

                                    <td>${questionList.getLevel()}</td>
                                    <td>
                                        <c:if test="${questionList.status == false}">
                                            <div style="font-weight: bold;color:red;">Deactive</div>
                                        </c:if>
                                        <c:if test="${questionList.status == true}">
                                            <div style="font-weight: bold;color:green;">Active</div>
                                        </c:if>
                                    </td>
                                    <td>
                                        <div class=' d-flex justify-content-center'>
                                        <a href="questiondetail?id=${questionList.id}"><img src="img/magnifying-glass.png" style="height:25px;width:25px;"></a> &nbsp;&nbsp;&nbsp;
                                        <a href="deletequestion?id=${questionList.id}"><img src="img/recycle-bin.png" style="height:25px;width:25px;"></a>
                                        </div>

                                    </td>



                                </tr>
                                <div class="dialog overlay" id="my-dialog2-${userprofile.getUser().getId()}">
                                    <div class="dialog-body">
                                        <a class="dialog-close-btn" href="">&times;</a>
                                        <div class="container">
                                            <br>
                                            <form action="addnew" method="post">
                                                <div class="add row">
                                                    <label class="form-label">Email</label>


                                                    <input type="text" value="${userprofile.getUser().getAccount()}" readonly>

                                                    <label class="form-label">name</label>
                                                    <input type="text" value="${userprofile.getFull_name()}"readonly>
                                                    <div>
                                                        <label class="form-label">Gender</label>
                                                        <input type="radio" name="gender" value="0" ${userprofile.getGender() == 0 ? "checked":""} disabled>Female &nbsp;&nbsp;
                                                        <input type="radio" name="gender" value="1" ${userprofile.getGender() == 1 ? "checked":""} disabled >Male
                                                    </div>
                                                    <label class="form-label">Phone</label>
                                                    <input type="text" value="${userprofile.phone_number()}" readonly>
                                                    <label class="form-label">Role</label>
                                                    <select class="select">                                               
                                                        <c:forEach var="list_role" items="${list_role}">
                                                            <option value="${list_role.getId()}" ${userprofile.getUser().getRole_id() == list_role.getId() ? "selected" : ""}>${list_role.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <br>
                                                    <label class="form-label">Status</label>
                                                    <select name="status" id="status">
                                                        <option value="0" ${userprofile.getUser().getStatus() == 0 ? "selected" : ""}>Deactive</option>
                                                        <option value="1" ${userprofile.getUser().getStatus() == 1 ? "selected" : ""}>Active</option>
                                                    </select>

                                                    <br><br><br>
                                                    <button>Change update</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination" style="display: flex; justify-content: center;">
                        <c:if test="${page > 1}">
                            <li><a href="questionList?page=${page-1}" >Previous</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${totalPage}" var="i">
                            <li><a href="questionList?page=${i}&search=${search}&level=${level}&subject=${subject}&lesson=${lesson}">${i}</a></li>
                            </c:forEach>
                            <c:if test="${page < totalPage}">
                            <li><a href="questionList?page=${page+1}">Next</a></li>
                            </c:if>
                    </ul>

                </div>
                <%@include file = "Login.jsp"%>  

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
                                            function applyFilters() {
                                                var genderSelect = document.getElementById("gender");
                                                var roleSelect = document.getElementById("role");
                                                var statusSelect = document.getElementById("status");
                                                var searchInput = document.getElementById("searchInput");

                                                var gender = genderSelect.options[genderSelect.selectedIndex].value;
                                                var role = roleSelect.options[roleSelect.selectedIndex].value;
                                                var status = statusSelect.options[statusSelect.selectedIndex].value;
                                                var search = searchInput.value;




                                                // Build your base URL
                                                var baseUrl = "userlist?";

                                                if (gender !== "all") {
                                                    baseUrl += "gender=" + gender + "&";
                                                }
                                                if (role !== "all") {
                                                    baseUrl += "role=" + role + "&";
                                                }
                                                if (status !== "all") {
                                                    baseUrl += "status=" + status + "&";
                                                }
                                                if (search.trim() !== "") {
                                                    baseUrl += "search=" + encodeURIComponent(search.trim()) + "&";
                                                }

                                                baseUrl = baseUrl.slice(0, -1);
                                                localStorage.setItem("gender", gender);
                                                localStorage.setItem("role", role);
                                                localStorage.setItem("status", status);
                                                localStorage.setItem("search", search);



                                                // Redirect to the filtered URL
                                                window.location.href = baseUrl;
                                            }

                                            function openPopup() {
                                                document.getElementById('question-import').classList.add('active');
                                            }

                                            function closePopup() {
                                                document.getElementById('question-import').classList.remove('active');
                                            }
                                            document.getElementById('fileInput').addEventListener('change', function (event) {
                                                var file = event.target.files[0];
                                                // display the id=submit
                                                var allowedType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
                                                if (file.type !== allowedType) {
                                                    event.target.value = null; // Clear the file selection
                                                    document.getElementById('resultContainer').textContent = "Invalid file type. Only XLSX files are allowed.";
                                                    return;
                                                } else {
                                                    document.getElementById('resultContainer').textContent = "";
                                                    //hide the id=submit
                                                    document.getElementById('submit').style.display = 'block';

                                                }
                                            });
                                            function chooseFile() {
                                                var fileInput = document.getElementById('fileInput');
                                                fileInput.click();
                                            }
        </script>
        <script src="js/PopUp.js"></script>
        <script src="js/navBar.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


    </body>


</html>