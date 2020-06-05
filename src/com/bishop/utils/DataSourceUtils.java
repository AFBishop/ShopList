package com.bishop.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceUtil
 * @Author Bishop
 */
public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;
    }

//    public static void main(String[] args) {
//        System.out.println(DataSourceUtils.getDataSource());
//    }

}
