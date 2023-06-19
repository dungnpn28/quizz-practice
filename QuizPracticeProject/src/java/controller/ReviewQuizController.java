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
public class ReviewQuizController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttemptDAO a = new AttemptDAO();
        QuestionDAO q = new QuestionDAO();
        QuestionExamDAO qe = new QuestionExamDAO();
        ExamDAO e = new ExamDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        int attemptId = Integer.parseInt(req.getParameter("attId"));
        int examId = Integer.parseInt(req.getParameter("examId"));

        //get exam name
        String examName = e.getExamNameById(examId);
        req.setAttribute("examname", examName);

        //get exam score 
        double score = a.getExamScore(attemptId, examId, u.getId());
        req.setAttribute("examscore", score);

        //get question list by exam id - non paging
        ArrayList<Question> allQuestionList = q.getListQuestionByExamIdNonPaging(examId);
        req.setAttribute("allQuestionL", allQuestionList);
        req.setAttribute("attId", attemptId);
        req.setAttribute("examId", examId);

        //pagination
        int page = Integer.parseInt(req.getParameter("page"));
        int endPage = qe.countExamQuestion(examId);
        int questionId = qe.getQuestionIdByExamId(examId, page);
        req.setAttribute("p", page);
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("questionL", questionList);
        req.setAttribute("endP", endPage);

        //get attempt
        Attempt att = a.getAttempt(attemptId, examId, questionId, u.getId());
        req.setAttribute("attempt", att);

        req.getRequestDispatcher("ReviewGeneral.jsp").forward(req, resp);

    }

}
