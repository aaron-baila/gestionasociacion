CREATE DATABASE  IF NOT EXISTS `asociacionmonterde` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `asociacionmonterde`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: asociacionmonterde
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `documentos`
--

DROP TABLE IF EXISTS `documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` enum('contrato','acta','informe','otro') DEFAULT 'otro',
  `fecha_creacion` date DEFAULT NULL,
  `responsable` varchar(100) DEFAULT NULL,
  `ruta` text,
  `miembro_id` int DEFAULT NULL,
  `reunion_id` int DEFAULT NULL,
  `evento_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `miembro_id` (`miembro_id`),
  KEY `reunion_id` (`reunion_id`),
  KEY `evento_id` (`evento_id`),
  CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembro` (`id`) ON DELETE SET NULL,
  CONSTRAINT `documentos_ibfk_2` FOREIGN KEY (`reunion_id`) REFERENCES `reuniones` (`id`) ON DELETE SET NULL,
  CONSTRAINT `documentos_ibfk_3` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentos`
--

LOCK TABLES `documentos` WRITE;
/*!40000 ALTER TABLE `documentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `ubicacion` text,
  `tipo` enum('cultural','benéfico','formativo','otro') DEFAULT 'otro',
  `estado` enum('pendiente','en curso','finalizado') DEFAULT 'pendiente',
  `presupuesto` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe_total` decimal(10,2) NOT NULL,
  `concepto` text,
  `estado` enum('pendiente','pagada') DEFAULT 'pendiente',
  `ruta_documento` text,
  `evento_id` int DEFAULT NULL,
  `proveedor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evento_id` (`evento_id`),
  KEY `proveedor_id` (`proveedor_id`),
  CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE SET NULL,
  CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `concepto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int DEFAULT '0',
  `ubicacion` text,
  `estado` enum('nuevo','usado','dañado') DEFAULT 'nuevo',
  `fecha_adquisicion` date DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro`
--

DROP TABLE IF EXISTS `miembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `miembro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `apodo` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` text,
  `fecha_nacimiento` date DEFAULT NULL,
  `foto` text,
  `cargo` varchar(50) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `LOPD` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro`
--

LOCK TABLES `miembro` WRITE;
/*!40000 ALTER TABLE `miembro` DISABLE KEYS */;
INSERT INTO `miembro` VALUES (1,'25203178P','Teresa','Sancho Saz','','tesansaz@gmail.com','606175855','',NULL,NULL,'Tesorero',NULL,'activo',NULL),(2,'73570690S','MAngeles','Soriano Saz','','gelesmonterde@gmail.com','657537932','',NULL,NULL,'ExTesorera',NULL,'activo',NULL),(3,'72980622N','Úrsula','Carrión Garcés','','ursula_garces@hotmail.com','690360209','',NULL,NULL,'ExSecretaria',NULL,'activo',NULL),(6,'53223478Y','Noelia','Peiró Saz','','noeliapeirosaz@gmail.com','650308681','',NULL,NULL,'ExVocal',NULL,'activo',NULL),(11,'18455927Z','Miriam','Juan Mor','','miriamjuanmor@gmail.com','636181781','',NULL,NULL,'Secretaria',NULL,'activo',NULL),(18,'29115620N','Ruben','Perez Obensa','Duretes','duretes@hotmail.com','669437120','',NULL,NULL,'Presidente',NULL,'activo',NULL),(21,'53752982G','Alejandro','Blasco Ferrando','Jimmy','blascoferrandoa@gmail.com','657584350','',NULL,NULL,'Vocal2',NULL,'activo',NULL),(22,'20920944Y','Ivan','Ruiperez Sos','Vechino','ruiperezivan666@gmail.com','601172361','',NULL,NULL,'Vocal3',NULL,'activo',NULL),(26,'44920765V','Jaime','Victoriano Cañete','Karraquillo','jaimevic1306@gmail.com','601073162','',NULL,NULL,'Vocal1',NULL,'activo',NULL),(30,'18454935B','David','Juan Soler','','david__cella@hotmail.com','638725913','',NULL,NULL,'Vicepresidente',NULL,'activo',NULL);
/*!40000 ALTER TABLE `miembro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_evento`
--

DROP TABLE IF EXISTS `miembro_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `miembro_evento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `miembro_id` int NOT NULL,
  `evento_id` int NOT NULL,
  `rol` enum('participante','organizador','otro') DEFAULT 'participante',
  PRIMARY KEY (`id`),
  KEY `miembro_id` (`miembro_id`),
  KEY `evento_id` (`evento_id`),
  CONSTRAINT `miembro_evento_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembro` (`id`) ON DELETE CASCADE,
  CONSTRAINT `miembro_evento_ibfk_2` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_evento`
--

LOCK TABLES `miembro_evento` WRITE;
/*!40000 ALTER TABLE `miembro_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `miembro_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_reunion`
--

DROP TABLE IF EXISTS `miembro_reunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `miembro_reunion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `miembro_id` int NOT NULL,
  `reunion_id` int NOT NULL,
  `asistencia` enum('presente','ausente') DEFAULT 'presente',
  PRIMARY KEY (`id`),
  KEY `miembro_id` (`miembro_id`),
  KEY `reunion_id` (`reunion_id`),
  CONSTRAINT `miembro_reunion_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembro` (`id`) ON DELETE CASCADE,
  CONSTRAINT `miembro_reunion_ibfk_2` FOREIGN KEY (`reunion_id`) REFERENCES `reuniones` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_reunion`
--

LOCK TABLES `miembro_reunion` WRITE;
/*!40000 ALTER TABLE `miembro_reunion` DISABLE KEYS */;
/*!40000 ALTER TABLE `miembro_reunion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` text,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `CIF` varchar(20) NOT NULL,
  `tipo` enum('suministros','servicios','otro') DEFAULT 'otro',
  PRIMARY KEY (`id`),
  UNIQUE KEY `CIF` (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reuniones`
--

DROP TABLE IF EXISTS `reuniones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reuniones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `resumen` text,
  `asunto` varchar(200) DEFAULT NULL,
  `acta` text,
  `tipo` enum('ordinaria','extraordinaria') DEFAULT 'ordinaria',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reuniones`
--

LOCK TABLES `reuniones` WRITE;
/*!40000 ALTER TABLE `reuniones` DISABLE KEYS */;
/*!40000 ALTER TABLE `reuniones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subvenciones`
--

DROP TABLE IF EXISTS `subvenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subvenciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_solicitud` date NOT NULL,
  `monto_solicitado` decimal(10,2) DEFAULT NULL,
  `estado` enum('pendiente','aprobada','rechazada') DEFAULT 'pendiente',
  `entidad_que_otorga` varchar(100) DEFAULT NULL,
  `evento_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evento_id` (`evento_id`),
  CONSTRAINT `subvenciones_ibfk_1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subvenciones`
--

LOCK TABLES `subvenciones` WRITE;
/*!40000 ALTER TABLE `subvenciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `subvenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voluntarios`
--

DROP TABLE IF EXISTS `voluntarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voluntarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `evento_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evento_id` (`evento_id`),
  CONSTRAINT `voluntarios_ibfk_1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntarios`
--

LOCK TABLES `voluntarios` WRITE;
/*!40000 ALTER TABLE `voluntarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `voluntarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-13 12:47:22
