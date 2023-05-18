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
public class UserAuthorizationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter("admin") != null ) {
            if(session.getAttribute("role").equals("customer")) {
                req.getRequestDispatcher("accessdenied.jsp").forward(req, resp);
            }
            if(session.getAttribute("role").equals("admin")) {
                req.getRequestDispatcher("Admin.jsp").forward(req, resp);
            }
        }
        if(req.getParameter("customer") != null ) {
            if(session.getAttribute("role").equals("admin")) {
                req.getRequestDispatcher("accessdenied.jsp").forward(req, resp);
            }
            if(session.getAttribute("role").equals("customer")) {
                req.getRequestDispatcher("Customer.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("testAuthorization.jsp");
    }

}
