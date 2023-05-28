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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import model.User;

/**
 *
 * @author Dell
 */
public class ResetPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String token = req.getParameter("token");

        // Check if the token exists and has not expired
        HttpSession session = req.getSession();
        LocalDateTime expirationDateTime = (LocalDateTime) session.getAttribute("expirationDateTime");

        if (expirationDateTime != null && LocalDateTime.now().isBefore(expirationDateTime)) {
            String encodedTo = req.getParameter("email");
            byte[] decodedBytes = Base64.getDecoder().decode(encodedTo);
            String originalTo = new String(decodedBytes, StandardCharsets.UTF_8);

            UserDAO p = new UserDAO();
            User user = p.checkAccount(originalTo);
            if (user == null) {
                resp.sendRedirect("login");
            } else {

                session.setAttribute("users", user);
                resp.sendRedirect("resetpassword2");
            }
        
        } else {
            // Token is invalid or has expired, display an error message or redirect to an appropriate page
          
            resp.sendRedirect("Error.jsp");
        }

    }

}
