/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SliderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Slider;

/**
 *
 * @author ADMIN
 */
public class SliderListController extends HttpServlet {

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

        List<Slider> listSlider = new SliderDAO().getSlider();
        request.setAttribute("listSlider", listSlider);

        List<Slider> filterStatus = new SliderDAO().getSliderByStatus(1);
//        List<Slider> filterStatus = new SliderDAO().getSliderByStatus(false);
        request.setAttribute("filterStatus", filterStatus);
        if(request.getParameter("checkActive") != null) {
            listSlider = new SliderDAO().getSliderByStatus(1);
        }
        if(request.getParameter("checkDeactive") != null) {
            listSlider = new SliderDAO().getSliderByStatus(0);
        }
                    request.setAttribute("listSlider", listSlider);

        request.getRequestDispatcher("SliderListAd.jsp").forward(request, response);

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

        HttpSession session = request.getSession();
        //button DELETE
        if (request.getParameter("btnDel") != null) {
            int id = Integer.parseInt(request.getParameter("sid"));
            List<Slider> listSlider = new SliderDAO().delete(id);
            request.setAttribute("listSlider", listSlider);
            request.getRequestDispatcher("SliderListAd.jsp").forward(request, response);
        }
        //button EDIT
        if (request.getParameter("btnEdit") != null) {
            int sid = Integer.parseInt(request.getParameter("sid"));
            Slider listSlider = new SliderDAO().getOneSlider(sid);
            request.setAttribute("sid", sid);
            request.setAttribute("listSlider", listSlider);
            request.getRequestDispatcher("EditSlider.jsp").forward(request, response);
        }

        String keyword = request.getParameter("keyword");
        if (keyword != null) {
            List<Slider> listSlider = new SliderDAO().getSlider();
            SliderDAO sDAO = new SliderDAO();
            listSlider = sDAO.searchSlider(keyword);
            request.setAttribute("listSlider", listSlider);
            request.setAttribute("key", keyword);
            request.getRequestDispatcher("SliderListAd.jsp").forward(request, response);
        }
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