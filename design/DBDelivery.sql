DROP database if exists `delivery`;
CREATE SCHEMA IF NOT EXISTS `delivery` DEFAULT CHARACTER SET utf8mb3 ;
USE `delivery`;

CREATE TABLE `order_product` (
  `id_order` int NOT NULL,
  `id_product` int NOT NULL,
  `product_quantity` int DEFAULT NULL,
  `product_price` float DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_product`),
  KEY `fk_Order_has_Product_Product1_idx` (`id_product`),
  KEY `fk_Order_has_Product_Order1_idx` (`id_order`),
  CONSTRAINT `fk_Order_has_Product_Order1` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`),
  CONSTRAINT `fk_Order_has_Product_Product1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_Product`)
) ENGINE=InnoDB ;

CREATE TABLE `orders` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `orders_date` varchar(45) DEFAULT NULL,
  `orders_status` varchar(45) DEFAULT NULL,
  `orders_delivaddress` varchar(80) DEFAULT NULL,
  `id_payment` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB CHARSET=utf8mb3;
-- Table structure for table `payment_type`
--

CREATE TABLE `payment_type` (
  `id_payment` int NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_payment`)
) ENGINE=InnoDB CHARSET=utf8mb3;
--
-- Dumping data for table `payment_type`
--

-- Table structure for table `product`
--
CREATE TABLE `product` (
  `id_Product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `id_product_type` int NOT NULL,
  PRIMARY KEY (`id_Product`),
  KEY `fk_Product_Product_Type1_idx` (`id_product_type`),
  CONSTRAINT `fk_Product_Product_Type1` FOREIGN KEY (`id_product_type`) REFERENCES `product_type` (`id_product_type`)
) ENGINE=InnoDB CHARSET=utf8mb3;
--
-- Table structure for table `product_type`
--
CREATE TABLE `product_type` (
  `id_product_type` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_product_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
--
-- Table structure for table `roles`
--
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `direccion` text,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_User_Roles1_idx` (`id_rol`),
  CONSTRAINT `fk_User_Roles1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;