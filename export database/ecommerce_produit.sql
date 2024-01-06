-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `path_photo` varchar(255) DEFAULT NULL,
  `categorie_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categorie_id` (`categorie_id`),
  CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (21,'Iphon 15',5000,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/8.jpeg',184),(22,'samsung galaxy s23 ultra',3500,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/9.png',184),(23,'pc portable msi',2500,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/11.jpeg',184),(24,'pc bureau lenovo',1800,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/12.jpeg',184),(25,'pc portable dell',1500,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/10.jpg',184),(26,'imprimante kyocera',950,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/13.jpeg',184),(27,'imprimante hp',650,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/14.jpeg',184),(28,'bicyclette btwin',900,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/15.jpeg',185),(29,'bicyclette decathlon',500,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/16.jpeg',185),(30,'bicyclette vtt rodeo',750,'C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images/17.jpeg',185);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-06 11:20:07
