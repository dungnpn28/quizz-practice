/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Acer
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("account") != null && req.getParameter("password") != null) {
            if(req.getParameter("account").equals("admin@admin.com") && req.getParameter("password").equals("123")){
                String role = "admin";
                HttpSession session = req.getSession();
                session.setAttribute("role", role);
                req.getRequestDispatcher("/userauthorization").forward(req, resp);
            }
            if(req.getParameter("account").equals("admin@admin.com") && req.getParameter("password").equals("123")){
                String role = "customer";  
                HttpSession session = req.getSession();
                session.setAttribute("role", role);
                req.getRequestDispatcher("/userauthorization").forward(req, resp);
            }
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

}
