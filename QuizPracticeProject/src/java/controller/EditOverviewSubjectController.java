/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author Dell
 */
@MultipartConfig
public class EditOverviewSubjectController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("subjectId");
        Part file = req.getPart("image");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String featured = req.getParameter("featured");
        boolean featuredValue = (featured != null && featured.equals("on")) ? true : false;
        String statuss = req.getParameter("status");
        boolean status = true;
        if (statuss.equals("false")) {
            status = false;
        }
        String ownerr = req.getParameter("owner");
        String description = req.getParameter("description");
        SubjectDAO sj = new SubjectDAO();
        if (file != null && file.getSize() > 0) {
        String originalFileName = file.getSubmittedFileName();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String image = System.currentTimeMillis() + fileExtension;

        
        sj.updateSubject(Integer.parseInt(id), image, name, Integer.parseInt(category), status, description, Integer.parseInt(ownerr), featuredValue);

        String uploadPath = "D:/QUIZZEROPROJECT/QuizPracticeProject/web/uploads/" + image;
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
        }else{
            sj.updateSubjectWithoutImage(Integer.parseInt(id), name, Integer.parseInt(category), status, description, Integer.parseInt(ownerr), featuredValue);
        }

        resp.sendRedirect("subjectdetailae?subjectId=" + id);

    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
