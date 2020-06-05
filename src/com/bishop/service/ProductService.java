package com.bishop.service;

import com.bishop.dao.ProductDao;
import com.bishop.domain.Product;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

/**
 * @ClassName ProductService
 * @Author Bishop
 */
public class ProductService {
    public List<Product> findAllProduct(){
        return new ProductDao().findAllProduct();
    }
    public Product findProduct(String pid){
        return new ProductDao().findProduct(pid);
    }
}
