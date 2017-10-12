/*
Navicat MySQL Data Transfer

Source Server         : iamp
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : one

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-12 11:20:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for o_user
-- ----------------------------
DROP TABLE IF EXISTS `o_user`;
CREATE TABLE `o_user` (
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `user_account` varchar(50) NOT NULL COMMENT '用户账号',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_sex` int(5) NOT NULL COMMENT '性别',
  `user_age` int(20) NOT NULL COMMENT '年龄',
  `user_creator` varchar(20) NOT NULL COMMENT '创建人',
  `user_department` varchar(20) NOT NULL COMMENT '所属部门',
  `user_phone` varchar(20) NOT NULL COMMENT '手机号码',
  `user_email` varchar(20) NOT NULL COMMENT '邮箱',
  `user_create_time` datetime NOT NULL COMMENT '创建时间',
  `user_update_time` datetime NOT NULL COMMENT '更新时间',
  `user_last_login_time` datetime NOT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_user
-- ----------------------------
INSERT INTO `o_user` VALUES ('d9bf7d617c9548f6909734622f5ded2a', 'lzx', 'linzx2015', 'sha256$LddlwdQJkz9hu3atVoqnC6Aq2mAXLndG$7a55960686250dda71c898f644b9505665769d6baded59e0163c6b80bcedc51e', '0', '22', 'admin', '开发部', '15394415898', '857720446@qq.com', '2017-10-12 10:38:56', '2017-10-12 10:38:56', '2017-10-12 10:38:56');
