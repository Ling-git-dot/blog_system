/*
Navicat Premium Data Transfer

Source Server         : localhost
Source Server Type    : MySQL
Source Server Version : 50730
Source Host           : localhost:3306
Source Schema         : blog_system

Target Server Type    : MySQL
Target Server Version : 50730
File Encoding         : 65001

Date: 21/06/2023 14:53:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
`content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章具体内容',
`created` date NOT NULL COMMENT '发表时间',
`modified` date NULL DEFAULT NULL COMMENT '修改时间',
`categories` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '默认分类' COMMENT '文章分类',
`tags` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标签',
`allow_comment` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否允许评论',
`thumbnail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章缩略图',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`authority` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
`article_id` int(11) NOT NULL COMMENT '关联的文章id',
`created` date NOT NULL COMMENT '评论时间',
`ip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户登录的ip地址',
`content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
`status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'approved' COMMENT '评论状态',
`author` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论用户用户名',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_statistic
-- ----------------------------
DROP TABLE IF EXISTS `t_statistic`;
CREATE TABLE `t_statistic`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`article_id` int(11) NOT NULL COMMENT '关联的文章id',
`hits` int(11) NOT NULL DEFAULT 0 COMMENT '文章点击总量',
`comments_num` int(11) NOT NULL DEFAULT 0 COMMENT '文章评论总量',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`created` date NULL DEFAULT NULL,
`valid` tinyint(1) NOT NULL DEFAULT 1,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_authority`;
CREATE TABLE `t_user_authority`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NOT NULL COMMENT '关联的用户id',
`authority_id` int(11) NOT NULL COMMENT '关联的权限id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
