/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.RoleDAO;
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
public class UserAuthorizationController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleDAO r = new RoleDAO();
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");
        if (r.getRoleNameByUserId(userId).equalsIgnoreCase("guest")) {
            req.getRequestDispatcher("GuestHome.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Login.jsp");
    }
    
}
