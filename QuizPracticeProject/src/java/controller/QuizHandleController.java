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
import model.Attempt;
import model.Question;
import model.User;

/**
 *
 * @author Acer
 */
public class QuizHandleController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttemptDAO a = new AttemptDAO();
        QuestionDAO q = new QuestionDAO();
        ExamDAO e = new ExamDAO();  
        QuestionExamDAO eq = new QuestionExamDAO();

        HttpSession session = req.getSession();
        int page = Integer.parseInt(req.getParameter("page"));
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("id"));
        int questionId = eq.getQuestionIdByExamId(examId, page);

        //get exam time 
        String duration = e.getExamDurationById(examId);
        int examDurationSecond = convertToTime(duration);
        req.setAttribute("examDuration", examDurationSecond);

        //quiz business
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        ArrayList<Question> allQuestionList = q.getAllListQuestionByExamId(examId);
        req.setAttribute("allQuestionL", allQuestionList);
        Question currentQuestion = q.getQuestionById(questionId);
        req.setAttribute("currentQues", currentQuestion);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        req.setAttribute("questionL", questionList);
        int endPage = 10;
        req.setAttribute("endP", endPage);

        //mark question
        if (req.getParameter("mark") != null) {
            boolean markAction = false;
            if (req.getParameter("mark").equals("mark")) {
                markAction = true;
            }
            a.markUnmarkQuestion(markAction, examId, questionId, u.getId());

        }

        //save answer
        String answer = req.getParameter("option");
        a.saveAnswer(answer, examId, questionId, u.getId());
        Attempt att = a.getAttempt(examId, questionId, u.getId());
        req.setAttribute("attempt", att);

        //score question
        if (att.getUserAnswer() != null) {
            Question currentQues = q.getQuestionById(questionId);
            if (att.getUserAnswer().equals(currentQues.getAnswer())) {
                a.scoreQuestion(currentQues.getMarksAllocated(), examId, questionId, u.getId());
            } else {
                a.scoreQuestion(0, examId, questionId, u.getId());
            }
        }

        //progress bar business
        int countAnsweredQuestion = a.getTotalAnsweredQuestion(examId, u.getId());
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
        QuestionExamDAO eq = new QuestionExamDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");

        //pagination
        int endPage = 10;
        int page = Integer.parseInt(req.getParameter("page"));
        int examId = Integer.parseInt(req.getParameter("id"));
        int questionId = eq.getQuestionIdByExamId(examId, page);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("questionL", questionList);
        ArrayList<Question> allQuestionList = q.getAllListQuestionByExamId(examId);
        req.setAttribute("allQuestionL", allQuestionList);

        req.setAttribute("endP", endPage);

        //create exam attempts
        a.createAttempt(examId, questionId, examId);

        Attempt att = a.getAttempt(examId, questionId, u.getId());
        req.setAttribute("attempt", att);

        //progress bar business
        int countAnsweredQuestion = a.getTotalAnsweredQuestion(examId, u.getId());
        req.setAttribute("countAnsQues", countAnsweredQuestion);

        //get exam time 
        String duration = e.getExamDurationById(examId);
        int examDurationSecond = convertToTime(duration);
        req.setAttribute("examDuration", examDurationSecond);

        //get attempt list where user_answer not null
        ArrayList<Attempt> attemptList = a.getAttemptList(examId, questionId, u.getId());
        req.setAttribute("attL", attemptList);

        //push to QuizHandle
        req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);

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

}
