package com.bishop.web;

import com.bishop.domain.Product;
import com.bishop.service.AdminProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AdminUpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> properties = request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        product.setPimage("products/1/c_0033.jpg");
        String pdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        product.setPdate(pdate);
        //4）、private int pflag;//商品是否下载 0代表未下架
        product.setPflag(0);
//        System.out.println(product);
        try {
            new AdminProductService().updateProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/adminproductlist");
    }
}
