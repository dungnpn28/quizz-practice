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
        // Retrieve the user's role from the session or token
        int userId = (int) session.getAttribute("userId");
        String role = r.getRoleNameByUserId(userId);
        // Get the requested resource URL
        String requestedURL = req.getRequestURI();

        // Check if the user's role has the necessary permission
        if (hasPermission(role, requestedURL)) {
            // User has the necessary permission, allow the request to proceed
            fc.doFilter(req, resp);
        } else {
            // User does not have the necessary permission, redirect to an error page or
            // display an access denied message
            resp.sendRedirect("AccessDenied.jsp");
        }
    }

    private boolean hasPermission(String role, String requestedURL) {
        if (requestedURL.contains("Home.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("GuestHome.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("Login.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("Register.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("Logout.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("AccessDenied.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("ProductDetail.jsp")) {
            switch (role) {
                case "guest":
                    return false;
                case "customer":
                    return true;
                case "admin":
                    return true;
                case "marketing":
                    return true;
                case "sale":
                    return true;
                case "expert":
                    return true;
                default:
                    return false;
            }
        }
        return true;

    }

}
