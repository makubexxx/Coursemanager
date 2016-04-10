CREATE DATABASE  IF NOT EXISTS `coursemanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `coursemanager`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
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
-- Table structure for table `coursenotice`
--

DROP TABLE IF EXISTS `coursenotice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursenotice` (
  `noticeid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(50) NOT NULL,
  `noticetitle` varchar(50) NOT NULL,
  `noticecontext` longtext,
  `byuser` varchar(50) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `pushda_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`noticeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursenotice`
--

LOCK TABLES `coursenotice` WRITE;
/*!40000 ALTER TABLE `coursenotice` DISABLE KEYS */;
INSERT INTO `coursenotice` VALUES (4,1,'欢迎各位同学访问我的课程信息','为了鼓励大家积极参与网络课堂，特别提示大家，访问次数和参与讨论次数最多的前5名期末总成绩加5分。 ','张老师',5,'2016-03-01 14:18:26'),(5,1,'test','test','张老师',5,'2016-03-31 08:46:06');
/*!40000 ALTER TABLE `coursenotice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10  8:27:00
