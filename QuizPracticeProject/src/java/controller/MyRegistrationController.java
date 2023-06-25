package controller;

import dal.MyRegistrationDAO;
import dal.PriceDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.MyRegistration;
import model.Price_Package;
import model.Subject;
import model.User;

/**
 *
 * @author ADMIN
 */
public class MyRegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessions = request.getSession();
        int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        User user = (User) sessions.getAttribute("user");
        SubjectDAO sDAO = new SubjectDAO();
//        PriceDAO pDAO = new PriceDAO();
        List<Price_Package> pL = new PriceDAO().getPrice_Package();
        Subject_CategoryDAO scDAO = new Subject_CategoryDAO();
        MyRegistrationDAO mrDAO = new MyRegistrationDAO();
        List<Subject> subjectList = new ArrayList<>();
        List<MyRegistration> mrList = mrDAO.getMyRegistration(user.getId(), page, PAGE_SIZE);
        subjectList = sDAO.getSubjects();
        request.setAttribute("pL", pL);
        request.setAttribute("mrList", mrList);
        request.setAttribute("subjectList", subjectList);

//        int totalSubject = sDAO.getTotalSubject();
//        int PAGE_SIZE = 3;
//        int page = 1;
//
//        int totalPage = totalSubject / PAGE_SIZE; //1
//        User user = (User) sessions.getAttribute("user");
//        int userId = user.getId();
//        List<Subject> subjectListByUserId = sDAO.getSubjectsByUserID(userId);
//        request.setAttribute("subjectListByUserId", subjectListByUserId);
//        int selectedCategoryId = 0;
//
//        //display registered subject
//        String checkRegisted = request.getParameter("checkRegisted");
//        if (checkRegisted != null && checkRegisted.equals("true")) {
//            sessions.removeAttribute("sortValue");
//            sessions.removeAttribute("checkFeatured");
//            sessions.removeAttribute("checkNotRegisted");
//            sessions.removeAttribute("keywordInSubjectList");
//            sessions.setAttribute("checkRegisted", checkRegisted);
//        }
//        if (sessions.getAttribute("checkRegisted") != null) {
//            subjectList = sDAO.getSubjectsByUserIDWithPaging(userId, page, PAGE_SIZE);
//            totalSubject = sDAO.getTotalRegistedSubject(userId);
//            totalPage = totalSubject / PAGE_SIZE; //1
//            if (totalSubject % PAGE_SIZE != 0) {
//                totalPage += 1;
//            }
//            if (sessions.getAttribute("selectedCategoryId") != null) {
//                subjectList = sDAO.getSubjectsByCategoryAndUserIDWithPaging(userId, selectedCategoryId, page, PAGE_SIZE);
//                totalSubject = sDAO.getTotalRegistedSubjectWithCategory(userId, selectedCategoryId);
//                totalPage = totalSubject / PAGE_SIZE; //1
//                if (totalSubject % PAGE_SIZE != 0) {
//                    totalPage += 1;
//                }
//                String categoryName = scDAO.getCategoryName(selectedCategoryId);
//                request.setAttribute("categoryName", categoryName);
//                request.setAttribute("subjectList", subjectList);
//
//            }
//        }
        request.getRequestDispatcher("MyRegistration.jsp").forward(request, response);
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