/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.37 : Database - score
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`score` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `score`;

/*Table structure for table `cms_article` */

DROP TABLE IF EXISTS `cms_article`;

CREATE TABLE `cms_article` (
  `id` varchar(64) DEFAULT NULL,
  `category_id` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `link` varchar(64) DEFAULT NULL COMMENT '文章链接',
  `color` varchar(32) DEFAULT NULL COMMENT '标题颜色',
  `image` varchar(64) DEFAULT NULL COMMENT '文章图片',
  `keywords` varchar(64) DEFAULT NULL COMMENT '关键词',
  `decription` varchar(128) DEFAULT NULL COMMENT '描述',
  `hits` int(11) DEFAULT NULL COMMENT '点击次数',
  `weight` varchar(16) DEFAULT NULL COMMENT '权重',
  `weight_date` varchar(16) DEFAULT NULL COMMENT '权重权限',
  `posid` varchar(16) DEFAULT NULL COMMENT '推进位',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志位'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cms_article` */

/*Table structure for table `cms_data` */

DROP TABLE IF EXISTS `cms_data`;

CREATE TABLE `cms_data` (
  `id` varchar(64) DEFAULT NULL,
  `copyfrom` varchar(64) DEFAULT NULL COMMENT '文章来源',
  `relation` varchar(64) DEFAULT NULL,
  `allow_comment` char(64) DEFAULT NULL COMMENT '是否允许评论',
  `url_content` varchar(64) DEFAULT NULL COMMENT '地址连接',
  `one_content` text COMMENT '一级内容',
  `two_content` text COMMENT '二级内容',
  `three_content` text COMMENT '三级内容',
  `four_content` text COMMENT '四级内容'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cms_data` */

/*Table structure for table `cms_date_role` */

DROP TABLE IF EXISTS `cms_date_role`;

CREATE TABLE `cms_date_role` (
  `id` varchar(64) DEFAULT NULL,
  `cms_id` varchar(64) DEFAULT NULL COMMENT '文章表关联到 cms_article',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色表关联到sys_role'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cms_date_role` */

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `login_ip` varchar(64) DEFAULT NULL COMMENT '登录的ip',
  `login_flag` char(1) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL COMMENT '登录日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `login_log` */

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` varchar(64) NOT NULL,
  `value` varchar(64) DEFAULT NULL COMMENT '键值',
  `label` varchar(64) DEFAULT NULL COMMENT '字典的值',
  `type` varchar(64) DEFAULT NULL COMMENT '类型',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `sort` varchar(64) DEFAULT NULL COMMENT '字段修改',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `sys_dict` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(64) DEFAULT NULL,
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属机构',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `enname` varchar(64) DEFAULT NULL COMMENT '角色英语名称',
  `role_type` varchar(64) DEFAULT NULL COMMENT '角色类型',
  `data_sope` varchar(64) DEFAULT NULL,
  `is_sys` char(1) DEFAULT NULL COMMENT '是否管理员',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志位',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限控制表';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_user` */

DROP TABLE IF EXISTS `sys_role_user`;

CREATE TABLE `sys_role_user` (
  `id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '关联到用户表',
  `role_id` varchar(64) DEFAULT NULL COMMENT '关联到角色表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_user` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(64) DEFAULT NULL,
  `area` varchar(128) DEFAULT NULL COMMENT '地址',
  `company` varchar(64) DEFAULT NULL COMMENT '公司',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `no` varchar(64) DEFAULT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `email` varchar(64) DEFAULT NULL COMMENT '邮编',
  `phone` varchar(64) DEFAULT NULL COMMENT '电话号码',
  `mobile` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `user_type` varchar(64) DEFAULT NULL COMMENT '用户类型',
  `photo_path` varchar(64) DEFAULT NULL COMMENT '用户头像',
  `login_log_id` varchar(64) DEFAULT NULL COMMENT '用户登录记录日志',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改者',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志位',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
