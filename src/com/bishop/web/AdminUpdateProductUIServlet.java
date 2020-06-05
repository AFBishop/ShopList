package com.bishop.web;

import com.bishop.domain.Category;
import com.bishop.domain.Product;
import com.bishop.service.AdminProductService;
import com.bishop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminUpdateProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product product = null;
        try {
            product = new AdminProductService().findProductById(pid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Category> categories = null;
        try {
            categories =  new CategoryService().findAllCategory();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("categories", categories);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
    }
}
