<%-- 
    Document   : PricePackage
    Created on : Jun 13, 2023, 8:53:08 PM
    Author     : dai
--%>
<%@page import= "java.util.List" %>
<%@page import = "model.Price_Package" %>
<%@page import = "java.util.*" %>
<%@page import = "dal.*" %>

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
        <h1>Price Package</h1>
        <div class="table-content">
            <form>
                <table class="table table-hover">
                    <thead class="table-menu">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Package</th>
                            <th scope="col">Duration</th>
                            <th scope="col">List Price</th>
                            <th scope="col">Sale Price</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody class="table-info">
                        <tr>
                            <c:forEach items="${pricePackageList}" var="pricePackage">
                            <th scope="row">${pricePackage.id}</th>
                            <td>Goi truy cap 3 thang</td>
                            <td>${pricePackage.duration}</td>
                            <td>${pricePackage.price}</td>
                            <td>${pricePackage.sale}</td>
                            <td>${pricePackage.status}</td>
                            <td>Edit</td>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

    </body>
    <%@include file="components/Footer.jsp" %>
</html>
