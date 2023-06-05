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
import java.util.List;
import model.User;
import model.UserProfile;

/**
 *
 * @author Dell
 */
public class UserListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserDAO u = new UserDAO();
        UserProfileDAO up = new UserProfileDAO();
//        List<User> list_user = u.getListUser();
        List<UserProfile> list_user_profile = up.getListUserProfile();
//        req.setAttribute("list_user", list_user);
        req.setAttribute("list_user_profile", list_user_profile);
        req.getRequestDispatcher("UserList.jsp").forward(req, resp);
    }
    
}
