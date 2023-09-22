/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : studb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/09/2023 14:16:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user3
-- ----------------------------
DROP TABLE IF EXISTS `tb_user3`;
CREATE TABLE `tb_user3`  (
  `id` int(11) NULL DEFAULT NULL,
  `username` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user3
-- ----------------------------
INSERT INTO `tb_user3` VALUES (1, 'zs', '123456', 'zs@sina.com', '1980-12-04');
INSERT INTO `tb_user3` VALUES (2, 'lisi', '123456', 'lisi@sina.com', '1981-12-4');
INSERT INTO `tb_user3` VALUES (3, 'uangun', '123456', 'uangun@sina.com', '1977-12-04');
INSERT INTO `tb_user3` VALUES (4, 'zl', '123456', 'zl@sina.com', '1989-12-23');

SET FOREIGN_KEY_CHECKS = 1;
