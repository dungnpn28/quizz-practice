/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.LessonDAO;
import dal.MyRegistrationDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Lesson;
import model.MyRegistration;
import model.Subject;
import model.User;

/**
 *
 * @author Dell
 */
public class LessonDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        String id = req.getParameter("id");
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        MyRegistrationDAO re = new MyRegistrationDAO();
        MyRegistration lesson = re.checkMyRegistration(Integer.parseInt(id),user_id);
        if(lesson == null){
            resp.sendRedirect("myRegistration");
        }else{
            LessonDAO le = new LessonDAO();
            SubjectDAO s = new SubjectDAO();
            Subject subject = s.getSubjectDetailById(Integer.parseInt(id));
            List<Lesson> list_lesson = le.getLessonDetailBySubjectId(Integer.parseInt(id));
            req.setAttribute("subject", subject);
            req.setAttribute("list_lesson", list_lesson);
            req.getRequestDispatcher("LessonDetail.jsp").forward(req, resp);
            
        }
        
    }
    
}
