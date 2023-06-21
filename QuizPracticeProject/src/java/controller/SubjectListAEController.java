/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.LessonDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.Lesson_Type;
import model.Lesson_Topic;
import model.Subject;
import model.Subject_Category;
import model.UserProfile;

/**
 *
 * @author Dell
 */
public class SubjectListAEController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String status = req.getParameter("status");
        String search = req.getParameter("search");
        if (category == null || category.isEmpty()) {
            category = "all";
        }
        if (status == null || status.isEmpty()) {
            status = "all";
        }
        if (search == null || search.isEmpty()) {
            search = "";
        }
        
        Subject_CategoryDAO sc = new Subject_CategoryDAO();
        SubjectDAO s = new SubjectDAO();
        UserProfileDAO up = new UserProfileDAO();
        LessonDAO l = new LessonDAO();
        
        String index = req.getParameter("index");
        if (index == null) {
            index = "1";
        }
         int count = s.getTotalSubjectFilter(category,status,search);//15
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        
        List<UserProfile> expertList = up.getListUserProfileByRole(4);
        List<Subject_Category> subjectCategoryList = sc.getSubjectCategory();
        List<Subject> subjectList = s.getSubjectsWithPaging(Integer.parseInt(index),category,status,search);
        List<Lesson> lessonList = l.getLesson();
        
        req.setAttribute("category", category);
        req.setAttribute("status", status);
        req.setAttribute("search", search);
        
        req.setAttribute("endP", endPage);
        req.setAttribute("tag", Integer.parseInt(index));
        
        req.setAttribute("lessonList", lessonList);
        req.setAttribute("expertList", expertList);
        req.setAttribute("subjectCategoryList", subjectCategoryList);
        req.setAttribute("subjectList", subjectList);
        req.getRequestDispatcher("SubjectListAE.jsp").forward(req, resp);

    }

}
