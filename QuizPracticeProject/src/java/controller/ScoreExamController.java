/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AttemptDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
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
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        int examId = Integer.parseInt(req.getParameter("examid"));
        //get number of attempts
        int attemptId = 1;
        double score = a.getExamScore(attemptId, examId, u.getId());
        req.setAttribute("examscore", score);
        req.getRequestDispatcher("Result.jsp").forward(req, resp);
    }

}
