/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MyRegistrationDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserDAO;
import dal.UserProfileDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Random;
import model.User;

/**
 *
 * @author LENOVO
 */
public class SubjectRegistedController extends HttpServlet {

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
        HttpSession sessions = request.getSession();

        String subjectId = request.getParameter("subjectId");
        String subjectName = request.getParameter("subjectName");
        String pricePackage = request.getParameter("selectedPackaged");

        Subject_CategoryDAO scDAO = new Subject_CategoryDAO();
        int categoryId = scDAO.getCategoryId(subjectId);

        if (sessions.getAttribute("user") != null) {
            User a = (User) sessions.getAttribute("user");

            MyRegistrationDAO mrDAO = new MyRegistrationDAO();
            mrDAO.addNewRegistration(subjectId, pricePackage, a.getId(), categoryId, subjectName);
            sessions.setAttribute("openNotification", "1");
            response.sendRedirect("subjectListPublic");

        } else {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String dob = request.getParameter("dob");
            String role = "1";
            String status = "1";
            String password = generateRandomPassword();

            String name64 = Base64.getEncoder().encodeToString(name.getBytes());
            String email64 = Base64.getEncoder().encodeToString(email.getBytes());
            String phone_number64 = Base64.getEncoder().encodeToString(phone.getBytes());
            String gender64 = Base64.getEncoder().encodeToString(gender.getBytes());
            String dob64 = Base64.getEncoder().encodeToString(dob.getBytes());
            String role64 = Base64.getEncoder().encodeToString(role.getBytes());
            String status64 = Base64.getEncoder().encodeToString(status.getBytes());
            String password64 = Base64.getEncoder().encodeToString(password.getBytes());
            String subjectid64 = Base64.getEncoder().encodeToString(subjectId.getBytes());
            String pricePackage64 = Base64.getEncoder().encodeToString(pricePackage.getBytes());
            String categoryId64 = Base64.getEncoder().encodeToString(String.valueOf(categoryId).getBytes());
            String subjectName64 = Base64.getEncoder().encodeToString(subjectName.getBytes());

            String emailContent = "<h1 style=\"color:blue\">Hi there</h1><br>"
                    + "To finish registration, please click the button below:<br>"
                    + "<a href=\"http://localhost:9999/QuizPracticeProject/verifyAddNewUserAndSubject?name64=" + name64
                    + "&email64=" + email64 + "&phone_number64=" + phone_number64 + "&gender64=" + gender64
                    + "&pass64=" + password64 + "&dob64=" + dob64 + "&role64=" + role64 + "&status64=" + status64
                    + "&subjectid64=" + subjectid64 + "&pricePackage64=" + pricePackage64 + "&categoryId64=" + categoryId64 + "&subjectName64=" + subjectName64 + "\">"
                    + "<button style=\"display: inline-block; padding: 10px 20px; font-size: 16px; text-align: center; text-decoration: none; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;\">Verify Account</button></a><br>"
                    + "Admin has provided you an account. Make sure that you click this button to verify the account.<br>"
                    + "<br>"
                    + "<p style=\"font-weight: bold;\">Your new password:</p>"
                    + "<p style=\"font-size: 18px; background-color: #f2f2f2; padding: 10px; border-radius: 5px;\">" + password + "</p>"
                    + "<br>"
                    + "All the best,<br>QUIZZERO.";

            SendingEmail sendMail = new SendingEmail();
            sendMail.sendEmail(email, emailContent);
            sessions.setAttribute("openNotification", "1");
            response.sendRedirect("subjectListPublic");

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
