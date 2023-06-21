<%-- 
    Document   : ChangeBlogDetail
    Created on : Jun 18, 2023, 5:05:00 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/ChangeBlogDetail.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
        if (session.getAttribute("user") != null) {
        // Nếu có user, bao gồm trang cusheader.jsp
            session.getAttribute("up");  
        %>
        <%
        }
        %>
        <%@ include file="components/CusHeader.jsp" %>
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
                        <div class="header-container">
                            <h1><a href="BlogListController">Blog list </a></h1>  
                            <h1> / </h1>
                            <h1><a href="blogDetail?id=${id}">Details </a></h1>
                        </div>
                        <p></p>
                        <!--<img src = "${blog.thumbnail}" alt="Can't display image" class="center" style="height:350px; width:750px">-->        

                        <form action="changeBlogDetail" method="post" enctype="multipart/form-data" id="changeDetailForm">          
                            <div class="image-upload">
                                <input type="file" name="thumbnail" id="imageUpload" accept="image/*"  onchange="loadFile(event)">
                                <label for="imageUpload">
                                    <img id="imagePreview" src="uploads/${blog.thumbnail}" class="img-fluid">
                                    <span class="btn btn-primary">Upload Image</span>
                                </label>
                            </div>
                            <div class="mb-3">
                                <label for="" class="form-label">Title</label>
                                <input name="title" value="${blog.title}" class="form-control" id="" aria-describedby="" required>
                            </div>
                            <div class="mb-3">
                                <label for="category" class="form-label">Category</label>
                                <select class="form-select" id="category" name="category" required>
                                    <option value="${blog.category_id}" hidden>${categoryName}</option>
                                    <c:forEach var="category" items="${listCategory}">
                                        <c:if test="${category.getId() != blog.category_id}">
                                            <option value="${category.getId()}">${category.getName()}</option>
                                        </c:if>


                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="" class="form-label">Brief Information</label>
                                <textarea name="brief_info" class="form-control" id="" aria-describedby="" required>${blog.brief_info}</textarea>
                            </div>
                            <div class="mb-3">
                                <label for="" class="form-label">Content</label>
                                <textarea name="content" class="form-control" id="" aria-describedby="" required>${blog.content}</textarea>
                            </div>
                            <div class="form-check mb-3">
                                <input class="form-check-input" type="checkbox" id="featured" name="flag" ${blog.flag == '1' ? 'checked' : ''}>
                                <label class="form-check-label" for="featured">Featured</label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Status: </label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="status1" value="1" ${blog.status ? 'checked' : ''}>
                                    <label class="form-check-label" for="status1">Active</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" id="status2" value="0" ${!blog.status ? 'checked' : ''}>
                                    <label class="form-check-label" for="status2">Inactive</label>
                                </div>
                            </div>
                            <input type="hidden" name="id" value="${id}">
                            <button type="submit" class="btn btn-primary">Update</button><br/>
                        </form>
                    </div>
                </div>
                <%@include file = "Login.jsp"%> 

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/navBar.js"></script>
        <script>
                                    var loadFile = function (event) {
                                        var output = document.getElementById('imagePreview');
                                        output.src = URL.createObjectURL(event.target.files[0]);
                                        output.onload = function () {
                                            URL.revokeObjectURL(output.src) // free memory
                                        }
                                    };
        </script>
        <script>
            // Gắn sự kiện "submit" vào form khi người dùng ấn submit
            var formElement = document.getElementById("changeDetailForm");
            formElement.addEventListener("submit", function (event) {
                if (!confirm("Are you sure you want to submit?")) {
                    event.preventDefault(); // Hủy sự kiện submit nếu người dùng không đồng ý
                }
            });
        </script>
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
