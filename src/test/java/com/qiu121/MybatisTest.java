package com.qiu121;

import com.qiu121.dao.AccountDao;
import com.qiu121.pojo.Account;
import com.qiu121.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/12/5
 */
public class MybatisTest {
    @Test
    public void testSelect() throws IOException {

        String user = "";
        String password = "";


        //加载工具类
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //获取SqlSession对象,开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        AccountDao mapper = sqlSession.getMapper(AccountDao.class);

        //执行SQL语句,查询语句不需要事务回滚
        List<Account> accounts = mapper.selectByAccount(user, password);
        System.out.println(accounts);
    }
}
