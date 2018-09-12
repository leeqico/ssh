DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id CHAR(32) PRIMARY KEY COMMENT 'ID',
	name VARCHAR(100) NOT NULL COMMENT '姓名',
	mobile VARCHAR(100) NOT NULL COMMENT '手机',
  	password VARCHAR(100) NOT NULL COMMENT '密码',
  	salt VARCHAR(100) NOT NULL COMMENT '盐',
	remark VARCHAR(255) COMMENT '备注'
) ENGINE=INNODB DEFAULT charset=utf8mb4 COMMENT='用户';

INSERT INTO `user`(id, name, mobile, password, salt, remark)
VALUES(replace(UUID(),'-',''), '李庆超','18826230693','e38c083352dbca4f0257b5c2aeb1d7c2', 'MTg4MjYyMzA2OTM=', null);