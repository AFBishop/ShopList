package com.bishop.web;

import com.bishop.domain.Category;
import com.bishop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateCategoryUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        Category category = new Category();
        try {
            category = new CategoryService().findCategory(cid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("category", category);
        request.getRequestDispatcher("/admin/category/edit.jsp").forward(request, response);
    }
}
