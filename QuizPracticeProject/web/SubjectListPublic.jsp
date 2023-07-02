<%-- 
    Document   : SubjectListPublic
    Created on : Jun 5, 2023, 7:20:56 AM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import= "model.User"%>
<%@page import= "model.UserProfile"%>
<%@page import= "model.Subject"%>
<%@page import= "dal.SubjectDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject List Public Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/SubjectListPublic.css" rel="stylesheet" type="text/css"/>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>



    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <%@ include file="components/CusHeader.jsp" %>
        <%
        } else {
        // Nếu không có user, bao gồm trang header.jsp
        %>
        <%@ include file="components/Header.jsp" %>
        <%
        }
        %>

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
                        <div class=" col-md-8">
                            <div class="row">
                                <div class="col-6">
                                    <div class="gif-and-heading d-flex">
                                        <c:choose>
                                            <c:when test="${not empty sessionScope.checkFeatured}">
                                                <h3 class="mb-3 mt-4">Subject list by featured</h3>
                                            </c:when>
                                            <c:when test="${not empty sessionScope.checkRegisted}">
                                                <h3 class="mb-3 mt-4">Subject list by registed</h3>
                                            </c:when>
                                            <c:when test="${not empty sessionScope.checkNotRegisted}">
                                                <h3 class="mb-3 mt-4">Subject list by not registed</h3>
                                            </c:when>
                                            <c:otherwise>
                                                <h3 class="mb-3 mt-4">All subject</h3>
                                            </c:otherwise>
                                        </c:choose>                
                                    </div>
                                    <c:if test="${not empty sessionScope.selectedCategoryId}">
                                        <h3>List subject by category: ${categoryName}</h3>
                                    </c:if>
                                </div>
                                <div class="col-12">
                                    <div class="d-flex justify-content-between">
                                        <form action="subjectListPublic" method="get">
                                            <input type="hidden" name="checkAll" value="true">
                                            <button class="subjectListButton" type="submit">All Subject</button>
                                        </form>
                                        <form action="subjectListPublic" method="get">
                                            <input type="hidden" name="checkFeatured" value="true">
                                            <button class="subjectListButton" type="submit">Feature Subject</button>
                                        </form>
                                        <c:if test="${not empty sessionScope.user}">
                                            <form action="subjectListPublic" method="get">
                                                <input type="hidden" name="checkRegisted" value="true">
                                                <button class="subjectListButton" type="submit">Registed Subject</button>
                                            </form>
                                            <form action="subjectListPublic" method="get">
                                                <input type="hidden" name="checkNotRegisted" value="true">
                                                <button class="subjectListButton" type="submit">Not Registed Subject</button>
                                            </form>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="col-12">
                                    <div id="carouselExampleIndicators3" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-inner header_fixed">
                                            <c:if test="${subjectList == null || subjectList.size() == 0}">
                                                Not found
                                            </c:if>
                                            <c:forEach items="${subjectList}" var="item" varStatus="status">
                                                <div class="row">
                                                    <div class="col-md-12 mb-3">
                                                        <div class="card" style="height:200px">
                                                            <div class="row g-0">
                                                                <div class="col-md-4">

                                                                    <img src="uploads/${item.getIllustration()}" class="card-img-left zoom-image" style="height:250px; width:250px" alt="..." onclick="window.location.href = 'subjectDetails?id=${item.getId()}'">
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <div class="card-body">
                                                                        <h5 class="card-title" onclick="window.location.href = 'subjectDetails?id=${item.getId()}'">${item.getName()}</h5>

                                                                        <div class="card-date">Updated date: ${item.getModified()}</div>
                                                                        <div class="card-date">List price: ${item.getMin_price()} đ - Sale price: ${item.getMin_sale()} đ</div>


                                                                        <c:forEach items="${subjectCategoryList}" var="category">
                                                                            <c:if test="${item.category_id == category.id}">
                                                                                <div class="card-category">Category: ${category.name}</div>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </div>
                                                                    <span class="multicolor-blink">
                                                                        <c:if test="${item.featured}">
                                                                            <img src="img/icons8-flame.gif" alt="Animated GIF">
                                                                            <p style="display: inline;">Featured subject</p>
                                                                        </c:if>
                                                                    </span>

                                                                    <c:if test="${empty sessionScope.user}">
                                                                        <%-- Nếu không có user trong session --%>
                                                                        <%-- Hiển thị nút Register --%>
                                                                        <span class="registerButton">
                                                                            <!--<a href="#" id="popUpLink3" data-toggle="modal"><button >Register</button> </a>-->
                                                                            <a class="dialog-btn" href="#my-dialog2-${item.getId()}">Registed</a>

                                                                        </span>

                                                                    </c:if>
                                                                    <c:if test="${not empty sessionScope.user}">
                                                                        <%-- Kiểm tra xem subject hiện tại có trong danh sách userSubjects hay không --%>
                                                                        <c:if test="${subjectListByUserId == null}">
                                                                            <span class="registerButton">
                                                                                <!--<a href="#" id="popUpLink3" data-toggle="modal"><button>Register</button> </a>-->
                                                                                <a class="dialog-btn" href="#my-dialog2-${item.getId()}">Registed</a>

                                                                            </span>
                                                                        </c:if>
                                                                        <c:if test="${subjectListByUserId != null}">
                                                                            <c:set var="isRegistered" value="false"/>
                                                                            <c:forEach var="subject" items="${subjectListByUserId}">
                                                                                <c:if test="${subject.getId() == item.getId()}">

                                                                                    <%-- Nếu người dùng đã tham gia môn học này --%>
                                                                                    <%-- Hiển thị nút không bấm được --%>
                                                                                    <span class="alreadyRegistedButton">
                                                                                        <button disabled>Already registed</button>
                                                                                    </span>
                                                                                    <%-- Gán giá trị true cho biến isRegistered và thoát khỏi vòng lặp --%>
                                                                                    <c:set var="isRegistered" value="true" />
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <%-- Kiểm tra biến isRegistered để hiển thị nút Register nếu không tìm thấy subject trùng khớp --%>
                                                                            <c:if test="${!isRegistered}">
                                                                                <span class="registerButton">
                                                                                    <!--<a href="#" id="popUpLink3" data-toggle="modal"><button>Register</button> </a>-->
                                                                                    <a class="dialog-btn" href="#my-dialog2-${item.getId()}">Registed</a>
                                                                                </span>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </c:if>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <div class="dialog overlay" id="my-dialog2-${item.getId()}">
                                                            <!-- <a href="#" class="overlay-close"></a>-->
                                                            <div class="dialog-body">
                                                                <a class="dialog-close-btn" href="">&times;</a>
                                                                <div class="container">
                                                                    <br>
                                                                    <c:if test="${not empty sessionScope.user}">
                                                                        <form id="subjectregisted-${item.getId()}" action="subjectRegisted" method="post">
                                                                            <div class="add row">
                                                                                <div class="col-md-5">
                                                                                    <img src="uploads/${item.getIllustration()}" alt="User Avatar">

                                                                                </div>
                                                                                <div class="col-md-7">
                                                                                    <label class="form-label">Subject name: ${item.getName()}</label>
                                                                                    <br>
                                                                                    <label class="form-label">Package option</label><br>
                                                                                    <c:forEach var="pricePackage" items="${pricePackageList}">
                                                                                        <c:if test="${item.getId() == pricePackage.subject_id}">
                                                                                            <input id="pricePackage" type="radio" name="selectedPackaged" value="${pricePackage.id}" required checked>${pricePackage.name}<br>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <div id="priceError" class="text-danger"></div>

                                                                                </div>
                                                                                <label class="form-label">Name</label>
                                                                                <input type="text" name="name" value="${userProfile.getFull_name()}"readonly>
                                                                                <label class="form-label">Email</label>
                                                                                <input type="text" name="email" value="${sessionScope.user.getAccount()}"readonly>
                                                                                <div>
                                                                                    <label class="form-label">Gender</label> &nbsp&nbsp
                                                                                    <input type="radio" name="gender" value="0" ${userProfile.getGender() == 0 ? "checked":""} disabled>Female &nbsp;&nbsp;
                                                                                    <input type="radio" name="gender" value="1" ${userProfile.getGender() == 1 ? "checked":""} disabled >Male
                                                                                </div>
                                                                                <label class="form-label">Phone</label>
                                                                                <input type="text" name="phone" value="${userProfile.phone_number()}" readonly>

                                                                                <br>


                                                                                <br>
                                                                                <!--                                                    <button type="submit">Change Update</button>-->
                                                                                <input type="submit" value="Registed" class="btn btn-primary" onclick ="return confirm('Are you sure you want to registed?')">
                                                                            </div>
                                                                        </form>
                                                                    </c:if>
                                                                    <c:if test="${empty sessionScope.user}">
                                                                        <form id="subjectregisted-${item.getId()}" name="subjectRegisted" action="subjectRegisted" method="post" onsubmit="return validateSubjectRegistedForm()">
                                                                            <div class="add row">
                                                                                <div class="col-md-5">
                                                                                    <img src="uploads/${item.getIllustration()}" alt="User Avatar">

                                                                                </div>
                                                                                <div class="col-md-7">
                                                                                    <label class="form-label">Subject name: ${item.getName()}</label>
                                                                                    <br>
                                                                                    <label class="form-label">Package option</label><br>
                                                                                    <c:forEach var="pricePackage" items="${pricePackageList}">
                                                                                        <c:if test="${item.getId() == pricePackage.subject_id}">
                                                                                            <input id="pricePackage" type="radio" name="selectedPackaged" value="${pricePackage.id}" required checked>${pricePackage.name}<br>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <div id="priceError" class="text-danger"></div>

                                                                                </div>
                                                                                <label class="form-label">Name</label>
                                                                                <input type="text" name="name">
                                                                                <label class="form-label">Email</label>
                                                                                <input type="text" name="email">
                                                                                <div>
                                                                                    <label class="form-label">Gender</label> &nbsp&nbsp
                                                                                    <input type="radio" name="gender" value="0" checked>Female &nbsp;&nbsp;
                                                                                    <input type="radio" name="gender" value="1">Male
                                                                                </div>
                                                                                <label class="form-label">Phone</label>
                                                                                <input type="text" name="phone">

                                                                                <br>


                                                                                <br>
                                                                                <!--                                                    <button type="submit">Change Update</button>-->
                                                                                <!--<button type="button" onclick="openConfirmationDialogSubjectRegisted(${item.getId()})">Registed</button>-->
                                                                                <input type="submit" value="Registed" class="btn btn-primary" onclick ="return confirm('Are you sure you want to registed?')">

                                                                                <div id="confirmation-dialog-${item.getId()}" class="modal">
                                                                                    <div class="modal-content">
                                                                                        <p>Are you sure?</p>
                                                                                        <div class="buttons">
                                                                                            <button id="confirm-yes-${item.getId()}">Yes</button>
                                                                                            <button id="confirm-no-${item.getId()}" onclick="modalCloseHandler(event)">No</button>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>

                                                                            </div>
                                                                        </form>
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <ul class="pagination" style="display: flex; justify-content: center;">
                                        <c:if test="${page > 1}">
                                            <li><a href="subjectListPublic?page=${page-1}">Previous</a></li>
                                            </c:if>
                                            <c:forEach begin="1" end="${totalPage}" var="i">
                                            <li><a href="subjectListPublic?page=${i}">${i}</a></li>
                                            </c:forEach>
                                            <c:if test="${page < totalPage}">
                                            <li><a href="subjectListPublic?page=${page+1}">Next</a></li>
                                            </c:if>
                                    </ul>
                                </div>                       
                            </div>
                        </div>
                        <div class="col-md-4 ">
                            <div class="sticky-table-container">
                                <div class="row d-flex justify-content-center">

                                    <div class="searchBox">
                                        <form action="subjectListPublic" method="get">
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
                                        <c:if test="${key!= mull}" >
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.checkFeatured}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from featured subject</h3>
                                                </c:when>
                                                <c:when test="${not empty sessionScope.checkRegisted}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from registed subject</h3>
                                                </c:when>
                                                <c:when test="${not empty sessionScope.checkNotRegisted}">
                                                    <h3 class="mb-3 mt-4">Search "${key}" from not registed subject</h3>
                                                </c:when>
                                                <c:otherwise>
                                                    <h3 class="mb-3 mt-4">Search "${key}" from all subject</h3>
                                                </c:otherwise>
                                            </c:choose>            
                                        </c:if>
                                        <br/>
                                        <form action="subjectListPublic" method="get">
                                            <select name="selectedCategory">
                                                <option value="0">All</option>
                                                <c:forEach items="${subjectCategoryList}" var="category">
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                            <button type="submit">Confirm</button>
                                        </form>
                                        <br/>
                                        <form action="subjectListPublic" method="get">
                                            <input type="radio" id="asc" name="sort" value="asc">
                                            <label for="asc">Price ↗</label>

                                            <input type="radio" id="desc" name="sort" value="desc">
                                            <label for="desc">Price ↘</label>
                                            <button type="submit">Confirm</button>
                                        </form>
                                        <c:if test="${checkSort == 'asc'}">
                                            <p>Sort ascending by price</p>
                                        </c:if>
                                        <c:if test="${checkSort == 'desc'}">
                                            <p>Sort descending by price</p>
                                        </c:if>
                                    </div>

                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Featured Subject</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    top 3 most recent featured subject
                                                </td>
                                            </tr>
                                            <c:forEach var="item" items="${featuredSubjectList}" begin="0" end="2">

                                                <tr onclick="window.location.href = 'subjectDetails?id=${item.getId()}'">
                                                    <td>
                                                        <div class="table-image">
                                                            <img src="uploads/${item.getIllustration()}" alt="Image">
                                                        </div>
                                                    </td>
                                                    <td class="card-title">${item.getName()}
                                                        <br/>
                                                        <div class="card-date">Updated date: ${item.getModified()}</div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file = "Login.jsp"%> 
                    <%@include file = "Register.jsp"%> 

                </div>
            </div>    
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/PopUp.js" type="text/javascript"></script>
        <script src="js/subjectListPublic.js" type="text/javascript"></script>      
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
    <%@include file="components/Footer.jsp" %>

</html>
