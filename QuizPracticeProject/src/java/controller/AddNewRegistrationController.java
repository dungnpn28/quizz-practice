/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author LENOVO
 */
public class AddNewRegistrationController extends HttpServlet {

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
        UserDAO uDAO = new UserDAO();
        List<User> userList = uDAO.getUsers();
        request.setAttribute("userList", userList);

        SubjectDAO sDAO = new SubjectDAO();
        List<Subject> subjectList = sDAO.getSubjects();
        request.setAttribute("subjectList", subjectList);

        request.getRequestDispatcher("AddNewRegistration.jsp").forward(request, response);

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

        UserDAO uDAO = new UserDAO();
        List<User> userList = uDAO.getUsers();
        request.setAttribute("userList", userList);

        SubjectDAO sDAO = new SubjectDAO();
        List<Subject> subjectList = sDAO.getSubjects();
        request.setAttribute("subjectList", subjectList);

        if (request.getParameter("subjectSelected") != null) {
            String subjectName = request.getParameter("subjectSelected");
            int subjectId = 0;

            for (Subject subject : subjectList) {
                if (subjectName.equals(subject.getName())) {
                    subjectId = subject.getId();
                    break;
                }
            }
            System.out.println("subject id: " + subjectId);
            Subject chooseSubject = sDAO.getSubjectById(subjectId);
            request.setAttribute("chooseSubject", chooseSubject);
                        System.out.println("chooseSubject name: " + chooseSubject.getName());

            request.getRequestDispatcher("AddNewRegistration.jsp").forward(request, response);
        }

        request.getRequestDispatcher("AddNewRegistration.jsp").forward(request, response);
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
