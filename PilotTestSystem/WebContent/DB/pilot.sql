/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : pilot

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-12-19 07:34:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_chapter
-- ----------------------------
DROP TABLE IF EXISTS `tb_chapter`;
CREATE TABLE `tb_chapter` (
  `chapterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_chapter
-- ----------------------------
INSERT INTO `tb_chapter` VALUES ('1', '第一章ABC', '章节一内容', '章节一注释', '状态一');
INSERT INTO `tb_chapter` VALUES ('2', '第二章', '章节二内容', '章节二注释', '状态二');
INSERT INTO `tb_chapter` VALUES ('3', '第三章', '章节三内容', '章节三注释', '状态三 ');
INSERT INTO `tb_chapter` VALUES ('4', '第四章', '章节四内容', '章节四注释', '状态四');
INSERT INTO `tb_chapter` VALUES ('5', '第五章', '第五章内容', '第五章介绍', null);

-- ----------------------------
-- Table structure for tb_error
-- ----------------------------
DROP TABLE IF EXISTS `tb_error`;
CREATE TABLE `tb_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicId` int(11) DEFAULT NULL,
  `errorCount` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `continueSelect` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_error
-- ----------------------------
INSERT INTO `tb_error` VALUES ('1', '1', '2', '1', 'Y');
INSERT INTO `tb_error` VALUES ('3', '3', '3', '1', 'Y');
INSERT INTO `tb_error` VALUES ('4', '7', '2', '1', 'Y');
INSERT INTO `tb_error` VALUES ('5', '9', '3', '1', 'Y');
INSERT INTO `tb_error` VALUES ('6', '12', '1', '1', 'N');
INSERT INTO `tb_error` VALUES ('7', '15', '1', '1', 'Y');
INSERT INTO `tb_error` VALUES ('9', '8', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('10', '4', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('11', '1', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('12', '3', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('13', '4', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('14', '6', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('15', '6', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('16', '9', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('17', '2', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('18', '8', '4', '9', 'Y');
INSERT INTO `tb_error` VALUES ('19', '9', '4', '9', 'Y');

-- ----------------------------
-- Table structure for tb_exam
-- ----------------------------
DROP TABLE IF EXISTS `tb_exam`;
CREATE TABLE `tb_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examTime` datetime DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `examName` varchar(100) DEFAULT NULL,
  `choiceNum` int(11) DEFAULT NULL,
  `choiceScore` int(11) DEFAULT NULL,
  `judgeNum` int(11) DEFAULT NULL,
  `judgeScore` int(11) DEFAULT NULL,
  `blankNum` int(11) DEFAULT NULL,
  `blankScore` int(11) DEFAULT NULL,
  `comment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_exam
-- ----------------------------
INSERT INTO `tb_exam` VALUES ('1', '2016-12-13 22:25:39', '60', '胡鹏程', '统考', '期末考试', '15', '15', '20', '1', '12', '12', '什么意思啊');
INSERT INTO `tb_exam` VALUES ('2', '2016-12-21 17:14:55', '69', '胡鹏程', '统考', '期末考试', '2', '2', '2', '1', '1', '2', '搞鬼啊');
INSERT INTO `tb_exam` VALUES ('3', '2016-12-10 21:03:51', '24', '胡鹏程', '自考', '自考测试1', '1', '1', '1', '0', '1', '0', '内容');
INSERT INTO `tb_exam` VALUES ('4', '2016-12-11 00:00:00', '12', '胡鹏程', '自考', '自主考试-2016-12-11', '5', '4', '1', '0', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('5', '2016-12-12 22:04:32', '60', '胡鹏程', '自考', '自考测试2', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('6', '2016-12-12 22:04:36', '60', '胡鹏程', '自考', '自考测试3', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('7', '2016-12-13 22:04:41', '60', '胡鹏程', '自考', '自考测试4', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('8', '2016-12-14 22:04:45', '60', '胡鹏程', '自考', '自考测试5', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('9', '2016-12-15 22:04:51', '60', '胡鹏程', '自考', '自考测试6', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('10', '2016-12-16 22:04:54', '60', '胡鹏程', '自考', '自考测试7', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('11', '2016-12-17 22:04:57', '60', '胡鹏程', '自考', '自考测试8', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('12', '2016-12-16 22:05:42', '60', '苗乐飞', '自考', '自考测试9', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('13', '2016-12-18 22:05:48', '60', '苗乐飞', '自考', '自考测试10', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('14', '2016-12-19 22:05:56', '60', '苗乐飞', '自考', '自考测试11', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('15', '2016-12-20 22:05:59', '60', '苗乐飞', '自考', '自考测试12', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('16', '2016-12-21 22:06:02', '60', '苗乐飞', '自考', '自考测试13', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('17', '2016-12-22 22:06:05', '60', '苗乐飞', '自考', '自考测试14', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('18', '2016-12-21 22:06:08', '60', '苗乐飞', '自考', '自考测试15', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('19', '2016-12-22 22:06:12', '60', '苗乐飞', '自考', '自考测试16', null, null, null, null, null, null, null);
INSERT INTO `tb_exam` VALUES ('20', '2016-12-14 00:00:00', '12', 'mlf', '自考', '自主考试-2016-12-14', '3', '3', '1', '0', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('21', '2016-12-14 00:00:00', '12', 'mlf', '自考', '自主考试-2016-12-14', '3', '2', '1', '1', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('22', '2016-12-14 00:00:00', '60', 'mlf', '自考', '自主考试-2016-12-14', '3', '5', '1', '1', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('23', '2016-12-14 00:00:00', '60', 'mlf', '自考', '自主考试-2016-12-14', '2', '5', '1', '1', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('24', '2016-12-14 00:00:00', '12', 'mlf', '自考', '自主考试-2016-12-14', '3', '7', '1', '2', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('25', '2016-12-14 00:00:00', '21', 'mlf', '自考', '自主考试-2016-12-14', '6', '12', '2', '3', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('26', '2016-12-14 00:00:00', '12', 'mlf', '自考', '自主考试-2016-12-14', '3', '14', '1', '4', '0', '0', '内容');
INSERT INTO `tb_exam` VALUES ('27', '2016-12-15 00:00:00', '40', 'mlf', '自考', '自主考试-2016-12-15', '4', '3', '1', '0', '0', '0', '内容');

-- ----------------------------
-- Table structure for tb_paper
-- ----------------------------
DROP TABLE IF EXISTS `tb_paper`;
CREATE TABLE `tb_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `topicId` int(11) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_paper
-- ----------------------------
INSERT INTO `tb_paper` VALUES ('1', '2', '1', '1', 'A', '1');
INSERT INTO `tb_paper` VALUES ('2', '2', '1', '2', 'C', '1');
INSERT INTO `tb_paper` VALUES ('3', '2', '1', '4', 'true', '1');
INSERT INTO `tb_paper` VALUES ('4', '2', '1', '9', 'false', '1');
INSERT INTO `tb_paper` VALUES ('5', '2', '1', '5', '空格', '2');
INSERT INTO `tb_paper` VALUES ('6', '3', '1', '1', 'A', '1');
INSERT INTO `tb_paper` VALUES ('7', '3', '1', '4', 'false', '0');
INSERT INTO `tb_paper` VALUES ('8', '3', '1', '5', '不会', '0');

-- ----------------------------
-- Table structure for tb_range
-- ----------------------------
DROP TABLE IF EXISTS `tb_range`;
CREATE TABLE `tb_range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `chapterId` varchar(50) DEFAULT NULL,
  `totalScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_range
-- ----------------------------

-- ----------------------------
-- Table structure for tb_right
-- ----------------------------
DROP TABLE IF EXISTS `tb_right`;
CREATE TABLE `tb_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_right
-- ----------------------------

-- ----------------------------
-- Table structure for tb_section
-- ----------------------------
DROP TABLE IF EXISTS `tb_section`;
CREATE TABLE `tb_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chapterId` varchar(10) DEFAULT NULL,
  `sectionId` varchar(10) DEFAULT NULL,
  `chapterName` varchar(50) DEFAULT NULL,
  `sectionName` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  `flags` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_section
-- ----------------------------
INSERT INTO `tb_section` VALUES ('1', '1', '1.1', '第一章', '第1.1小节', '1.1内容', '标志');
INSERT INTO `tb_section` VALUES ('2', '1', '1.2', '第一章', '第1.2小节', '1.2内容', '标志');
INSERT INTO `tb_section` VALUES ('3', '1', '1.3', '第一章', '第1.3小节', '1.3内容', '标志');
INSERT INTO `tb_section` VALUES ('4', '1', '1.4', '第一章', '第1.4小节', '1.4内容', '标志');
INSERT INTO `tb_section` VALUES ('5', '2', '2.1', '第二章', '第2.1小节', '2.1内容', '标志');
INSERT INTO `tb_section` VALUES ('6', '2', '2.2', '第二章', '第2.2小节', '2.2内容', '标志');
INSERT INTO `tb_section` VALUES ('7', '2', '2.3', '第二章', '第2.3小节', '2.3内容', '标志');
INSERT INTO `tb_section` VALUES ('8', '3', '3.1', '第三章', '第3.1小节', '3.1内容', '标志');
INSERT INTO `tb_section` VALUES ('9', '3', '3.2', '第三章', '第3.2小节', '3.2内容', '标志');
INSERT INTO `tb_section` VALUES ('10', '4', '4.1', '第四章', '第4.1小节', '4.1内容', '标志');
INSERT INTO `tb_section` VALUES ('11', '4', '4.2', '第四章', '第4.2小节', '4.2内容', '标志');
INSERT INTO `tb_section` VALUES ('12', '4', '4.3', '第四章', '第4.3小节', '4.3内容', '标志');

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(300) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `chapterId` int(11) DEFAULT NULL,
  `chapterName` varchar(50) DEFAULT NULL,
  `sectionName` varchar(50) DEFAULT NULL,
  `optionA` varchar(100) DEFAULT NULL,
  `optionB` varchar(100) DEFAULT NULL,
  `optionC` varchar(100) DEFAULT NULL,
  `optionD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_topic
-- ----------------------------
INSERT INTO `tb_topic` VALUES ('1', '美国总统是喵喵喵？', 'A', 'choice', '1', '1', '第一章', '第1.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('2', '中国总统是谁？', 'A', 'choice', '1', '1', '第一章', '第1.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('3', '印度总统是谁？', 'A', 'choice', '1', '1', '第一章', '第1.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('4', '俄罗斯总统是谁？', 'true', 'judge', '1', '1', '第一章', '第1.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('5', '加拿大总统是谁？', '空格', 'blank', '2', '1', '第一章', '第1.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('6', '英国总统是谁？', 'A', 'choice', '1', '2', '第二章', '第2.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('7', '法国总统是谁？', 'A', 'choice', '1', '2', '第二章', '第2.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('8', '德国总统是谁？', 'A', 'choice', '1', '2', '第二章', '第2.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('9', '葡萄牙总统是谁？', 'true', 'judge', '1', '2', '第二章', '第2.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('10', '叙利亚总统是谁？', '空格', 'blank', '2', '2', '第二章', '第2.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('11', '伊拉克总统是谁？', 'A', 'choice', '1', '3', '第三章', '第3.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('12', '巴西总统是谁？', 'A', 'choice', '1', '3', '第三章', '第3.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('13', '阿根廷总统是谁？', 'A', 'choice', '1', '3', '第三章', '第3.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('14', '巴基斯坦总统是谁？', 'true', 'judge', '1', '3', '第三章', '第3.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('15', '以色列总统是谁？', '空格', 'blank', '2', '3', '第三章', '第3.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('16', '日本总统是谁？', 'A', 'choice', '1', '4', '第四章', '第4.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('17', '韩国总统是谁？', 'A', 'choice', '1', '4', '第四章', '第4.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('18', '蒙古总统是谁？', 'A', 'choice', '1', '4', '第四章', '第4.1小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('19', '白俄罗斯总统是谁？', 'true', 'judge', '1', '4', '第四章', '第4.2小节', 'A', 'B', 'C', 'D');
INSERT INTO `tb_topic` VALUES ('20', '马来西亚总统是谁？', '空格', 'blank', '2', '4', '第四章', '第4.1小节', 'A', 'B', 'C', 'D');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `identity` varchar(18) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `registDate` datetime DEFAULT NULL,
  `rightNum` int(11) DEFAULT NULL,
  `finishNum` int(11) DEFAULT NULL,
  `errorNum` int(11) DEFAULT NULL,
  `examNum` int(11) DEFAULT NULL,
  `comment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '3333333', 'hpc', '9999999', 'manager', '问题', '答案', '1993-06-12 00:00:00', '12', '13', '1', '1', 'god');
INSERT INTO `tb_user` VALUES ('2', '666666', 'xxq', '123456789', 'manager', '问题', '答案', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('3', '666666', 'll', '123456789', 'manager', '问题', '答案', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('4', '666666', 'lcj', '123456789', 'user', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('5', '666666', 'wqb', '123456789', 'user', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('6', '666666', 'wsb', '123456789', 'user', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('7', '666666', 'spl', '123456789', 'user', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('8', '666666', 'i', '123456789', 'user', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('9', '666666', 'mlf', '123456789', 'user', null, null, null, null, null, null, null, null);
