-- 用户档案
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id CHAR(32) PRIMARY KEY COMMENT 'ID',
	name VARCHAR(100) NOT NULL COMMENT '姓名',
	mobile VARCHAR(100) NOT NULL COMMENT '手机',
  	password VARCHAR(100) NOT NULL COMMENT '密码',
  	salt VARCHAR(100) NOT NULL COMMENT '盐',
	remark VARCHAR(255) COMMENT '备注'
) ENGINE=INNODB DEFAULT charset=utf8mb4 COMMENT='用户';

/*
 * INSERT INTO `user`(id, name, mobile, password, salt, remark)
 * VALUES(replace(UUID(),'-',''), '李庆超','18826230693','e38c083352dbca4f0257b5c2aeb1d7c2', 'MTg4MjYyMzA2OTM=', null);
 */

-- 客户档案
drop table if exists customer;
create table customer(
	id char(32) primary key comment 'ID',
	name varchar(100) not null comment '名称',
	mobile varchar(100) comment '手机号',
	address varchar(255) comment '地址',
	`user` char(32) comment '用户',
	remark varchar(255) comment '备注'
)engine=innodb default charset=utf8mb4 comment='客户档案';

