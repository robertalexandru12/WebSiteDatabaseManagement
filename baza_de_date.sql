-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pibd
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `idclient` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) NOT NULL,
  `prenume` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `buget` float DEFAULT NULL,
  PRIMARY KEY (`idclient`),
  UNIQUE KEY `idclienti_UNIQUE` (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (113,'Popa','Florin','Dragasani, Valcea',1500),(114,'Florin','POP','jud Constanta',5900),(115,'Popescu','Andrei','Tg Jiu, jud Gor',1000),(116,'Manea','George','Bucuresti',2222);
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `constructori`
--

DROP TABLE IF EXISTS `constructori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `constructori` (
  `idconstructor` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) NOT NULL,
  `prenume` varchar(45) NOT NULL,
  `salariu` float DEFAULT NULL,
  PRIMARY KEY (`idconstructor`),
  UNIQUE KEY `idconstructor_UNIQUE` (`idconstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `constructori`
--

LOCK TABLES `constructori` WRITE;
/*!40000 ALTER TABLE `constructori` DISABLE KEYS */;
INSERT INTO `constructori` VALUES (2,'X','HH',566.555),(14,'AKKA','AAA',1111);
/*!40000 ALTER TABLE `constructori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lucrare`
--

DROP TABLE IF EXISTS `lucrare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lucrare` (
  `idlucrare` int NOT NULL AUTO_INCREMENT,
  `idclient` int NOT NULL,
  `idconstructor` int NOT NULL,
  `datainceput` date DEFAULT NULL,
  `pret` float DEFAULT NULL,
  `durataZile` int DEFAULT NULL,
  PRIMARY KEY (`idlucrare`),
  KEY `fk_link_1_idx` (`idclient`),
  KEY `fk_link_2_idx` (`idconstructor`),
  CONSTRAINT `fk_link_1` FOREIGN KEY (`idclient`) REFERENCES `clienti` (`idclient`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_link_2` FOREIGN KEY (`idconstructor`) REFERENCES `constructori` (`idconstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lucrare`
--

LOCK TABLES `lucrare` WRITE;
/*!40000 ALTER TABLE `lucrare` DISABLE KEYS */;
INSERT INTO `lucrare` VALUES (57,115,14,'2024-01-22',1200,86),(58,113,2,'2024-01-15',333,4),(60,116,2,'2024-01-23',999,12345);
/*!40000 ALTER TABLE `lucrare` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-06 22:32:15
