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
import java.io.IOException;
import model.User;

/**
 *
 * @author Dell
 */
public class LogInController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String account = req.getParameter("account");
        String password = req.getParameter("password");
        UserDAO p = new UserDAO();
        User a = p.login(account, password);
        if(a == null){
            req.setAttribute("mess", "Wrong user or pass");
            req.getRequestDispatcher("Signin.jsp").forward(req, resp);
        }else{
            
           
          
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
