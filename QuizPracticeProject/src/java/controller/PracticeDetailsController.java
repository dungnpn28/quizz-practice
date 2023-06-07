/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PracticeDetailsDAO;
import dal.Subject_CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import model.Dimension;
import model.Exam;
import model.Subject_Category;

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
            PracticeDetailsDAO pdDAO = new PracticeDetailsDAO();
            List<Exam> examList = new ArrayList<>();
            examList = pdDAO.getExamByName();
            request.setAttribute("examList", examList);
            List<Dimension> DimensionList = new ArrayList<>();
            DimensionList = pdDAO.getSubjectDimension();
            request.setAttribute("DimensionList", DimensionList);
            request.getRequestDispatcher("PracticeDetails.jsp").forward(request, response);       
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
        String subject = request.getParameter("subject");
         int numRows = 0;
        Scanner scanner = new Scanner(System.in);
        String questions = request.getParameter("questions");
        int numQuestions = scanner.nextInt();
        Random rand = new Random();
      Set<Integer> randomNums = new HashSet<>();
      while(randomNums.size() < numQuestions) {
         randomNums.add(rand.nextInt(numRows) + 1);
      }
        String topic = request.getParameter("topic");
        request.getRequestDispatcher("QuizHandle.jsp").forward(request, response);
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
