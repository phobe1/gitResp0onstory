/*
 Navicat MySQL Data Transfer

 Source Server         : phobe
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : Test

 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 12/10/2017 19:12:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog_user`
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `USER_PWD` varchar(50) DEFAULT NULL,
  `MAIL` varchar(150) DEFAULT NULL,
  `ADDR` varchar(255) DEFAULT NULL,
  `BORN` varchar(60) DEFAULT NULL,
  `IN_DATE` datetime DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `USER_TYPE` int(11) DEFAULT NULL,
  `USER_STATUS` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `blog_user`
-- ----------------------------
BEGIN;
INSERT INTO `blog_user` VALUES ('1', 'admin', '233', '2ff4d63f4adb19d17cc0a99d2532b6a1', 'zdshen@163.com', null, null, null, null, '2', null), ('2', 'sysadmin', '系统管理员', '9bc34549d565d9505b287de0cd20ac77be1d3f2c', null, null, null, null, null, '2', null), ('12', 'tom5', '汤姆', '1234567', '123@163.com', '北京市', null, null, '2017-12-10 12:04:52', null, null), ('13', 'tom6', '汤姆6', '123456', '123@163.com', '北京市', null, null, '2017-12-10 16:23:04', null, null), ('14', 'www', 'wwww', 'wewewe', '78897', 'wew', null, null, null, null, null), ('15', 'tom7', '汤姆', '1234567', '123@163.com', '北京市', null, null, '2017-12-10 18:45:42', null, null), ('16', 'aa', 'aa', 'aa', '123@163.com', 'aa', null, null, '2017-12-10 18:47:03', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
