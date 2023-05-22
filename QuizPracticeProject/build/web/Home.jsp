<%-- 
    Document   : Home.jsp
    Created on : May 22, 2023, 8:13:13 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
=======
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/Home.css" type="text/css"/>
>>>>>>> parent of ab65327 (del)
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< HEAD
        <h1>Hello World!</h1>
=======
        <%@include file="components/Header.jsp" %>



        <!-- SLIDER -->

        <!--    <div class="slider">
                <input type="radio" name="images" id="i1" checked>
                <input type="radio" name="images" id="i2">
                <input type="radio" name="images" id="i3">
        
        
                 slide 1 
                <div class="slide_img" id="one">
                    <img src="http://vietnamese.cri.cn/mmsource/images/2017/06/02/d18f170450234ed1acd704f4944c4157.jpg" alt="">
                    <label for="i3" class="previous"></label>
                    <label for="i2" class="next"></label>
                </div>
        
        
                 slide 2 
                <div class="slide_img" id="two">
                    <img src="https://www.sagen.com.vn/Data/Sites/1/Product/250/truong-dai-hoc-fpt-binh-dinh-h2..jpg" alt="">
                    <label for="i1" class="previous"></label>
                    <label for="i3" class="next"></label>
                </div>
        
        
                 slide 3 
                <div class="slide_img" id="three">
                    <img src="https://uni.fpt.edu.vn/Data/Sites/1/media/1-anh/133136198_156947376226863_5664584930400544253_n.jpg" alt="">
                    <label for="i2" class="previous"></label>
                    <label for="i1" class="next"></label>
                </div>
        
                <div class="nav">
                    <label class="dots" id="dot1" for="i1"></label>
                    <label class="dots" id="dot2" for="i2"></label>
                    <label class="dots" id="dot3" for="i3"></label>
        
                </div>
            
        
        
        
                 <input type="radio" name="slider" id="slider1" checked>
                <input type="radio" name="slider" id="slider1">
                <input type="radio" name="slider" id="slider1">
                <input type="radio" name="slider" id="slider1"> 
        
            </div>-->
        <div class="row">
            <div class="boxContainer col-md-7">
                <div class="box">
                    <div class="image">
                        <!-- Đặt nội dung ảnh tại đây -->

                    </div>
                    <div class="content">
                        <!-- Đặt nội dung khác tại đây -->
                        <h2>Tiêu đề</h2>
                        <p>Nội dung</p>
                    </div>
                </div>
                <div class="box">Ô 2</div>
                <div class="box">Ô 3</div>
                <div class="box">Ô 4</div>
                <div class="box">Ô 5</div>
                <div class="box">Ô 6</div>
            </div>
        </div>
        <div class="overlay" id="divOne">
            <div class="wrapper">
                <%@include file="Login.jsp" %>
            </div>
        </div>
        <%@include file="components/Footer.jsp" %>
>>>>>>> parent of ab65327 (del)
    </body>
</html>
