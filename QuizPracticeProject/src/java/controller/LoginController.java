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
import java.io.PrintWriter;
import model.User;
import model.UserProfile;

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
         String errorMessage = "";
        if (a == null) {
             errorMessage = "Wrong password or email";
            sendResponse(resp, errorMessage);
            return;        
        } else {
            HttpSession sessions = req.getSession();
            sessions.setAttribute("user", a);
            UserProfileDAO upDAO = new UserProfileDAO();
            String userName = upDAO.getUserName(a.getId());
            UserProfile uProfile = upDAO.getUserProfile(a.getId());
            sessions.setAttribute("uProfile", uProfile);
            sessions.setAttribute("userName", userName);
            sendResponse(resp,"");
        }

    }
       private void sendResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(errorMessage);
        out.flush();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

}
