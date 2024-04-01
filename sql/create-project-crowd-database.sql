CREATE DATABASE `project_crowd` CHARACTER SET utf8;

use project_crowd;

drop table if exists t_admin;
create table t_admin(
	id int not null auto_increment, # 主键
	login_acct varchar(255) not null, # 登录账号
	user_pswd varchar(255) not null, # 登录密码
	user_name varchar(255) not null, # 昵称
	email varchar(255) not null, # 邮件地址
	create_time char(19), # 创建时间
	primary key (id)
);

insert into `t_admin` (`login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) values('tom', '$2a$10$IlXkOqXWGQUB7WZKPrkLCOvKXCB4.L/u65jMv3xnaimm0Bp/SrHyW', '汤姆', 'tom@qq.com', NULL);
insert into `t_admin` (`login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) values('jerry', '$2a$10$IlXkOqXWGQUB7WZKPrkLCOvKXCB4.L/u65jMv3xnaimm0Bp/SrHyW', '杰瑞', 'jerry@qq.com', NULL);

drop table if exists t_role;
create table t_role(
	id int not null auto_increment,
	name char(100),
	primary key (id)
);

insert into `t_role` (`name`) values('用户管理');
insert into `t_role` (`name`) values('角色管理');

drop table if exists inner_admin_role;
create table inner_admin_role(
	id int not null auto_increment,
	admin_id int,
	role_id int,
	primary key (id)
);

insert into inner_admin_role (admin_id, role_id) values (1,1);
insert into inner_admin_role (admin_id, role_id) values (1,2);
insert into inner_admin_role (admin_id, role_id) values (2,2);

drop table if exists t_menu;
create table t_menu(
	id int not null auto_increment,
	pid int,
	name varchar(200),
	url varchar(200),
	icon varchar(200),
	primary key (id)
);

insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('1',NULL,'系统权限菜单','glyphicon glyphicon-th-list',NULL);
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('2','1',' 控 制 面 板 ','glyphicon glyphicon-dashboard','main.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('3','1','权限管理','glyphicon glyphicon glyphicon-tasks',NULL);
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('4','3',' 用 户 维 护 ','glyphicon glyphicon-user','user/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('5','3',' 角 色 维 护 ','glyphicon glyphicon-king','role/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('6','3',' 菜 单 维 护 ','glyphicon glyphicon-lock','permission/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('7','1',' 业 务 审 核 ','glyphicon glyphicon-ok',NULL);
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('8','7',' 实 名 认 证 审 核 ','glyphicon glyphicon-check','auth_cert/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('9','7',' 广 告 审 核 ','glyphicon glyphicon-check','auth_adv/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('10','7',' 项 目 审 核 ','glyphicon glyphicon-check','auth_project/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('11','1',' 业 务 管 理 ','glyphicon glyphicon-th-large',NULL);
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('12','11',' 资 质 维 护 ','glyphicon glyphicon-picture','cert/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('13','11',' 分 类 管 理 ','glyphicon glyphicon-equalizer','certtype/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('14','11',' 流 程 管 理 ','glyphicon glyphicon-random','process/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('15','11',' 广 告 管 理 ','glyphicon glyphicon-hdd','advert/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('16','11',' 消 息 模 板 ','glyphicon glyphicon-comment','message/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('17','11',' 项 目 分 类 ','glyphicon glyphicon-list','projectType/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('18','11',' 项 目 标 签 ','glyphicon glyphicon-tags','tag/index.htm');
insert into `t_menu` (`id`, `pid`, `name`, `icon`, `url`) values('19','1',' 参 数 管 理 ','glyphicon glyphicon-list-alt','param/index.htm');

drop table if exists t_auth;
create table t_auth(
	id int not null auto_increment,
	name varchar(200) default null,
	title varchar(200) default null,
	category_id int default null,
	primary key (id)
);

INSERT INTO t_auth(id,`name`,title,category_id) VALUES(1,'','用户模块',NULL);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(2,'user:delete','删除',1);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(3,'user:get','查询',1);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(4,'user:add','新增',1);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(5,'','角色模块',NULL);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(6,'role:delete','删除',5);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(7,'role:get','查询',5);
INSERT INTO t_auth(id,`name`,title,category_id) VALUES(8,'role:add','新增',5);

drop table if exists inner_role_auth;
create table inner_role_auth(
	id int not null auto_increment,
	role_id int,
	auth_id int,
	primary key (id)
);

insert into inner_role_auth (role_id, auth_id) values (1,2);
insert into inner_role_auth (role_id, auth_id) values (1,3);
insert into inner_role_auth (role_id, auth_id) values (1,4);
insert into inner_role_auth (role_id, auth_id) values (2,6);
insert into inner_role_auth (role_id, auth_id) values (2,7);
insert into inner_role_auth (role_id, auth_id) values (2,8);

drop table if exists t_member;
create table t_member(
 id int(11) not null auto_increment,
 loginacct varchar(255) not null,
 userpswd char(200) not null,
 username varchar(255),
 email varchar(255),
 primary key (id)
);

insert into t_member (loginacct, userpswd, username, email) values ("tom", "$2a$10$IlXkOqXWGQUB7WZKPrkLCOvKXCB4.L/u65jMv3xnaimm0Bp/SrHyW", "汤姆", "tom@qq.com");

# 分类表【原项目中，实际创建众筹项目时使用的分类数据并未从表中获得】
drop table if exists t_type;
create table t_type(
	id int(11) not null auto_increment,
	name varchar(255) comment '分类名称',
	remark varchar(255) comment '分类介绍',
	primary key (id)
);

insert into t_type (name, remark) values ("科技", "开启智慧未来");
insert into t_type (name, remark) values ("设计", "创建改变未来");
insert into t_type (name, remark) values ("农业", "网络天下肥美");
insert into t_type (name, remark) values ("公益", "汇聚点点爱心");

# 项目分类中间表
drop table if exists t_project_type;
create table t_project_type(
	id int not null auto_increment,
	projectid int(11),
	typeid int(11),
	primary key (id)
);

# 标签表【原项目中使用了假数据，因此标签表没有作用】
drop table if exists t_tag;
create table t_tag(
	id int(11) not null auto_increment,
	pid int(11),
	name varchar(255),
	primary key (id)
);

# 项目标签中间表【原项目中使用了假数据，因此标签中间表没有作用】
drop table if exists t_project_tag;
create table t_project_tag(
	id int(11) not null auto_increment,
	projectid int(11),
	tagid int(11),
	primary key (id)
);

# 项目表
drop table if exists t_project;
create table t_project(
	id int(11) not null auto_increment,
	project_name varchar(255) comment '项目名称',
	project_description varchar(255) comment '项目描述',
	money bigint (11) comment '筹集金额',
	day int(11) comment '筹集天数',
	status int(4) comment '0-即将开始，1-众筹中，2-众筹成功，3-众筹失败',
	deploydate varchar(10) comment '项目发起时间',
	supportmoney bigint(11) comment '已筹集到的金额',
	supporter int(11) comment '支持人数',
	completion int(3) comment '百分比完成度',
	memberid int(11) comment '发起人的会员 id',
	createdate varchar(19) comment '项目创建时间',
	follower int(11) comment '关注人数',
	header_picture_path varchar(255) comment '头图路径',
	primary key (id)
);

# 项目表项目详情图片表
drop table if exists t_project_item_pic;
create table t_project_item_pic(
	id int(11) not null auto_increment,
	projectid int(11),
	item_pic_path varchar(255),
	primary key (id)
);

# 项目发起人信息表
drop table if exists t_member_launch_info;
create table t_member_launch_info(
	id int(11) not null auto_increment,
	memberid int(11) comment '会员 id',
	description_simple varchar(255) comment '简单介绍',
	description_detail varchar(255) comment '详细介绍',
	phone_num varchar(255) comment '联系电话',
	service_num varchar(255) comment '客服电话',
	primary key (id)
);

# 回报信息表
drop table if exists t_return;
create table t_return(
	id int(11) not null auto_increment,
	projectid int(11),
	type int(4) comment '0 - 实物回报， 1 虚拟物品回报',
	supportmoney int(11) comment '支持金额',
	content varchar(255) comment '回报内容',
	count int(11) comment '回报产品限额， “0” 为不限回报数量',
	signalpurchase int(11) comment '是否设置单笔限购',
	purchase int(11) comment '具体限购数量',
	freight int(11) comment '运费， “0” 为包邮',
	invoice int(4) comment '0 - 不开发票， 1 - 开发票',
	returndate int(11) comment '项目结束后多少天向支持者发送回报',
	describ_pic_path varchar(255) comment '说明图片路径',
	primary key (id)
);

# 发起人确认信息表
drop table if exists t_member_confirm_info;
create table t_member_confirm_info(
	id int(11) not null auto_increment,
	memberid int(11) comment '会员 id',
	paynum varchar(200) comment '易付宝企业账号',
	cardnum varchar(200) comment '法人身份证号',
	primary key (id)
);

# 订单表
drop table if exists t_order;
CREATE TABLE t_order(
	id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
	order_num CHAR(100) COMMENT '订单号',
	pay_order_num CHAR(100) COMMENT '支付宝流水号',
	order_amount DOUBLE(10,5) COMMENT '订单金额',
	invoice INT COMMENT '是否开发票（0 不开， 1 开） ',
	invoice_title CHAR(100) COMMENT '发票抬头',
	order_remark CHAR(100) COMMENT '订单备注',
	address_id CHAR(100) COMMENT '收货地址 id',
	PRIMARY KEY (id)
);

# 收货地址表
drop table if exists t_address;
CREATE TABLE t_address(
	id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
	receive_name CHAR(100) COMMENT '收件人',
	phone_num CHAR(100) COMMENT '手机号',
	address CHAR(200) COMMENT '收货地址',
	member_id INT COMMENT '用户 id',
	PRIMARY KEY (id)
);

# 项目信息表
drop table if exists t_order_project;
CREATE TABLE t_order_project(
	id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
	project_name CHAR(200) COMMENT '项目名称',
	launch_name CHAR(100) COMMENT '发起人',
	return_content CHAR(200) COMMENT '回报内容',
	return_count INT COMMENT '回报数量',
	support_price INT COMMENT '支持单价',
	freight INT COMMENT '配送费用',
	order_id INT COMMENT '订单表的主键',
	PRIMARY KEY (`id`)
);