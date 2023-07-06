/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MyRegistrationDAO;
import dal.PriceDAO;
import dal.Subject_CategoryDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.MyRegistration;
import model.Price_Package;
import model.Subject_Category;
import model.User;

/**
 *
 * @author LENOVO
 */
public class RegistrationListController extends HttpServlet {

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
        int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        MyRegistrationDAO mrDAO = new MyRegistrationDAO();
        Subject_CategoryDAO scDAO = new Subject_CategoryDAO();

        List<Subject_Category> categoryList = new ArrayList<>();
        categoryList = scDAO.getSubjectCategory();
        request.setAttribute("categoryList", categoryList);

        String category = request.getParameter("category");
        String status = request.getParameter("status");

        String search = request.getParameter("search");
        if (category == null || category.isEmpty()) {
            category = "all";
        }
        if (status == null || status.isEmpty()) {
            status = "all";
        }
        if (search == null || search.isEmpty()) {
            search = "";
        }

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int count = mrDAO.getTotalAllRegistrationFilter(category, search, status);
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        List<MyRegistration> mrList = mrDAO.getAllRegistrationWithPaging(Integer.parseInt(index), category, search, status);
        request.setAttribute("mrList", mrList);

        PriceDAO pDAO = new PriceDAO();
        List<Price_Package> pricePackageList = new ArrayList<>();
        pricePackageList = pDAO.getPricePackageAvailable();
        request.setAttribute("pricePackageList", pricePackageList);

        List<User> userList = new ArrayList<>();
        UserDAO uDAO = new UserDAO();
        userList = uDAO.getUsers();
        request.setAttribute("userList", userList);

        request.setAttribute("category", category);
        request.setAttribute("status", status);
        request.setAttribute("search", search);

        request.setAttribute("endP", endPage);
        request.setAttribute("tag", Integer.parseInt(index));
        request.getRequestDispatcher("RegistrationList.jsp").forward(request, response);
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
        processRequest(request, response);
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
