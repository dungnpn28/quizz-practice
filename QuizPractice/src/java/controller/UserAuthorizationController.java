/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Acer
 */
public class UserAuthorizationController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check if the user has admin role in web.xml
        if (req.isUserInRole("admin")) {
            // If the user has admin role, redirect to admin page
            resp.sendRedirect("Admin.jsp");
        } else if (req.isUserInRole("customer")) {
            // If the user has customer role, redirect to customer page
            resp.sendRedirect("accessdenied.jsp");
        }

        
    }
    
}
