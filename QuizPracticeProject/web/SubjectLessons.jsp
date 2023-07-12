
<%-- 
    Document   : SubjectLessons
    Created on : Jun 19, 2023, 4:34:15 PM
    Author     : dai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "model.*"%>
<%@page import= "dal.*"%>
<%@page import= "java.util.*"%>
<%@page import= "java.util.ArrayList" %>
<%@page import= "java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/SubjectListAE.css" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%@include file="components/CusHeader.jsp"%>

    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1 style="font-size:35px">SUBJECT LESSONS</h1>
                <div class="topnav">
                    <div class="left-container">
                        <div class="search-bar-container">
                            <input type="text" id="search-bar" placeholder="Search..." value="${search}">
                            <button id="search-icon" onclick="applyFilters()">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                                </svg>
                            </button>
                        </div>
                        <div class="filter-container">
                            <select name="category" id="filter1" onchange="applyFilters()">
                                <option value= "all" >All</option>
                                <c:forEach var="lessonTypeList" items="${lessonTypeList}">
                                    <option value="${lessonTypeList.getId()}" ${lessonTypeList.getId().toString() eq category ? "selected" : ""} >${lessonTypeList.getName()}</option>
                                </c:forEach>
                            </select>
                            <select name="status" id="filter2" onchange="applyFilters()">
                                <option value="all" ${status eq "all" ? "selected" : ""}>All</option>
                                <option value="1" ${status eq "1" ? "selected" : ""}>Active</option>
                                <option value="0" ${status eq "0" ? "selected" : ""}>Deactive</option>

                            </select>
                            <button class="clear-filter" id="clear-filter" onclick="clearFilters()">Clear</button>
                        </div>
                    </div>
                    <div class="right-container">
                        <a href="addNewLessonDetails?subjectId=${subjectId}"><button id="add-button">Add New</button></a>
                    </div>
                </div>
                <div class="header_fixed">
                    <table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Lesson</th>
                                <th>Order</th>
                                <th>Type</th>
                                <th>Status</th>

                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lessonList}" var="lesson">
                                <tr>
                                    <td>${lesson.getId()}</td>
                                    <td>${lesson.getName()}</td>
                                    <td>${lesson.getOrder()}</td>

                                    <c:forEach items="${lessonTypeList}" var="lessonType">
                                        <c:if test="${lesson.type_id == lessonType.id}">
                                            <td>${lessonType.name}</td>
                                        </c:if>
                                    </c:forEach>

                                    <c:if test="${lesson.isStatus() == true}">
                                        <td><div class="active-button">Active</div></td>
                                    </c:if>
                                    <c:if test="${lesson.isStatus() == false}">
                                        <td><div class="deactive-button">Deactive</div></td>
                                    </c:if>
                                    <td>
                                        <c:if test="${lesson.status}">
                                            <a class="dialog-btn" href="subjectLessons?subjectId=${subjectId}&statusDeactive=1&lessonId=${lesson.getId()}">Deactive</a>
                                        </c:if>
                                        <c:if test="${!lesson.status}">
                                            <a class="dialog-btn" href="subjectLessons?subjectId=${subjectId}&statusActive=1&lessonId=${lesson.getId()}">Active</a>
                                        </c:if>

                                        <a href="editLessonDetails?lessonId=${lesson.getId()}&subjectId=${subjectId}">Edit</a>
                                        <a href="#">View detail</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>


                    </table>
                    <div class="pagination">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <a class="${tag == i?"active":""}" href="subjectlistae?index=${i}&status=${status}&category=${category}&search=${search}"">${i}</a>
                        </c:forEach>
                    </div>

                </div>
                <a href="subjectListAE" class="btn btn-primary">Back to Subject list</a>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/PopUp.js" type="text/javascript"></script>
        <script src="js/SubjectLesson.js" type="text/javascript"></script>      
        <script src="js/navBar.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
    <%@include file="components/Footer.jsp" %>

</html>
