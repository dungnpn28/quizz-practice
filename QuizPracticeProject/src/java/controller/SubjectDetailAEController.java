/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import dal.DimensionDAO;
import dal.Dimension_TypeDAO;
import dal.PriceDAO;
import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import dal.UserProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Dimension;
import model.Dimension_Type;
import model.Price_Package;
import model.Subject;
import model.Subject_Category;
import model.UserProfile;

/**
 *
 * @author Dell
 */
public class SubjectDetailAEController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subjectId = req.getParameter("subjectId");
        String tab = req.getParameter("tab");
        if(tab == null ||tab.isEmpty()){
            tab = "home";
        }
        String index = req.getParameter("index");
        if (index == null) {
            index = "1";
        }
        String indexD = req.getParameter("indexD");
        if(indexD == null){
            indexD = "1";
        }
        SubjectDAO s = new SubjectDAO();
        Subject_CategoryDAO sc = new Subject_CategoryDAO();
        UserProfileDAO up = new UserProfileDAO();
        PriceDAO p = new PriceDAO();
        DimensionDAO d = new DimensionDAO();
        Dimension_TypeDAO dt = new Dimension_TypeDAO();
        
        int count = p.countPricePackageBySubjectIdWithPaging(Integer.parseInt(subjectId));
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        int countD = d.countDimensionBySubjectIdWithPaging(Integer.parseInt(subjectId));
        int endPageD = countD / 5;
        if (count % 5 != 0) {
            endPageD++;
        }
        List<Price_Package> allPricePackageList = p.getPricePackageAvailable();
        List<Price_Package> pricePackageListWithPaging = p.getPricePackageBySubjectIdWithPaging(Integer.parseInt(index), Integer.parseInt(subjectId));
        List<Price_Package> pricePackageList = p.getPricePackageBySubjectId(Integer.parseInt(subjectId));
        Subject subject = s.getSubjectDetailById(Integer.parseInt(subjectId));
        List<Subject_Category> list_sc = sc.getSubjectCategory();
        List<UserProfile> list_expert = up.getListUserProfileByRole(4);
        List<Dimension> dimensionList = d.getDimensionBySubjectId(Integer.parseInt(indexD),Integer.parseInt(subjectId));
        List<Dimension_Type> list_dimension_type = dt.getDimensionType();
        
        req.setAttribute("tab", tab);
        req.setAttribute("subjectId", subjectId);
        req.setAttribute("pricePackageListWithPaging", pricePackageListWithPaging);
        req.setAttribute("allPricePackageList", allPricePackageList);
        req.setAttribute("pricePackageList", pricePackageList);
        req.setAttribute("subject", subject);
        req.setAttribute("list_sc", list_sc);
        req.setAttribute("list_expert", list_expert);
        req.setAttribute("dimensionList", dimensionList);
        req.setAttribute("list_dimension_type", list_dimension_type);
        req.setAttribute("endP", endPage);
        req.setAttribute("tag", Integer.parseInt(index));
        req.setAttribute("endPD", endPageD);
        req.setAttribute("tagD", Integer.parseInt(indexD));
//        boolean isAjaxRequest = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
//
//        if (isAjaxRequest) {
//            Map<String, Object> attributeMap = new HashMap<>();
//
//            attributeMap.put("subjectId", subjectId);
//           // attributeMap.put("pricePackageList", pricePackageList);
//            attributeMap.put("subject", subject);
////            attributeMap.put("list_sc", list_sc);
////            attributeMap.put("list_expert", list_expert);
//            attributeMap.put("endP", endPage);
//            attributeMap.put("tag", Integer.parseInt(index));
//            
//            Gson gson = new Gson();
//            String pricePackageListWithPagingJson = gson.toJson(pricePackageListWithPaging);
//            attributeMap.put("pricePackageListWithPaging", pricePackageListWithPagingJson);
//            String allPricePackageListJson = gson.toJson(allPricePackageList);
//            attributeMap.put("allPricePackageList", allPricePackageListJson);
//            String pricePackageListJson = gson.toJson(pricePackageList);
//            attributeMap.put("pricePackageList",pricePackageListJson);
//            
//            // Convert the attribute map to JSON using Gson
//
//            String jsonResponse = gson.toJson(attributeMap);
//
//            // Set the response headers and write the JSON response
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write(jsonResponse);
//        } else {
            // Chuyển tiếp đến trang JSP
            req.getRequestDispatcher("SubjectDetailAE.jsp").forward(req, resp);
        //}

    }

}
