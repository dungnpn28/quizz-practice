/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AttemptDAO;
import dal.ExamDAO;
import dal.QuestionDAO;
import dal.QuestionExamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import model.Attempt;
import model.Question;
import model.User;

/**
 *
 * @author Acer
 */
public class QuizHandleController extends HttpServlet {

    private AtomicInteger timerValue;
    private ScheduledExecutorService scheduler;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttemptDAO a = new AttemptDAO();
        QuestionDAO q = new QuestionDAO();
        ExamDAO e = new ExamDAO();
        QuestionExamDAO qe = new QuestionExamDAO();

        HttpSession session = req.getSession();
        int page = Integer.parseInt(req.getParameter("page"));
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("id"));
        int questionId = qe.getQuestionIdByExamId(examId, page);

        //get exam time 
//        String duration = e.getExamDurationById(examId);
//        int examDurationSecond = convertToTime(duration);
//        req.setAttribute("examDuration", examDurationSecond);
//        System.out.println("aaaaa" + examDurationSecond);
        if (timerValue != null && timerValue.get() > 0) {
            timerValue.decrementAndGet();
        }
        // Set the remaining time (countdown) as a request attribute
        req.setAttribute("examDurations", timerValue.get());

        //get attempt id
        int countAttempt = a.countExamAttempt(examId, u.getId());
        int attemptId = countAttempt;
        req.setAttribute("attId", attemptId);

        //quiz business
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        ArrayList<Question> allQuestionList = q.getAllListQuestionByExamId(examId);
        req.setAttribute("allQuestionL", allQuestionList);
        Question currentQuestion = q.getQuestionById(questionId);
        req.setAttribute("currentQues", currentQuestion);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        req.setAttribute("questionL", questionList);
        int endPage = qe.countExamQuestion(examId);
        req.setAttribute("endP", endPage);

        //mark question
        if (req.getParameter("mark") != null) {
            boolean markAction = false;
            if (req.getParameter("mark").equals("mark")) {
                markAction = true;
            }
            a.markUnmarkQuestion(markAction, attemptId, examId, questionId, u.getId());
        }
        //save answer
        String answer = req.getParameter("option");
        a.saveAnswer(answer, attemptId, examId, questionId, u.getId());
        Attempt att = a.getAttempt(attemptId, examId, questionId, u.getId());
        req.setAttribute("attempt", att);

        //score question
        if (att.getUserAnswer() != null) {
            Question currentQues = q.getQuestionById(questionId);
            if (att.getUserAnswer().equals(currentQues.getAnswer())) {
                a.scoreQuestion(currentQues.getMarksAllocated(), attemptId, examId, questionId, u.getId());
            } else {
                a.scoreQuestion(0, attemptId, examId, questionId, u.getId());
            }
        }

        //progress bar business
        int countAnsweredQuestion = a.getTotalAnsweredQuestion(attemptId, examId, u.getId());
        req.setAttribute("countAnsQues", countAnsweredQuestion);

        //question status
        boolean isAnswered = false;
        if (att.getUserAnswer() != null) {
            isAnswered = true;
        }
        req.setAttribute("questionStatus", isAnswered);
        req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDAO q = new QuestionDAO();
        AttemptDAO a = new AttemptDAO();
        ExamDAO e = new ExamDAO();
        QuestionExamDAO qe = new QuestionExamDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("id"));

        //pagination
        int page = Integer.parseInt(req.getParameter("page"));
        int endPage = qe.countExamQuestion(examId);
        int questionId = qe.getQuestionIdByExamId(examId, page);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("questionL", questionList);
        req.setAttribute("endP", endPage);

        //get attempt id
        int countAttempt = a.countExamAttempt(examId, u.getId());
        int attemptId = countAttempt + 1;
        if (page > 1) {
            attemptId = countAttempt;
        }
        req.setAttribute("attId", attemptId);
        //score exam 
        if (req.getParameter("mod") != null) {
            stopCountdownTimer();
            resp.sendRedirect("scorequiz?examid=" + examId + "&attId=" + attemptId);
        } else {
            ArrayList<Question> allQuestionList = q.getQuestionListByExamAttempt(examId, attemptId, u.getId());
            req.setAttribute("allQuestionL", allQuestionList);
            //create exam attempts
            a.createAttempt(attemptId, examId, questionId, u.getId());

            Attempt att = a.getAttempt(attemptId, examId, questionId, u.getId());
            req.setAttribute("attempt", att);

            //progress bar business
            int countAnsweredQuestion = a.getTotalAnsweredQuestion(attemptId, examId, u.getId());
            req.setAttribute("countAnsQues", countAnsweredQuestion);

            //get exam time 
            String duration = e.getExamDurationById(examId);
            int examDurationSecond = convertToTime(duration);

            if (timerValue == null) {
                timerValue = new AtomicInteger(examDurationSecond);
                startCountdownTimer();
            }
            req.setAttribute("examDurations", timerValue.get());

            //get attempt list where user_answer not null
            ArrayList<Attempt> attemptList = a.getAttemptList(attemptId, examId, questionId, u.getId());
            req.setAttribute("attL", attemptList);

            //push to QuizHandle
            req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);
        }

    }

    //function convert string to time
    private int convertToTime(String time) {
        time = time.substring(0, time.length() - 8);
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        int second = Integer.parseInt(t[2]);
        int totalTime = hour * 3600 + minute * 60 + second;
        return totalTime;
    }

    public void startCountdownTimer() {
        scheduler = Executors.newScheduledThreadPool(1);
        // Schedule the task to run every second (1000 milliseconds)
        scheduler.scheduleAtFixedRate(() -> {
            if (timerValue.get() > 0) {
                timerValue.decrementAndGet();
            } else {
                // Stop the timer when the countdown finishes
                stopCountdownTimer();
            }
        }, 0, 1, TimeUnit.SECONDS); // Delay 0 seconds, repeat every 1 second
    }

    public void stopCountdownTimer() {
        // Shutdown the scheduler and stop the timer
        if (scheduler != null) {
            timerValue = null;
            scheduler.shutdown();
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
