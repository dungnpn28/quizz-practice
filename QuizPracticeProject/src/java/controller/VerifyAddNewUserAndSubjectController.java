/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MyRegistrationDAO;
import dal.RegisterDAO;
import dal.UserDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class VerifyAddNewUserAndSubjectController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         String emailContent = "<h1 style=\"color:blue\">Hi there</h1><br>"
//                    + "To finish registration, please click the button below:<br>"
//                    + "<button onclick=\"location.href='http://localhost:8080/QuizPracticeProject/verifyaddnewuser?name64=" + name64
//                    + "&email64=" + email64 + "&phone_number64=" + phone_number64 + "&gender64=" + gender64
//                    + "&pass64=" + password64 + "&dob64=" + dob64+"&role64=" + role64+"&status64=" + status64+"'\">Verify Account</button><br>"
//                    + "Admin has provided you an account. Make sure that you click this button to verify the account.<br>"
//                    + "<br>"
//                    + "<p style=\"font-weight: bold;\">Your new password:</p>"
//                    + "<p style=\"font-size: 18px; background-color: #f2f2f2; padding: 10px; border-radius: 5px;\">" + password + "</p>"
//                    + "<br>"
//                    + "All the best,<br>QUIZZERO.";

        String name64 = req.getParameter("name64");
        String email64 = req.getParameter("email64");
        String phone_number64 = req.getParameter("phone_number64");
        String gender64 = req.getParameter("gender64");
        String pass64 = req.getParameter("pass64");
        String dob64 = req.getParameter("dob64");
        String role64 = req.getParameter("role64");
        String status64 = req.getParameter("status64");
        
        String subjectid64 = req.getParameter("subjectid64");
        String pricePackage64 = req.getParameter("pricePackage64");
        String categoryId64 = req.getParameter("categoryId64");
        String subjectName64 = req.getParameter("subjectName64");
        String registedStatus64 = req.getParameter("registedStatus64");

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
        decodedBytes = Base64.getDecoder().decode(role64);
        String role = new String(decodedBytes, StandardCharsets.UTF_8);
        decodedBytes = Base64.getDecoder().decode(status64);
        String status = new String(decodedBytes, StandardCharsets.UTF_8);

        decodedBytes = Base64.getDecoder().decode(subjectid64);
        String subjectId = new String(decodedBytes, StandardCharsets.UTF_8);
        decodedBytes = Base64.getDecoder().decode(pricePackage64);
        String pricePackage = new String(decodedBytes, StandardCharsets.UTF_8);
        decodedBytes = Base64.getDecoder().decode(categoryId64);
        String categoryId = new String(decodedBytes, StandardCharsets.UTF_8);
        decodedBytes = Base64.getDecoder().decode(subjectName64);
        String subjectName = new String(decodedBytes, StandardCharsets.UTF_8);
        decodedBytes = Base64.getDecoder().decode(registedStatus64);
        String registedStatus = new String(decodedBytes, StandardCharsets.UTF_8);

        RegisterDAO r = new RegisterDAO();
        UserDAO u = new UserDAO();
        MyRegistrationDAO mrDAO = new MyRegistrationDAO();

        if (u.checkAccount(email) != null) {
            resp.sendRedirect("AccessDenied.jsp");

        } else {
            try {
                r.addUser(email, pass, Integer.parseInt(role), Integer.parseInt(status));
            } catch (SQLException ex) {
                Logger.getLogger(VerifyAddNewUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int id = r.getID(email);
            try {
                r.addUserProfile(id, name, Integer.parseInt(gender), dob, phone_number);
            } catch (SQLException ex) {
                Logger.getLogger(VerifyAddNewUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mrDAO.addNewRegistration(subjectId, pricePackage, id, Integer.parseInt(categoryId), subjectName, Integer.parseInt(registedStatus));
            resp.sendRedirect("home");
        }

    }

}
