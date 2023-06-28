<%-- 
    Document   : UserList
    Created on : Jun 4, 2023, 1:29:21 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="model.UserProfile"%>
<%@page import="dal.UserDAO"%>
<%@page import="dal.RoleDAO"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import = "java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="css/UserList.css" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <!--<link href="css/Style.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <% } %>
                <%@include file="components/CusHeader.jsp"%>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">               
                <h1 style="font-size:35px">USER LIST</h1>
                <div class="topnav">

                    <div class="search-container">

                        <input type="text" placeholder="Searchbyname,email,phone" name="search" id="searchInput" value="${search}">
                        <button onclick="applyFilters()"><i class="fa fa-search"></i></button>


                    </div>
                    <div class="search-container">
                        <div class="a1">
                            Gender
                            <select name="gender" id="gender" onchange="applyFilters()">
                                <option value="all" ${gender == 'all' ? 'selected' : ''}>All</option>
                                <option value="0" ${gender == '0' ? 'selected' : ''}>Female</option>
                                <option value="1" ${gender == '1' ? 'selected' : ''}>Male</option>

                            </select>
                        </div>
                    </div>

                    <div class="search-container">
                        <div class="a1">
                            Role
                            <select name="role" id="role" onchange="applyFilters()">
                                <option value= "all" >All</option>
                                <c:forEach var="list_role" items="${list_role}">
                                    <option value="${list_role.getId()}" ${role eq list_role.getId().toString() ? "selected" : ""}>${list_role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="search-container">
                        <div class="a1">
                            Status
                            <select name="status" id="status" onchange="applyFilters()">
                                <option value="all" ${status == 'all' ? 'selected' : ''}>All</option>
                                <option value="0" ${status == '0' ? 'selected' : ''}>Deative</option>
                                <option value="1"${status == '1' ? 'selected' : ''}>Active</option>

                            </select>
                        </div>
                    </div>

                    <div class="search-container">

                        <button><a href="userlist">Clear filter</a></button>

                    </div>

                    <div class="search-container3">
                        <button><a class="dialog-btn" href="#my-dialog">ADD NEW</a></button>
                        <div class="dialog overlay" id="my-dialog">
                            <div class="dialog-body">
                                <a class="dialog-close-btn" href="">&times;</a>
                                <div class="container">
                                    <br>
                                    <form id="addnew" action="addnewuser" method="post" onsubmit="return validateForm()">
                                        <div class="add row">
                                            <label class="form-label">Email</label>
                                            <input name="email" id="emailInput" type="text" placeholder="Email" required oninput="validateEmail()">
                                            <div id="emailError" class="text-danger"> </div>

                                            <label class="form-label">Name</label>
                                            <input name="name" id="nameInput" type="text" placeholder="Name" required oninput="validateName()">
                                            <div id="nameError" class="text-danger"></div>

                                            <label class="form-label">Gender</label>
                                            <div>
                                                <input id="femaleInput" type="radio" name="gender" value="0" required onchange="validateGender()">Female &nbsp;&nbsp;
                                                <input id="maleInput" type="radio" name="gender" value="1" required onchange="validateGender()">Male
                                            </div>
                                            <div id="genderError" class="text-danger"></div>

                                            <label class="form-label">Phone</label>
                                            <input id="phoneInput" name="phone" type="text" placeholder="Phone number" required oninput="validatePhone()">
                                            <div id="phoneError" class="text-danger"></div>
                                            <label>DOB</label>
                                            <input id="dobInput" type="date" name="dob"required oninput ="validateDob()">
                                            <div id="DobError" class="text-danger"></div>

                                            <label class="form-label">Role</label>
                                            <select id="roleSelect" class="select" name="role">
                                                <c:forEach var="list_role" items="${list_role}">
                                                    <option value="${list_role.getId()}">${list_role.name}</option>
                                                </c:forEach>
                                            </select>

                                            <label class="form-label">Status</label>
                                            <select name="status" id="statusSelect">
                                                <option value="0">Deactive</option>
                                                <option value="1">Active</option>
                                            </select>
                                        </div>
                                        <br>
                                        <button type="button" onclick="openConfirmationDialog1()">CREATE</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="confirmation-dialog" class="modal">
                            <div class="modal-content">
                                <p>Are you sure?</p>
                                <div class="buttons">
                                    <button id="confirm-yes">Yes</button>
                                    <button id="confirm-no" onclick="modalCloseHandler(event)">No</button>
                                </div>
                            </div>
                        </div>
                    </div>




                    <br>
                    <div class="header_fixed">
                        <table>
                            <thead>
                                <tr>
                                    <!--                                    <th><a href="#" onclick="toggleSortOrder('id')">id</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('username')">Username</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('gender')">Gender</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('email')">Email</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('phone')">Phone</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('role')">Role</a></th>
                                                                        <th><a href="#" onclick="toggleSortOrder('status')">Status</a></th>
                                    
                                                                        <th>Action</th>-->
                                    <!--                                    <th><a href="userlist?sortColumn=id&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">id</a></th>
                                                                        <th><a href="userlist?sortColumn=username&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Username</a></th>
                                                                        <th><a href="userlist?sortColumn=gender&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Gender</a></th>
                                                                        <th><a href="userlist?sortColumn=email&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Email</a></th>
                                                                        <th><a href="userlist?sortColumn=phone&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Phone</a></th>
                                                                        <th><a href="userlist?sortColumn=role&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Role</a></th>
                                                                        <th><a href="userlist?sortColumn=status&sortOrder=${sortOrder}&index=${tag}&status=${status}&role=${role}&gender=${gender}&search=${search}">Status</a></th>
                                                                        <th>Action</th>-->
                                    <th>id</th>
                                    <th>Username</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Role</th>
                                    <th>Created</th>
                                    <<th>Modified</th>
                                    <th>Status</th>
                                    <th>Action</th>

                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${list_user_profile}" var="userprofile">

                                    <tr>
                                        <td>${userprofile.getUser().getId()}</td>

                                        <td>${userprofile.getFull_name()}</td>
                                        <c:choose>
                                            <c:when test="${userprofile.getGender() == 0}">
                                                <td>Female</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>Male</td>
                                            </c:otherwise>

                                        </c:choose>

                                        <td>${userprofile.getUser().getAccount()}</td>
                                        <td>${userprofile.phone_number()}</td>
                                        <c:choose>
                                            <c:when test="${userprofile.getUser().getRole_id() == 1}">
                                                <td>Customer</td>
                                            </c:when>
                                            <c:when test="${userprofile.getUser().getRole_id() == 2}">
                                                <td>Marketing</td>
                                            </c:when>
                                            <c:when test="${userprofile.getUser().getRole_id() == 3}">
                                                <td>Sale</td>
                                            </c:when>
                                            <c:when test="${userprofile.getUser().getRole_id() == 4}">
                                                <td>Expert</td>
                                            </c:when>

                                            <c:otherwise>
                                                <td>Admin</td>
                                            </c:otherwise>

                                        </c:choose>
                                        <td>${userprofile.getCreated()}</td>
                                        <td>${userprofile.getModified()}</td>
                                        <c:choose>
                                            <c:when test="${userprofile.getUser().getStatus() == 0}">
                                                <td><div class="activation1">Deactive</div></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><div  class="activation2">Active</div></td>
                                            </c:otherwise>
                                        </c:choose>


                                        <c:choose>
                                            <c:when test="${userprofile.getUser().getId() == sessionScope.user.getId()}">
                                                <td>THIS IS ME</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><a class="dialog-btn" href="#my-dialog2-${userprofile.getUser().getId()}"><img src="img/search.jpg"></a></td>
                                                    </c:otherwise>
                                                </c:choose>

                                    </tr>
                                <div class="dialog overlay" id="my-dialog2-${userprofile.getUser().getId()}">
                                    <!-- <a href="#" class="overlay-close"></a>-->
                                    <div class="dialog-body">
                                        <a class="dialog-close-btn" href="">&times;</a>
                                        <div class="container">
                                            <br>
                                            <form id="changeuser-${userprofile.getUser().getId()}" action="changeuserprofileadmin" method="post">
                                                <div class="add row">
                                                    <div class="col-md-4">
                                                        <c:choose>
                                                            <c:when test="${userprofile.getAvatar()== null}">
                                                                <div class="image-container">
                                                                    <img src="uploads/avatar-mac-dinh-1.png" alt="User Avatar">
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="image-container">
                                                                    <img src="uploads/${userprofile.getAvatar()}" alt="User Avatar">
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <label class="form-label">ID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <input type="text" value="${userprofile.getUser().getId()}" name="id" readonly>
                                                        <br>
                                                        <label class="form-label">Email</label>


                                                        <input type="text" value="${userprofile.getUser().getAccount()}" readonly>
                                                        <br>
                                                        <label class="form-label">Name</label>
                                                        <input type="text" name="name" value="${userprofile.getFull_name()}"readonly>
                                                        <div>
                                                            <label class="form-label">Gender</label> &nbsp&nbsp
                                                            <input type="radio" name="gender" value="0" ${userprofile.getGender() == 0 ? "checked":""} disabled>Female &nbsp;&nbsp;
                                                            <input type="radio" name="gender" value="1" ${userprofile.getGender() == 1 ? "checked":""} disabled >Male
                                                        </div>
                                                        <label class="form-label">Phone</label>
                                                        <input type="text" name="phone" value="${userprofile.phone_number()}" readonly>
                                                    </div>

                                                    <label class="form-label">Role</label>
                                                    <select class="select" name="role">                                               
                                                        <c:forEach var="list_role" items="${list_role}">
                                                            <option value="${list_role.getId()}" ${userprofile.getUser().getRole_id() == list_role.getId() ? "selected" : ""}>${list_role.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <br>
                                                    <label class="form-label">Status</label>
                                                    <select name="status" id="status">
                                                        <option value="0" ${userprofile.getUser().getStatus() == 0 ? "selected" : ""}>Deactive</option>
                                                        <option value="1" ${userprofile.getUser().getStatus() == 1 ? "selected" : ""}>Active</option>
                                                    </select>

                                                    <br><br><br>
                                                    <!--                                                    <button type="submit">Change Update</button>-->
                                                    <button type="button" onclick="openConfirmationDialog(${userprofile.getUser().getId()})">Change update</button>
                                                    <div id="confirmation-dialog-${userprofile.getUser().getId()}" class="modal">
                                                        <div class="modal-content">
                                                            <p>Are you sure?</p>
                                                            <div class="buttons">
                                                                <button id="confirm-yes-${userprofile.getUser().getId()}">Yes</button>
                                                                <button id="confirm-no-${userprofile.getUser().getId()}" onclick="modalCloseHandler(event)">No</button>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                            </tbody>

                        </table>


                    </div>

                    <div class="pagination">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <a class="${tag == i?"active":""}" href="userlist?index=${i}&status=${status}&role=${role}&gender=${gender}&search=${search}">${i}</a>
                        </c:forEach>
                    </div>

                </div>
                <%@include file="Login.jsp"%>

            </div>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="js/PopUp.js" type="text/javascript"></script>
            <script src="js/userList.js" type="text/javascript"></script>      
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


    </body>


</html>
