package controller;

import dal.MyRegistrationDAO;
import dal.PriceDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserDAO;
import dal.UserProfileDAO;
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
import model.Subject_Category;
import model.User;
import model.UserProfile;

/**
 *
 * @author ADMIN
 */
public class MyRegistrationController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessions = request.getSession();
        MyRegistrationDAO mrDAO = new MyRegistrationDAO();

        if (request.getParameter("reigsId") != null && request.getParameter("checkCancel") != null) {
               mrDAO.deleteRegistration(request.getParameter("reigsId"));
        }
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
        List<Subject> subjectList = new ArrayList<>();
//        List<MyRegistration> mrList = mrDAO.getMyRegistration(user.getId(), page, PAGE_SIZE);
        subjectList = sDAO.getSubjects();
        List<Subject_Category> categoryList = new ArrayList<>();
        categoryList = scDAO.getSubjectCategory();

        String category = request.getParameter("category");

        String search = request.getParameter("search");
        if (category == null || category.isEmpty()) {
            category = "all";
        }

        if (search == null || search.isEmpty()) {
            search = "";
        }

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int count = mrDAO.getTotalRegistrationFilter(category, search, user.getId());
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        List<MyRegistration> mrList = mrDAO.getMyRegistrationWithPaging(Integer.parseInt(index), category, search, user.getId());
        request.setAttribute("categoryList", categoryList);
        User a = (User) sessions.getAttribute("user");
        UserProfileDAO upDAO = new UserProfileDAO();
        UserProfile userProfile = upDAO.getUserProfile(a.getId());
        request.setAttribute("userProfile", userProfile);

        PriceDAO pDAO = new PriceDAO();
        List<Price_Package> pricePackageList = new ArrayList<>();
        pricePackageList = pDAO.getAllPricePackage();
        request.setAttribute("pricePackageList", pricePackageList);

        request.setAttribute("endP", endPage);
        request.setAttribute("tag", Integer.parseInt(index));

        request.setAttribute("pL", pL);
        request.setAttribute("mrList", mrList);
        request.setAttribute("subjectList", subjectList);

        request.getRequestDispatcher("MyRegistration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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