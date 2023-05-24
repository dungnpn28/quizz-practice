<%-- 
    Document   : Home.jsp
    Created on : May 22, 2023, 8:13:13 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <div>
        <link rel="stylesheet" href="css/Home.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>QuizPractice</title>
    </div>
    </head>
    <%@include file="components/Header.jsp"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <body>
        
        <!-- SLIDER -->
    <div class="slider">
        <input type="radio" name="images" id="i1" checked>
        <input type="radio" name="images" id="i2">
        <input type="radio" name="images" id="i3">


        <!-- slide 1 -->
        <div class="slide_img" id="one">
            <img src="http://vietnamese.cri.cn/mmsource/images/2017/06/02/d18f170450234ed1acd704f4944c4157.jpg" alt="">
            <label for="i3" class="previous"></label>
            <label for="i2" class="next"></label>
        </div>


        <!-- slide 2 -->
        <div class="slide_img" id="two">
            <img src="https://www.sagen.com.vn/Data/Sites/1/Product/250/truong-dai-hoc-fpt-binh-dinh-h2..jpg" alt="">
            <label for="i1" class="previous"></label>
            <label for="i3" class="next"></label>
        </div>


        <!-- slide 3 -->
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
    </div>


    <h4> Featured subjects <a href="">View all subjects</a></h4>
    <div class="row">
        <div class="boxContainer col-md-7">
            <div class="box">
                <div class="boxImage">
                    <img src="https://png.pngtree.com/png-vector/20201229/ourmid/pngtree-a-british-short-blue-and-white-cat-png-image_2654518.jpg" width="100%" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">                        
                    <img src="" width="100" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">                        
                    <img src="" width="100" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>           
            </div>
            <div class="box">
                <div class="boxImage">                        
                    <img src="" width="100" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">                        
                    <img src="" width="100" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">                        
                    <img src="" width="100" height="100%" alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
        </div>

        <div class="thumbnail_container">
            <div class="tn1">
                Title 
                <iframe width="300px" height="150px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>
            </div>

            <div class="tn2">
                Title 
                <iframe width="300px" height="150px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>
            </div>
            <div class="contact">
                FACEBOOK: <a href="">Links</a><br>
                CONTACT: <a href="">Links</a>
            </div>          
        </div>
    </div>

    <h4>Hot posts <a href="">View all posts</a></h4>

    <div class="post_Container">
        <div class="post_box">
            <div class="ti_da">
                <h3>Title</h3>
                <h5>DATE:</h5>
            </div>

            <div class="content">
                <div class="th_cnt">
                    <iframe width="200px" height="150px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>
                    <p class="title">
                        Description
                    </p>
                </div>
            </div>
        </div>

        <div class="post_box">
            <div class="ti_da">
                <h3>Title</h3>
                <h5>DATE:</h5>
            </div>

            <div class="content">
                <div class="th_cnt">
                    <iframe width="200px" height="150px" src="" frameborder="0" allowfullscreen class="vid1"></iframe>
                    <p class="title">
                        Description
                    </p>
                </div>
            </div>
        </div>
    </div>
        
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
