/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.QuestionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author Acer
 */
public class QuizHandleController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        String pageStr = req.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        QuestionDAO q = new QuestionDAO();
        int examId = Integer.parseInt(req.getParameter("id"));
        ArrayList<Question> questionList = q.getListQuestionByExamId(examId, page);
        req.setAttribute("id", examId);        
        req.setAttribute("questionL", questionList);
        int endPage = 10;
        req.setAttribute("endP", endPage);
        req.getRequestDispatcher("QuizHandle.jsp").forward(req, resp);

    }

}
