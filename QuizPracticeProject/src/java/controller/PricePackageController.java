/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PriceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Price_Package;
import model.User;

/**
 *
 * @author dai
 */
public class PricePackageController extends HttpServlet {

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
        int page_size = 5;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        PriceDAO pDAO = new PriceDAO();
        List<Price_Package> pricePackageList = new ArrayList<>();
        pricePackageList = pDAO.getPrice_PackageWithPaging(page, page_size);
//        pricePackageList = pDAO.getPrice_Package();
        int totalPricePackage = pDAO.getTotalPricePackage();
        int totalPage = totalPricePackage / page_size; //1
        if (totalPricePackage % page_size != 0) {
            totalPage += 1;
        }
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pricePackageList", pricePackageList);
        request.getRequestDispatcher("PricePackage.jsp").forward(request, response);
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
        int xId = Integer.parseInt(request.getParameter("id"));
        String xName = request.getParameter("name");
        String xDescription = request.getParameter("description");
        int xDuration = Integer.parseInt(request.getParameter("duration"));
        Double xPrice = Double.parseDouble(request.getParameter("price"));
        Double xSale = Double.parseDouble(request.getParameter("sale"));
        int xStatus = Integer.parseInt(request.getParameter("status"));
        PriceDAO pd = new PriceDAO();
        Price_Package pp = new Price_Package(xId, xName, xDescription, xDuration, xPrice, xSale, xStatus);
        pd.update(pp);
        response.sendRedirect("pricePackage");

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
