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
-- Table structure for table `courserwork`
--

DROP TABLE IF EXISTS `courserwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courserwork` (
  `courseworkid` int(11) NOT NULL AUTO_INCREMENT,
  `belongcourseid` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `courseworktitle` varchar(255) DEFAULT NULL,
  `coursework_content` text,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `statue` int(11) DEFAULT NULL,
  `attachment` varchar(255) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`courseworkid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courserwork`
--

LOCK TABLES `courserwork` WRITE;
/*!40000 ALTER TABLE `courserwork` DISABLE KEYS */;
INSERT INTO `courserwork` VALUES (1,'1',1140611109,'第1章课后作业','1. 比较单道批处理OS、多道批处理OS、分时OS、实时OS的主要特征。 2. OS有哪些几大特征？其最基本的特征什么？','2013-03-04 16:00:00','2013-03-30 16:00:00',1,'demo.java',0);
/*!40000 ALTER TABLE `courserwork` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-28 22:18:03
