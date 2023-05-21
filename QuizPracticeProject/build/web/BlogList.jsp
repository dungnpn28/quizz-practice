<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
    <div>
        <link rel="stylesheet" href="css/BLogList.css" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
    </div>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
    <%@include file="components/header.jsp" %>
    <div class="blog_list">
        <div class="boxContainer col-md-7">
            <div class="box">
                <div class="video">
                    <video></video>
                </div>
                <div class="content">
                    <h4>TITLE</h4>
                    <p>brief-info</p>
                </div>
            </div>
            
            <div class="box">
                <div class="video">
                    <video></video>
                </div>
                <div class="content">
                    <h4>TITLE</h4>
                    <p>brief-info</p>
                </div>
            </div>
            
            <div class="box">
                <div class="video">
                    <video></video>
                </div>
                <div class="content">
                    <h4>TITLE</h4>
                    <p>brief-info</p>
                </div>
            </div>
            
            <div class="box">
                <div class="video">
                    <video></video>
                </div>
                <div class="content">
                    <h4>TITLE</h4>
                    <p>brief-info</p>
                </div>
            </div>
        </div>
        
        <div class="search">
            <form>
                <input type="text" name="search" placeholder="search..." class="search_box">
                <select>
                    <option>C#</option>
                    <option>Java</option>
                    <option>Python</option>
                    <option>C++</option>
                    <option>C</option>
                </select>
            </form>
        </div>
        
    </div>
</body>
<%@include file="components/footer.jsp" %>
</html>
