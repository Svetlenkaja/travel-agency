-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_agency
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
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tour_type` int NOT NULL,
  `tour_code` int NOT NULL,
  `transport_type` int NOT NULL,
  `transport_code` int NOT NULL,
  `food_type` int NOT NULL,
  `food_code` int NOT NULL,
  `date_of_departure` datetime DEFAULT NULL,
  `number_of_nights` int NOT NULL,
  `state_type` int DEFAULT NULL,
  `state_code` int DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `cost_with_discont` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (5,3,1,4,1,5,5,NULL,7,6,1,500,0),(6,3,1,4,1,5,3,NULL,10,6,2,1000,0),(7,3,1,4,1,5,2,NULL,10,6,3,100,0),(8,3,1,4,1,5,2,NULL,10,6,1,1000,0),(9,3,1,4,1,5,3,NULL,5,6,1,500,0),(10,3,1,4,2,5,3,NULL,7,6,1,800,0),(11,4,1,4,3,4,4,NULL,5,6,1,300,0),(12,4,1,4,1,4,2,NULL,2,6,1,100,0),(13,4,1,4,1,4,2,NULL,10,6,1,800,0),(14,4,1,4,1,4,2,NULL,12,6,1,950,0),(15,4,1,4,2,4,2,NULL,10,6,1,700,0),(17,3,1,3,2,3,2,NULL,10,6,1,100,0),(18,3,1,3,2,3,2,NULL,10,6,1,100,0),(19,3,1,3,1,3,2,NULL,10,6,1,100,0);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-21  1:26:21