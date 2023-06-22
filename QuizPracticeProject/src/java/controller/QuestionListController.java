/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LessonDAO;
import dal.QuestionDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Lesson;
import model.Question;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class QuestionListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("btnDel") != null) {
            int id = Integer.parseInt(request.getParameter("qid"));
            List<Question> questionList = new QuestionDAO().DelOneQuestion(id);
            request.setAttribute("questionList",questionList);
            request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
        }
        if (request.getParameter("btnUpdate") != null) {
            int qid = Integer.parseInt(request.getParameter("qid"));
            Question questionList = new QuestionDAO().getOneQuestion(qid);
            request.setAttribute("qid", qid);
            request.setAttribute("questionList", questionList);
            request.getRequestDispatcher("UpdateQuestion.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String lesson = request.getParameter("lesson");
        String level = request.getParameter("level");
        String search = request.getParameter("search");
        if (subject == null || subject.isEmpty()) {
            subject = "all";
        }
        if (lesson == null || lesson.isEmpty()) {
            lesson = "all";
        }
        if (level == null || level.isEmpty()) {
            level = "all";
        }
        if (search == null || search.isEmpty()) {
            search = "";
        }

        int PAGE_SIZE = 10;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        QuestionDAO qd = new QuestionDAO();
        SubjectDAO sd = new SubjectDAO();
        LessonDAO ld = new LessonDAO();

        List<Subject> sL = sd.getSubjects();
        List<Question> qL = qd.getAllQuestion(page, PAGE_SIZE, subject, lesson, level, search);

        int totalQuestion = qd.getTotalQuestion(subject, lesson, level, search);

        int totalPage = totalQuestion / PAGE_SIZE; //1
        if (totalQuestion % PAGE_SIZE != 0) {
            totalPage += 1;
        }
        List<Lesson> lL = ld.getLesson();
        request.setAttribute("subjectList", sL);
        request.setAttribute("questionList", qL);
        request.setAttribute("page", page); //de phan trang
        request.setAttribute("totalPage", totalPage); //de phan trang
        request.setAttribute("lessonList", lL);
        request.setAttribute("subject", subject);
        request.setAttribute("lesson", lesson);
        request.setAttribute("level", level);
        request.setAttribute("search", search);

        request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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