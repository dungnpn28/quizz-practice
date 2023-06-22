/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.UserDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

//import java.util.Properties;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
/**
 *
 * @author Dell
 */
public class AddNewUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String dob = req.getParameter("dob");
        String role = req.getParameter("role");
        String status = req.getParameter("status");
        String password = generateRandomPassword();

        String name64 = Base64.getEncoder().encodeToString(name.getBytes());
        String email64 = Base64.getEncoder().encodeToString(email.getBytes());
        String phone_number64 = Base64.getEncoder().encodeToString(phone.getBytes());
        String gender64 = Base64.getEncoder().encodeToString(gender.getBytes());
        String dob64 = Base64.getEncoder().encodeToString(dob.getBytes());
        String role64 = Base64.getEncoder().encodeToString(role.getBytes());
        String status64 = Base64.getEncoder().encodeToString(status.getBytes());
        String password64 = Base64.getEncoder().encodeToString(password.getBytes());

        UserDAO u = new UserDAO();
        UserProfileDAO up = new UserProfileDAO();
        String errorMessage = "";
        if (u.checkAccount(email) != null) {
            errorMessage = "This email has existed";
            sendResponse(resp, errorMessage);
            return;
        } else {
            String emailContent = "<h1 style=\"color:blue\">Hi there</h1><br>"
                    + "To finish registration, please click the button below:<br>"
                    + "<a href=\"http://localhost:9999/QuizPracticeProject/verifyaddnewuser?name64=" + name64
                    + "&email64=" + email64 + "&phone_number64=" + phone_number64 + "&gender64=" + gender64
                    + "&pass64=" + password64 + "&dob64=" + dob64 + "&role64=" + role64 + "&status64=" + status64 + "\">"
                    + "<button style=\"display: inline-block; padding: 10px 20px; font-size: 16px; text-align: center; text-decoration: none; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;\">Verify Account</button></a><br>"
                    + "Admin has provided you an account. Make sure that you click this button to verify the account.<br>"
                    + "<br>"
                    + "<p style=\"font-weight: bold;\">Your new password:</p>"
                    + "<p style=\"font-size: 18px; background-color: #f2f2f2; padding: 10px; border-radius: 5px;\">" + password + "</p>"
                    + "<br>"
                    + "All the best,<br>QUIZZERO.";

            SendingEmail sendMail = new SendingEmail();
            sendMail.sendEmail(email, emailContent);
            sendResponse(resp, errorMessage);
        }

    }

    private String generateRandomPassword() {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()";

        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder();

        // Tạo mật khẩu ngẫu nhiên với 6 ký tự
        for (int i = 0; i < 6; i++) {
            // Chọn ngẫu nhiên một chữ hoa hoặc một ký tự đặc biệt để chèn vào mật khẩu
            boolean useUppercase = random.nextBoolean();
            boolean useSpecialCharacter = random.nextBoolean();

            if (useUppercase) {
                char uppercaseLetter = uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length()));
                passwordBuilder.append(uppercaseLetter);
            } else if (useSpecialCharacter) {
                char specialCharacter = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
                passwordBuilder.append(specialCharacter);
            } else {
                // Nếu không chọn chữ hoa hoặc ký tự đặc biệt, chọn ngẫu nhiên một chữ thường
                char lowercaseLetter = (char) (random.nextInt(26) + 'a');
                passwordBuilder.append(lowercaseLetter);
            }
        }

        return passwordBuilder.toString();
    }

    private void sendResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(errorMessage);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
