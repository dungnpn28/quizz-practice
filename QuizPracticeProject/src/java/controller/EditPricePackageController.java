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
import model.Price_Package;

/**
 *
 * @author Dell
 */
public class EditPricePackageController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int xId = Integer.parseInt(req.getParameter("id"));
        String xName = req.getParameter("name");
        String xDescription = req.getParameter("description");
        int xDuration = Integer.parseInt(req.getParameter("duration"));
        Double xPrice = Double.parseDouble(req.getParameter("price"));
        Double xSale = Double.parseDouble(req.getParameter("sale"));
        int xStatus = Integer.parseInt(req.getParameter("status"));
         String index = req.getParameter("index");
        String subjectId = req.getParameter("subjectId");
        PriceDAO pd = new PriceDAO();
        Price_Package pp = new Price_Package(xId, xName, xDescription, xDuration, xPrice, xSale, xStatus);
        pd.updatedetail(pp);
        pd.updatedetail2(Integer.parseInt(subjectId), xId, xStatus);
        
       
        resp.sendRedirect("subjectdetailae?subjectId="+subjectId+"&tab=contact&index="+index);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
