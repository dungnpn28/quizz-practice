/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.RegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet{

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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String phone_number = request.getParameter("Mobile");
        String gender = request.getParameter("Gender");
        String pass = request.getParameter("Pass");
        String rePass = request.getParameter("rePass");
        String dob = request.getParameter("dob");
        
        String name64 = Base64.getEncoder().encodeToString(name.getBytes());
        String email64 = Base64.getEncoder().encodeToString(email.getBytes());
        String phone_number64 = Base64.getEncoder().encodeToString(phone_number.getBytes());
        String gender64 = Base64.getEncoder().encodeToString(gender.getBytes());
        String pass64 = Base64.getEncoder().encodeToString(pass.getBytes());
        String dob64 = Base64.getEncoder().encodeToString(dob.getBytes());
        
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(30);
        
        if (pass.equals(rePass)) {
            if (validateDob(dob)) {
                RegisterDAO dao = new RegisterDAO();
                User existUser = dao.checkUserExist(email);
                if (existUser == null) {
                    
                        String emailContent = "<h1 style=\"color:blue\">Hi there</h1><br>"
                                + "To finish registration please go to the following page:<br>"
                                + "<a href=\"http://localhost:9999/QuizPracticeProject/registerverified?name64="+name64
                                +"&email64="+email64+"&phone_number64="+phone_number64+"&gender64="+gender64
                                +"&pass64="+pass64+"&dob64="+dob64+"&expirationDate="+expirationDate+"\">Click here</a><br>"
                                + "If you do not wish to register, ignore this message, it will expire in 30 minutes"
                                + "All the best,<br>QUIZZERO.";
                        
                        SendingEmail sendMail = new SendingEmail();
                        sendMail.sendEmail(email, emailContent);
                        response.sendRedirect("home");
                
                } else {
                
                    response.setContentType("text/html");
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('The email already exist');");
                    pw.println("</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
                    rd.include(request, response);
                }
            } else {
                response.setContentType("text/html");
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('You must be 16 year old to register');");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
                rd.include(request, response);
            }
        } else {
            response.setContentType("text/html");
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Password and retype password must match');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.include(request, response);
        }
    }
    
    protected boolean validateDob(String dob) {
        if (dob != "") {
            LocalDate Date = LocalDate.parse((CharSequence) dob);
            return Period.between(Date, LocalDate.now()).getYears() >= 16;
        } else {
            return false;
        }
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
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        response.sendRedirect("Register.jsp");
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
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
