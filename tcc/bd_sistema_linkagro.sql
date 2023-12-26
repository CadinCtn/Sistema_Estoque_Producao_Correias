CREATE DATABASE  IF NOT EXISTS `bd_tcc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_tcc`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_tcc
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Agrothor',2,2.00,2.00),(2,'Agrothor',4,20.00,100.00),(3,'Agropem',3,5.00,25.00),(4,'Agropem',3,10.00,40.00),(6,'Primethor',4,2.50,30.00),(10,'Primethor',2,16.00,100.00);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
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
  `espessura` varchar(50) DEFAULT NULL,
  `met_extra` float(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `ordem_producao_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `produtos` (`produto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_producao`
--

LOCK TABLES `ordem_producao` WRITE;
/*!40000 ALTER TABLE `ordem_producao` DISABLE KEYS */;
INSERT INTO `ordem_producao` VALUES (1,'Agropem',90,16.00,150.00,2,'Corte','','2',2.50),(2,'Agrothor',100,20.00,100.00,5,'Calandra','t\nt\nt223\n23','1.4',2.00),(3,'Primethor',100,20.00,50.00,4,'Calandra','10 Lances de 2X50','3x1.8+1',1.00),(5,'Teste',90,16.00,90.00,2,'Calandra','Teste','2.5+2',1.00);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1998,'Testee','05/12/2023','15/12/2023',''),(2000,'Jit','09/10/2023','20/10/2023',''),(2307,'Belagricolaa','07/12/2023','14/12/2023',''),(2309,'Teste','12/12/2023','28/12/2023',''),(2317,'Cocamar','12/11/2023','15/12/2023','Urgente'),(2318,'Sandro P.','12/12/2023','15/12/2023','');
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
  KEY `id` (`id`),
  CONSTRAINT `pedidos_op_ibfk_1` FOREIGN KEY (`id_op`) REFERENCES `ordem_producao` (`id`),
  CONSTRAINT `pedidos_op_ibfk_2` FOREIGN KEY (`id`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_op`
--

LOCK TABLES `pedidos_op` WRITE;
/*!40000 ALTER TABLE `pedidos_op` DISABLE KEYS */;
INSERT INTO `pedidos_op` VALUES (1,2317,'Cocamar',16.00,100.00,1),(3,2317,'Cocamar',2.00,50.00,2),(3,2307,'Belagricolaa',2.00,50.00,3),(3,2318,'Sandro P.',2.00,100.00,5),(3,2318,'Sandro P.',2.00,2.00,6),(2,2317,'Cocamar',20.00,167.59,7),(5,2307,'Belagricolaa',20.00,90.00,8);
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
  `cor_produto` varchar(500) NOT NULL,
  PRIMARY KEY (`produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES ('Agropem','java.awt.Color[r=255,g=204,b=0]'),('Agrothor','java.awt.Color[r=51,g=255,b=0]'),('Primethor','java.awt.Color[r=255,g=0,b=0]'),('Teste','java.awt.Color[r=51,g=51,b=51]');
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'cris','2404','ADM'),(2,'Felipe','1234',NULL),(5,'EMANOELE','251021',NULL);
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

-- Dump completed on 2023-12-26 17:00:35
