<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : SubjectLessons
    Created on : Jun 19, 2023, 4:34:15 PM
    Author     : dai
--%>
<%@page import= "java.util.List" %>
<%@page import = "model.Lesson" %>
<%@page import = "java.util.*" %>
<%@page import = "dal.*" %>
<%@page import = "model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="">Add lesson</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Lesson</th>
                    <th>Order</th>
                    <th>Type</th>
                    
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lesson" items="${lessonList}">            
                    <tr>
                        <td>${lesson.getId()}</td>
                        <td>${lesson.getName()}</td>
                        <td>${lesson.getOrder()}</td>
                        <td>${lesson.getLesson_type_name()}</td>
                        <c:if test="${lesson.isStatus() == true}">
                            <td><div class="active-button">Active</div></td>
                        </c:if>
                        <c:if test="${lesson.isStatus() == false}">
                            <td><div class="deactive-button">Deactive</div></td>
                        </c:if>
                        <td><a href="">Edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
