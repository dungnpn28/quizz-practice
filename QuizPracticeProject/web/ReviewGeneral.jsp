<%-- Document : ReviewGeneral Created on : Jun 18, 2023, 11:05:14 PM Author : Acer --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Review</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <link rel="stylesheet" href="css/ReviewGeneral.css" type="text/css" />
        <script src="js/QuizHandle.js"></script>
    </head>

    <body>
        <main>

            <div class="header-container">  
                <div class="logo w-100 h-auto col-md-2">
                    <img href="quizhandle" src="img/1.png" alt="logo" />
                </div>
                <div class="exam-name w-100 h-auto col-md-4">
                    <h4>
                        <span>Exam Name:</span> ${examname}
                    </h4>
                    <h4>
                        <span>Attempt ID:</span> ${attId} 
                    </h4>
                </div>


                <div class="exam-mark w-100 h-auto col-md-3">
                    <h4>
                        <span>Mark:</span> ${examscore} 
                    </h4>
                </div>
                <div class="exit-button w-100 h-auto col-md-3">
                    <button onclick="openExitPopup()">X</button>
                    <div id="exit-popup" class="exit-popup-overlay">
                        <div class="exit-popup-content">
                            <div class="exit-header">
                                <h2>Exit Review?</h2>
                            </div>
                            <div class="exit-popup-button">
                                <button onclick="closeExitPopup()">Continue Reviewing</button>
                                <a id="exit-immediate" href="simulationexam">Yes</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <c:forEach var="question" items="${questionL}">
                <div class="content-container">

                    <div class="review-sidebar col-md-3">
                        <h3>Question ${question.questionOrder}: </h3>
                        <table>
                            <tbody>
                                <tr>
                                    <th>Question ID: </th>
                                    <td>${question.id}</td>
                                </tr>
                                <tr>
                                    <th>Score Allocated:  </th>
                                    <td>${question.marksAllocated}</td>
                                </tr>
                                <tr>
                                    <th>Score:  </th>
                                    <td>${attempt.score}</td>
                                </tr>
                                <tr>
                                    <th>State: </th>
                                    <td><c:if test="${attempt.marked eq true}"> Marked </c:if>
                                        <c:if test="${attempt.marked eq false}"> Not Marked </c:if></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="review-body col-md-9">
                            <div class="game-quiz-container">

                                <div class="game-question-container">
                                    <h1 id="display-question">${question.content}</h1>
                            </div>
                            <div class="game-options-container">
                                <span>
                                    <input type="radio" id="option-one" name="option" class="radio"
                                           value="${question.optionA}" onclick="submit();" />
                                    <label for="option-one" class="option" id="option-one-label">A.
                                        ${question.optionA}</label>
                                </span>


                                <span>
                                    <input type="radio" id="option-two" name="option" class="radio"
                                           value="${question.optionB}" onclick="submit();" />
                                    <label for="option-two" class="option" id="option-two-label">B.
                                        ${question.optionB}</label>
                                </span>


                                <span>
                                    <input type="radio" id="option-three" name="option" class="radio"
                                           value="${question.optionC}" />
                                    <label for="option-three" class="option" id="option-three-label">C.
                                        ${question.optionC}</label>
                                </span>


                                <span>
                                    <input type="radio" id="option-four" name="option" class="radio"
                                           value="${question.optionD}" onclick="submit();" />
                                    <label for="option-four" class="option" id="option-four-label">D.
                                        ${question.optionD}</label>
                                </span>


                            </div>


                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="footer-container">
                <div class="review-progress">
                    <button onclick="openPopup()">Review Result</button>
                    <div id="popup" class="popup-overlay">
                        <div class="popup-content">
                            <div class="review-header">
                                <h1>Review Progress</h1>
                            </div>
                            <div class="question-filter">
                                <button>All Questions</button>
                                <button class="marked-question">Correct Answer</button>
                                <button class="unanswered-question">Incorrect Answer</button>
                                <button class="answered-question">Marked Question</button>

                            </div>
                            <div class="question-navigation">
                                <c:forEach var="question" items="${allQuestionL}">
                                    <a href="reviewquiz?examId=${examId}&attId=${attId}&page=${question.questionOrder}">${question.questionOrder}</a>
                                </c:forEach>
                            </div>
                            <div class="navigate-btn">
                                <button onclick="closePopup()">Continue Reviewing</button>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="next-previous">
                    <c:if test="${p > 1}">
                        <div class="footer-left">
                            <a href="reviewquiz?examId=${examId}&attId=${attId}&page=${p-1}">Previous Question</a>
                        </div>
                    </c:if>
                    <c:if test="${p < endP}">
                        <div class="footer-right">
                            <a href="reviewquiz?examId=${examId}&attId=${attId}&page=${p+1}">Next Question</a>
                        </div>
                    </c:if>
                </div>
            </div>

        </main>

    </body>

</html>