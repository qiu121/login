package com.qiu121.dao;

import com.qiu121.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/12/5
 */
public interface AccountDao {
    /**
     * 散装参数查询
     *
     * @param user
     * @param password
     * @return
     */
    List<Account> selectByAccount(@Param("user") String user,
                                  @Param("password") String password);

    /**
     * 对象参数查询
     *
     * @param author
     * @return
     */
    List<Account> selectByAccount(Account author);
}
