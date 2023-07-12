<%-- 
    Document   : AddNewRegistration
    Created on : Jul 13, 2023, 2:24:38 AM
    Author     : LENOVO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.*" %>
<%@page import = "java.model.*" %>
<%@page import = "java.dal.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Registration Page</title>
        <link href="css/AddNewRegistration.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <%
        }
        %>
        <%@ include file="components/CusHeader.jsp" %>
        <div class="wrapper">
            <%
            if (session.getAttribute("user") != null) {
            %>
            <%@include file="components/navbar.jsp" %>
            <%
            } 
            %>
            <div id="content">
                <div class="container row d-flex">
                    <div class="container row d-flex justify-content-between">
                        <div class="header-container">
                            <h1><a href="registrationList">Registration List </a></h1>  
                            <h1> / </h1>
                            <h1><a href="addnewregistration">Add new Registration </a></h1>
                        </div>


                        <p></p>
                          
                        <div class="mb-3">
                            <label for="" class="form-label">Account</label>
                            <input name="accountSelected" type="text" id="accountInput" class="form-control" placeholder="Nhập kí tự...">
             
                        </div>

                        <form action="addnewregistration" method="post">          

                            <div class="mb-3">
                                <label for="" class="form-label">Subject</label>
                                <input name="subjectSelected" type="text" id="subjectInput" class="form-control" placeholder="Nhập kí tự...">
                                
                            </div>
                            <button type="submit" class="btn btn-primary">Show subject information</button><br/>
                        </form>

                        <c:if test="${not empty chooseSubject}">
                            <div class="mb-3">
                                <h1>${chooseSubject.getName()}</h1>

                            </div>
                        </c:if>


                        <form action="addnewregistration" method="post">          

                            <div class="mb-3">
                                <label for="" class="form-label">Brief Information</label>
                                <textarea name="brief_info" class="form-control" id="" aria-describedby="" required>${blog.brief_info}</textarea>
                            </div>
                            <div class="mb-3" id="contentInput">
                                <label for="editor" class="form-label"> Content</label>
                                <textarea name="htmlContent" id="editor" class="form-control" rows="10" cols="80" required> ${blog.content}</textarea>
                            </div>

                            <div class="form-check mb-3">
                                <input class="form-check-input" type="checkbox" id="featured" name="flag" ${blog.flag == '1' ? 'checked' : ''}>
                                <label class="form-check-label" for="featured">Featured</label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Status: </label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="status1" value="1" ${blog.status ? 'checked' : ''}>
                                    <label class="form-check-label" for="status1">Active</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="status2" value="0" ${!blog.status ? 'checked' : ''}>
                                    <label class="form-check-label" for="status2">Inactive</label>
                                </div>
                            </div>
                            <input type="hidden" name="id" value="${id}">
                            <button type="submit" class="btn btn-primary">Update</button><br/>
                            <a href="blogDetail?id=${id}" class="btn btn-danger">Cancel</a>

                        </form>
                    </div>
                </div>
                <%@include file = "Login.jsp"%> 

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!--<script src="js/AddNewRegistration.js"></script>-->
        <script src="js/navBar.js"></script>



    </body>
    <%@include file="components/Footer.jsp" %>
</html>
