package com.qiu121.web;

import com.qiu121.pojo.Account;
import com.qiu121.util.JDBCUtil;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/11/20
 */

@WebServlet("/login")
@SuppressWarnings({"all"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Account> list = new ArrayList<>();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setUser(username);
        account.setPassword(password);
        list.add(account);

        //获取连接
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            conn = JDBCUtil.getDruidConn();
            try {
                pstmt = conn.prepareStatement(JDBCUtil.SQL);
                try {
                    pstmt.setString(1, account.getUser());
                    pstmt.setString(2, account.getPassword());
                    rs = pstmt.executeQuery();
                    //登录成功
                    if (rs.next()) {
                        //读取文件
                        FileInputStream fileInputStream = new FileInputStream("src/main/resources/Tux.jpg");
                        //获取字符输入流对象
                        ServletOutputStream outputStream = response.getOutputStream();
                        //IOUtils工具类直接拷贝字节流文件
                        IOUtils.copy(fileInputStream, outputStream);

                        System.out.println(list);

                    } else {
                        response.setContentType("text/html; charset=UTF-8");
                        PrintWriter writer = response.getWriter();
                        request.getRequestDispatcher("/index.html").forward(request, response);

                        System.out.println(list);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
