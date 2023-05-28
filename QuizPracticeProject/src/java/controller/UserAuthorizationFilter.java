/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.RoleDAO;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.User;

/**
 *
 * @author Acer
 */
public class UserAuthorizationFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse resp = (HttpServletResponse) sr1;
        HttpSession session = req.getSession();
        RoleDAO r = new RoleDAO();
        User u = (User) session.getAttribute("user");
        String role = null;
        if (u != null) {
            role = r.getRoleNameByUserId(u.getId());
        }
        if (role == null) {
            role = "Guest";
        }
        String requestedURL = req.getRequestURI();
        if (hasPermission(role, requestedURL)) {
            fc.doFilter(req, resp);
        } else {
            resp.sendRedirect("AccessDenied.jsp");
        }
    }

    private boolean hasPermission(String role, String requestedURL) {
        if (requestedURL.contains("ChangePassword.jsp") || requestedURL.contains("changepassword")) {
            return role.equals("Guest");
        }

        if (requestedURL.contains("PracticeList.jsp")) {
            return role.equals("Customer");
        }


        if (requestedURL.contains("simulationExam") || requestedURL.contains("SimulationExam.jsp")) {
            return role.equals("Customer");

        }

        if (requestedURL.contains("changeUserProfile") || requestedURL.contains("UserProfile.jsp")) {
            return !role.equals("Guest");

        }

        if (requestedURL.contains("emailresetpassword") || requestedURL.contains("EmailResetPassword.jsp")) {
            return role.equals("Guest");

        }

        if (requestedURL.contains("resetpassword") || requestedURL.contains("ResetPassword.jsp")) {
            return role.equals("Guest");

        }

        if (requestedURL.contains("CusHome.jsp") || requestedURL.contains("cusHome")) {
            return !role.equals("Guest");

        }
        
        if (requestedURL.contains("Home.jsp") || requestedURL.contains("home")) {
            return role.equals("Guest");

        }

        if (requestedURL.contains("Successful.jsp")) {
            return !role.equals("Guest");

        }
        
        if (requestedURL.contains("register") || requestedURL.contains("RegisterController")) {
            return role.equals("Guest");

        }

        if (requestedURL.contains("Footer.jsp")) {
            return false;
        }

        if (requestedURL.contains("CusHeader.jsp")) {
            return false;
        }

        if (requestedURL.contains("Header.jsp")) {
            return false;
        }

        return true;
    }

}
