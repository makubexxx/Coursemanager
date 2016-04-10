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
-- Table structure for table `coursedetail`
--

DROP TABLE IF EXISTS `coursedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursedetail` (
  `courseid` int(11) NOT NULL,
  `course_noid` int(50) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `coursecredit` int(11) DEFAULT NULL,
  `studytimes` int(11) DEFAULT NULL,
  `teachername` varchar(255) DEFAULT NULL,
  `teacheremail` varchar(255) DEFAULT NULL,
  `targetbook` varchar(255) DEFAULT NULL,
  `bibliography` varchar(255) DEFAULT NULL,
  `teachmodel` varchar(255) DEFAULT NULL,
  `course_description` longtext,
  `coursecanlendar` longtext,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursedetail`
--

LOCK TABLES `coursedetail` WRITE;
/*!40000 ALTER TABLE `coursedetail` DISABLE KEYS */;
INSERT INTO `coursedetail` VALUES (1,2,'操作系统',4,60,'张老师','112@163.com','冯裕忠.操作系统.北京.清华大学出版社.2010-8','汤子瀛.计算机操作系统.西安.西安电子科技大学出版社(修订版)','授课+实验','《操作系统》是计算机类课程的必修专业核心课。操作系统是计算机系统中必不可少的系统软件，是计算机系统中各种资源的管理者和各种活动的组织者、指挥者，它使整个计算机系统协调一致且有效地工作。','1. 理论教学（共45课时）');
/*!40000 ALTER TABLE `coursedetail` ENABLE KEYS */;
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
