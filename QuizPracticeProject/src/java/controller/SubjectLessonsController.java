/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LessonDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.Lesson_Type;

/**
 *
 * @author dai
 */
public class SubjectLessonsController extends HttpServlet {

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
        HttpSession sessions = request.getSession();
        int subjectId;

        if (request.getParameter("subjectId") != null) {
            subjectId = Integer.parseInt(request.getParameter("subjectId"));

        } else {
            subjectId = Integer.parseInt(sessions.getAttribute("subjectId").toString());
        }
        LessonDAO lDAO = new LessonDAO();

        if (request.getParameter("statusActive") != null) {
            String lessonId = request.getParameter("lessonId");
            lDAO.updateStatus(lessonId, 1);
        } else if (request.getParameter("statusDeactive") != null) {
            String lessonId = request.getParameter("lessonId");
            lDAO.updateStatus(lessonId, 0);
        }

        String category = request.getParameter("category");
        String status = request.getParameter("status");
        String search = request.getParameter("search");
        if (category == null || category.isEmpty()) {
            category = "all";
        }
        if (status == null || status.isEmpty()) {
            status = "all";
        }
        if (search == null || search.isEmpty()) {
            search = "";
        }

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int count = lDAO.getTotalLessonFilter(category, status, search, subjectId);//15
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }

        List<Lesson_Type> lessonTypeList = new ArrayList<>();
        lessonTypeList = lDAO.getLessonType();
        List<Lesson> lessonList = new ArrayList<>();
        lessonList = lDAO.getLessonsWithPaging(Integer.parseInt(index), category, status, search, subjectId);

        request.setAttribute("category", category);
        request.setAttribute("status", status);
        request.setAttribute("search", search);

        request.setAttribute("endP", endPage);
        request.setAttribute("tag", Integer.parseInt(index));

        sessions.setAttribute("subjectId", subjectId);
        request.setAttribute("lessonTypeList", lessonTypeList);
        request.setAttribute("lessonList", lessonList);
        request.setAttribute("subjectId", subjectId);
        request.getRequestDispatcher("SubjectLessons.jsp").forward(request, response);
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
