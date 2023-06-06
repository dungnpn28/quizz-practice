/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.QuestionExamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Acer
 */
public class StartQuizController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int examId = Integer.parseInt(req.getParameter("id"));
        QuestionExamDAO qe = new QuestionExamDAO();
        int firstQuestionId = qe.getQuestionIdByExamId(examId, page);
        req.getRequestDispatcher("quizhandle?id=" + examId + "&page=" + page + "&qId=" + firstQuestionId).forward(req, resp);
    }   
}
