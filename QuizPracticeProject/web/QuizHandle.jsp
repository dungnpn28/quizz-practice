<%-- Document : QuizHandle Created on : Jun 5, 2023, 2:12:23 PM Author : Acer --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css"
                href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Quiz Handle</title>
            <link rel="stylesheet" href="css/QuizHandle.css" type="text/css" />
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

                <div style="height: 20px" class="progress rounded-pill">
                    <div role="progressbar" aria-valuenow="44" aria-valuemin="0" aria-valuemax="100" style="width: 44%"
                        class="progress-bar rounded-pill bg-gradient"></div>
                </div>

                <div class="under-header">
                    <div class="under-header-left">
                        <h4>Question: <span>1</span>/<span>10</span><h4>
                    </div>
                    <div class="under-header-right">
                        <button id="mark-question"> 🚩Mark Question</button>    
                    </div>
                </div>

                <div class="game-quiz-container">

                    <div class="game-question-container">
                        <h1 id="display-question">Ấn Độ năm ở châu lục nào ??????????</h1>
                    </div>

                    <div class="game-options-container">

                        <div class="modal-container" id="option-modal">

                            <div class="modal-content-container">
                                <h1>Please Pick An Option</h1>

                                <div class="modal-button-container">
                                    <button>Continue</button>
                                </div>

                            </div>

                        </div>

                        <span>
                            <input type="radio" id="option-one" name="option" class="radio" value="optionA" />
                            <label for="option-one" class="option" id="option-one-label"></label>
                        </span>


                        <span>
                            <input type="radio" id="option-two" name="option" class="radio" value="optionB" />
                            <label for="option-two" class="option" id="option-two-label"></label>
                        </span>


                        <span>
                            <input type="radio" id="option-three" name="option" class="radio" value="optionC" />
                            <label for="option-three" class="option" id="option-three-label"></label>
                        </span>


                        <span>
                            <input type="radio" id="option-four" name="option" class="radio" value="optionD" />
                            <label for="option-four" class="option" id="option-four-label"></label>
                        </span>


                    </div>

                    <div class="next-button-container">
                        <button>Next Question</button>
                    </div>

                </div>
            </main>
        </body>

        </html>