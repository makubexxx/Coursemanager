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
-- Table structure for table `coursereply`
--

DROP TABLE IF EXISTS `coursereply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursereply` (
  `coursereplyid` int(11) NOT NULL AUTO_INCREMENT,
  `belongcoursediscussid` varchar(255) DEFAULT NULL,
  `replyuser` varchar(255) DEFAULT NULL,
  `reply_content` text,
  `reply_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`coursereplyid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursereply`
--

LOCK TABLES `coursereply` WRITE;
/*!40000 ALTER TABLE `coursereply` DISABLE KEYS */;
INSERT INTO `coursereply` VALUES (1,'1','呵呵','老师讲的好','2014-08-31 16:00:00'),(2,'1','哈哈','老师讲的很详细','2014-08-31 16:00:00'),(3,'1','张三','老师讲的很清楚','2014-08-31 16:00:00'),(4,'1','李四','老师讲的很仔细','2014-08-31 16:00:00'),(5,'1','mxs','12344','2016-03-06 08:31:07'),(6,'2','admin','学习心得','2016-04-07 07:35:45');
/*!40000 ALTER TABLE `coursereply` ENABLE KEYS */;
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
