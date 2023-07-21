/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SliderDAO;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import model.Slider;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
public class EditSliderController extends HttpServlet {

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
//        processRequest(request, response);
        HttpSession session = request.getSession();
        int sid = Integer.parseInt(request.getParameter("sid"));
        String title = request.getParameter("title");
        String note = request.getParameter("note");
        String statuss = request.getParameter("status");
        boolean status = true;
        if (statuss.equals("0")) {
            status = false;
        }
        String backlink = request.getParameter("backlink");

        SliderDAO sDAO = new SliderDAO();
        Slider x = null;
        String thumbnail = null;
        Part file = request.getPart("thumbnail");

        if (file != null && file.getSize() > 0) {
            String originalFileName = file.getSubmittedFileName();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            thumbnail = System.currentTimeMillis() + fileExtension;

            String uploadPath = "D:/QUIZZEROPROJECT/QuizPracticeProject/web/uploads/" + thumbnail;
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
            sDAO.updateSliderWithImage(title, thumbnail, sid, backlink, status, note);
        } else {
            sDAO.updateSliderWithoutImage(title, sid, backlink, status, note);
        }
        List<Slider> listSlider = sDAO.getSlider();
        request.setAttribute("listSlider", listSlider);

        List<Slider> filterStatus = new SliderDAO().getSliderByStatus(1);
        request.setAttribute("filterStatus", filterStatus);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("mess", "Update successfully !!!");
        request.getRequestDispatcher("/sliderDetail?sid=" + sid).forward(request, response);
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
