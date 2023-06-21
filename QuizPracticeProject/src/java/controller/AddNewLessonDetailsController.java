/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ExamDAO;
import dal.LessonDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Exam;
import model.Lesson;
import model.Lesson_Topic;
import model.Lesson_Type;


/**
 *
 * @author dai
 */
public class AddNewLessonDetailsController extends HttpServlet {

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
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        LessonDAO lDAO = new LessonDAO();
        ExamDAO eDAO = new ExamDAO();
        List<Lesson_Topic> lessonTopicList = new ArrayList<>();
        List<Lesson_Type> lessonTypeList = new ArrayList<>();
        List<Exam> lExam = eDAO.getAllExam();
        lessonTypeList = lDAO.getLessonType();
        lessonTopicList = lDAO.getLessonTopic();
        request.setAttribute("lessonTopicList", lessonTopicList);
        request.setAttribute("lessonTypeList", lessonTypeList);
        request.setAttribute("lExam", lExam);
        request.setAttribute("subjectId", subjectId);
        request.getRequestDispatcher("LessonDetails.jsp").forward(request, response);

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
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        String xName = request.getParameter("name");
        int xType = Integer.parseInt(request.getParameter("selectedType"));
        int xTopic = Integer.parseInt(request.getParameter("selectedTopic"));
        int xOrder = Integer.parseInt(request.getParameter("order"));
        String xLink = request.getParameter("link");
        String xContent = request.getParameter("htmlContent");
        String xStatus = request.getParameter("status");
        int xQuiz = Integer.parseInt(request.getParameter("selectedQuiz"));
        boolean status = true;
        if (xStatus.equals("0")) {
            status = false;
        }
        LessonDAO lDAO = new LessonDAO();
        lDAO.insertQuizlesson(subjectId, xTopic, xName, xType, xOrder, xLink, xContent, status, xQuiz);
        response.sendRedirect("subjectLessons?subjectId=" + subjectId);
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
