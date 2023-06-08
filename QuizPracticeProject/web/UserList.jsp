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

    </head>
    <body>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <%@include file="components/CusHeader.jsp"%>
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
                            <!--                            <a href="#" class="overlay-close"></a>-->
                            <div class="dialog-body">
                                <a class="dialog-close-btn" href="">&times;</a>
                                <div class="container">
                                    <br>
                                    <form action="addnew" method="post">
                                        <div class="add row">
                                            <label class="form-label">Email</label>


                                            <input type="text" placeholder="Email" required="">

                                            <label class="form-label">name</label>
                                            <input type="text" placeholder="Name" required="">
                                            <div>
                                                <label class="form-label">Gender</label> &nbsp&nbsp
                                                <input type="radio" name="gender" value="0">Female &nbsp&nbsp
                                                <input type="radio" name="gender" value="0">Male
                                            </div>
                                            <label class="form-label">Phone</label>
                                            <input type="text" placeholder="Phone number" required="">
                                            <label class="form-label">Role</label>
                                            <select class="select">                                               
                                                <c:forEach var="list_role" items="${list_role}">
                                                    <option value="${list_role.getId()}">${list_role.name}</option>
                                                </c:forEach>
                                            </select>
                                            <label class="form-label">Status</label>
                                            <select name="status" id="status" >

                                                <option value="0" >Deative</option>
                                                <option value="1">Active</option>

                                            </select>
                                        </div>
                                        <br>
                                        <button type="submit" name="submit">CREATE</button>

                                    </form>
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

                                        <c:choose>
                                            <c:when test="${userprofile.getUser().getStatus() == 0}">
                                                <td><div class="activation1">Deactive</div></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><div  class="activation2">Active</div></td>
                                            </c:otherwise>
                                        </c:choose>



                                        <td><a class="dialog-btn" href="#my-dialog2-${userprofile.getUser().getId()}"><img src="img/search.jpg"></a></td>


                                    </tr>
                                <div class="dialog overlay" id="my-dialog2-${userprofile.getUser().getId()}">
                                    <!--                            <a href="#" class="overlay-close"></a>-->
                                    <div class="dialog-body">
                                        <a class="dialog-close-btn" href="">&times;</a>
                                        <div class="container">
                                            <br>
                                            <form action="addnew" method="post">
                                                <div class="add row">
                                                    <label class="form-label">Email</label>


                                                    <input type="text" value="${userprofile.getUser().getAccount()}" readonly>

                                                    <label class="form-label">name</label>
                                                    <input type="text" value="${userprofile.getFull_name()}"readonly>
                                                    <div>
                                                        <label class="form-label">Gender</label> &nbsp&nbsp
                                                        <input type="radio" name="gender" value="0" ${userprofile.getGender() == 0 ? "checked":""} disabled>Female &nbsp;&nbsp;
                                                        <input type="radio" name="gender" value="1" ${userprofile.getGender() == 1 ? "checked":""} disabled >Male
                                                    </div>
                                                    <label class="form-label">Phone</label>
                                                    <input type="text" value="${userprofile.phone_number()}" readonly>
                                                    <label class="form-label">Role</label>
                                                    <select class="select">                                               
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
                                                    <button>Change update</button>
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
            </div>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

            <script type="text/javascript">
                                $(document).ready(function () {
                                    $('#sidebarCollapse').on('click', function () {
                                        $('#sidebar').toggleClass('active');
                                    });
                                });
            </script>
            <script>
                function applyFilters() {
                    var genderSelect = document.getElementById("gender");
                    var roleSelect = document.getElementById("role");
                    var statusSelect = document.getElementById("status");
                    var searchInput = document.getElementById("searchInput");

                    var gender = genderSelect.options[genderSelect.selectedIndex].value;
                    var role = roleSelect.options[roleSelect.selectedIndex].value;
                    var status = statusSelect.options[statusSelect.selectedIndex].value;
                    var search = searchInput.value;




                    // Build your base URL
                    var baseUrl = "userlist?";

                    if (gender !== "all") {
                        baseUrl += "gender=" + gender + "&";
                    }
                    if (role !== "all") {
                        baseUrl += "role=" + role + "&";
                    }
                    if (status !== "all") {
                        baseUrl += "status=" + status + "&";
                    }
                    if (search.trim() !== "") {
                        baseUrl += "search=" + encodeURIComponent(search.trim()) + "&";
                    }

                    baseUrl = baseUrl.slice(0, -1);
                    localStorage.setItem("gender", gender);
                    localStorage.setItem("role", role);
                    localStorage.setItem("status", status);
                    localStorage.setItem("search", search);



                    // Redirect to the filtered URL
                    window.location.href = baseUrl;
                }


            </script>
            <script src="js/PopUp.js"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


    </body>


</html>
