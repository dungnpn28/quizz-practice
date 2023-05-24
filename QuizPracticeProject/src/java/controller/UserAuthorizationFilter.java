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
        String role = "";
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
        if (requestedURL.contains("ChangePassword.jsp")  || requestedURL.contains("changePassword")) {
            switch (role) {
                case "Guest":
                    return true;
                case "user":
                    return false;
                default:
                    return false;
                
            }
        }
        
        if (requestedURL.contains("PracticeList.jsp") || requestedURL.contains("practiceList")) {
            switch (role) {
                case "Customer":
                    return true;
                default:
                    return false;               
            }
        }
        
        if (requestedURL.contains("ResetPassword.jsp") || requestedURL.contains("resetPassword")) {
            switch (role) {
                case "Guest":
                    return false;
                default:
                    return true;
                
            }
        }
        
        if (requestedURL.contains("SimulationExam.jsp")  || requestedURL.contains("simulationExam")) {
            switch (role) {
                case "Customer":
                    return true;
                default:
                    return false;            
            }
        }

        if (requestedURL.contains("Login.jsp") || requestedURL.contains("login")) {
            switch (role) {
                case "Guest":
                    return true;
                default:
                    return false;
                
            }
        }

        if (requestedURL.contains("Register.jsp") || requestedURL.contains("register")) {
            switch (role) {
                case "Guest":
                    return false;
                default:
                    return true;
                
            }
        }

        if (requestedURL.contains("GuestHome.jsp")) {
            switch (role) {
                case "Guest":
                    return true;
                default:
                    return false;
                
            }
        }

        if (requestedURL.contains("Home.jsp")) {
            switch (role) {
                case "Guest":
                    return false;
                default:
                    return true;
                
            }
        }
        
        if (requestedURL.contains("searchBySybject")) {
            switch (role) {
                case "Customer":
                    return true;
                default:
                    return false;
                
            }
        }
        
        if (requestedURL.contains("Successful.jsp")) {
            switch (role) {
                case "Guest":
                    return false;
                default:
                    return true;
                
            }
        }
        
        if (requestedURL.contains("Footer.jsp")) {
            return false;
        }
        
        if (requestedURL.contains("Header.jsp")) {
            return false;
        }
        
        if (requestedURL.contains("CusHeader.jsp")) {
            return false;
        }
        
        
        return true;
    }

}
