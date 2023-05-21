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
import java.sql.Date;

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

        // Determine the required permissions for the resource based on its URL
        // String requiredPermission = determineRequiredPermission(requestedURL);

        // Check if the user's role has the necessary permission
        if (hasPermission(role, requestedURL)) {
            // User has the necessary permission, allow the request to proceed
            fc.doFilter(req, resp);
        } else {
            // User does not have the necessary permission, redirect to an error page or
            // display an access denied message
            resp.sendRedirect("accessDenied.jsp");
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
                case "marketing":
                    return true;
                case "admin":
                    return true;
                default:
                    return false;
            }
        }

        if (requestedURL.contains("MyRegistrations.jsp")) {
            switch (role) {
                case "marketing":
                    return true;
                case "admin":
                    return true;
                default:
                    return false;
            }
        }

        return false;

    }
    
    //convert date dd/mm/yyyy to yyyy-mm-dd
    public static String convertDate(String date) {
        String[] arr = date.split("/");
        String newDate = arr[2] + "-" + arr[1] + "-" + arr[0];
        return newDate;
    }

}
