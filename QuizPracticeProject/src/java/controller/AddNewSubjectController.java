/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import model.Subject_Category;
import model.UserProfile;

/**
 *
 * @author Dell
 */
@MultipartConfig
public class AddNewSubjectController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("thumbnail");

        String originalFileName = file.getSubmittedFileName();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String thumbnail = System.currentTimeMillis() + fileExtension;
        
        String name = req.getParameter("name");
        String category_idd = req.getParameter("category");
        int category_id = Integer.parseInt(category_idd);
        String ownerr = req.getParameter("owner");
        int owner_id = Integer.parseInt(ownerr);
        String statuss = req.getParameter("status");
        boolean status = true;
        if (statuss.equals("0")) {
            status = false;
        }
        String description = req.getParameter("description");
        String featured = req.getParameter("featured");
        boolean featuredValue = (featured != null && featured.equals("on")) ? true : false;
        SubjectDAO sj = new SubjectDAO();
        sj.addNewSubject(thumbnail, name, category_id, status, description, featuredValue, owner_id);

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
        req.setAttribute("mess", "success add");
        req.getRequestDispatcher("SubjectListAE.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject_CategoryDAO sc = new Subject_CategoryDAO();
        List<Subject_Category> list_sc = sc.getSubjectCategory();
        UserProfileDAO up = new UserProfileDAO();
        List<UserProfile> list_expert = up.getListUserProfileByRole(4);
        req.setAttribute("list_sc", list_sc);
        req.setAttribute("list_expert", list_expert);
        req.getRequestDispatcher("AddNewSubject.jsp").forward(req, resp);
    }

}
