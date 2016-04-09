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
-- Table structure for table `coursediscuss`
--

DROP TABLE IF EXISTS `coursediscuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursediscuss` (
  `coursediscussid` int(11) NOT NULL AUTO_INCREMENT,
  `coursediscusstitile` varchar(50) NOT NULL,
  `coursediscusscontent` varchar(255) NOT NULL,
  `belongcourseid` varchar(50) NOT NULL,
  `bycreate` varchar(255) DEFAULT NULL,
  `onclick` int(11) DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `pushtime` datetime DEFAULT NULL,
  PRIMARY KEY (`coursediscussid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursediscuss`
--

LOCK TABLES `coursediscuss` WRITE;
/*!40000 ALTER TABLE `coursediscuss` DISABLE KEYS */;
INSERT INTO `coursediscuss` VALUES (1,'学习操作系统的感受','各位同学，操作系统课程教学已经讲授三次课了，请大家谈谈听课的感受？对于课堂教学，请问大家有没有更好的建议？','1','张老师',1,1,'2014-09-01 00:00:00'),(2,'学习心得','学习心得','1','mxs',0,0,'2016-03-06 16:59:50'),(7,'操作系统哪家强？','操作系统哪家强？','1','hehehenihaoa',0,0,'2016-03-31 15:14:15'),(8,'test','test','1','hehehenihaoa',0,0,'2016-03-31 15:23:49');
/*!40000 ALTER TABLE `coursediscuss` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-09 13:06:19
