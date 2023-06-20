/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Blog_CategoryDAO;
import dal.BlogDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.Blog_Category;

/**
 *
 * @author ADMIN
 */
public class BlogListController extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
        List<Blog_Category> listCategory = new Blog_CategoryDAO().getCategory();
        req.setAttribute("listCategory", listCategory);

        BlogDAO bDAO = new BlogDAO();
        List<Blog> listBlog = bDAO.getBlogList();
        req.setAttribute("listBlog", listBlog);

        int author_id = 0;
        if (req.getParameter("authorId") != null) {
            author_id = Integer.parseInt(req.getParameter("authorId"));
            listBlog = bDAO.getBlogListByAuthor(author_id);
            String authorName = bDAO.getAuthor(author_id);
            req.setAttribute("authorName", authorName);
            req.setAttribute("authorId", author_id);
            req.setAttribute("listBlog", listBlog);

        }

        int selectedCategoryId = 0;
        if (req.getParameter("selectedCategory") != null) {
            selectedCategoryId = Integer.parseInt(req.getParameter("selectedCategory"));
            if (selectedCategoryId == 0) {

                listBlog = bDAO.getBlogList();
            } else {
                listBlog = bDAO.getBlogListByCategory(selectedCategoryId);
                String categoryName = bDAO.getCategoryName(selectedCategoryId);
                req.setAttribute("categoryName", categoryName);
            }
            req.setAttribute("listBlog", listBlog);
        }

        req.getRequestDispatcher("BlogList.jsp").forward(req, resp);
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
