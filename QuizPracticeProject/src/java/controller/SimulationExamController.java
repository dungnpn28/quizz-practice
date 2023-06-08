/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.ExamDAO;
import dal.QuestionExamDAO;
import dal.SubjectDAO;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Exam;
import model.Subject;
import model.User;

/**
 *
 * @author LENOVO
 */
public class SimulationExamController extends HttpServlet {

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
        int PAGE_SIZE = 2;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("user");
        ExamDAO eDAO = new ExamDAO();
        SubjectDAO sDAO = new SubjectDAO();
        List<Subject> subjectList = new ArrayList<>();
        subjectList = sDAO.getSubjects();
        List<Exam> examList = new ArrayList<>();
//        examList = eDAO.getExamByUserID(x.getId());
        examList = eDAO.getExamByUserIDwithPaging(x.getId(), page, PAGE_SIZE);
        int totalExam = eDAO.getTotalExamByUserid(x.getId());
        int totalPage = totalExam / PAGE_SIZE; //1
        if (totalExam % PAGE_SIZE != 0) {
            totalPage += 1;
        }
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        if (examList.isEmpty() || examList == null) {
            request.getRequestDispatcher("SimulationExam.jsp").include(request, response);
        } else {
            
            request.setAttribute("examList", examList);
            request.setAttribute("subjectList", subjectList);
            request.getRequestDispatcher("SimulationExam.jsp").forward(request, response);

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
        processRequest(request, response);
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
