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
        HttpSession session = req.getSession();
        int page = 1;
        String pageStr = req.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("id"));
        int questionId = 0;
        questionId = Integer.parseInt(req.getParameter("qId"));
        Attempt att = a.getAttempt(examId, questionId, u.getId());
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        req.setAttribute("questionL", questionList);
        req.setAttribute("attempt", att);
        int endPage = 10;
        req.setAttribute("endP", endPage);
        //save answer
        String answer = req.getParameter("option");
        System.out.println(answer + "dddddd");
        a.saveAnswer(answer, examId, questionId, u.getId());
        req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDAO q = new QuestionDAO();
        AttemptDAO a = new AttemptDAO();
        HttpSession session = req.getSession();

        //pagination
        int page = 1;
        String pageStr = req.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int examId = Integer.parseInt(req.getParameter("id"));
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("p", page);
        req.setAttribute("id", examId);
        req.setAttribute("questionL", questionList);
        int endPage = 10;
        req.setAttribute("endP", endPage);

        //create attempt 
        User u = (User) session.getAttribute("user");
        int questionId = Integer.parseInt(req.getParameter("qId"));
        Attempt att = a.getAttempt(examId, questionId, u.getId());
        req.setAttribute("attempt", att);
        a.createAttempt(examId, questionId, u.getId());

        //push to QuizHandle
        req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);

    }

}
