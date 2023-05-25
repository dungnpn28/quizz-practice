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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User;
import model.UserProfile;

/**
 *
 * @author ACER
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

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
        int gender = Integer.parseInt(request.getParameter("Gender"));
        String pass = request.getParameter("Pass");
        String rePass = request.getParameter("rePass");
        String dob = request.getParameter("dob");
        if (pass.equals(rePass)) {
            if (validateDob(dob)) {
                RegisterDAO dao = new RegisterDAO();
                User existUser = dao.checkUserExist(email);
                if (existUser == null) {
                    HttpSession sessions = request.getSession();
                    User user = new User(email, pass);
                    UserProfile userprofile = new UserProfile(name, gender, phone_number, dob);
                    sessions.setAttribute("user", user);
                    sessions.setAttribute("userprofile", userprofile);
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");

                    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("quizzeroproject@gmail.com", "dytmgttusivorrvq");
                            // Put your email id and password here
                        }
                    });
                    try {
                        String emailContent = "<h1 style=\"color:blue\">Hi there</h1><br>"
                                + "To finish registration please go to the following page:<br>"
                                + "<a href=\"http://localhost:8080/QuizPracticeProject/registerverified\">Click here</a><br>"
                                + "If you do not wish to register, ignore this message."
                                + "All the best,<br>QUIZZERO.";
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("quizzeroproject@gmail.com")); // Change accordingly
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                        message.setSubject("Verified registration");
                        message.setContent(emailContent, "text/html");

                        // Send message
                        Transport.send(message);

                        request.getRequestDispatcher("Home.jsp").forward(request, response);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }

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
        try {
            processRequest(request, response);
            response.sendRedirect("Register.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
            response.sendRedirect("Register.jsp");
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
