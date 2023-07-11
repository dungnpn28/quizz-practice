/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.PriceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class EditStatusPricePackageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String price = req.getParameter("price");
        String subjectId = req.getParameter("subjectId");
        String index = req.getParameter("index");
        String tab = req.getParameter("tab");
        int status = 1;
        if(req.getParameter("status").equals("0")){
            status = 0;
        }
        
        PriceDAO p = new PriceDAO();
        
        p.updateStatus(Integer.parseInt(price),Integer.parseInt(subjectId),status);
        resp.sendRedirect("subjectdetailae?tab="+tab+"&subjectId="+subjectId+"&index="+index);
    }
    
}
