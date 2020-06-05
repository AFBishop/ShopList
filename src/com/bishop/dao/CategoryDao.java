package com.bishop.dao;

import com.bishop.domain.Category;
import com.bishop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.security.AllPermission;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CategoryDao
 * @Author Bishop
 */
public class CategoryDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    public void addCategory(Category category) throws SQLException {
        String sql = "insert into category values(?,?)";
        runner.update(sql, category.getCid(), category.getCname());
    }

    public List<Category> findAllCategory() throws SQLException {
        String sql = "select * from category";
        List<Category> categories = runner.query(sql, new BeanListHandler<Category>(Category.class));
        return categories;
    }
    public void delCategory(String cid) throws SQLException {
        String sql = "delete from category where cid = ?";
        runner.update(sql, cid);
    }
    public Category findCategory(String cid) throws SQLException {
        String sql = "select * from category where cid = ?";
        return runner.query(sql, new BeanHandler<Category>(Category.class), cid);
    }
    public void updateCategory(Category category) throws SQLException {
        String sql = "update category set cname = ? where cid = ?";
        runner.update(sql, category.getCname(), category.getCid());
    }
}
