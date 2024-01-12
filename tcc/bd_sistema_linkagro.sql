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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Agropem',3,7.00,25.00),(2,'Agropem',4,20.00,100.00),(5,'Agrothor',3,20.00,50.00),(6,'Agrothor',3,20.00,30.00),(9,'Agropem',8,2.50,20.00),(10,'Primethor',3,10.00,29.60),(14,'Transportadora 1/8-1/16',2,2.00,2.00),(15,'Agropem',3,2.00,30.00),(16,'Agropem',3,7.00,26.00),(17,'Primethor',2,20.00,100.00),(18,'Agropem',3,5.00,20.00);
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
  `corte` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`vinc`),
  KEY `id_op` (`id_op`),
  CONSTRAINT `estoque_pendente_ibfk_1` FOREIGN KEY (`id_op`) REFERENCES `ordem_producao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
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
  `espessura` varchar(50) DEFAULT NULL,
  `met_extra` float(4,2) DEFAULT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `ordem_producao_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `produtos` (`produto`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_producao`
--

LOCK TABLES `ordem_producao` WRITE;
/*!40000 ALTER TABLE `ordem_producao` DISABLE KEYS */;
INSERT INTO `ordem_producao` VALUES (3,'Agropem',100,16.00,100.00,5,'Prensa','Teste\nTeste\nTeste',NULL,NULL,''),(6,'Agropem',90,16.00,50.00,2,'Caladandra','',NULL,NULL,''),(8,'Agropem',90,28.00,20.00,2,'','Estoque',NULL,NULL,''),(10,'Agropem',100,16.00,40.00,2,'','Estoque',NULL,NULL,''),(11,'Agropem',90,16.00,100.00,2,'','Estoque',NULL,NULL,''),(19,'Transportadora 1/8-1/16',90,16.00,2.00,2,'','',NULL,NULL,''),(34,'Transportadora 1/8-1/16',100,28.00,100.00,3,'Prensa','',NULL,NULL,''),(37,'Agropem',90,16.00,25.00,10,'','','null',0.00,''),(40,'Agropem',90,16.00,20.00,2,'','Estoque',NULL,NULL,''),(46,'Agropem',90,16.00,100.00,2,'','',NULL,NULL,''),(48,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(49,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(52,'Agropem',90,16.00,100.00,2,'','',NULL,NULL,''),(54,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(55,'Primethor',90,20.00,90.00,2,'','90 metro',NULL,NULL,''),(57,'Agropem',90,24.00,79.00,2,'','',NULL,NULL,''),(58,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(59,'Agropem',125,20.00,100.00,2,'','',NULL,NULL,''),(60,'Transportadora 1/8-1/16',90,20.00,100.00,4,'','',NULL,NULL,''),(62,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(63,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(64,'Agropem',90,20.00,100.00,2,'prensa','',NULL,NULL,''),(65,'Agrothor',100,28.00,72.00,2,'','',NULL,NULL,''),(66,'Agropem',90,16.00,100.00,2,'','',NULL,NULL,''),(67,'Agrothor',100,28.00,108.00,4,'','',NULL,NULL,''),(68,'Agropem',90,16.00,20.00,2,'','',NULL,NULL,''),(69,'Agropem',90,20.00,100.00,2,'','T: 20x100\nEhorizontal: \n3x50\n2x30\n20x20',NULL,NULL,''),(70,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(71,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(72,'Agropem',90,16.00,100.00,2,'','',NULL,NULL,''),(73,'Agropem',90,20.00,100.00,2,'','',NULL,NULL,''),(74,'Agrothor',90,16.00,120.00,5,'','','4x1.2+1',8.00,''),(75,'Agropem',90,16.00,100.00,2,'','','1x1.2+1',3.00,''),(76,'Agropem',90,20.00,100.00,2,'','','2x1.2',2.00,'');
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
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (2222,'Cao','14/10/2023','17/10/2023','URGENTE',''),(2345,'Felipeles','06/10/2023','09/10/2023','',''),(4444,'Janilson','01/10/2023','20/10/2023','Expedição',''),(8989,'555','10/10/2023','03/10/2023','','');
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
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_op`
--

LOCK TABLES `pedidos_op` WRITE;
/*!40000 ALTER TABLE `pedidos_op` DISABLE KEYS */;
INSERT INTO `pedidos_op` VALUES (3,2345,'Felipeles',9.00,23.00,2),(19,8989,'555',2.00,20.00,9),(19,2345,'Felipeles',20.00,20.00,13),(19,2345,'Felipeles',20.00,20.00,15),(6,4444,'Janilson',2.00,50.00,22),(3,4444,'Janilson',2.00,2.00,23),(34,4444,'Janilson',10.00,100.00,54),(37,2222,'Cao',16.00,10.00,59),(37,2222,'Cao',16.00,10.00,60),(46,2345,'Felipeles',10.00,25.00,80),(46,4444,'Janilson',16.00,25.00,81),(46,8989,'555',16.00,25.00,82),(48,8989,'555',16.00,25.00,86),(48,2345,'Felipeles',14.00,25.00,87),(48,2345,'Felipeles',10.00,25.00,88),(49,4444,'Janilson',16.00,25.00,89),(49,2222,'Cao',10.00,25.00,90),(49,2345,'Felipeles',14.00,25.00,91),(52,4444,'Janilson',14.00,50.00,102),(52,2222,'Cao',10.00,20.00,103),(52,4444,'Janilson',10.00,25.00,104),(52,4444,'Janilson',2.00,1.50,105),(54,4444,'Janilson',15.00,40.00,111),(54,4444,'Janilson',10.00,20.00,112),(54,4444,'Janilson',5.00,5.00,114),(3,8989,'555',2.00,2.00,116),(54,4444,'Janilson',10.00,15.00,117),(54,4444,'Janilson',5.00,5.00,118),(55,8989,'555',18.00,40.00,120),(55,4444,'Janilson',9.00,10.00,121),(55,2222,'Cao',11.00,40.00,122),(55,2222,'Cao',9.00,10.00,123),(54,4444,'Janilson',10.00,5.00,128),(57,2222,'Cao',13.00,79.00,129),(58,4444,'Janilson',10.00,20.00,130),(58,4444,'Janilson',7.00,15.00,131),(58,2345,'Felipeles',10.00,60.00,132),(58,8989,'555',7.00,15.00,133),(58,2345,'Felipeles',10.00,20.00,134),(59,2345,'Felipeles',10.00,100.00,135),(59,8989,'555',10.00,50.00,138),(59,8989,'555',7.00,50.00,141),(59,2345,'Felipeles',3.00,30.00,142),(60,2345,'Felipeles',20.00,20.00,143),(60,2222,'Cao',10.00,60.00,144),(60,8989,'555',7.00,20.00,145),(60,4444,'Janilson',7.00,30.00,146),(62,2345,'Felipeles',18.00,60.00,154),(62,2222,'Cao',6.00,40.00,155),(62,4444,'Janilson',7.00,20.00,156),(63,4444,'Janilson',4.00,100.00,157),(63,4444,'Janilson',8.00,50.00,158),(63,4444,'Janilson',14.00,50.00,159),(63,2345,'Felipeles',4.00,60.00,160),(64,2345,'Felipeles',10.00,50.00,161),(64,2222,'Cao',10.00,100.00,162),(64,8989,'555',7.00,50.00,163),(64,8989,'555',1.00,30.00,170),(65,8989,'555',11.00,42.00,172),(65,8989,'555',11.00,30.00,173),(65,4444,'Janilson',11.00,68.00,174),(66,8989,'555',10.00,50.00,175),(66,4444,'Janilson',3.00,50.00,176),(66,8989,'555',3.00,50.00,177),(67,2345,'Felipeles',11.00,52.00,178),(67,4444,'Janilson',11.00,52.00,179),(67,8989,'555',11.00,56.00,180),(67,4444,'Janilson',11.00,56.00,181),(68,4444,'Janilson',10.00,20.00,182),(68,8989,'555',6.00,20.00,185),(69,4444,'Janilson',17.00,50.00,186),(69,8989,'555',10.00,30.00,187),(69,2345,'Felipeles',8.00,30.00,188),(70,2345,'Felipeles',6.00,30.00,190),(70,8989,'555',5.00,25.00,191),(70,4444,'Janilson',4.00,20.00,192),(70,2222,'Cao',3.00,10.00,193),(70,2345,'Felipeles',2.00,100.00,197),(71,4444,'Janilson',10.00,20.00,199),(71,8989,'555',3.00,20.00,200),(71,2345,'Felipeles',4.00,20.00,201),(72,2222,'Cao',15.00,50.00,202),(72,2345,'Felipeles',10.00,50.00,203),(73,8989,'555',18.00,20.00,204),(73,2345,'Felipeles',10.00,30.00,205),(73,4444,'Janilson',4.00,25.00,206),(73,2222,'Cao',7.00,20.00,208),(73,4444,'Janilson',2.00,10.00,209);
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
-- Table structure for table `relatorios_op`
--

DROP TABLE IF EXISTS `relatorios_op`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relatorios_op` (
  `id` int NOT NULL,
  `cal_dataInicio` varchar(10) NOT NULL,
  `cal_horaInicio` varchar(5) NOT NULL,
  `cal_horaFim` varchar(5) NOT NULL,
  `cal_dataFim` varchar(10) NOT NULL,
  `cal_espessura` varchar(50) NOT NULL,
  `cal_responsavel` varchar(100) NOT NULL,
  `cal_obs` varchar(500) DEFAULT NULL,
  `pre_dataInicio` varchar(10) NOT NULL,
  `pre_horaInicio` varchar(5) NOT NULL,
  `pre_horaFim` varchar(5) NOT NULL,
  `pre_dataFim` varchar(10) NOT NULL,
  `pre_tempo` varchar(5) NOT NULL,
  `pre_responsavel` varchar(100) NOT NULL,
  `pre_obs` varchar(500) DEFAULT NULL,
  `cor_dataInicio` varchar(10) NOT NULL,
  `cor_horaInicio` varchar(5) NOT NULL,
  `cor_horaFim` varchar(5) NOT NULL,
  `cor_dataFim` varchar(10) NOT NULL,
  `cor_concerto` varchar(3) NOT NULL,
  `cor_responsavel` varchar(100) NOT NULL,
  `cor_obs` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `relatorios_op_ibfk_1` FOREIGN KEY (`id`) REFERENCES `ordem_producao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relatorios_op`
--

LOCK TABLES `relatorios_op` WRITE;
/*!40000 ALTER TABLE `relatorios_op` DISABLE KEYS */;
/*!40000 ALTER TABLE `relatorios_op` ENABLE KEYS */;
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

-- Dump completed on 2024-01-09 11:10:40
