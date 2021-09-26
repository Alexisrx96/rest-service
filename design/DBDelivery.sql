-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema delivery
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema delivery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `delivery` DEFAULT CHARACTER SET utf8 ;
USE `delivery` ;

-- -----------------------------------------------------
-- Table `delivery`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`orders` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `orders_date` VARCHAR(45) NULL DEFAULT NULL,
  `orders_status` VARCHAR(45) NULL DEFAULT NULL,
  `orders_delivaddress` VARCHAR(80) NULL DEFAULT NULL,
  `id_product` INT NULL DEFAULT NULL,
  `product_quantity` INT NULL DEFAULT NULL,
  `product_price` FLOAT NULL DEFAULT NULL,
  `id_payment` INT NULL DEFAULT NULL,
  `id_user` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO orders(orders_date, orders_status, orders_delivaddress, id_product, product_quantity, product_price, id_payment, id_user) VALUES('24/09/2021', 'ON KITCHEN', 'LA CAMPANERA, SOYAPANGO',1, 2,5.99,3,1), ('23/09/2021', 'ON KITCHEN', 'COMUNIDAD 22 DE ABRIL',2, 2,8.99,2,1);

-- -----------------------------------------------------
-- Table `delivery`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`payment_type` (
  `id_payment` INT(11) NOT NULL AUTO_INCREMENT,
  `payment_type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_payment`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO payment_type(payment_type) VALUES('CASH'), ('CREDIT CARD'), ('CRYPTO');

-- -----------------------------------------------------
-- Table `delivery`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`roles` (
  `id_rol` INT(11) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `delivery`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(300) NULL DEFAULT NULL,
  `direccion` TEXT NULL DEFAULT NULL,
  `id_rol` INT(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_User_Roles1_idx` (`id_rol` ASC),
  CONSTRAINT `fk_User_Roles1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `delivery`.`roles` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `delivery`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`invoice` (
  `id_invoice` INT(11) NOT NULL AUTO_INCREMENT,
  `payment_type` VARCHAR(45) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `id_order` INT(11) NOT NULL,
  `id_payment` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  PRIMARY KEY (`id_invoice`),
  INDEX `fk_Invoice_Order1_idx` (`id_order` ASC) ,
  INDEX `fk_Invoice_Payment_Type1_idx` (`id_payment` ASC),
  INDEX `fk_Invoice_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_Invoice_Order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `delivery`.`orders` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Payment_Type1`
    FOREIGN KEY (`id_payment`)
    REFERENCES `delivery`.`payment_type` (`id_payment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `delivery`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `delivery`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`product_type` (
  `id_product_type` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product_type`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO product_type(type) VALUES('MEXICAN FOOD'), ('ITALIAN FOOD'), ('ALCOHOLIC BEVERAGES');

-- -----------------------------------------------------
-- Table `delivery`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`product` (
  `id_Product` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `id_product_type` INT(11) NOT NULL,
  PRIMARY KEY (`id_Product`),
  INDEX `fk_Product_Product_Type1_idx` (`id_product_type` ASC),
  CONSTRAINT `fk_Product_Product_Type1`
    FOREIGN KEY (`id_product_type`)
    REFERENCES `delivery`.`product_type` (`id_product_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO product(name, price, id_product_type) VALUES('Burrito Medium',5.99,1), ('Alfredo Pasta',8.99,2), ('Italian Soda',2.99,3);
-- -----------------------------------------------------
-- Table `delivery`.`order_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`order_product` (
  `id_order` INT(11) NOT NULL,
  `id_product` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`, `id_product`),
  INDEX `fk_Order_has_Product_Product1_idx` (`id_product` ASC),
  INDEX `fk_Order_has_Product_Order1_idx` (`id_order` ASC),
  CONSTRAINT `fk_Order_has_Product_Order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `delivery`.`orders` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_has_Product_Product1`
    FOREIGN KEY (`id_product`)
    REFERENCES `delivery`.`product` (`id_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
