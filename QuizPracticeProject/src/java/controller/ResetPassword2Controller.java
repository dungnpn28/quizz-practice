/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.User;

/**
 *
 * @author Dell
 */
public class ResetPassword2Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
        User user  = (User) session.getAttribute("users");
        String password = req.getParameter("password");
        UserDAO p = new UserDAO();
        p.updatePassword(user.getAccount(), password);
        session.removeAttribute("users");
        resp.sendRedirect("home");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("users") == null){
            resp.sendRedirect("AccessDenied.jsp");
        }else{
        req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
        }
    }
    
}
