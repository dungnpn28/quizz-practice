<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <div>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/Home.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
    </div>
</head>
<body>
    <%@include file="components/header.jsp" %>
    <style>
        .boxContainer {
            display: grid;
            grid-template-columns: repeat(3, 1fr); /* Chia thành 3 cột có độ rộng bằng nhau */
            grid-template-rows: repeat(2, 1fr); /* Chia thành 2 hàng có chiều cao bằng nhau */
            gap: 10px; /* Khoảng cách giữa các ô */
        }

        .box {
            display: flex;
            background-color: #ccc;
            padding: 20px;
        }
        .image {
            flex: 1; /* Chiếm 50% chiều rộng */
        }

        .content {
            flex: 1; /* Chiếm 50% chiều rộng */
        }
    </style>
    <!-- SLIDER -->
    <div class="slider">
        <input type="radio" name="images" id="i1" checked>
        <input type="radio" name="images" id="i2">
        <input type="radio" name="images" id="i3">


<!--         slide 1 
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

        </div>-->




        <!-- <input type="radio" name="slider" id="slider1" checked>
        <input type="radio" name="slider" id="slider1">
        <input type="radio" name="slider" id="slider1">
        <input type="radio" name="slider" id="slider1"> -->

    </div>
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
            <%@include file="Register.jsp" %>
        </div>
    </div>
    
    <%@include file="components/footer.jsp" %>
</body>
</html>
