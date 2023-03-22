/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.26 : Database - springboot_vb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot_vb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `springboot_vb`;

/*Table structure for table `auda` */

DROP TABLE IF EXISTS `auda`;

CREATE TABLE `auda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '与用户表联查',
  `auname` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '招聘者名字',
  `agree` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户是否同意',
  `describe` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '招聘描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

/*Data for the table `auda` */

insert  into `auda`(`id`,`user_id`,`auname`,`agree`,`describe`) values 
(1,1,'admin','0',NULL),
(2,2,'ali','0',NULL),
(3,3,'baidu','0',NULL),
(18,2,'admin','0',NULL),
(19,3,'admin','0',NULL);

/*Table structure for table `educations` */

DROP TABLE IF EXISTS `educations`;

CREATE TABLE `educations` (
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL COMMENT '与用户表联查',
  `from` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教育起止时间',
  `to` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教育起止时间',
  `degree` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学位',
  `school` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校',
  `description` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `tags` int DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `educations` */

insert  into `educations`(`id`,`user_id`,`from`,`to`,`degree`,`school`,`description`,`tags`) values 
(1,1,'9-2018','5-2022','硕士','萧山达利电子学院','学校不断地创新教育理念，深化教学内容、课程体系与实践教学改革，大力推进素质教育，取得了显著成果。',0),
(2,2,NULL,NULL,'学士','西湖大学',NULL,NULL),
(3,3,'9-2018','5-2022','学士','草滩皇家学院','学校不断地创新教育理念，深化教学内容、课程体系与实践教学改革，大力推进素质教育，取得了显著成果。',NULL);

/*Table structure for table `experiences` */

DROP TABLE IF EXISTS `experiences`;

CREATE TABLE `experiences` (
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL COMMENT '与用户联查',
  `role` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `company` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司',
  `fromto` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '起止时间',
  `isCurrentJob` tinyint(1) DEFAULT NULL COMMENT '是否当前工作',
  `description` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `tags` int DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `experiences` */

insert  into `experiences`(`id`,`user_id`,`role`,`company`,`fromto`,`isCurrentJob`,`description`,`tags`) values 
(1,1,'java工程师','百度','7-2018,11-2019',1,'独立处理和解决完整的Java开发项目',NULL),
(2,2,'py开发工程师','达利','9-2020,1-2021',1,'研发算法与改bug',NULL),
(3,3,'算法工程师','腾讯',NULL,1,'开发框架与加班改bug',NULL);

/*Table structure for table `interests` */

DROP TABLE IF EXISTS `interests`;

CREATE TABLE `interests` (
  `id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `interests` */

/*Table structure for table `languages` */

DROP TABLE IF EXISTS `languages`;

CREATE TABLE `languages` (
  `id` int DEFAULT NULL,
  `name` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '语言名',
  `level` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '水平'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `languages` */

/*Table structure for table `projects` */

DROP TABLE IF EXISTS `projects`;

CREATE TABLE `projects` (
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL COMMENT '跟用户实现联查',
  `name` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名',
  `link` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目链接',
  `from` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目起止时间',
  `to` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目起止时间',
  `description` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目描述',
  `tags` int DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `projects` */

insert  into `projects`(`id`,`user_id`,`name`,`link`,`from`,`to`,`description`,`tags`) values 
(1,1,'物流管理系统','link','13-2020','1-2021','这是一个物流管理系统',0),
(2,1,'线上销售系统','link.com','5-2021','10-2021','该系统是为了拓宽线上销售渠道，增加销售额委托我司开发的一个线上销售系统，主要有产品模块，用户模块，支付模块，订单模块，基础模块等',1),
(3,2,'目标检测',NULL,NULL,NULL,'深度学习，图像特征提取',NULL),
(4,3,'语音处理',NULL,NULL,NULL,'深度学习，语音降噪',NULL);

/*Table structure for table `skill` */

DROP TABLE IF EXISTS `skill`;

CREATE TABLE `skill` (
  `id` int DEFAULT NULL,
  `name` char(30) DEFAULT NULL,
  `level` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `skill` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `role` int DEFAULT NULL COMMENT '1管理员 2用户',
  `username` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `fullname` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `job` char(30) DEFAULT NULL COMMENT '工作',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `email` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `links` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
  `socialnetwork` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '社交网络',
  `resume` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人介绍',
  `experiences` char(255) DEFAULT NULL COMMENT '实习经历',
  `projects` char(255) DEFAULT NULL COMMENT '项目经历',
  `educations` char(255) DEFAULT NULL COMMENT '教育背景',
  `skills` char(255) DEFAULT NULL COMMENT '技能',
  `languages` char(255) DEFAULT NULL COMMENT '语言',
  `interests` char(255) DEFAULT NULL COMMENT '兴趣爱好',
  `certificate` char(255) DEFAULT NULL COMMENT '技能证书',
  `auda` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`role`,`username`,`password`,`fullname`,`job`,`phone`,`email`,`links`,`socialnetwork`,`resume`,`experiences`,`projects`,`educations`,`skills`,`languages`,`interests`,`certificate`,`auda`) values 
(1,2,'zhang','39677','张三','Java测试','18699999999','zhang66@163.com','super.com,dfa.com',NULL,'我是张三','1','1','1',NULL,NULL,'\'跑步\', \'游戏\', \'画画\'','计算机二级,蓝桥杯贰等奖,ACM比赛三等奖,英语六级',1),
(2,2,'wang','39677','王五','py程序设计','13263958136','wang69@163.com',NULL,NULL,'诚实可靠小王子','2','2','2',NULL,NULL,NULL,'英语六级',2),
(3,2,'zhao','39677','赵六','大数据分析','16831347979','zhao989@qq.com',NULL,NULL,'赵四个人简历','3','3','3',NULL,NULL,NULL,'计算机二级,\r\n蓝桥杯贰等奖,\r\nACM比赛三等奖,英语六级',3),
(4,1,'admin','39677','admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'英语四级',NULL),
(5,1,'ali','39677','ali',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(11,2,'xiao','39677',NULL,NULL,'13083263958',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
