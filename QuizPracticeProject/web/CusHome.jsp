<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <div>
        <link rel="stylesheet" href="css/CusHome.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
    </div>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
    <%@include file="components/CusHeader.jsp" %>

    <!-- SLIDER -->
    <div class="slider">
        <input type="radio" name="images" id="i1" checked>
        <input type="radio" name="images" id="i2">
        <input type="radio" name="images" id="i3">


        <!-- slide 1 -->
        <div class="slide_img" id="one">
            <img src="" alt="">
            <label for="i3" class="previous"></label>
            <label for="i2" class="next"></label>
        </div>


        <!-- slide 2 -->
        <div class="slide_img" id="two">
            <img src="" alt="">
            <label for="i1" class="previous"></label>
            <label for="i3" class="next"></label>
        </div>


        <!-- slide 3 -->
        <div class="slide_img" id="three">
            <img src="" alt="">
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
                    <img src="" width="100%" height="100%" alt="Ảnh">
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
                <image>
            </div>

            <div class="tn2">
                Title 
                <img>
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
                    <img>
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
                    <img>
                    <p class="title">
                        Description
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
<%@include file="components/Footer.jsp" %>x
</html>
