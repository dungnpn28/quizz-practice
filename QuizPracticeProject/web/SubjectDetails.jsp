<%@page import= "java.util.List" %>
<%@page import = "model.Subject" %>
<%@page import = "model.Price_Package" %>
<%@page import = "java.util.*" %>
<%@page import = "dal.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    //SubjectDetailDAO u = new SubjectDetailDAO(); 
  List<Subject> lst = (List<Subject>)request.getAttribute("lst");
//  List<String> cols = u.getColNames("Subject"); 
%>   

<html>
    <head>
        <title>Subject Details</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    </head>
    <%
if (session.getAttribute("user") != null) {
   // Nếu có user, bao gồm trang cusheader.jsp
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
    <body>
        <div class="navbar2">
            <div class="container2">
                <span class="navbar2-brand"><a href="cusHome">Home</a></span>
                <span class="navbar2-brand-divider ">/</span>
                <span class="navbar2-brand-divider ">/</span>
                <span class="navbar2-brand">Subject Detail</span>
            </div>
        </div>
        <div class="container container1">
            <div class="sidebar">
                <div class="search-box">
                    <form action="SearchSubjectName" method="POST">
                        <input type="text" name="SubjectName" placeholder="Enter subject name...">
                        <button type="submit">Search</button>
                    </form>
                </div>
                <div class="widget">
                    <h2 class="widget-title">List</h2>
                    <form action="subject" method="POST">
                        <p>Sort by: 
                      
                        <p>
                        <p>Sorting type:
                        <p>
                            <input type="radio" name="sortType" value="ASC" checked="" /> Ascendingly
                        <p>
                            <input type="radio" name="sortType" value="DESC" /> Descendingly
                        <p>
                            <input type="submit" value="Sort">
                    </form>
                </div>
<!--                <div class="widget">
                    <h2 class="widget-title">Rate</h2>
                    <div class="rating">
                        <input type="radio" id="star1" name="rating" value="1">
                        <label for="star1" title="1 star">&#9733;</label>
                        <input type="radio" id="star2" name="rating" value="2">
                        <label for="star2" title="2 stars">&#9733;</label>
                        <input type="radio" id="star3" name="rating" value="3">
                        <label for="star3" title="3 stars">&#9733;</label>
                        <input type="radio" id="star4" name="rating" value="4">
                        <label for="star4" title="4stars">&#9733;</label>
                        <input type="radio" id="star5" name="rating" value="5" checked>
                        <label for="star5" title="5 stars">&#9733;</label>
                    </div>
                </div>
                <div class="widget">
                    <h2 class="widget-title">Comment</h2>
                    <ul style="list-style: none">
                        <li>bổ ích quá</li>
                        <li>rất thú vị cảm ơn tác giả</li>
                    </ul>
                </div>-->
                <!--                <div class="widget">
                                        <div class="last">                
                                            <h2 class="widget-title"  >Last Post</h2>                
                                            <div class="card-body">
                                                <img src="${last.image}" alt="Post thumbnail">
                                                <h2><a style=" text-decoration: none" href="detail?bid=${last.blogid}" title="View Post">${last.title}</a></h2>
                                                <p style="font-size: 10px;">${last.briefInfor}</p>
                                            </div>                          
                                        </div>
                                    </div>-->
            </div>
            <div class="post">
                <div class="post-image">
                    <img src="${SubjectDetails.illustration}" alt="img">
                </div>

                <h1>${SubjectDetails.name}</h1>
                <p> <strong>Price:</strong> ${SubjectDetails.price}</p>
                <p>  <strong>Sale:</strong> $${"{:.2f}".format(SubjectDetails.price * 0.95)}</p>

                <p><strong> Detail:</strong></p>
                <p>${SubjectDetails.description}</p>
                <div class="author">
                    <p><strong>Status:</strong> ${SubjectDetails.status ? "Enroll" : "Unenroll" }</p>


                </div>
                <div style="text-align: center;">
                    <form  method="POST" action="submit">
                        <input type="hidden" name="subjectId" value="${SubjectDetails.subjectId}">
                        <button type="submit" ${SubjectDetails.status ? "disabled" : ""} onclick="return confirm('Are you sure you want to enroll?')">Enroll</button>
                    </form>     
                </div>
            </div>
        </div>
        <%@include file="components/Footer.jsp" %>
    </body>
</html>