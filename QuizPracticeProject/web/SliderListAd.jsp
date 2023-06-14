<%-- 
    Document   : SliderListAd
    Created on : Jun 4, 2023, 1:46:08 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Slider List</title>
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">-->
                <link href="css/SliderListAd.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="components/CusHeader.jsp" %>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            
            <table border="1">          
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>Image</td>
                        <td>Title</td>
                        <td>Backlink</td>
                        <td>Status</td>
                        <td>Actions</td>                    
                    </tr>
                    <c:forEach items="${listSlider}" var="listSlider">
                        <tr>
                            <td>
                                <div class="col">
                                    ${listSlider.getId()}
                                </div>
                            </td>
                            <td>
                                <div class="col">
                                    <img src="${listSlider.getImage()}" height="100px" width="150px">
                                </div>
                            </td>
                            <td>
                                <div class="col">
                                    ${listSlider.getTitle()}
                                </div>
                            </td>
                            <td>
                                <div class="col">
                                    <a href="${listSlider.getBacklink()}">${listSlider.getBacklink()}</a>
                                </div>
                            </td>
                            <td>
                                <div class="col">
                                    <c:if test="${listSlider.status == true}">
                                        Active
                                    </c:if>
                                    <c:if test="${listSlider.status == false}">
                                        Active
                                    </c:if>
                                </div>
                            </td>
                            <td>
                                <div class="col">
                                    <form action="sliderList" method="post">
                                        <button type="submit" name="btnEdit">EDIT</button>
                                        <button type="submit" name="btnDel">DELETE</button>
                                        <input hidden name="sid" value="${listSlider.getId()}">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
            <nav aria-label="...">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${listS}" var="i">
                            <li class="page-item"><a class="page-link" href="sliderPaging?index=${i}">${i}</a></li>
                            </c:forEach>
                    </ul>
                </nav>
            <div>
                <form id="cateForm" method="" action="">
                    <select name="cateSelect" class="cateSelect">
                        <option>All</option>
                        <c:forEach items="${filterStatus}" var="statusItem">
                            <option>${statusItem.status}</option>
                        </c:forEach>
                    </select>            
                </form>
                <form action="sliderList" method="post">
                    <input value="${key}" type="search" placeholder="Search..." aria-label="Search" name="keyword"/>
                    <button class="btn" type="submit">Search</button>
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>