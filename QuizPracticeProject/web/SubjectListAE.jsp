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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        <div class="searchBox">
                    <form action="subjectListAE" method="get">
                        <div class="input-group">
                            <input
                                class="form-control"
                                value="${key}"
                                type="search"
                                placeholder="Search by exam name"
                                aria-label="Search"
                                name="keyword"
                                />
                            <button class="btn btn-primary" type="submit">
                                Search
                            </button>
                        </div>
                    </form>
                    
                    <form action="subjectListAE" method="get">
                        <select name="selectedCategory">
                            <option value="0">All</option>
        <c:forEach items="${subjectCategoryList}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>

</div>-->

        <table border="1">
            <tbody>

                <tr>
                    <td>ID</td>
                    <td>Illustration</td>
                    <td>Name</td>
                    <td>Category</td>
                    <td>Number of Lessons</td>
                    <td>Description</td>
                    <td>Status</td>
                    <td>Action</td>
                </tr>
                <c:forEach var="item" items="${subjectList}">
                    <tr>
                        <td>${item.getId()}</td>
                        <td><img src="${item.getIllustration()}" height="100px" width="150px"></td>
                        <td>${item.name}</td>
                        <td>${item.category_id}</td>
                        <td></td>
                        <td>${item.description}</td>
                        <td>${item.status}</td>
                        <td>
                            <a href="pricePackage?subjectId=${item.getId()}">View detail</a> <br/>
                            <a href="subjectLessons?subjectId=${item.getId()}">View lessons</a>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addnewsubject" type="submit"><button>Add Course</button></a>

    </body>
</html>