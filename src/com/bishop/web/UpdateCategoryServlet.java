package com.bishop.web;

import com.bishop.domain.Category;
import com.bishop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.dom.DOMResult;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        Category category = new Category();
        category.setCname(cname);
        category.setCid(cid);
        try {
            new CategoryService().updateCategory(category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/categorylist");
    }
}
