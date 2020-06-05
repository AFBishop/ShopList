package com.bishop.web;

import com.bishop.domain.Product;
import com.bishop.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request);
        List<Product> products = null;
        try {
            products = new AdminProductService().findAllProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
    }
}
