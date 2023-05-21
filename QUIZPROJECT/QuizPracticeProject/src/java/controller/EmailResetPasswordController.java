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
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import model.User;

/**
 *
 * @author Dell
 */
public class EmailResetPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String to = req.getParameter("email"); // Change accordingly
        UserDAO p = new UserDAO();
        if(p.checkAccount(to) == null){
            req.setAttribute("mess", "This account does not exist");
            req.getRequestDispatcher("Emailresetpassword.jsp").forward(req, resp);
        }else{
        
         User user = p.checkAccount(to);
         HttpSession sessions = req.getSession();
         sessions.setAttribute("usertoreset", user);
        
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
  + "To reset your Quizzero password, please go to the following page:<br>"
  + "<a href=\"http://localhost:8080/QuizPracticeProject/resetpassword\">Click here</a><br>"
  + "If you do not wish to reset your password, ignore this message. It will expire in a few hours<br>"
  + "All the best,<br>QUIZZERO.";
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress("quizzeroproject@gmail.com")); // Change accordingly
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         message.setSubject("Password reset");
         message.setContent(emailContent,"text/html");

         // Send message
         Transport.send(message);

        
         req.getRequestDispatcher("Successful.jsp").forward(req, resp);
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
    }
        }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    }

}
