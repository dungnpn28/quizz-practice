/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ExamDAO;
import dal.MyRegistrationDAO;
import dal.PracticeDetailsDAO;
import dal.QuestionDAO;
import dal.QuestionExamDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.User_ExamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import model.Dimension;
import model.Exam;
import model.MyRegistration;
import model.Subject;
import model.Subject_Category;
import model.User;

/**
 *
 * @author dai
 */
public class PracticeDetailsController extends HttpServlet {

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
        PracticeDetailsDAO pdDAO = new PracticeDetailsDAO();

        HttpSession sessions = request.getSession();
        User a = (User) sessions.getAttribute("user");

        MyRegistrationDAO mDAO = new MyRegistrationDAO();
        List<MyRegistration> mr = new ArrayList<>();
        mr = mDAO.getAllRegistration(a.getId());
        request.setAttribute("mr", mr);

        request.getRequestDispatcher("PracticeDetails.jsp").forward(request, response);
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
        
        HttpSession sessions = request.getSession();
        User a = (User) sessions.getAttribute("user");

        String subject = request.getParameter("subject");
        int subjectID = Integer.parseInt(subject);

        Scanner scanner = new Scanner(System.in);
        String questions = request.getParameter("questions");
        int numberOfQuestion = Integer.parseInt(questions);
        QuestionDAO qDAO = new QuestionDAO();
        List<Integer> questionIdList = qDAO.getQuestionIdBySubjectId(subjectID);

        if (numberOfQuestion > questionIdList.size()) {
//            request.setAttribute("errorMessage", "dcmmmmmmmmm");
            response.sendRedirect("practiceDetails");
        }

        List<Integer> randomQusetionId = getNumbers(questionIdList, numberOfQuestion);
        List<Integer> randomOrderList = generateRandomOrder(numberOfQuestion);

        ExamDAO eDAO = new ExamDAO();
        eDAO.insertPracticeDetail(subjectID, numberOfQuestion);
        int examId = eDAO.getMaxIdFromExam();
        User_ExamDAO ueDAO = new User_ExamDAO();
        List<Integer> exam_ids = new ArrayList<>();
        exam_ids.add(examId);
        ueDAO.addNewUser_Exam(a.getId(), exam_ids);
        double mark = 10/numberOfQuestion;
        QuestionExamDAO qeDAO = new QuestionExamDAO();
        qeDAO.insertQuestionExam(examId, randomQusetionId, randomOrderList,mark);

//        request.getRequestDispatcher("quizhandle?id="+examId+"&page=1").forward(request, response);
        response.sendRedirect("quizhandle?id="+examId+"&page=1");
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
