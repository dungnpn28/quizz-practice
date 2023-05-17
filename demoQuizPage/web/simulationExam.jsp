<%-- 
    Document   : simulationExam
    Created on : May 17, 2023, 8:41:31 AM
    Author     : LENOVO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulation Exam</title>
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <body>
        <h2> existing exams </h2>
        <style>
            table {
                border-collapse: collapse;
            }

            td {
                padding: 10px; /* Khoảng cách trong ô */
                width: 200px; /* Rộng của ô */
            }
            .rectangle-box {
                border: 1px solid #ccc;
                padding: 10px;
                width: 300px;
            }

            .input-group {
                margin-bottom: 10px;
            }

            .input-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .input-group input {
                width: 100%;
                padding: 5px;
            }

            .list-item {
                margin-bottom: 5px;
            }
        </style>
        <div class="col-md-8">
            <table border="1">
                <tr>
                    <td> ID </td>
                    <td> subject </td>
                    <td> simulation exam </td>
                    <td> level </td>
                    <td> #question </td>
                    <td> duration </td>
                    <td> pass rate </td>
                </tr>
            </table>
        </div>
        <div class="col-md-4">

            <div class="rectangle-box">
                <div class="input-group">
                    <label for="filterByTopic">Lọc theo chủ đề:</label>
                    <input type="text" id="filterByTopic" placeholder="Nhập chủ đề">
                </div>

                <div class="input-group">
                    <label for="searchItems">Tìm kiếm bài kiểm tra:</label>
                    <input type="text" id="searchItems" placeholder="Nhập tên bài kiểm tra">
                </div>

               
            </div>
        </div>
    </body>
    
</html>
