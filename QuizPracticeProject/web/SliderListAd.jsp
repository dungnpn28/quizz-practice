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
        <link rel="stylesheet" href="css/MyRegistration.css" type="text/css"/>


    </head>
    <body>
        <%@ include file="components/CusHeader.jsp" %>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
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
                                        <img src="uploads/${listSlider.getImage()}" height="100px" width="150px">
                                    </div>
                                </td>
                                <td>
                                    <div class="col">
                                        ${listSlider.getTitle()}
                                    </div>
                                </td>
                                <td>
                                    <div class="col">
                                        <a href="${listSlider.getBacklink()}" style="background: none; color: #000000">${listSlider.getBacklink()}</a>
                                    </div>
                                </td>
                                <td>
                                    <div class="col">
                                        <c:if test="${listSlider.status == true}">
                                            Active
                                        </c:if>
                                        <c:if test="${listSlider.status == false}">
                                            Inactive
                                        </c:if>
                                    </div>
                                </td>
                                <td>
                                    <div class="row">
                                        <div class ="col">



                                            <div class="col">
                                                <form action="sliderList" method="post">
                                                    <button type="submit" name="btnEdit" style="background: linear-gradient(90deg,#755bea,#ff72c0)">EDIT</button>

                                                    <input hidden name="sid" value="${listSlider.id}">
                                                </form>
                                                <form action="sliderList" method="post" id="deleteForm">
                                                    <input hidden name="sid" value="${listSlider.getId()}">
                                                    <button type="submit" name="btnDel" style="background: linear-gradient(90deg,#755bea,#ff72c0)">DELETE</button>
                                                </form>
                                            </div>  
                                            <a  class="dialog-btn"  href="sliderDetail?sid=${listSlider.getId()}" style="color: #ffffff">VIEW DETAIL</a>


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
        <script>
            // Gắn sự kiện "submit" vào form khi người dùng ấn submit
            var formElement = document.getElementById("deleteForm");
            formElement.addEventListener("submit", function (event) {
                if (!confirm("Are you sure you want to delete?")) {
                    event.preventDefault(); // Hủy sự kiện submit nếu người dùng không đồng ý
                }
            });
        </script>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>