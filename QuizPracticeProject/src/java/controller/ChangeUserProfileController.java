/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserProfileDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.User;
import model.UserProfile;

/**
 *
 * @author dai
 */
@MultipartConfig
public class ChangeUserProfileController extends HttpServlet {

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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int xUser_id = user.getId();
        int genderValue = 0;
        Part file = request.getPart("avatar");
        String xAvatar = file.getSubmittedFileName();
        String uploadPath = "E:/FPT Subjects/SE5/SWP/pull2/QuizPracticeProject/web/uploads/" + xAvatar;
        try {
        FileOutputStream fos = new FileOutputStream(uploadPath);
        InputStream is = file.getInputStream();
        byte[] data = new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        String xFull_name = request.getParameter("fullname");
        String xPhone_number = request.getParameter("phonenum");
        String regex = "^(03[2-9]|05[6|8|9]|07[0|6-9]|08[1-5|8|9]|09[0-9])[0-9]{7}$";
        String input = xPhone_number;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            request.setAttribute("tbao", "Invalid phone number");
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        } else {
            String xDob = request.getParameter("dob");
            String xGender = request.getParameter("radB1");
            if (xGender.equals("male")) {
                genderValue = 1;
            }
            UserProfile up = new UserProfile(xUser_id, xAvatar, xFull_name, genderValue, xDob, xPhone_number);
            UserProfileDAO u = new UserProfileDAO();
            u.update(up);
            response.sendRedirect("cusHome");
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
