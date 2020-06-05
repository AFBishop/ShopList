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
import java.util.UUID;

public class AdminAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request);
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> properties =  request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /**
         * @Author Bishop
         * @Description //TODO
         * @Date 22:46 2020/6/4
         * @Param [request, response]
         * @return void
         *  `pid` varchar(32) NOT NULL,
         *   `pname` varchar(50) DEFAULT NULL,
         *   `market_price` double DEFAULT NULL,
         *   `shop_price` double DEFAULT NULL,
         *   `pimage` varchar(200) DEFAULT NULL,
         *   `pdate` date DEFAULT NULL,
         *   `is_hot` int(11) DEFAULT NULL,
         *   `pdesc` varchar(255) DEFAULT NULL,
         *   `pflag` int(11) DEFAULT NULL,
         *   `cid` varchar(32) DEFAULT NULL,
         *   PRIMARY KEY (`pid`),
         *   KEY `sfk_0001` (`cid`),
         **/
        product.setPid(UUID.randomUUID().toString().substring(0,5));
        product.setPimage("products/1/c_0033.jpg");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        product.setPdate(format.format(new Date()));
        product.setPflag(0);

        try {
            new AdminProductService().addProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/adminproductlist");

    }
}
