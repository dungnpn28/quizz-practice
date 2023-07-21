<%-- 
    Document   : AddNewQuizDetails
    Created on : Jul 11, 2023, 10:19:32 AM
    Author     : dai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import= "model.*"%>
<%@page import= "dal.*"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/LessonDetails.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizzero</title>
    </head>
    <body>


        <%@include file="components/CusHeader.jsp" %>
    <body>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1>ADD QUIZ</h1>
                <div class="quiz-detail">
                    <form class="form-wrapper" id="editQuiz" name="editQuiz" action="addnewquizdetailsae" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input name="name" type="text" class="form-control" id="name" required>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <select name="selectedSubject" id="selectedSubject" required>
                                <c:forEach items="${lSubject}" var="subject">
                                    <option value="${subject.id}">${subject.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="level" class="form-label">Exam level</label>                          
                            <select name="level" required>
                                <option value="1">1</option>
                                <option value="2">2</option>                                  
                                <option value="3">3</option>                                  
                                <option value="4">4</option>                                  
                                <option value="5">5</option>                                  
                            </select>                           
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="duration" class="form-label">Duration(minutes)</label>
                            <input name="duration" type="text" class="form-control" id="duration" required>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="passrate" class="form-label">Pass Rate</label>
                            <input name="passrate" type="text" class="form-control" id="passrate" required>
                        </div>
                        <br>                

                        <br>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea name="description" class="form-control" type="text" rows="10" cols="80" id="description" value="" required></textarea>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="questions" class="form-label">Number of questions</label>
                            <input name="questions" type="text" class="form-control" id="questions" required>      
                        </div>
                        <div class="mb-3">
                            <label for="questype" class="form-label">Question type</label>

                            <c:forEach items="${lDimension}" var="type">
                                <input type="radio" name="questionType" value="${type.id}">${type.name}</option>
                            </c:forEach>

                        </div>

                        <div id="formContainer">
                            <div class="form-row mb-2 d-flex">

                                <div class="col">
                                    <select id="selectOption" class="form-control" name="selectOption0">

                                        <option value="option1">Option 1</option>
                                        <option value="option2">Option 2</option>
                                        <option value="option3">Option 3</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <input type="number" id="inputNumber" name="inputNumber0" class="form-control" placeholder="Number of Questions">
                                </div>

                                <div class="col">
                                    <button class="btn btn-primary"  onclick="addRow()">Add</button>
                                </div>
                            </div>
                        </div>

                        <div class="button-group">
                            <input type="submit" class="btn btn-primary" value="Add" onclick ="return confirm('Are you sure you want to update?')">
                            <a href="javascript:history.go(-1)" class="btn btn-danger">Back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script>
        function addRow() {
            var selectOption = document.getElementById('selectOption').value;
            var inputNumber = document.getElementById('inputNumber').value;

            var formContainer = document.getElementById('formContainer');
            var rows = Array.from(formContainer.getElementsByClassName('form-row')); // Chuyển HTMLCollection thành mảng

            var newRow = document.createElement('div');
            newRow.className = 'form-row mb-2 d-flex';

            var selectColumn = document.createElement('div');
            selectColumn.className = 'col';
            var selectClone = document.getElementById('selectOption').cloneNode(true);
            selectClone.name = 'selectOption' + rows.length;
            selectClone.value = selectOption;
            selectColumn.appendChild(selectClone);
            newRow.appendChild(selectColumn);

            var inputColumn = document.createElement('div');
            inputColumn.className = 'col';
            var inputClone = document.getElementById('inputNumber').cloneNode(true);
            inputClone.name = 'inputNumber' + rows.length;
            inputClone.value = inputNumber;
            inputColumn.appendChild(inputClone);
            newRow.appendChild(inputColumn);

            var deleteColumn = document.createElement('div');
            deleteColumn.className = 'col';
            var deleteButton = document.createElement('button');
            deleteButton.className = 'btn btn-danger';
            deleteButton.innerHTML = 'Delete';
            deleteButton.onclick = function () {
                deleteRow(newRow);
                updateClasses();
            };
            deleteColumn.appendChild(deleteButton);
            newRow.appendChild(deleteColumn);

            formContainer.appendChild(newRow);

            // Cập nhật lại các class cho tất cả các dòng
            updateClasses();
        }

        function deleteRow(row) {
            var formContainer = document.getElementById('formContainer');
            formContainer.removeChild(row);

            // Cập nhật lại các class cho tất cả các dòng sau khi xóa
            updateClasses();
        }

        function updateClasses() {
            var formContainer = document.getElementById('formContainer');
            var rows = Array.from(formContainer.getElementsByClassName('form-row')); // Chuyển HTMLCollection thành mảng

            for (var i = 0; i < rows.length; i++) {
                rows[i].classList.remove('row-' + i); // Xóa lớp cũ
                rows[i].classList.add('row-' + i); // Cập nhật lớp mới
            }
        }

// Gọi hàm addRow() ban đầu để hiển thị dòng đầu tiên


// Gọi hàm addAddRowBut
    </script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/navBar.js" type="text/javascript"></script>
</body>
</html>
