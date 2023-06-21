/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.RegisterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "RegisterVerifiedController", urlPatterns = {"/registerverified"})
public class RegisterVerifiedController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
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
        try {
            String name64 = request.getParameter("name64");
            String email64 = request.getParameter("email64");
            String phone_number64 = request.getParameter("phone_number64");
            String gender64 = request.getParameter("gender64");
            String pass64 = request.getParameter("pass64");
            String dob64 = request.getParameter("dob64");
            String expirationDate = request.getParameter("expirationDate");
            String role64 = request.getParameter("role64");
            String status64= request.getParameter("status64");
            String now = LocalDateTime.now().toString();
            if(expirationDate.compareTo(now) >= 0){
            
            byte[] decodedBytes = Base64.getDecoder().decode(name64);
            String name = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(email64);
            String email = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(phone_number64);
            String phone_number = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(gender64);
            String gender = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(pass64);
            String pass = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(dob64);
            String dob = new String(decodedBytes, StandardCharsets.UTF_8);
            decodedBytes = Base64.getDecoder().decode(status64);
            String status = new String(decodedBytes, StandardCharsets.UTF_8);  
            decodedBytes = Base64.getDecoder().decode(role64);
            String role = new String(decodedBytes, StandardCharsets.UTF_8);
            RegisterDAO dao = new RegisterDAO();
            User existUser = dao.checkUserExist(email);
            if (existUser == null) {
                dao.registerUser(email, pass,Integer.parseInt(role),Integer.parseInt(status));
                int id = dao.getID(email);
                dao.registerProfile(id, name, Integer.parseInt(gender), dob, phone_number);
                response.sendRedirect("home");
            }
            }else{
                response.sendRedirect("Register.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterVerifiedController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterVerifiedController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
