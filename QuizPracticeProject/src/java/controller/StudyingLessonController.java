/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.LessonDAO;
import dal.MyRegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Lesson;
import model.MyRegistration;
import model.User;

/**
 *
 * @author Dell
 */
public class StudyingLessonController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lessonId = req.getParameter("lessonId");
        String subjectId = req.getParameter("subjectId");
        HttpSession session = req.getSession();
        LessonDAO le = new LessonDAO();
        MyRegistrationDAO re = new MyRegistrationDAO();
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        Lesson lesson = le.getLessonByLessonId(Integer.parseInt(subjectId), user_id, Integer.parseInt(lessonId));
       if(lesson == null){
           resp.sendRedirect("myRegistration");
       }else{
           req.setAttribute("lesson", lesson);
           req.setAttribute("subjectId", subjectId);
           req.setAttribute("lessonId", lessonId);
           req.getRequestDispatcher("StudyingLesson.jsp").forward(req, resp);
       }
        
    }
    
}
