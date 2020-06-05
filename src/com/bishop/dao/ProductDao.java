package com.bishop.dao;

import com.bishop.domain.Product;
import com.bishop.utils.DataSourceUtils;
import com.mysql.jdbc.MiniAdmin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ProductDao
 * @Author Bishop
 */
public class ProductDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    public List<Product> findAllProduct(){
        List<Product> list = null;
        String sql = "select * from product";
        try {
            list  = runner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public Product findProduct(String pid){
        Product product = null;
        String sql = "select * from product where pid = ?";
        try {
            product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

//    public static void main(String[] args) {
//        System.out.println(new ProductDao().findProduct("1"));
//    }
}
