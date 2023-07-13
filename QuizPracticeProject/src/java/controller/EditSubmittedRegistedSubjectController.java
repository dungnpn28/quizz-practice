/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ExamDAO;
import dal.MyRegistrationDAO;
import dal.User_ExamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.User;

/**
 *
 * @author LENOVO
 */
public class EditSubmittedRegistedSubjectController extends HttpServlet {

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

        String idOfSubject = request.getParameter("idOfSubject");
        String registrationId = request.getParameter("registrationId");
        String pricePackage = request.getParameter("selectedPackaged");
        String registedStatus = request.getParameter("registedStatus");
        int registedstatus = Integer.parseInt(registedStatus);
        MyRegistrationDAO mrDAO = new MyRegistrationDAO();
        User_ExamDAO ueDAO = new User_ExamDAO();
        ExamDAO eDAO = new ExamDAO();
        List<Integer> exam_ids = eDAO.getExamIdBySubjectId(idOfSubject);

        mrDAO.updateRegistration(registrationId, pricePackage, registedstatus);

        User a = (User) sessions.getAttribute("user");
                    

        if (registedStatus.equals("1") && !exam_ids.isEmpty()) {
            ueDAO.addNewUser_Exam(a.getId(), exam_ids);
        }
        response.sendRedirect("myRegistration");
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
