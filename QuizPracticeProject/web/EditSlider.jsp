<%-- 
    Document   : SliderEdit
    Created on : Jun 6, 2023, 2:42:29 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/SliderListAd.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@ include file="components/CusHeader.jsp" %>

        <div class="container">

            <form action="editSlider" method="post" enctype="multipart/form-data" id="changeDetailForm">                
                <div class="mb-3">
                    <label for="" class="form-label">Title</label>
                    <input name="title" value="${listSlider.title}" class="form-control" id="" aria-describedby="">
                </div>

                <div class="image-upload">
                    <input type="file" name="thumbnail" id="imageUpload" accept="image/*"  onchange="loadFile(event)">
                    <label for="imageUpload">
                        <img id="imagePreview" src="uploads/${listSlider.image}" class="img-fluid">
                        <span class="btn btn-primary">Upload Image</span>
                    </label>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Backlink</label>
                    <input name="backlink" value="${listSlider.backlink}" class="form-control" id="">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Notes</label>
                    <input name="note" value="${listSlider.note}" class="form-control" id="">
                </div>
                <div class="mb-3">
                    <label class="form-label">Status: </label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="status" id="status1" value="1" ${listSlider.status ? 'checked' : ''}>
                        <label class="form-check-label" for="status1">Active</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="status" id="status2" value="0" ${!listSlider.status ? 'checked' : ''}>
                        <label class="form-check-label" for="status2">Inactive</label>
                    </div>
                </div>

                <input hidden name="sid" value="${listSlider.getId()}" class="form-control">

                <button type="submit" class="btn btn-primary">Update</button><br/>
            </form>
        </div>
        <br/><button class="custom-button mb-3"><a href="sliderList" style="text-decoration: none"> < Back to Slider list</a></button>
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