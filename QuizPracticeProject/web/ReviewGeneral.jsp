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
                                <a id="exit-immediate" href="simulationExam">Yes</a>
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
                                    <th>Score Allocated: </th>
                                    <td>${question.marksAllocated}</td>
                                </tr>
                                <tr>
                                    <th>Score: </th>
                                    <td>${attempt.score}</td>
                                </tr>
                                <tr>
                                    <th>State: </th>
                                    <td>
                                        <c:if test="${attempt.marked eq true}"> Marked </c:if>
                                        <c:if test="${attempt.marked eq false}"> Not Marked </c:if>
                                        </td>
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
                                           value="${question.optionA}" disabled <c:if
                                               test="${attempt.userAnswer eq question.optionA}">checked</c:if>/>
                                           <label for="option-one" class="option" id="option-one-label">A.
                                           ${question.optionA} <c:if test="${question.answer eq question.optionA}">
                                               → Correct Answer</c:if></label>
                                    </span>


                                    <span>
                                        <input type="radio" id="option-two" name="option" class="radio"
                                               value="${question.optionB}" disabled <c:if
                                            test="${attempt.userAnswer eq question.optionB}">checked</c:if>/>
                                        <label for="option-two" class="option" id="option-two-label">B.
                                        ${question.optionB} <c:if test="${question.answer eq question.optionB}">
                                            → Correct Answer</c:if> </label>
                                    </span>


                                    <span>
                                        <input type="radio" id="option-three" name="option" class="radio"
                                               value="${question.optionC}" disabled <c:if
                                            test="${attempt.userAnswer eq question.optionC}">checked</c:if>/>
                                        <label for="option-three" class="option" id="option-three-label">C.
                                        ${question.optionC} <c:if test="${question.answer eq question.optionC}">
                                            → Correct Answer</c:if></label>
                                    </span>


                                    <span>
                                        <input type="radio" id="option-four" name="option" class="radio"
                                               value="${question.optionD}" disabled <c:if
                                            test="${attempt.userAnswer eq question.optionD}">checked</c:if>/>
                                        <label for="option-four" class="option" id="option-four-label">D.
                                        ${question.optionD} <c:if test="${question.answer eq question.optionD}">
                                            → Correct Answer</c:if></label>
                                    </span>


                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="peek-at-answer">
                    <c:if test="${question.explaination ne null}">
                        <button onclick="openPeekPopup()">Show Explanation</button>
                    </c:if>
                    <div id="peek-popup" class="peek-popup-overlay">
                        <div class="peek-popup-content">
                            <div class="peek-header">
                                <h1>Show Explaination</h1>
                            </div>
                            <div class="question-id">
                                <h4>Question ID: ${question.id}</h4>
                            </div>

                            <div class="peek-content">
                                <h2>Question: ${question.content}</h2>
                                <h3>Answer: ${question.answer}</h3>
                                <h3>Explanation: ${question.explaination}</h3>
                            </div>
                            <div class="peek-button">
                                <button onclick="closePeekPopup()">Continue Reviewing</button>
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
                                    <c:forEach var="q" items="${allQuestionL}">
                                        <a class="${q.}" href="reviewquiz?examId=${examId}&attId=${attId}&page=${q.questionOrder}">${q.questionOrder}</a>
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
                            <a href="reviewquiz?examId=${examId}&attId=${attId}&page=${p-1}">Previous
                                Question</a>
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