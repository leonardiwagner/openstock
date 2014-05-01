CREATE DATABASE  IF NOT EXISTS `bankofjava` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bankofjava`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bankofjava
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.14.04.1

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `balance` datetime NOT NULL,
  `created` datetime NOT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (3,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:41:50',NULL),(4,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:48:29',NULL),(5,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:51:00',NULL),(6,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:51:30',NULL),(7,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:51:32',NULL),(8,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:51:56',NULL),(9,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:51:58',NULL),(10,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 18:52:10',NULL),(11,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:03:15',NULL),(12,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-04-27 19:03:16',NULL),(13,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:07:53',NULL),(14,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:08:12',NULL),(15,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:08:34',NULL),(16,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:14:26',NULL),(17,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-04-27 19:15:12',NULL),(18,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-05-01 13:27:28',NULL),(19,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-05-01 13:27:29',NULL),(20,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-05-01 13:27:29',NULL),(21,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-05-01 13:28:15',NULL),(22,'User Test Coin','test.coin@bankofjava.com','123','0000-00-00 00:00:00','2014-05-01 13:28:16',NULL),(23,'Julius','julius@julius.com','123','0000-00-00 00:00:00','2014-05-01 13:28:16',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coin`
--

DROP TABLE IF EXISTS `coin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin`
--

LOCK TABLES `coin` WRITE;
/*!40000 ALTER TABLE `coin` DISABLE KEYS */;
INSERT INTO `coin` VALUES (1,15,'2014-04-27 19:08:34'),(2,17,'2014-04-27 19:15:12'),(3,18,'2014-05-01 13:27:29'),(4,21,'2014-05-01 13:28:16');
/*!40000 ALTER TABLE `coin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investment`
--

DROP TABLE IF EXISTS `investment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL,
  `index` int(11) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investment`
--

LOCK TABLES `investment` WRITE;
/*!40000 ALTER TABLE `investment` DISABLE KEYS */;
/*!40000 ALTER TABLE `investment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-01 13:50:56
