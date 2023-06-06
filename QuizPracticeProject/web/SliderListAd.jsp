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
        <title>JSP Page</title>
    </head>
    <body>
        <form id="cateForm" method="" action="">
            <select name="cateSelect" class="cateSelect">
                <option>All</option>
                <c:forEach items="${filterStatus}" var="statusItem">
                    <option>${statusItem.status}</option>
                </c:forEach>
                <option></option>

            </select>
        </form> 
        <table border="1">          
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>Image</td>
                    <td>Title</td>
                    <td>Status</td>
                    <td>Actions</td>                    
                </tr>
                <c:forEach items="${listSlider}" var="listSlider">
                    <tr>
                        <td>${listSlider.getId()}</td>
                        <td><img src="${listSlider.getImage()}" height="100px" width="150px"></td>
                        <td>${listSlider.getTitle()}</td>
                        <td>
                            <c:if test="${listSlider.status == true}">
                                Active
                            </c:if>
                            <c:if test="${listSlider.status == false}">
                                Active
                            </c:if>
                        </td>
                        <td>
                            <form action="sliderList" method="post">
                                <button type="submit" name="btnEdit">EDIT</button>
                                <c:if test="${listSlider.status == true}">
                                    <button>HIDE</button>
                                </c:if>
                                <c:if test="${listSlider.status == false}">
                                    <button>SHOW</button>
                                </c:if>
                                <button type="submit" name="btnDel">DELETE</button>
                                <input hidden name="sid" value="${listSlider.getId()}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="" method="">
            <button type="submit" name="btnAdd">+ ADD NEW SLIDER</button>
        </form>
    </body>
</html>
