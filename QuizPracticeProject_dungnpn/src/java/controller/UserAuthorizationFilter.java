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
        String role = r.getRoleNameByUserId(u.getId());
        String requestedURL = req.getRequestURI();
        if (hasPermission(role, requestedURL)) {
            fc.doFilter(req, resp);
        } else {
            resp.sendRedirect("AccessDenied.jsp");
        }
    }

    private boolean hasPermission(String role, String requestedURL) {
        if (requestedURL.contains("Home.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                default:
                    return true;
            }
        }

        if (requestedURL.contains("GuestHome.jsp")) {
            switch (role) {
                case "guest":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("AccessDenied.jsp")) {
            return true;
        }

        if (requestedURL.contains("BlogList.jsp")) {
            switch (role) {
                case "marketing":
                    return true;
                case "admin":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("BlogDetails.jsp")) {
            switch (role) {
                case "marketing":
                    return true;
                case "admin":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("SimulationExams.jsp")) {
            switch (role) {
                case "customer":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("EmailResetPassword.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                default:
                    return true;
            }
        }
        
        if (requestedURL.contains("Successful.jsp")) {
            switch (role) {
                case "customer":
                    return true;
                default:
                    return false;
            }
        }

        return false;

    }
    

}
