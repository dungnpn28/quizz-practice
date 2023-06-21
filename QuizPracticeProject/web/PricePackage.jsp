<%-- 
    Document   : PricePackage
    Created on : Jun 13, 2023, 8:53:08 PM
    Author     : dai
--%>
<%@page import= "java.util.List" %>
<%@page import = "model.Price_Package" %>
<%@page import = "java.util.*" %>
<%@page import = "dal.*" %>
<%@page import = "model.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/PricePackage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizerro</title>
    </head>
    <%
        String str = "";
        User u = (User) request.getSession().getAttribute("user");
        if(u.getRole_id() != 4 && u.getRole_id() != 5){
            response.sendRedirect("AccessDenied.jsp");
        } else {
            if(u.getRole_id() == 4){
                str = "view-Only";
            }
        }
    %>
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1>Price Package</h1>
                <div class="table-content">

                    <div class="add-pricePackage" id="add-pricePackage">
                        <div class="add-content">
                            <div class="button-close">
                                <button onclick="closeAddForm()" class="btn btn-danger">x</button>
                            </div>
                            <form id="addForm" name="addForm" action="addnewpricePackage" method="POST" onsubmit="return validateForm()">
                                Package's Name: <input name="name" type="text">
                                <br>
                                Description: <input name="description" type="text">
                                <br>
                                Duration(months): <input name="duration" type="text">
                                <br>
                                List Price: <input name="price" type="text">
                                <br>
                                Sale Price: <input name="sale" type="text">
                                <br>
                                Status: <input type="radio" name="status" value="1" checked=""> Active
                                <input type="radio" name="status" value="0"> Deactive
                                <br>
                                <input type="hidden" name="subjectId" value="${subjectId}">
                                <input type="submit" value="Add New" class="btn btn-primary" onclick ="return confirm('Are you sure you want to add?')">
                            </form>
                        </div>
                    </div>
                    <div class="table-view">                        
                        <button class="btn btn-primary" onclick="openAddForm()" id="<%=str%>">Add New</button>
                        <table class="table table-hover">                   
                            <tr class="table-menu">
                                <th scope="col">#</th>
                                <th scope="col">Package</th>
                                <th scope="col">Description</th>
                                <th scope="col">Duration</th>
                                <th scope="col">List Price</th>
                                <th scope="col">Sale Price</th>                
                                <th scope="col">Status</th>
                                <th scope="col" id="<%=str%>">Action</th>
                            </tr>
                            <c:forEach items="${pricePackageList}" var="pricePackage">
                                <tr class="table-info">
                                    <th scope="row">${pricePackage.getId()}</th>
                                    <td>${pricePackage.getName()}</td>
                                    <td>${pricePackage.getDescription()}</td>
                                    <c:if test="${pricePackage.getDuration() == 0}">
                                        <td></td>
                                    </c:if>
                                    <c:if test="${pricePackage.getDuration() != 0}">
                                        <td>${pricePackage.getDuration()}</td>
                                    </c:if>
                                    <td>${pricePackage.getPrice()}</td>
                                    <td>${pricePackage.getSale()}</td>
                                    <c:if test="${pricePackage.getStatus() == 1}">
                                        <td><div class="active-button">Active</div></td>
                                    </c:if>
                                    <c:if test="${pricePackage.getStatus() == 0}">
                                        <td><div class="deactive-button">Deactive</div></td>
                                    </c:if>
                                    <td id="<%=str%>"><a href="#edit-pricePackage-${pricePackage.getId()}">  <button class="btn btn-primary" onclick="openEditForm(${pricePackage.getId()})" >Edit</button></a></td>
                                </tr>
                                <div class="edit-pricePackage" id="edit-pricePackage-${pricePackage.getId()}">
                                    <div class="edit-content">
                                        <div class="button-close">
                                            <button onclick="closeEditForm(${pricePackage.getId()})" class="btn btn-danger">x</button>
                                        </div>
                                        <form action="pricePackage" method="post" onsubmit="return validateForm1(${pricePackage.getId()})" name="editForm-${pricePackage.getId()}" >
                                            ID: <input name="id" type="text" value="${pricePackage.getId()}" readonly>
                                            <br>
                                            Package's Name: <input name="name" type="text" value="${pricePackage.getName()}">
                                            <br>
                                            Description: <input name="description" type="text" value="${pricePackage.getDescription()}">
                                            <br>
                                            Duration(months): <input name="duration" type="text" value="${pricePackage.getDuration()}">
                                            <br>
                                            List Price: <input name="price" type="text" value="${pricePackage.getPrice()}">
                                            <br>
                                            Sale Price: <input name="sale" type="text" value="${pricePackage.getSale()}">
                                            <br>
                                            Status:                 
                                            <input type="radio" name="status" value="1" ${pricePackage.getStatus() == 1?"checked":""} >Active
                                            <input type="radio" name="status" value="0" ${pricePackage.getStatus() == 0?"checked":""} > Deactive
                                            <br>
                                            <input type="hidden" name="subjectId" value="${subjectId}">

                                            <input type="submit" value="Update" class="btn btn-primary" onclick ="return confirm('Are you sure you want to update?')">
                                        </form>    
                                    </div>
                                </div>
                            </c:forEach>                   
                        </table>
                        <ul class="pagination" style="display: flex; justify-content: center;">
                            <c:if test="${page > 1}">
                                <li><a href="pricePackage?page=${page-1}">Previous</a></li>
                                </c:if>
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                <li><a href="pricePackage?page=${i}">${i}</a></li>
                                </c:forEach>
                                <c:if test="${page < totalPage}">
                                <li><a href="pricePackage?page=${page+1}">Next</a></li>
                                </c:if>
                        </ul>
                    </div>



                    <script src="js/PricePackage.js"></script>
                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script>
                                                $(document).ready(function () {
                                                    $('#carouselExampleIndicators2').carousel();
                                                });
                    </script>
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('#sidebarCollapse').on('click', function () {
                                $('#sidebar').toggleClass('active');
                            });
                        });
                    </script>
                    <!--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>-->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="js/Validation.js"></script>
                </div>
            </div>
        </div>
    </body>

</html>
