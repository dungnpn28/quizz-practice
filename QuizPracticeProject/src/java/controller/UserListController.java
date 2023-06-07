/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.RoleDAO;
import dal.UserDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Role;
import model.User;
import model.UserProfile;

/**
 *
 * @author Dell
 */
public class UserListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserDAO u = new UserDAO();
       
        String gender = req.getParameter("gender");
        String role = req.getParameter("role");
        String status = req.getParameter("status");
        String search = req.getParameter("search");
        if (gender == null || gender.isEmpty()) {
            gender = "all";
        }
        if (role == null || role.isEmpty()) {
            role = "all";
        }
        if (status == null || status.isEmpty()) {
            status = "all";
        }
        if(search == null || search.isEmpty()){
            search = "";
        }
        String index = req.getParameter("index");
        if (index == null) {
            index = "1";
        }
        UserProfileDAO up = new UserProfileDAO();
        RoleDAO r = new RoleDAO();
        int count = up.getTotalUserProfileFilter(gender, role, status,search);//15
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        List<UserProfile> list_user_profile;
        if (gender.equals("all") && role.equals("all") && status.equals("all")) {
            list_user_profile = up.pagingUserList(Integer.parseInt(index),search);
        } else {
            list_user_profile = up.filterUserList(Integer.parseInt(index), gender, role, status,search);
        }
        List<Role> list_role = r.getListRole();
        req.setAttribute("list_role", list_role);
        req.setAttribute("endP", endPage);
        req.setAttribute("tag", Integer.parseInt(index));
//        List<User> list_user = u.getListUser();
        req.setAttribute("gender", gender);
        req.setAttribute("role", role);
        req.setAttribute("status", status);
        req.setAttribute("search", search);
//        req.setAttribute("list_user", list_user);
        req.setAttribute("list_user_profile", list_user_profile);
       
        req.getRequestDispatcher("UserList.jsp").forward(req, resp);
        
    }

}
