/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AuthorizationDAO;
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
import java.util.ArrayList;
import model.Authorization;
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
        boolean hasPermission = true;
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse resp = (HttpServletResponse) sr1;
        AuthorizationDAO a = new AuthorizationDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        String requestedURL = req.getRequestURI();
        System.out.println(requestedURL);
        int userId = 6;
        if (u!=null) {
            userId = u.getId();
        }
        ArrayList<Authorization> list = new ArrayList<>();
        list = a.getAllowedUrlByRoleId(userId);
        for (Authorization authorization : list) {
            if (requestedURL.contains(req.getContextPath() + "/" + authorization.getUrl())) {
                System.out.println("aaaa" + req.getContextPath() + "/" + authorization.getUrl());
                hasPermission = false;
            }
        }
        if (hasPermission) {
            fc.doFilter(req, resp);
        } else {
            resp.sendRedirect("AccessDenied.jsp");
        }
    }

}


