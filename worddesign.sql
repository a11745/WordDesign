/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.53 : Database - worddesign
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`worddesign` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `worddesign`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`pwd`,`role`) values (1,'root','root',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`state`) values (1,'zhang','123',1),(2,'lisi','123',0),(3,'wangwu','123',0);

/*Table structure for table `userlog` */

DROP TABLE IF EXISTS `userlog`;

CREATE TABLE `userlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `log-user` (`userId`),
  CONSTRAINT `log-user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `userlog` */

insert  into `userlog`(`id`,`ip`,`userId`,`addtime`) values (1,'127.0.0.1',1,'2018-07-17 09:59:37'),(2,'127.0.0.1',1,'2018-07-17 00:00:00'),(3,'127.0.0.1',1,'2018-07-19 00:00:00'),(4,'127.0.0.1',1,'2018-07-19 00:00:00'),(5,'127.0.0.1',1,'2018-07-19 00:00:00'),(6,'127.0.0.1',1,'2018-07-19 00:00:00'),(7,'127.0.0.1',1,'2018-07-19 00:00:00'),(8,'127.0.0.1',1,'2018-07-19 00:00:00'),(9,'127.0.0.1',1,'2018-07-19 00:00:00');

/*Table structure for table `words` */

DROP TABLE IF EXISTS `words`;

CREATE TABLE `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordname` varchar(255) DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `chinese` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `word-user` (`userid`),
  CONSTRAINT `word-user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `words` */

insert  into `words`(`id`,`wordname`,`quality`,`state`,`userid`,`chinese`) values (1,'abc','abc',11,1,'abc'),(3,'delete','n',1,1,'删除'),(4,'age','n',1,1,'年龄'),(5,'sex','n',0,1,'性别'),(6,'name','n',0,1,'姓名'),(7,'add','v',0,1,'添加'),(8,'teacher','n',0,1,'老师');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
