package com.qiu121.web;

import com.qiu121.dao.AccountDao;
import com.qiu121.pojo.Account;
import com.qiu121.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/12/5
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        Account account = new Account();
        account.setUser(user);
        account.setPassword(password);
        System.out.println(account);

        //加载工具类
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //获取SqlSession对象,开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        AccountDao mapper = sqlSession.getMapper(AccountDao.class);

        //执行SQL语句,查询语句不需要事务回滚
        List<Account> accounts = mapper.selectByAccount(account);

        if (!(accounts.isEmpty())) {
            response.setContentType("text/html;charset=UTF-8");
            response.sendRedirect("https://www.baidu.com");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("/index.html").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
