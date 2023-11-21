CREATE DATABASE  IF NOT EXISTS `bd_linkagro` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_linkagro`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_linkagro
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
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  `lonas` int NOT NULL,
  `largura` float(4,2) NOT NULL,
  `metragem` float(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `produtos` (`produto`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Agropem',3,7.00,25.00),(2,'Agropem',4,20.00,100.00),(5,'Agrothor',3,20.00,50.00),(6,'Agrothor',3,20.00,30.00),(9,'Agropem',8,2.50,20.00),(10,'Primethor',3,10.00,29.60),(14,'Transportadora 1/8-1/16',2,2.00,2.00),(15,'Agropem',3,2.00,30.00),(16,'Agropem',3,7.00,26.00),(17,'Primethor',2,20.00,100.00);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque_pendente`
--

DROP TABLE IF EXISTS `estoque_pendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque_pendente` (
  `id_op` int NOT NULL,
  `vinc` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  `lonas` int NOT NULL,
  `largura` float(4,2) NOT NULL,
  `metragem` float(5,2) NOT NULL,
  PRIMARY KEY (`vinc`),
  KEY `id_op` (`id_op`),
  CONSTRAINT `estoque_pendente_ibfk_1` FOREIGN KEY (`id_op`) REFERENCES `ordem_producao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque_pendente`
--

LOCK TABLES `estoque_pendente` WRITE;
/*!40000 ALTER TABLE `estoque_pendente` DISABLE KEYS */;
/*!40000 ALTER TABLE `estoque_pendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_producao`
--

DROP TABLE IF EXISTS `ordem_producao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_producao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  `EE` int NOT NULL,
  `largura_tecido` float(4,2) NOT NULL,
  `metragem_tecido` float(5,2) NOT NULL,
  `lonas` int NOT NULL,
  `setor` varchar(20) DEFAULT NULL,
  `observacao` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `ordem_producao_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `produtos` (`produto`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_producao`
--

LOCK TABLES `ordem_producao` WRITE;
/*!40000 ALTER TABLE `ordem_producao` DISABLE KEYS */;
INSERT INTO `ordem_producao` VALUES (3,'Agropem',100,16.00,100.00,5,'Prensa','Teste\nTeste\nTeste'),(6,'Agropem',90,16.00,50.00,2,'Caladandra',''),(8,'Agropem',90,28.00,20.00,2,'',''),(10,'Agropem',100,16.00,40.00,2,'',''),(11,'Agropem',90,16.00,100.00,2,'',''),(19,'Transportadora 1/8-1/16',90,16.00,2.00,2,'',''),(34,'Transportadora 1/8-1/16',100,28.00,100.00,3,'Prensa',''),(37,'Agropem',90,16.00,25.00,10,'',''),(40,'Agropem',90,16.00,20.00,2,'',''),(46,'Agropem',90,16.00,100.00,2,'',''),(48,'Agropem',90,20.00,100.00,2,'',''),(49,'Agropem',90,20.00,100.00,2,'',''),(52,'Agropem',90,16.00,100.00,2,'',''),(54,'Agropem',90,20.00,100.00,2,'',''),(55,'Primethor',90,20.00,100.00,2,'','');
/*!40000 ALTER TABLE `ordem_producao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL,
  `nome_cliente` varchar(255) NOT NULL,
  `data_fechamento` varchar(10) DEFAULT NULL,
  `data_embarque` varchar(10) DEFAULT NULL,
  `observacao` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (2222,'Cao','14/10/2023','17/10/2023','URGENTE'),(2345,'Felipeles','06/10/2023','09/10/2023',''),(4444,'Janilson','01/10/2023','20/10/2023','Expedição'),(8989,'555','10/10/2023','03/10/2023','');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_op`
--

DROP TABLE IF EXISTS `pedidos_op`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_op` (
  `id_op` int NOT NULL,
  `id` int NOT NULL,
  `nome_cliente` varchar(255) NOT NULL,
  `largura` float(4,2) DEFAULT NULL,
  `metragem` float(5,2) DEFAULT NULL,
  `vinc` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`vinc`),
  KEY `id_op` (`id_op`),
  CONSTRAINT `pedidos_op_ibfk_1` FOREIGN KEY (`id_op`) REFERENCES `ordem_producao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_op`
--

LOCK TABLES `pedidos_op` WRITE;
/*!40000 ALTER TABLE `pedidos_op` DISABLE KEYS */;
INSERT INTO `pedidos_op` VALUES (3,2345,'Felipeles',9.00,23.00,2),(19,8989,'555',2.00,20.00,9),(19,2345,'Felipeles',20.00,20.00,13),(19,2345,'Felipeles',20.00,20.00,15),(6,4444,'Janilson',2.00,50.00,22),(3,4444,'Janilson',2.00,2.00,23),(34,4444,'Janilson',10.00,100.00,54),(37,2222,'Cao',16.00,10.00,59),(37,2222,'Cao',16.00,10.00,60),(46,2345,'Felipeles',10.00,25.00,80),(46,4444,'Janilson',16.00,25.00,81),(46,8989,'555',16.00,25.00,82),(48,8989,'555',16.00,25.00,86),(48,2345,'Felipeles',14.00,25.00,87),(48,2345,'Felipeles',10.00,25.00,88),(49,4444,'Janilson',16.00,25.00,89),(49,2222,'Cao',10.00,25.00,90),(49,2345,'Felipeles',14.00,25.00,91),(52,4444,'Janilson',14.00,50.00,102),(52,2222,'Cao',10.00,20.00,103),(52,4444,'Janilson',10.00,25.00,104),(52,4444,'Janilson',2.00,1.50,105),(54,4444,'Janilson',15.00,40.00,111),(54,4444,'Janilson',10.00,20.00,112),(54,4444,'Janilson',5.00,5.00,114),(3,8989,'555',2.00,2.00,116),(54,4444,'Janilson',10.00,15.00,117),(54,4444,'Janilson',5.00,5.00,118),(55,8989,'555',18.00,40.00,120),(55,4444,'Janilson',9.00,10.00,121),(55,2222,'Cao',11.00,40.00,122),(55,2222,'Cao',9.00,10.00,123);
/*!40000 ALTER TABLE `pedidos_op` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `produto` varchar(50) NOT NULL,
  PRIMARY KEY (`produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES ('Agropem'),('Agrothor'),('Primethor'),('Transportadora 1/8-1/16');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `permissao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'cris','2404','ADM'),(2,'roger','251021','ADM'),(9,'felipe','felipe09',NULL),(13,'testeADM','teste','ADM'),(20,'tinisio','1234',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-21  7:45:46
