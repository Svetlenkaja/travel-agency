-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: travel_agency
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classifier`
--

DROP TABLE IF EXISTS `classifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classifier` (
  `type` int NOT NULL,
  `code` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `shortname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classifier`
--

LOCK TABLES `classifier` WRITE;
/*!40000 ALTER TABLE `classifier` DISABLE KEYS */;
INSERT INTO `classifier` VALUES (1,1,'Константы системы',NULL),(1,2,'Роли пользователей',NULL),(1,3,'Типы туров',NULL),(1,4,'Тип транспорта',NULL),(1,5,'Тип питания',NULL),(1,6,'Статус тура',NULL),(2,1,'Администратор',NULL),(2,2,'Менеджер',NULL),(2,3,'Клиент',NULL),(3,1,'Отдых','REST'),(3,2,'Экскурссия','EXCURSION'),(3,3,'Оздоровление','THERAPY'),(4,1,'Самолет','AIRPLANE'),(4,2,'Поезд','TRAIN'),(4,3,'Автобус','BUS'),(4,4,'Лайнер','SHIP'),(5,1,'Room only','RO'),(5,2,'Bed & breakfast','BB'),(5,3,'Half board','HB'),(5,4,'Full board','FB'),(5,5,'All inclusive','AI'),(5,6,'Ultra all inclusive','UAI'),(6,1,'Активный',NULL),(6,2,'Горящий',NULL),(6,3,'Забронирован',NULL),(6,4,'Оплачен',NULL),(6,5,'Аннулирован',NULL);
/*!40000 ALTER TABLE `classifier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 18:07:18
