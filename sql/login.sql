CREATE DATABASE IF NOT EXISTS `login` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 登录用户表
CREATE TABLE IF NOT EXISTS login.`account`
(
    `id`          BIGINT                             NOT NULL AUTO_INCREMENT COMMENT '主键' PRIMARY KEY,
    `user`        VARCHAR(15)                        NOT NULL COMMENT '用户名',
    `password`      VARCHAR(50)                        NOT NULL COMMENT '密码',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY (`user`)
)ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT '登录用户表';


-- 添加数据
INSERT INTO login.`account`(`user`, `password`)
VALUES ('zhangsan', SHA('123')),
       ('lisi', SHA('234'));

SELECT *
FROM login.`account`;
