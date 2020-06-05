package com.bishop.service;

import com.bishop.dao.AdminProductDao;
import com.bishop.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AdminProductService
 * @Author Bishop
 */
public class AdminProductService {
    public List<Product> findAllProduct() throws SQLException {
        return new AdminProductDao().findAllProduct();
    }
    public void addProduct(Product product) throws SQLException {
        new AdminProductDao().addProduct(product);
    }
    public void delProduct(String pid) throws SQLException {
        new AdminProductDao().delProduct(pid);
    }

    public Product findProductById(String pid) throws SQLException {
        return new AdminProductDao().findProductById(pid);
    }

    public void updateProduct(Product product) throws SQLException {
        new AdminProductDao().updateProduct(product);
    }
}
