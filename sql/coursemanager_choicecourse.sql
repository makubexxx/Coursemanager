-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: coursemanager
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `choicecourse`
--

DROP TABLE IF EXISTS `choicecourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choicecourse` (
  `choiceid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `coursename` varchar(50) NOT NULL,
  `coursedate` varchar(50) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `teachername` varchar(20) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`choiceid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choicecourse`
--

LOCK TABLES `choicecourse` WRITE;
/*!40000 ALTER TABLE `choicecourse` DISABLE KEYS */;
INSERT INTO `choicecourse` VALUES (1,1,'操作系统','(2014-2015秋季学期)',1140611109,'张老师','2014-08-31 16:00:00'),(2,2,'程序设计基础II——数据结构与算法(05)','(2014-2015秋季学期)',1140611109,'张老师','2014-08-31 16:00:00'),(3,3,'日本文化(01)','(2013-2014秋季学期)',1140611110,'王老师','2013-08-31 16:00:00'),(4,3,'日本文化(01)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(5,5,'大学物理(02)(2012-2013春季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(6,6,'思想道德修养与法律基础（人文素养）(02)(2012-2013春季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(7,7,'日语II(01)(2013-2014春季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(8,8,'高等数学Ⅱ(02)(2012-2013春季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(9,9,' 影视作品赏析(01)(2013-2014秋季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(10,10,'概率论与数理统计(34)(2013-2014秋季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(11,11,'Java程序设计(02)(2013-2014秋季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(12,12,'计算机组成与架构(02)(2013-2014秋季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(13,13,' 大学英语Ⅳ(01)(2014-2015春季学期)','(2013-2014秋季学期)',1140611109,'王老师','2013-08-31 16:00:00'),(14,1,'操作系统','(2014-2015秋季学期)',0,'张老师','2014-08-31 16:00:00');
/*!40000 ALTER TABLE `choicecourse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-09 13:06:18
