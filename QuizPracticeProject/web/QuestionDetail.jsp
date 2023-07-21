<%-- 
    Document   : QuestionDetail
    Created on : Jul 19, 2023, 2:43:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <%@include file="components/CusHeader.jsp"%>

        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>


            <div id="content">     


                <h1>EDIT QUESTION</h1>
                <br><br>
                <form action="questiondetail" method="post">
                    <div class="row d-flex justify-content-center">

                        <input type="hidden" name="id" value="${question.id}">

                        <div class="col-md-4">
                            <h1>Question Information</h1>
                            <!-- Three Select Elements -->

                            <label>Subject</label>
                            <p1>${question.subjectId}</p1>
                            <select name="subjectId" class="form-select mb-3 form-select-lg">
                                <c:forEach var="list_subject" items="${list_subject}">                              
                                    <option value="${list_subject.id}" ${list_subject.id == question.subjectId? "selected": ""}>${list_subject.name}</option>
                                </c:forEach>

                            </select>
                            <label>Status</label>
                            <select name="status" class="form-select mb-3 form-select-lg">                             

                                <option value="false"${question.status == false?"selected":""}>Deactive</option>
                                <option value="true" ${question.status == true?"selected":""}>Active</option>

                            </select>
                            <label>Level</label>
                            <select name="level" class="form-select mb-3 form-select-lg">                        
                                <option value="easy" ${question.level eq "easy"?"selected":""}>Easy</option>
                                <option value="medium" ${question.level eq "medium"?"selected":""}>Medium</option>
                                <option value="hard" ${question.level eq "hard"?"selected":""}>Hard</option>
                            </select>
                        </div>

                        <!-- Right Side -->
                        <div class="col-md-4">
                            <h1>Question Details</h1>
                            <!-- Two Text Areas -->
                            <label>Question content</label>
                            <textarea name="content" class="form-control mb-3" rows="5" placeholder="Text Area 1" required>${question.content}</textarea>
                            <label>Question explaination</label>
                            <textarea name="explaination" class="form-control mb-3" rows="5" placeholder="Text Area 2">${question.answer_explaination}</textarea>
                            <br>
                            <label>ANSWERS</label>
                            <div class="form-check mb-3">
                                <input class="form-check-input" name="answer" type="radio" value="a" ${question.optionA eq question.answer ?"checked":""}>
                                <input type="text" name="optionA" class="form-control" placeholder="Input Text 1" value="${question.optionA}" required>
                            </div>




                            <div class="form-check mb-3">
                                <input class="form-check-input" name="answer" type="radio"  value="b" ${question.optionB eq question.answer ?"checked":""}>
                                <input type="text" name="optionB" class="form-control" placeholder="Input Text 2" value="${question.optionB}" required>
                            </div>


                            <div class="form-check mb-3">
                                <input class="form-check-input" name="answer" type="radio" value="c" ${question.optionC eq question.answer ?"checked":""}>
                                <input type="text" name="optionC" class="form-control" placeholder="Input Text 3" value="${question.optionC}" required>
                            </div>


                            <div class="form-check mb-3">
                                <input class="form-check-input" name="answer" type="radio" value="d" ${question.optionD eq question.answer ?"checked":""}>
                                <input type="text" name="optionD" class="form-control" placeholder="Input Text 4" value="${question.optionD}"required>
                            </div>
                            <br>
                            <div class="form-check mb-3">
                                <button class="btn btn-primary" type="submit">SAVE</button> &nbsp;&nbsp;&nbsp;
                                <button class="btn btn-danger">Cancel</button>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
        <script src="js/navBar.js"></script>

    </body>
</html>
