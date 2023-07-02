<%-- 
    Document   : SubjectListAE
    Created on : Jun 7, 2023, 2:13:43 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "java.util.*" %>
<%@page import= "model.*"%>
<%@page import= "dal.*"%>
<%@page import="model.Subject_Category"%>
<%@page import="dal.Subject_CategoryDAO"%>
<%@page import="model.Subject"%>
<%@page import="dal.SubjectDAO"%>
<%@page import="model.UserProfile"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import="model.User"%>
<%@page import="dal.UserDAO"%>
<%@page import="model.Lesson"%>
<%@page import="model.Lesson_Type"%>
<%@page import="model.Lesson_Topic"%>
<%@page import="dal.LessonDAO"%>



<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/SubjectListAE.css" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>

    <body>


        <%@include file="components/CusHeader.jsp"%>


        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1 style="font-size:35px">SUBJECT LIST</h1>
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
                                <c:forEach var="subjectCategoryList" items="${subjectCategoryList}">
                                    <option value="${subjectCategoryList.getId()}" ${subjectCategoryList.getId().toString() eq category ? "selected" : ""} >${subjectCategoryList.getName()}</option>
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
                        <a href="addnewsubject"><button id="add-button">Add New</button></a>
                    </div>
                </div>
                <div class="header_fixed">
                    <table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Number of lessons</th>
                                <th>Owner</th>
                                <th>Status</th>

                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${subjectList}" var="subjectList">
                                <tr>
                                    <td>${subjectList.getId()}</td>
                                    <td>${subjectList.getName()}</td>
                                    <c:forEach var="subjectCategoryList" items="${subjectCategoryList}">
                                        <c:if test="${subjectList.category_id == subjectCategoryList.id}">
                                            <td>${subjectCategoryList.name}</td>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="count" value="0" />
                                    <c:forEach var="lessonList" items="${lessonList}">                                  
                                        <c:if test="${lessonList.subject_id == subjectList.id}">
                                            <c:set var="count" value="${count + 1}" />
                                        </c:if>     
                                    </c:forEach>
                                    <td>${count}</td>
                                    <c:forEach var="expertList" items="${expertList}">

                                        <c:if test="${subjectList.getAuthor_id() == expertList.getUser_id()}">
                                            <td>${expertList.full_name}</td>

                                        </c:if>

                                    </c:forEach>

                                    <c:choose>
                                        <c:when test="${subjectList.isStatus()}">
                                            <td>Active</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Deactive</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><a class="dialog-btn" href="subjectdetailae?subjectId=${subjectList.getId()}">View detail</a>
                                        <a class="dialog-btn" href="subjectLessons?subjectId=${subjectList.getId()}">View lessons</a></td>

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
            </div>

        </div>


        <script src="js/PopUp.js" type="text/javascript"></script>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script src="js/subjectList.js" type="text/javascript"></script>      
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
    <%@include file="components/Footer.jsp" %>

</html>