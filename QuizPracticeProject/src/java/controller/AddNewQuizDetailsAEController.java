/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.PracticeDetailsController.generateRandomOrder;
import dal.Dimension_TypeDAO;
import dal.ExamDAO;
import dal.QuestionDAO;
import dal.QuestionExamDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Dimension_Type;
import model.Exam;
import model.Subject;

/**
 *
 * @author Dell
 */
public class AddNewQuizDetailsAEController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int subjectId = Integer.parseInt(req.getParameter("selectedSubject"));
        int level = Integer.parseInt(req.getParameter("level"));
        String duration = req.getParameter("duration");
        int hour = Integer.parseInt(duration)/ 60;
        int minute =  Integer.parseInt(duration) - hour * 60;
        double passrate= Double.parseDouble(req.getParameter("passrate"));
        String description = req.getParameter("description");
        int num = Integer.parseInt(req.getParameter("questions"));
        int question_type = Integer.parseInt(req.getParameter("questionType"));
        
        ExamDAO e = new ExamDAO();
        QuestionDAO qDAO = new QuestionDAO();
        
        e.insertExam(name, subjectId, level, hour, minute, passrate, num, description, true);
        int id=e.getMaxIdFromExam();
       
        List<Integer> questionIdList = qDAO.getQuestionIdBySubjectIdAndQuestionType(subjectId,question_type);
        
             List<Integer> randomQusetionId = getNumbers(questionIdList, num);
             List<Integer> randomOrderList = generateRandomOrder(num);
             
             QuestionExamDAO qeDAO = new QuestionExamDAO();
             double mark_allocated = 10/num;
             qeDAO.insertQuestionExam(id, randomQusetionId, randomOrderList,mark_allocated);
             resp.sendRedirect("quizlist");
       

        
    }
     public List<Integer> getNumbers(List<Integer> numberList, int count) {
        List<Integer> resultList = new ArrayList<>();
        Collections.shuffle(numberList);  // Xáo trộn danh sách ban đầu
        for (int i = 0; i < count && i < numberList.size(); i++) {
            resultList.add(numberList.get(i));
        }
        return resultList;
    }

    public static List<Integer> generateRandomOrder(int maxValue) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 1; i <= maxValue; i++) {
            randomList.add(i);
        }

        Collections.shuffle(randomList);

        return randomList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       
    
        
        SubjectDAO sDAO = new SubjectDAO();
        List<Subject> lSubject = new ArrayList<>();
        lSubject = sDAO.getSubjects();
        req.setAttribute("lSubject", lSubject);
        
        Dimension_TypeDAO dDAO = new Dimension_TypeDAO();
        List<Dimension_Type> lDimension = new ArrayList();
        lDimension = dDAO.getDimensionType();
        req.setAttribute("lDimension", lDimension);
        
        req.getRequestDispatcher("AddNewQuizDetailsAE.jsp").forward(req, resp);
    }
    
}
