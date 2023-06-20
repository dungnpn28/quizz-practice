/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AttemptDAO;
import dal.QuestionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Question;
import model.User;

/**
 *
 * @author Acer
 */
public class ScoreExamController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttemptDAO a = new AttemptDAO();
        QuestionDAO q = new QuestionDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("examid"));
        int attemptId = Integer.parseInt(req.getParameter("attId"));
        ArrayList<Question> allQuestionList = q.getAllListQuestionByExamId(examId);
        for (Question question : allQuestionList) {
            a.createNullAttempt(attemptId, examId, question.getId(), u.getId());
            
        }
        double score = a.getExamScore(attemptId, examId, u.getId());
        req.setAttribute("examscore", score);
        req.setAttribute("examId", examId);
        req.setAttribute("attId", attemptId);
        req.getRequestDispatcher("Result.jsp").forward(req, resp);
    }

}
