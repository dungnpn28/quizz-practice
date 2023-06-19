/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SubjectDAO;
import dal.Subject_CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.Subject_Category;
import model.User;

/**
 *
 * @author LENOVO
 */
public class SubjectListPublicController extends HttpServlet {

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
        HttpSession sessions = request.getSession();
        int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        List<Subject_Category> subjectCategoryList = new ArrayList<>();
        Subject_CategoryDAO scDAO = new Subject_CategoryDAO();
        subjectCategoryList = scDAO.getSubjectCategory();

        SubjectDAO sDAO = new SubjectDAO();
        List<Subject> subjectList = new ArrayList<>();
        //display all subject in list
        subjectList = sDAO.getSubjectsWithPaging(page, PAGE_SIZE);
        String checkAll = request.getParameter("checkAll");
        if (checkAll != null && checkAll.equals("true")) {
            sessions.removeAttribute("sortValue");
            sessions.removeAttribute("checkFeatured");
            sessions.removeAttribute("checkRegisted");
            sessions.removeAttribute("checkNotRegisted");
            sessions.removeAttribute("keywordInSubjectList");
            sessions.removeAttribute("selectedCategoryId");
        }
        int totalSubject = sDAO.getTotalSubject();

        int totalPage = totalSubject / PAGE_SIZE; //1
        if (totalSubject % PAGE_SIZE != 0) {
            totalPage += 1;
        }
        int selectedCategoryId = 0;
        if (sessions.getAttribute("selectedCategoryId") != null) {
            selectedCategoryId = (int) sessions.getAttribute("selectedCategoryId");
        }

        if(sessions.getAttribute("selectedCategoryId") != null && sessions.getAttribute("checkFeatured") == null && 
                sessions.getAttribute("checkRegisted") == null && sessions.getAttribute("checkNotRegisted") == null && 
                sessions.getAttribute("sortValue") == null && sessions.getAttribute("keywordInSubjectList") == null) {
            selectedCategoryId = Integer.parseInt(sessions.getAttribute("selectedCategoryId").toString());
            subjectList = sDAO.getSubjectsByCategoryAndPaging(selectedCategoryId, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalSubjectByCategory(selectedCategoryId);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                String categoryName = scDAO.getCategoryName(selectedCategoryId);
                request.setAttribute("categoryName", categoryName);
        }
        
        List<Subject> featuredSubjectList = sDAO.getFeaturedSubjectsWithPaging(page, PAGE_SIZE);
        request.setAttribute("featuredSubjectList", featuredSubjectList);

        //display featured subject list
        String checkFeatured = request.getParameter("checkFeatured");
        if (checkFeatured != null && checkFeatured.equals("true")) {
            sessions.removeAttribute("sortValue");
            sessions.removeAttribute("checkRegisted");
            sessions.removeAttribute("checkNotRegisted");
            sessions.removeAttribute("keywordInSubjectList");
            sessions.setAttribute("checkFeatured", checkFeatured);
        }
        if (sessions.getAttribute("checkFeatured") != null) {
            subjectList = sDAO.getFeaturedSubjectsWithPaging(page, PAGE_SIZE);
            totalSubject = sDAO.getTotalFeaturedSubject();
            totalPage = totalSubject / PAGE_SIZE; //1
            if (totalSubject % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            if (sessions.getAttribute("selectedCategoryId") != null) {
                subjectList = sDAO.getFeaturedSubjectsWithCategoryAndPaging(selectedCategoryId, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalFeaturedSubjectByCategory(selectedCategoryId);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                String categoryName = scDAO.getCategoryName(selectedCategoryId);
                request.setAttribute("categoryName", categoryName);
            }
        }

        //lấy list subject user đã registed
        if (sessions.getAttribute("user") != null) {
            User user = (User) sessions.getAttribute("user");
            int userId = user.getId();
            List<Subject> subjectListByUserId = sDAO.getSubjectsByUserID(userId);
            request.setAttribute("subjectListByUserId", subjectListByUserId);

            //display registed subject
            String checkRegisted = request.getParameter("checkRegisted");
            if (checkRegisted != null && checkRegisted.equals("true")) {
                sessions.removeAttribute("sortValue");
                sessions.removeAttribute("checkFeatured");
                sessions.removeAttribute("checkNotRegisted");
                sessions.removeAttribute("keywordInSubjectList");
                sessions.setAttribute("checkRegisted", checkRegisted);
            }
            if (sessions.getAttribute("checkRegisted") != null) {
                subjectList = sDAO.getSubjectsByUserIDWithPaging(userId, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalRegistedSubject(userId);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                if (sessions.getAttribute("selectedCategoryId") != null) {
                    subjectList = sDAO.getSubjectsByCategoryAndUserIDWithPaging(userId, selectedCategoryId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalRegistedSubjectWithCategory(userId, selectedCategoryId);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                    String categoryName = scDAO.getCategoryName(selectedCategoryId);
                    request.setAttribute("categoryName", categoryName);

                }
            }

            //display not registed subject
            String checkNotRegisted = request.getParameter("checkNotRegisted");
            if (checkNotRegisted != null && checkNotRegisted.equals("true")) {
                sessions.removeAttribute("sortValue");
                sessions.removeAttribute("checkFeatured");
                sessions.removeAttribute("checkRegisted");
                sessions.removeAttribute("keywordInSubjectList");
                sessions.setAttribute("checkNotRegisted", checkNotRegisted);
            }
            if (sessions.getAttribute("checkNotRegisted") != null) {
                subjectList = sDAO.getSubjectsNotRegistedByUserIDWithPaging(userId, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalNotRegistedSubject(userId);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                if (sessions.getAttribute("selectedCategoryId") != null) {
                    subjectList = sDAO.getSubjectsNotRegistedByCategoryAndUserIDWithPaging(userId, selectedCategoryId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalNotRegistedSubjectWithCategory(userId, selectedCategoryId);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                    String categoryName = scDAO.getCategoryName(selectedCategoryId);
                    request.setAttribute("categoryName", categoryName);
                }
            }

        }
        if (sessions.getAttribute("keywordInSubjectList") != null) {
            String keywordInSubjectList = (String) sessions.getAttribute("keywordInSubjectList");
            sessions.removeAttribute("selectedCategoryId");
            subjectList = sDAO.searchInAllSubject(keywordInSubjectList, page, PAGE_SIZE);
            totalSubject = sDAO.getTotalSubjectWithKeyword(keywordInSubjectList);
            totalPage = totalSubject / PAGE_SIZE; //1
            if (totalSubject % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            if (sessions.getAttribute("checkFeatured") != null) {
                subjectList = sDAO.searchInFeatturedSubject(keywordInSubjectList, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalFeaturedSubjectWithKeyword(keywordInSubjectList);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
            }
            if (sessions.getAttribute("user") != null) {
                User user = (User) sessions.getAttribute("user");
                int userId = user.getId();
                if (sessions.getAttribute("checkRegisted") != null) {
                    subjectList = sDAO.searchSubjectsByUserIDWithPaging(keywordInSubjectList, userId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalRegistedSubjectWithKeyword(userId, keywordInSubjectList);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                }
                if (sessions.getAttribute("checkNotRegisted") != null) {
                    subjectList = sDAO.searchSubjectsNotRegistedByUserIDWithPaging(keywordInSubjectList, userId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalNotRegistedSubjectWithKeyword(userId, keywordInSubjectList);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                }
            }
        }
        //get search keyword
        String keyword = request.getParameter("keyword");
        if (keyword != null) {
            sessions.setAttribute("keywordInSubjectList", keyword);
            sessions.removeAttribute("selectedCategoryId");
            subjectList = sDAO.searchInAllSubject(keyword, page, PAGE_SIZE);
            totalSubject = sDAO.getTotalSubjectWithKeyword(keyword);
            totalPage = totalSubject / PAGE_SIZE; //1
            if (totalSubject % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            if (sessions.getAttribute("checkFeatured") != null) {
                subjectList = sDAO.searchInFeatturedSubject(keyword, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalFeaturedSubjectWithKeyword(keyword);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
            }
            if (sessions.getAttribute("user") != null) {
                User user = (User) sessions.getAttribute("user");
                int userId = user.getId();
                if (sessions.getAttribute("checkRegisted") != null) {
                    subjectList = sDAO.searchSubjectsByUserIDWithPaging(keyword, userId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalRegistedSubjectWithKeyword(userId, keyword);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                }
                if (sessions.getAttribute("checkNotRegisted") != null) {
                    subjectList = sDAO.searchSubjectsNotRegistedByUserIDWithPaging(keyword, userId, page, PAGE_SIZE);
                    totalSubject = sDAO.getTotalNotRegistedSubjectWithKeyword(userId, keyword);
                    totalPage = totalSubject / PAGE_SIZE; //1
                    if (totalSubject % PAGE_SIZE != 0) {
                        totalPage += 1;
                    }
                }
            }
        }
        
        if (request.getParameter("selectedCategory") != null ) {
            selectedCategoryId = Integer.parseInt(request.getParameter("selectedCategory"));
            sessions.setAttribute("selectedCategoryId", selectedCategoryId);
            sessions.removeAttribute("sortValue");
            sessions.removeAttribute("checkFeatured");
            sessions.removeAttribute("checkRegisted");
            sessions.removeAttribute("checkNotRegisted");
            sessions.removeAttribute("keywordInSubjectList");
            if (selectedCategoryId == 0) {
                sessions.removeAttribute("selectedCategoryId");
                subjectList = sDAO.getSubjectsWithPaging(page, PAGE_SIZE);
                totalSubject = sDAO.getTotalSubject();

                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
            } else {
                subjectList = sDAO.getSubjectsByCategoryAndPaging(selectedCategoryId, page, PAGE_SIZE);
                totalSubject = sDAO.getTotalSubjectByCategory(selectedCategoryId);
                totalPage = totalSubject / PAGE_SIZE; //1
                if (totalSubject % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                String categoryName = scDAO.getCategoryName(selectedCategoryId);
                request.setAttribute("categoryName", categoryName);
            }
        }
        if (request.getParameter("sort") != null) {
            String sortValue = request.getParameter("sort");
            sessions.setAttribute("sortValue", sortValue);
        }
        if (sessions.getAttribute("sortValue") != null) {
            String sortValue = (String) sessions.getAttribute("sortValue");
            sessions.removeAttribute("checkFeatured");
            sessions.removeAttribute("checkRegisted");
            sessions.removeAttribute("checkNotRegisted");
            sessions.removeAttribute("keywordInSubjectList");
            sessions.removeAttribute("selectedCategoryId");
            if (sortValue.equals("asc")) {
                subjectList = sDAO.getSubjectsSortASCWithPaging(page, PAGE_SIZE);
                request.setAttribute("checkSort", "asc");
            } else if (sortValue.equals("desc")) {
                subjectList = sDAO.getSubjectsSortDESCWithPaging(page, PAGE_SIZE);
                request.setAttribute("checkSort", "desc");
            }
            totalSubject = sDAO.getTotalSubject();

            totalPage = totalSubject / PAGE_SIZE; //1
            if (totalSubject % PAGE_SIZE != 0) {
                totalPage += 1;
            }
        }

        request.setAttribute("key", keyword);
        request.setAttribute("subjectCategoryList", subjectCategoryList);
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("SubjectListPublic.jsp").forward(request, response);
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
