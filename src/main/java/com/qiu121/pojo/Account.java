package com.qiu121.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/11/20
 * 数据层映射类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    /**
     * 用户名
     */
    private String user;
    /**
     * 密码
     */
    private String password;
}
