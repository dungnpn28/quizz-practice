<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "model.UserProfile"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="model.UserProfile"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel="stylesheet" href="css/CusHeader.css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <title>Quizzero</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%
            UserProfile a = null;
            User u = null;
            if(session.getAttribute("user") != null) {
                u = (User) session.getAttribute("user");
            }
            UserProfileDAO upd = new UserProfileDAO();
            UserProfile up = upd.getUserProfile(u.getId());
            session.setAttribute("up", up);

            if(session.getAttribute("up") != null) {
               a = (UserProfile) session.getAttribute("up");
            }
            String gd = "";
            int gender = up.getGender();
            if (gender == 1) {
                gd = "male";
            } else {
                gd = "female";
            }
            
        %>




        <div class="header_content">
            <div>
                <a href="cusHome"><img src="img\2.png" class="header_logo"></a>
                <svg xmlns="http://www.w3.org/2000/svg" id="sidebarCollapse" width="40" height="40" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                </svg>
            </div>

            <div class="header_menu">
                <ul>
                    <li><a href="BlogListController">Post</a></li>
                    <li><a href="subjectListPublic">Subject</a></li>
                    <li><a href="practiceList">Practice List</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="uploads/<%=a.getAvatar()%>" width="60" height="60" alt="Avatar">
                </button>

                <ul class="dropdown-menu dropdown-menu-lg" aria-labelledby="dropdownMenuButton">
                    <li class="d-flex justify-content-center" style="font-weight: bold;font-size: 10px"><%=a.getFull_name()%></li><br>
                    <li class="d-flex" ><img src="img/profile.png" style="width: 20px" alt=""><a class="dropdown-item" href="UserProfile.jsp">VIew profile</a></li>
                    <li class="d-flex"><img src="img/setting.png" style="width: 20px" alt=""><a class="dropdown-item" href="#" id="popUpLink">Change password</a></li>
                    <li class="d-flex"><img src="" style="width: 20px" alt=""><a class="dropdown-item" href="myRegistration">My registration</a></li>
                    <li class="d-flex"><img src="img/logout.png" style="width: 20px" alt=""><a class="dropdown-item" href="logout">Log out</a></li>

                </ul>
            </div>
            <script>
                let submenu = document.getElementById("submenu");
                function toggleMenu() {
                    submenu.classList.toggle("open_menu");
                }
            </script>
            <div id="popUpModal" class="modal_popUp">
                <div class="modal-content_popUp">

                    <h2>Change password</h2>

                    <form id="changePasswordForm" method="POST" action="changePassword">

                        Old password<input type="password" name="oldPass" placeholder="Old password" required><br/>
                        New password<input type="password" name="pass1" placeholder="new password" required><br/>
                        New password again<input type="password" name="pass2" placeholder="new password again" required>
                        <br/>
                        <button style="background: linear-gradient(to right, #5CE1E6, #0578A4)" type="submit">Change</button>
                        <button class="close-popup" style="background-color: #e64545">&times; Cancel</button>
                    </form>
                    <div id="errorMessage" class="error-message"></div>
                </div>
            </div>


            <div id="PopUpProfile" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header" >						
                            <h2 class="modal-title" id="exampleModalLabel">Information</h2>
                        </div>
                        <div class="modal-body">					
                            <div class="row">
                                <form action="changeUserProfile" method="post" enctype="multipart/form-data">
                                    <div class="col-md-5">
                                        <div class="col text-center">
                                            <img id="imagePreview" src="uploads/<%=up.getAvatar()%>" width="200" height="250">
                                            <br>
                                            <input name="avatar" type="file" accept="image/*"  onchange="loadFile(event)">
                                        </div>
                                    </div>
                                    <div class="col-md-7" class="info">
                                        <p> Email: <input name="email" type="email" value="<%=u.getAccount()%>" disabled >
                                        <p> Full Name: <input name="fullname" type="text" value="<%=up.getFull_name()%>" >
                                        <p> Phone number: <input name="phonenum" type="tel"value="<%=up.phone_number()%>" >
                                            ${requestScope.tbao}
                                        <p> Dob: <input name="dob" type="date" value="<%=up.getDob()%>" >
                                        <p> Gender: 
                                            <%if (gender == 1) {%>
                                            <input type="radio" name="radB1" value="male" checked />Male
                                            <input type="radio" name="radB1" value="female" />Female
                                            <% }else {   %>                                         
                                            <input type="radio" name="radB1" value="male"  />Male
                                            <input type="radio" name="radB1" value="female" checked/>Female
                                            <% }%>
                                            <br/>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                                            <button type="submit" class="btn btn-primary">Save</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>    
                </div>
            </div>


            <script>
                var closeBtn = document.querySelector('.close-popup');
                var popUpModal = document.getElementById('popUpModal');

                closeBtn.addEventListener('click', function () {
                    popUpModal.style.display = 'none';
                });
            </script>
            <script>
                const sidebarCollapse = document.getElementById("sidebarCollapse");

                sidebarCollapse.addEventListener("click", function () {
                    this.classList.toggle("active");
                });
            </script>

        </div>
        <script src="js/PopUp.js" type="text/javascript"></script>
        <script src="js/PreviewImage.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

    </body>

</html>
