/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BlogDAO;
import dal.SliderDAO;
import dal.SubjectDAO;
import dal.UserProfileDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Blog;
import model.Slider;
import model.Subject;
import model.User;

/**
 *
 * @author ADMIN
 */
public class CusHomeController extends HttpServlet {

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
//        processRequest(request, response);
//        String account = request.getParameter("account");
//        String password = request.getParameter("password");
//        UserDAO p = new UserDAO();
//        User a = p.login(account, password);
        int PAGE_SIZE = 5;
        int page = 1;
        List<Blog> listBlog = new BlogDAO().getBlogList(page,PAGE_SIZE);
        request.setAttribute("listBlog", listBlog);

        List<Slider> listSlider = new SliderDAO().getSliderByStatus(1);
        request.setAttribute("listSlider",listSlider);
        
        List<Subject> listSubject = new SubjectDAO().getSubjects();
        request.setAttribute("listSubject", listSubject);
//        if(a== null){
        //request.getRequestDispatcher("Home.jsp").forward(request, response);
//        }else{
//            HttpSession sessions = request.getSession();
//        sessions.setAttribute("user", a);
        request.getRequestDispatcher("CusHome.jsp").forward(request, response);
//        }
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
