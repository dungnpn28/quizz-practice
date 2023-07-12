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
public class AddNewPricePackageDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xName = req.getParameter("name");
        String xDescription = req.getParameter("description");
        int xDuration = Integer.parseInt(req.getParameter("duration"));
        Double xPrice = Double.parseDouble(req.getParameter("price"));
        Double xSale = Double.parseDouble(req.getParameter("sale"));
        int xStatus = Integer.parseInt(req.getParameter("status"));
        String index = req.getParameter("index");
        String subjectId = req.getParameter("subjectId");
        PriceDAO pd = new PriceDAO();
        Price_Package pp = new Price_Package(xName, xDescription, xDuration, xPrice, xSale, xStatus);
        pd.insert(pp);
        int a = pd.findPricePackage();
        pd.insert1(a,Integer.parseInt(subjectId),xStatus);
        resp.sendRedirect("subjectdetailae?subjectId="+subjectId+"&tab=contact");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String price = req.getParameter("price");
        String subjectId = req.getParameter("subjectId");
          PriceDAO pd = new PriceDAO();
           pd.insert1(Integer.parseInt(price),Integer.parseInt(subjectId),1);
           resp.sendRedirect("subjectdetailae?subjectId="+subjectId+"&tab=contact");
           
    }

}
