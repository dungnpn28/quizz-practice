<%-- 
    Document   : home
    Created on : May 16, 2023, 10:10:44 PM
    Author     : ADMIN
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
    </div>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
    <%@include file="components/header.jsp" %>

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
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSus7K6uN2jdBRHM2LhBtC7LAfrgTzmyMOg4GX8_uDh&s" width="100" height="120 alt="Ảnh">
                </div>
                <div class="boxContent">
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">
                    <!-- Đặt nội dung ảnh tại đây -->
                    <img src="https://images.pexels.com/photos/15770288/pexels-photo-15770288.jpeg?cs=srgb&dl=pexels-screeny-15770288.jpg&fm=jpg" width="100" height="120  " alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">
                    <!-- Đặt nội dung ảnh tại đây -->
                    <img src="https://images.pexels.com/photos/15770293/pexels-photo-15770293.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" width="100" height="120  " alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>           
            </div>
            <div class="box">
                <div class="boxImage">
                    <!-- Đặt nội dung ảnh tại đây -->
                    <img src="https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026dpr\u003d1\u0026w\u003d500" width="100" height="120  " alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">
                    <!-- Đặt nội dung ảnh tại đây -->
                    <img src="https://anhnendep.net/wp-content/uploads/2016/10/hinh-nen-dein-thoai-hoa-anh-dao-07.jpg" width="100" height="120  " alt="Ảnh">
                </div>
                <div class="boxContent">
                    <!-- Đặt nội dung khác tại đây -->
                    <h2>Tiêu đề</h2>
                    <p>Nội dung</p>
                </div>
            </div>
            <div class="box">
                <div class="boxImage">
                    <!-- Đặt nội dung ảnh tại đây -->
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQexjvhaBUFs5ZvWakftt4msuMArkusMInrg&usqp=CAU" width="100" height="120  " alt="Ảnh">
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
                <iframe width="300px" height="150px" src="https://www.youtube.com/embed/ZKjIHQxG_3Q" frameborder="0" allowfullscreen class="vid1"></iframe>
            </div>

            <div class="tn2">
                Title 
                <iframe width="300px" height="150px" src="https://www.youtube.com/embed/DVEUcbPkb-c" frameborder="0" allowfullscreen class="vid1"></iframe>
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
            <h3>Title</h3>
            <div class="content">
                <div class="th_cnt">
                    <iframe width="200px" height="150px" src="https://www.youtube.com/embed/ZKjIHQxG_3Q" frameborder="0" allowfullscreen class="vid1"></iframe>
                    <p>
                        Aas df asd fasd fasd fasd fas dfa sdf asdf asdf asdf asdd fasdfasdf asdf asdf sad fasdf as df
                    </p>
                </div>
                <h5>DATE</h5>
            </div>
        </div>

        <div class="post_box">
            thumbnail
        </div>
    </div>


</body>
<%@include file="components/footer.jsp" %>
</html>
