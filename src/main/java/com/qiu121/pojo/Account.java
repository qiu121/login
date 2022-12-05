package com.qiu121.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author qiu121
 * @version 1.0
 * @date 2022/12/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings({"all"})
public class Account {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String user;
    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
