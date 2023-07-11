package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dal.BlogDAO;
import dal.Blog_CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Blog;
import model.Blog_Category;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "BlogDetailController", urlPatterns = {"/blogDetail"})
public class BlogDetailController extends HttpServlet {

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
        int PAGE_SIZE = 5;
        int page = 1;
        String id = request.getParameter("id");
        int blogId = Integer.parseInt(id);
        request.setAttribute("id", id);
        BlogDAO bDAO = new BlogDAO();
        int view = bDAO.getView(blogId);
        bDAO.updateView(blogId, view);

        List<Blog> updatedBlogList = bDAO.getBlogListOrderByUpdated();
        List<Blog> mostViewBlogList = bDAO.getBlogListOrderByView();

        request.setAttribute("updatedBlogList", updatedBlogList);
        request.setAttribute("mostViewBlogList", mostViewBlogList);

        Blog blog = bDAO.getBlogDetail(id);
        request.setAttribute("blog", blog);

        int author_id = blog.getAuthor_id();
        String author = bDAO.getAuthor(author_id);
        request.setAttribute("authorId", author_id);
        request.setAttribute("author", author);

        int category_id = blog.getCategory_id();
        String category = bDAO.getCategoryName(category_id);
        request.setAttribute("categoryId", category_id);
        request.setAttribute("category", category);

        List<Blog_Category> listCategory = new Blog_CategoryDAO().getCategory();
        request.setAttribute("listCategory", listCategory);
        List<Blog> listBlog = bDAO.getBlogList(page, PAGE_SIZE);
        request.setAttribute("listBlog", listBlog);

        request.getRequestDispatcher("BlogDetails.jsp").forward(request, response);
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
