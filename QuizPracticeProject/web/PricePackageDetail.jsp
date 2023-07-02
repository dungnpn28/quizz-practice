<%-- 
    Document   : PricePackageDetail
    Created on : Jun 27, 2023, 1:55:24 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Price Package</h1>
        <div class="table-content">

            <div class="add-pricePackage" id="add-pricePackage">
                <div class="add-content">
                    <div class="button-close">
                        <button onclick="closeAddForms()" class="btn btn-danger">x</button>
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
<!--                                <input type="hidden" name="subjectId" value="${s}">-->
                        <input type="submit" value="Add New" class="btn btn-primary" onclick ="return confirm('Are you sure you want to add?')">
                    </form>
                </div>
            </div>
        </div>
        <div class="table-view">                        
            <!--                            <button class="btn btn-primary" onclick="openAddForms()">Add New</button>
                                        <div class="dropdown">
                                            <button class="btn btn-primary">Dropdown Menu</button>
                                            <div class="dropdown-content">
                                                <a href="#">ADD EXISTING PRICE PACKAGE</a>
                                                <a href="#" onclick="openAddForms()">ADD NEW</a>
            
                                            </div>
                                        </div>-->
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown button
                </button>
                <ul class="dropdown-menu">
                    <li class="dropdown">
                        <button class="dropdown-item dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Add existing package</button>
                        <ul class="dropdown-menu dropdown-submenu">
                            <!--                                            <li><a class="dropdown-item" href="#">Submenu item 1</a></li>
                                                                        <li><a class="dropdown-item" href="#">Submenu item 2</a></li>-->
                            <c:forEach items="${allPricePackageList}" var="allPricePackageList">
                                <c:set var="count" value="0" />
                                <c:forEach items="${pricePackageList}" var="pricePackage">
                                    <c:if test="${allPricePackageList.id == pricePackage.id}">
                                        <c:set var="count" value="${count + 1}" /> <!-- Tăng giá trị biến đếm count -->
                                    </c:if>
                                </c:forEach>
                                <c:if test="${count eq 0}">
                                    <li><a class="dropdown-item" href="#">
                                            <span class="label" style="color: red;font-weight: bold;">name:</span>
                                            <span class="value">${allPricePackageList.name}</span>
                                            <span class="label" style="color: red;font-weight: bold;">description:</span>
                                            <span class="value" >${allPricePackageList.description}</span>
                                            <span class="label" style="color: red;font-weight: bold;">duration:</span>
                                            <span class="value">${allPricePackageList.duration}</span>
                                            <span class="label" style="color: red;font-weight: bold;">price:</span>
                                            <span class="value">${allPricePackageList.price}</span>
                                            <span class="label" style="color: red;font-weight: bold;">sale:</span>
                                            <span class="value">${allPricePackageList.sale}</span>
                                        </a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                    <li><a class="dropdown-item" href="#" onclick="openAddForms()">Add new</a></li>
                </ul>
            </div>

            <div id="pricepackage">
                <table class="table table-hover">                   
                    <tr class="table-menu">
                        <th scope="col">#</th>
                        <th scope="col">Package</th>
                        <th scope="col">Description</th>
                        <th scope="col">Duration</th>
                        <th scope="col">List Price</th>
                        <th scope="col">Sale Price</th>                
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>

                    <c:forEach items="${pricePackageListWithPaging}" var="pricePackageListWithPaging">
                        <tr class="table-info">
                            <th scope="row">${pricePackageListWithPaging.getId()}</th>
                            <td>${pricePackageListWithPaging.getName()}</td>
                            <td>${pricePackageListWithPaging.getDescription()}</td>
                        <c:if test="${pricePackageListWithPaging.getDuration() == 0}">
                            <td></td>
                        </c:if>
                        <c:if test="${pricePackageListWithPaging.getDuration() != 0}">
                            <td>${pricePackageListWithPaging.getDuration()}</td>
                        </c:if>
                        <td>${pricePackageListWithPaging.getPrice()}</td>
                        <td>${pricePackageListWithPaging.getSale()}</td>
                        <c:if test="${pricePackageListWithPaging.getStatus() == 1}">
                            <td><div class="active-button">Active</div></td>
                        </c:if>
                        <c:if test="${pricePackageListWithPaging.getStatus() == 0}">
                            <td><div class="deactive-button">Deactive</div></td>
                        </c:if>
                        <td><a href="#edit-pricePackage-${pricePackageListWithPaging.getId()}">  <button class="btn btn-primary" onclick="openEditForms(${pricePackageListWithPaging.getId()})" >Edit</button></a></td>

                        </tr>
                        <div class="edit-pricePackage" id="edit-pricePackage-${pricePackageListWithPaging.getId()}">
                            <div class="edit-content">
                                <div class="button-close">
                                    <button onclick="closeEditForms(${pricePackageListWithPaging.getId()})" class="btn btn-danger">x</button>
                                </div>
                                <form action="pricePackage" method="post" onsubmit="return validateForm1(${pricePackageListWithPaging.getId()})" name="editForm-${pricePackageListWithPaging.getId()}" >
                                    ID: <input name="id" type="text" value="${pricePackageListWithPaging.getId()}" readonly>
                                    <br>
                                    Package's Name: <input name="name" type="text" value="${pricePackageListWithPaging.getName()}">
                                    <br>
                                    Description: <input name="description" type="text" value="${pricePackageListWithPaging.getDescription()}">
                                    <br>
                                    Duration(months): <input name="duration" type="text" value="${pricePackageListWithPaging.getDuration()}">
                                    <br>
                                    List Price: <input name="price" type="text" value="${pricePackageListWithPaging.getPrice()}">
                                    <br>
                                    Sale Price: <input name="sale" type="text" value="${pricePackageListWithPaging.getSale()}">
                                    <br>
                                    Status:                 
                                    <input type="radio" name="status" value="1" ${pricePackageListWithPaging.getStatus() == 1?"checked":""} >Active
                                    <input type="radio" name="status" value="0" ${pricePackageListWithPaging.getStatus() == 0?"checked":""} > Deactive
                                    <br>
                                    <input type="hidden" name="subjectId" value="${subjectId}">

                                    <input type="submit" value="Update" class="btn btn-primary" onclick ="return confirm('Are you sure you want to update?')">
                                </form>    
                            </div>
                        </div>
                    </c:forEach>

                </table>
                <ul class="pagination" style="display: flex; justify-content: center;">
                    <c:forEach begin="1" end="${endP}" var="i">
                        <a class="${tag == i?"active":""}" href="subjectdetailae?index=${i}&subjectId=${subjectId}">${i}</a>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>
</html>
