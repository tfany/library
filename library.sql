/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 17/06/2019 17:41:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_category` int(10) NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rent` decimal(10, 2) NULL DEFAULT NULL COMMENT '租金 按月算',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `public_time` datetime(0) NULL DEFAULT NULL,
  `supplier` int(10) NULL DEFAULT NULL,
  `stock` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `b_category`(`book_category`) USING BTREE,
  INDEX `b_supplier`(`supplier`) USING BTREE,
  CONSTRAINT `b_category` FOREIGN KEY (`book_category`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b_supplier` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book_img
-- ----------------------------
DROP TABLE IF EXISTS `book_img`;
CREATE TABLE `book_img`  (
  `book_img_id` int(10) NOT NULL,
  `book` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_img_id`) USING BTREE,
  INDEX `b_book`(`book`) USING BTREE,
  CONSTRAINT `b_book` FOREIGN KEY (`book`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(10) NOT NULL,
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '历史', NULL, NULL);
INSERT INTO `category` VALUES (2, '文学', NULL, 1);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `history_id` int(10) NOT NULL AUTO_INCREMENT,
  `book` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user` int(10) NULL DEFAULT NULL,
  `rent_time` datetime(0) NULL DEFAULT NULL,
  `remand_time` datetime(0) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `num` int(10) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '0未还 1已还',
  PRIMARY KEY (`history_id`) USING BTREE,
  INDEX `h_user`(`user`) USING BTREE,
  INDEX `h_book`(`book`) USING BTREE,
  CONSTRAINT `h_book` FOREIGN KEY (`book`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_user` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_id` int(10) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank`  (
  `level` int(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discount` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`level`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES (1, '假的会员', 1.00);
INSERT INTO `rank` VALUES (2, '白银会员', 0.98);
INSERT INTO `rank` VALUES (3, '黄金会员', 0.95);
INSERT INTO `rank` VALUES (4, '白金会员', 0.90);
INSERT INTO `rank` VALUES (5, '钻石会员', 0.85);
INSERT INTO `rank` VALUES (6, '王者会员', 0.80);

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent`  (
  `rent_id` int(10) NOT NULL,
  `user` int(10) NULL DEFAULT NULL,
  `book` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rent_count` int(10) NULL DEFAULT NULL,
  `rent_time` datetime(0) NULL DEFAULT NULL,
  `duration` int(10) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `rend_id` int(11) NOT NULL,
  `r_book` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rent_id`) USING BTREE,
  INDEX `r_book`(`book`) USING BTREE,
  INDEX `r_user`(`user`) USING BTREE,
  INDEX `FKrktt5g7d5b94nf7ifhbrorid4`(`r_book`) USING BTREE,
  CONSTRAINT `FKrktt5g7d5b94nf7ifhbrorid4` FOREIGN KEY (`r_book`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `r_book` FOREIGN KEY (`book`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `r_user` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `supplier_id` int(10) NOT NULL,
  `supplier_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_num` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(18) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_num` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT 1 COMMENT '0不可用 1可用',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` int(1) NULL DEFAULT 1,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `u_phone_num`(`phone_num`) USING BTREE,
  INDEX `u_rank`(`rank`) USING BTREE,
  CONSTRAINT `u_rank` FOREIGN KEY (`rank`) REFERENCES `rank` (`level`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10001, '江泽晖', '男', 'tf511925', '13992543350', '2019-06-14 18:04:33', '2019-06-14 18:04:33', 1, '/userHeadImg/10001/2019061418043317759.jpg', 1);
INSERT INTO `user` VALUES (10002, '132', '男', '123456', '13999999999', '2019-06-16 11:23:05', '2019-06-16 11:23:05', 1, '/userHeadImg/10002/2019061611230561173.png', 1);
INSERT INTO `user` VALUES (10003, '123', '男', '132465', '13992543360', '2019-06-16 11:25:28', '2019-06-16 11:25:28', 1, '/userHeadImg/10003/2019061611252766015.jpg', 1);

SET FOREIGN_KEY_CHECKS = 1;
