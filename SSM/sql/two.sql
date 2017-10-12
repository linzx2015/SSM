/*
Navicat MySQL Data Transfer

Source Server         : iamp
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : two

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-12 11:20:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_video
-- ----------------------------
DROP TABLE IF EXISTS `t_video`;
CREATE TABLE `t_video` (
  `video_name` varchar(50) NOT NULL DEFAULT '' COMMENT '摄像头名称',
  `video_url` varchar(255) NOT NULL DEFAULT '' COMMENT '摄像头地址',
  `video_id` varchar(255) NOT NULL COMMENT '摄像头id',
  `video_description` varchar(255) NOT NULL COMMENT '摄像头描述',
  `video_create_time` datetime NOT NULL COMMENT '摄像头创建时间',
  `video_update_time` datetime NOT NULL COMMENT '摄像头更新时间',
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_video
-- ----------------------------
INSERT INTO `t_video` VALUES ('权利的游戏', 'www.baidu.com/s????', 'c2a0f9aebe544476ac8195fbf4bf06d7', '好像很好看的样子', '2017-10-12 10:49:26', '2017-10-12 10:49:26');
