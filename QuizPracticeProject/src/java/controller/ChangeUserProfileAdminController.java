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
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class ChangeUserProfileAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String role = req.getParameter("role");
        String status = req.getParameter("status");
        UserDAO u = new UserDAO();
        UserProfileDAO up = new UserProfileDAO();
        u.changeUser(Integer.parseInt(id),Integer.parseInt(role),Integer.parseInt(status));
        up.changeUser(Integer.parseInt(id));
        req.setAttribute("id", id);
        req.setAttribute("role", role);
        req.setAttribute("status", status);
        resp.sendRedirect("userlist");
//        req.getRequestDispatcher("UserList.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
