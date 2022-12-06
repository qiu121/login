package com.qiu121;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/12/6
 */
public class DruidTest {
    @Test
    public void testConnect() throws Exception {
        String s = System.getProperty("user.dir");
        System.out.println(s);

        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader(s + "/src/druid.properties"));
        //通过当前类的class对象获取资源文件
        //InputStream resourceAsStream = DruidDemo.class.getResourceAsStream("/druid.properties");

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);


        //获取数据库连接Connection
        Connection conn = dataSource.getConnection();
        System.out.println(conn);


    }
}

