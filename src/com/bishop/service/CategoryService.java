package com.bishop.service;


import com.bishop.dao.CategoryDao;
import com.bishop.domain.Category;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {

    public List<Category> findAllCategory() throws SQLException {
        return new CategoryDao().findAllCategory();
    }
    public void addCategory(Category category) throws SQLException {
        new CategoryDao().addCategory(category);
    }
    public void delCategory(String cid) throws SQLException {
        new CategoryDao().delCategory(cid);
    }
    public Category findCategory(String cid) throws SQLException {
        return new CategoryDao().findCategory(cid);
    }
    public void updateCategory(Category category) throws SQLException {
        new CategoryDao().updateCategory(category);
    }
}
