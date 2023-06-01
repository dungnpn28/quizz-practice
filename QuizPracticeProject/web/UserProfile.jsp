<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.UserProfile"%>
<%@page import="dal.UserProfileDAO"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <%
            User u = null;
            if(session.getAttribute("user") != null) {
                u = (User) session.getAttribute("user");
            }
            UserProfileDAO upd = new UserProfileDAO();
            UserProfile up = upd.getUserProfile(u.getId());
            String gd = "";
            int gender = up.getGender();
            if (gender == 1) {
                gd = "male";
            } else {
                gd = "female";
            }
        %>
       
        <a href="#PopUp" class="btn btn-primary" data-toggle="modal">Profile</a>
        <a href="#">
            <div id="PopUp" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header" >						
                            <h2 class="modal-title" >Information</h2>
                        </div>
                        <div class="modal-body">					
                            <div class="row">
                                <form action="changeUserProfile" method="post" enctype="multipart/form-data" >
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
        </a>
      
    </body>
    <script src="js/PreviewImage.js" type="text/javascript"></script>
</html>
