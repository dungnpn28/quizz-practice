<%-- Document : QuizHandle Created on : Jun 5, 2023, 2:12:23 PM Author : Acer --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Handle</title>
        <link rel="stylesheet" href="css/QuizHandle.css" type="text/css" />
        <script src="js/QuizHandle.js"></script>
    </head>

    <body>
        <main>

            <div class="header-container">
                <div class="logo w-100 h-auto col-md-4">
                    <img href="quizhandle" src="img/1.png" alt="logo" />
                </div>
                <div class="runout-time w-100 h-auto col-md-4">
                    <h1>01 : 30 : 00 <span id="time"></span></h1>
                </div>
                <div class="exit-button w-100 h-auto col-md-4">
                    <button id="exit-exam">X</button>
                </div>
            </div>

            <div class="progress rounded-pill">
                <div role="progressbar" aria-valuenow="44" aria-valuemin="0" aria-valuemax="100" style="width: 44%"
                     class="progress-bar rounded-pill bg-gradient"></div>
            </div>
            <c:forEach var="question" items="${questionL}"> 
                <div class="under-header">
                    <div class="under-header-left">
                        <h4>Question: <span>${question.getId()}</span>/<span>${endP}</span></h4>
                    </div>
                    <div class="under-header-right">
                        <button class="mark-question"> Mark Question</button>
                    </div>
                </div>
                <div class="game-quiz-container">

                    <div class="game-question-container">
                        <h1 id="display-question">${question.getContent()}</h1>
                    </div>

                    <div class="game-options-container">


                        <span>
                            <input type="radio" id="option-one" name="option" class="radio" value="optionA" />
                            <label for="option-one" class="option" id="option-one-label">A. ${question.getOptionA()}</label>
                        </span>


                        <span>
                            <input type="radio" id="option-two" name="option" class="radio" value="optionB" />
                            <label for="option-two" class="option" id="option-two-label">B. ${question.getOptionB()}</label>
                        </span>


                        <span>
                            <input type="radio" id="option-three" name="option" class="radio" value="optionC" />
                            <label for="option-three" class="option" id="option-three-label">C. ${question.getOptionC()}</label>
                        </span>


                        <span>
                            <input type="radio" id="option-four" name="option" class="radio" value="optionD" />
                            <label for="option-four" class="option" id="option-four-label">D. ${question.getOptionD()}</label>
                        </span>


                    </div>

                    <div class="peek-at-answer">
                        <button onclick="openPeekPopup()">Peek At Answer</button>
                        <div id="peek-popup" class="peek-popup-overlay">
                            <div class="peek-popup-content">
                                <div class="peek-header">
                                    <h1>Peek at answer</h1>
                                </div>
                                <div class="peek-content">
                                    <h2>Question: ${question.content}</h2>
                                    <h3>Answer: ${question.answer}</h3>
                                </div>
                                <div class="peek-button">                                
                                    <button onclick="closePeekPopup()">Back to Exam</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="footer-container">
                    <div class="review-progress">
                        <button onclick="openPopup()">Review Progress</button>
                        <div id="popup" class="popup-overlay">
                            <div class="popup-content">
                                <div class="review-header">
                                    <h1>Review Progress</h1>
                                </div>
                                <div class="question-filter">
                                    <button>All Questions</button>
                                    <button class="marked-question">Marked Questions</button>
                                    <button class="unanswered-question">Unanswered Questions</button>
                                    <button class="answered-question">Answered questions</button>

                                </div>
                                <div class="question-navigation">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <a href="quizhandle?id=${id}&page=${i}">${i}</a>
                                    </c:forEach>
                                </div>
                                <div class="navigate-btn">
                                    <button onclick="closePopup()">Back to Exam</button>
                                    <button class="score-exam">Score the exam</button>
                                </div>

                            </div>
                        </div>

                    </div>
                    <div class="next-previous">
                        <div class="footer-left">
                            <button id="previous-question">Previous Question</button>
                        </div>
                        <div class="footer-right">
                            <button id="next-question">Next Question</button>
                        </div>
                    </div>

                </c:forEach> 
        </main>
    </body>

</html>