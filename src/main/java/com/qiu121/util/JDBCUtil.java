package com.qiu121.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/11/22
 * jdbc工具类
 */
public class JDBCUtil {

    /**
     * 定义字符串,封装为类常量
     */
    public final static String SQL = "SELECT `id` FROM login.`account` WHERE `user`=? AND `password`=SHA(?);";

    public static Connection getDruidConn() throws Exception {

        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader( "src/druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接Connection
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        return conn;

    }

    public static Connection getConn() throws Exception {

        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //获取连接
        return DriverManager.getConnection(url, user, password);
    }
}
