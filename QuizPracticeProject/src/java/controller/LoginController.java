/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.UserDAO;
import dal.UserProfileDAO;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        UserDAO p = new UserDAO();
        User a = p.login(account, password);

        if (a == null) {
            req.setAttribute("mess", "Wrong user or pass");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            HttpSession sessions = req.getSession();
            sessions.setAttribute("user", a);
            UserProfileDAO upDAO = new UserProfileDAO();
            String userName = upDAO.getUserName(a.getId());
            sessions.setAttribute("userName", userName);
            req.getRequestDispatcher("CusHome.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

}
