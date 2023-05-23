/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import dal.UserDAO;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("user");
        String oldPassword = request.getParameter("oldPass");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
        String errorMessage = "";
        UserDAO u = new UserDAO();
        if (!oldPassword.equals(x.getPassword())) {
            errorMessage = "Please re-enter old password";
            sendResponse(response, errorMessage);
            return;
        }else if (!password1.matches("^(?=.*[A-Z!@#$%^&*(),.?\":{}|<>]).{6,}$")) {
            errorMessage = "Please re-enter new password, it should be at least 6 characters long, contain at least one special character or one uppercase letter";
            sendResponse(response, errorMessage);
            return;
        } else if (!password1.equals(password2)) {
            errorMessage = "New password and new password again does not match";
            sendResponse(response, errorMessage);
            return;
        }
        u.updatePassword(x, password2);
        sendResponse(response, "");
    }

    private void sendResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(errorMessage);
        out.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
