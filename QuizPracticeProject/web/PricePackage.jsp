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
    <%@include file="components/CusHeader.jsp" %>
    <body>
        <%
            User u = null;
            PriceDAO pd = new PriceDAO();
            Price_Package pp = pd.getPrice(u.getId());
            String st = "";
            int status = pp.getStatus();
            if (status == 1) {
                st = "Active";
            } else {
                st = "Deactive";
            }
        %>
        <div class="table-content">
            <%
            if (session.getAttribute("user") != null) {
            %>
            <%@include file="components/navbar.jsp" %>
            <%
            } 
            %>
            <div class="add-pricePackage" id="add-pricePackage">
                <div class="add-content">
                    <div class="button-close">
                        <button onclick="closeAddForm()" class="btn btn-danger">x</button>
                    </div>
                    <form action="addnewpricePackage" method="POST" enctype="multipart/form-data">
                        Package's Name: <input name="name" type="text">
                        <br>
                        Duration(months): <input name="duration" type="text">
                        <br>
                        List Price: <input name="price" type="text">
                        <br>
                        Sale Price: <input name="sale" type="text">
                        <br>
                        Status: <input type="radio" name="status" value="true"> Active
                        <input type="radio" name="status" value="false"> Deactive
                        <br>
                        <input type="submit" value="Add New" class="btn btn-primary">
                    </form>

                </div>
            </div>
            <div class="table-view">
                <button class="btn btn-primary" onclick="openAddForm()">Add New</button>
                <table class="table table-hover">                   
                    <tr class="table-menu">
                        <th scope="col">#</th>
                        <th scope="col">Package</th>
                        <th scope="col">Duration</th>
                        <th scope="col">List Price</th>
                        <th scope="col">Sale Price</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>
                    <c:forEach items="${pricePackageList}" var="pricePackage">
                        <tr class="table-info">
                            <th scope="row">${pricePackage.getId()}</th>
                            <td>${pricePackage.getName()}</td>
                            <c:if test="${pricePackage.getDuration() == 0}">
                                <td></td>
                            </c:if>
                            <c:if test="${pricePackage.getDuration() != 0}">
                                <td>${pricePackage.getDuration()}</td>
                            </c:if>
                            <td>${pricePackage.getPrice()}</td>
                            <td>${pricePackage.getSale()}</td>
                            <c:if test="${pricePackage.isStatus() == true}">
                                <td>Active</td>
                            </c:if>
                            <c:if test="${pricePackage.isStatus() == false}">
                                <td>Deactive</td>
                            </c:if>
                            <td><button class="btn btn-primary" onclick="openAddForm()">Edit</button></td>
                        </tr>
                    </c:forEach>                   
                </table>
            </div>
            <div class="add-pricePackage" id="add-pricePackage">
            <form action="pricePackage" method="post">
                Package's Name: <input name="name" type="text" value="${pricePackage.getName()}">
                <br>
                Duration(months): <input name="duration" type="text" value="${pricePackage.getDuration()}">
                <br>
                List Price: <input name="price" type="text" value="${pricePackage.getPrice()}">
                <br>
                Sale Price: <input name="sale" type="text" value="${pricePackage.getSale()}">
                <br>
                Status: 
                <%if (status == 1) {%>
                <input type="radio" name="status" value="true" checked> Active
                <input type="radio" name="status" value="false"> Deactive
                <% }else {   %>
                <input type="radio" name="status" value="true"> Active
                <input type="radio" name="status" value="false" checked> Deactive
                <% }%>
                <br>
                <input type="submit" value="Update" class="btn btn-primary">
            </form>     
            </div>
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
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
