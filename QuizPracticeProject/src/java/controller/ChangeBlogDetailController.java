/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BlogDAO;
import dal.Blog_CategoryDAO;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import model.Blog;
import model.Blog_Category;

/**
 *
 * @author LENOVO
 */
@MultipartConfig
public class ChangeBlogDetailController extends HttpServlet {

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
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        BlogDAO dao = new BlogDAO();
        Blog blog = dao.getBlogDetail(id);
        request.setAttribute("blog", blog);

        List<Blog_Category> listCategory = new Blog_CategoryDAO().getCategory();
        request.setAttribute("listCategory", listCategory);

        request.getRequestDispatcher("ChangeBlogDetail.jsp").forward(request, response);

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

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int category_id = Integer.parseInt(request.getParameter("category"));
        String brief_info = request.getParameter("brief_info");
        String content = request.getParameter("content");
        String featured = request.getParameter("flag");
        String flag;
        if (featured != null && featured.equals("on")) {
            flag = "1";
        } else {
            flag = "0";
        }
        String statuss = request.getParameter("status");
        boolean status = true;
        if (statuss.equals("0")) {
            status = false;
        }
        Blog x = null;
        BlogDAO bDAO = new BlogDAO();

        String thumbnail = null;
        Part file = request.getPart("thumbnail");

        if (file != null && file.getSize() > 0) {
            String originalFileName = file.getSubmittedFileName();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            thumbnail = System.currentTimeMillis() + fileExtension;

            String uploadPath = "E:/FPT Subjects/SE5/SWP/pull2/QuizPracticeProject/web/uploads/" + thumbnail;
            try {
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = file.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            x = new Blog(id, thumbnail, title, category_id, flag, status, content, brief_info);
            bDAO.updateBlogWithThumbnail(x);
        }
        x = new Blog(id, title, category_id, flag, status, content, brief_info);
        bDAO.updateBlogWithoutThumbnail(x);

        request.setAttribute("notificationMessage", "Update successfully !!!");
        request.getRequestDispatcher("/blogDetail?id=" + id).forward(request, response);
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
