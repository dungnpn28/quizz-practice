/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.QuestionDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Question;
import model.Subject;
import model.User;

/**
 *
 * @author Dell
 */
public class QuestionDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String statuss = req.getParameter("status");
        Boolean status = true;
        if(statuss.equals("false")){
            status = false;
        }
        String subjectId = req.getParameter("subjectId");
        String level = req.getParameter("level");
        String content = req.getParameter("content");
        String explaination = req.getParameter("explaination");
        String optionA = req.getParameter("optionA");
        String optionB = req.getParameter("optionB");
        String optionC = req.getParameter("optionC");
        String optionD = req.getParameter("optionD");
        String answer = req.getParameter("answer");
        switch (answer) {
            case "a":
                answer = optionA;
                break;
            case "b":
                answer = optionB;
                break;
            case "c":
                answer = optionC;
                break;
            default:
                answer=optionD;
                break;
        }
        QuestionDAO q = new QuestionDAO();
        q.updateQuestion(Integer.parseInt(subjectId),level,content,explaination,optionA,optionB,optionC,optionD,answer,Integer.parseInt(id),status);
        resp.sendRedirect("questionList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        
        List<Subject> list_subject;
        QuestionDAO q = new QuestionDAO();
        SubjectDAO s = new SubjectDAO();
        if(user.getRole_id() == 5){
            list_subject = s.getSubjects();
        }else{
            list_subject = s.getSubjectByAuthorId(user.getId());
        }
        
       
        Question question =q.getQuestionDetailById(Integer.parseInt(id));
        req.setAttribute("list_subject", list_subject);
        req.setAttribute("question", question);
        req.getRequestDispatcher("QuestionDetail.jsp").forward(req, resp);
    }
    
}
