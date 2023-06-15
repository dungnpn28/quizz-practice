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

    </head>
    <body>
        <%@ include file="components/CusHeader.jsp" %>

        <div class="container">

            <form action="editSlider" method="post">                
                <div class="mb-3">
                    <label for="" class="form-label">Title</label>
                    <input name="title" value="${listSlider.title}" class="form-control" id="" aria-describedby="">
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Image Link</label>
                    <input name="img" value="${listSlider.image}" class="form-control" id="">
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Backlink</label>
                    <input name="backlink" value="${listSlider.backlink}" class="form-control" id="">
                </div>

                <input hidden name="sid" value="${listSlider.getId()}" class="form-control">

                <button type="submit" class="btn btn-primary">Update</button><br/>

            </form>
        </div>
        <br/><button class="custom-button mb-3"><a href="sliderList" style="text-decoration: none"> < Back to Slider list</a></button>

    </body>
    <%@include file="components/Footer.jsp" %>

</html>