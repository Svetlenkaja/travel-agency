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
-- Table structure for table `rest_tour`
--

DROP TABLE IF EXISTS `rest_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rest_tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tour_id` int NOT NULL,
  `hotel_id` int DEFAULT NULL,
  `number_of_adults` int DEFAULT NULL,
  `number_of_children` int DEFAULT NULL,
  `room_type_location_principle_type` int DEFAULT '10',
  `room_type_location_principle_code` int DEFAULT '1',
  `room_type_by_view_type` int DEFAULT '11',
  `room_type_by_view_code` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_rest_tour_id_tour_idx` (`tour_id`),
  CONSTRAINT `fk_rest_tour_id_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rest_tour`
--

LOCK TABLES `rest_tour` WRITE;
/*!40000 ALTER TABLE `rest_tour` DISABLE KEYS */;
INSERT INTO `rest_tour` VALUES (1,5,1,0,12,10,1,11,1),(2,6,1,0,0,10,2,11,2),(3,7,1,0,0,10,1,11,2),(4,8,1,0,0,10,2,11,3),(5,9,1,0,0,10,2,11,3),(6,10,1,0,0,10,3,11,1),(7,11,1,0,0,10,1,11,1),(8,12,1,0,0,10,2,11,1),(9,13,1,0,0,10,1,11,1),(10,14,1,0,0,10,1,11,1),(11,15,1,0,0,10,1,11,1),(13,17,1,0,0,10,1,11,1),(14,18,1,0,0,10,1,1,1),(15,19,1,0,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `rest_tour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 18:01:53
