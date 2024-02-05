GRANT ALL PRIVILEGES ON *.* TO 'mysql'@'%';
CREATE DATABASE IF NOT EXISTS ecomm;
use ecomm;
DROP TABLE IF EXISTS `address_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `first_line` varchar(255) DEFAULT NULL,
  `second_line` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `apparel_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apparel_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `gender_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender_category` (
  `id` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `contact_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `office` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `apparel_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apparel_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_local_path` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `apparel_id` int DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbhhntl1fv5cccoc8kdi9no5nk` (`apparel_id`),
  KEY `FKdppl4w7x3149j5vskuxr27fbp` (`gender_id`),
  CONSTRAINT `FKbhhntl1fv5cccoc8kdi9no5nk` FOREIGN KEY (`apparel_id`) REFERENCES `apparel_category` (`id`),
  CONSTRAINT `FKdppl4w7x3149j5vskuxr27fbp` FOREIGN KEY (`gender_id`) REFERENCES `gender_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `bank_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `customer_id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `routing_number` varchar(255) DEFAULT NULL,
  `seller_id` int NOT NULL,
  `address_id` int DEFAULT NULL,
  `contact_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlt5lxtmmschwmaik8bk7e081d` (`address_id`),
  KEY `FKegmte3pxp69hx9rys4in03q4a` (`contact_id`),
  CONSTRAINT `FKegmte3pxp69hx9rys4in03q4a` FOREIGN KEY (`contact_id`) REFERENCES `contact_info` (`id`),
  CONSTRAINT `FKlt5lxtmmschwmaik8bk7e081d` FOREIGN KEY (`address_id`) REFERENCES `address_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `product_brand_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_brand_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `brand_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_local_path` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9e5sybnkqq5l0ia5iygep6vtq` (`brand_id`),
  CONSTRAINT `FK9e5sybnkqq5l0ia5iygep6vtq` FOREIGN KEY (`brand_id`) REFERENCES `product_brand_category` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `carousel_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carousel_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_local_path` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `delivery_status` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `track_package_link` varchar(255) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjtn74v05w29os87mepaa06kll` (`address_id`),
  KEY `FKm54qruhhds5mlklmo9fcf7tcm` (`product_id`),
  CONSTRAINT `FKjtn74v05w29os87mepaa06kll` FOREIGN KEY (`address_id`) REFERENCES `address_info` (`id`),
  CONSTRAINT `FKm54qruhhds5mlklmo9fcf7tcm` FOREIGN KEY (`product_id`) REFERENCES `order_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `price_range_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_range_category` (
  `id` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `available_quantity` int NOT NULL,
  `image_local_path` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `ratings` float NOT NULL,
  `seller_id` int NOT NULL,
  `verification_status` int DEFAULT NULL,
  `apparel_id` int DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `price_id` int DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX9ws9cwjer26lrdx8pg18o4npv` (`gender_id`,`apparel_id`,`brand_id`,`price`),
  KEY `FKaoybeugv1xmsh079m2i89p7ug` (`apparel_id`),
  KEY `FK5erklkue0hhpawivdg5613nmo` (`price_id`),
  KEY `FK2fxk6m27hqpy3h82pn6l1hpb9` (`brand_id`),
  CONSTRAINT `FK2fxk6m27hqpy3h82pn6l1hpb9` FOREIGN KEY (`brand_id`) REFERENCES `product_brand_category` (`id`),
  CONSTRAINT `FK5erklkue0hhpawivdg5613nmo` FOREIGN KEY (`price_id`) REFERENCES `price_range_category` (`id`),
  CONSTRAINT `FKaoybeugv1xmsh079m2i89p7ug` FOREIGN KEY (`apparel_id`) REFERENCES `apparel_category` (`id`),
  CONSTRAINT `FKbuskw9m5b0ji86wihiw38dfmt` FOREIGN KEY (`gender_id`) REFERENCES `gender_category` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `sort_by_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sort_by_category` (
  `id` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





INSERT INTO `ecomm`.`apparel_category` (`id`, `type`) VALUES ('1', 'Ethnic');
INSERT INTO `ecomm`.`apparel_category` (`id`, `type`) VALUES ('3', 'Foot Wear');
INSERT INTO `ecomm`.`apparel_category` (`id`, `type`) VALUES ('4', 'Western Wear');
INSERT INTO `ecomm`.`apparel_category` (`id`, `type`) VALUES ('5', 'Casuals');
INSERT INTO `ecomm`.`apparel_category` (`id`, `type`) VALUES ('6', 'Beauty');
INSERT INTO `ecomm`.`gender_category` (`id`, `type`) VALUES ('1', 'Men');
INSERT INTO `ecomm`.`gender_category` (`id`, `type`) VALUES ('2', 'Women');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('1', 'Website/categories/cat5.pn', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023834/e6xjy25guovm9omelia4.png', 'Beauty', '6', '2');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('2', 'Website/categories/cat3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023834/is1hq4uxuyqm3fzsfu23.png', 'Footwaer', '3', '2');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('3', 'Website/categories/cat3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023833/vktslx1upsauz4lncvyu.png', 'Western Wear', '4', '2');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('6', 'Website/categories/cat3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023831/mwfxzwy5mxjo4ug8neby.png', 'Ethnic Wear', '1', '2');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('8', 'Website/categories/cat3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023832/a25vwcovkuazcagakgxu.png', 'Foot Wear', '3', '1');
INSERT INTO `ecomm`.`apparel_images` (`id`, `image_local_path`, `imageurl`, `title`, `apparel_id`, `gender_id`) VALUES ('9', 'Website/categories/cat3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023832/emcwuilh01wklmqhb0xy.png', 'Casual Wear', '5', '1');
INSERT INTO `ecomm`.`carousel_images` (`id`, `image_local_path`, `imageurl`) VALUES ('1', 'Website/Images/WebsiteCarousel_1.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023831/p4qdikd5megmlf4d4svb.png');
INSERT INTO `ecomm`.`carousel_images` (`id`, `image_local_path`, `imageurl`) VALUES ('2', 'Website/Images/WebsiteCarousel_2.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706464471/d6b2qpflmp9bevbjewv6.png');
INSERT INTO `ecomm`.`carousel_images` (`id`, `image_local_path`, `imageurl`) VALUES ('3', 'Website/Images/WebsiteCarousel_3.png', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706023835/snsko1qhadk4otrb451r.png');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('1', 'Under $50');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('2', '$50-$100');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('3', '$100-$200');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('4', '$200-$300');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('5', '$300-$400');
INSERT INTO `ecomm`.`price_range_category` (`id`, `type`) VALUES ('6', 'Above $400');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('1', 'Roadster');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('2', 'Friskers');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('3', 'WROGN');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('4', 'Allen Solly');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('5', 'Lakme');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('6', 'Faces');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('7', 'Maybeline');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('8', 'Kalini');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('9', 'Libas');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('10', 'Puma');
INSERT INTO `ecomm`.`product_brand_category` (`id`, `type`) VALUES ('11', 'HighLander');
INSERT INTO `ecomm`.`sort_by_category` (`id`, `type`) VALUES ('1', 'What''s New');
INSERT INTO `ecomm`.`sort_by_category` (`id`, `type`) VALUES ('2', 'Popularity');
INSERT INTO `ecomm`.`sort_by_category` (`id`, `type`) VALUES ('3', 'Price: Low To High');
INSERT INTO `ecomm`.`sort_by_category` (`id`, `type`) VALUES ('4', 'Price: High To Low');
alter table ecomm.product_info modify column verification_status int
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('1', '1000',  'https://res.cloudinary.com/dessb5xeq/image/upload/v1706438148/Product/ih2fxcpxavigqucwgkna.png', 'Solid A-Line Top', '600', '5', '1', '1', '3', '2', '6', '1','2024-01-24 18:03:39','The Lifestyle Co. Women White & Pink Woven Design Comfort Insole Mesh Sneakers');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('2', '1000',  'https://res.cloudinary.com/dessb5xeq/image/upload/v1706438148/Product/f9cw5vnosjngs6rmsfwt.png', 'Lakme Sun Expert', '299', '5', '1', '1', '4', '2', '4', '5','2024-01-24 18:03:39','Sun Expert Ultra Matte SPF 40 PA+++ Compact - 7g');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('3', '100', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706438148/Product/wquczy3f4jg5btjnsfpb.png', 'Maybeline Matte Lipstick', '50', '3', '1', '1', '6', '2', '1', '7', '2024-01-24 18:03:39', 'New York Color Sensational Creamy Matte Lipstick - Touch of Spice');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('4', '50', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706438148/Product/qyrswhezv1l48jqxpb1s.png', 'Faces Foundation', '80', '4', '1', '1', '6', '2', '2', '6', '2024-01-24 18:03:39', 'Weightless Matte Foundation with Grape Extracts & Shea Butter 18ml - Natural 02');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('5', '500', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706438148/Product/mcmxkgjdszhuz0zsxbui.png', 'Maybeline Compact', '117', '4', '1', '1', '6', '2', '3', '7', '2024-01-24 18:03:39', 'New York Fit Me Matte + Poreless SPF 32 Compact Powder 6g - Ivory 115');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('6', '50', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706449211/Product/zt1jhxiqscxarikspahn.png', 'Parachute Trouser', '10', '2', '1', '1', '4', '2', '1', '1', '2024-01-24 18:03:39', 'The Lifestyle Co. Women Solid Baggy Fit Parachute Trouser');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('7', '111', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706449211/Product/oaatzpl4tr1zd9jm2rim.png', 'Cotton Sweatshirt', '300', '5', '1', '1', '4', '2', '4', '4', '2024-01-24 18:03:39', 'Women Lavender Pure Cotton Sweatshirt');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('8', '500', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706449212/Product/fsmzdims2rtcejlqe9ap.png', 'Denim Jacket', '300', '1', '1', '1', '4', '2', '4', '3', '2024-01-24 18:03:39', 'Unisex Conversational Typography Printed Boxy Fit Pure Cotton Denim Jacket');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('9', '350', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706450035/Product/x2ps2h0hcv1kjhy2dhwj.png', 'Kalini Kurta Sets', '70', '0', '1', '1', '1', '2', '2', '8', '2024-01-24 18:03:39', 'Shibori Dyed Regular Kurta with Trousers & Dupatta');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('10', '20', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706450035/Product/fxusonmil0dfzmznow3e.png', 'Libas Kurta Sets', '80', '1', '1', '1', '1', '2', '2', '9', '2024-01-24 18:03:39', 'Women Ethnic Motifs Regular Kurta with Trousers & Dupatta');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('11', '50', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706452851/Product/lcgn3bnyxlxqz9c7qdbt.png', 'Puma Sports Shoes', '500', '5', '1', '1', '3', '1', '6', '10', '2024-01-24 18:03:39', 'Smash Sprint Indoor Sports Shoes');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('12', '30', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706452851/Product/ivs7jeczp6gsjht4nest.png', 'Puma Black Sports Shoes', '800', '5', '1', '1', '3', '1', '6', '10', '2024-01-24 18:03:39', 'Men Escoot Running Shoes');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('13', '1000', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706452851/Product/kn5w5n4qvyf2by5iympj.png', 'Roadster Casual Shoes', '200', '4', '1', '1', '3', '1', '3', '1', '2024-01-24 18:03:39', 'Men Brown Textured PU Sneakers');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('14', '500', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706454642/Product/sqwthsemp1hpp2tfuwb6.png', 'Roadster Jacket', '400', '2', '1', '1', '5', '1', '5', '1', '2024-01-24 18:03:39', 'Men Grey Solid Puffer Jacket');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('15', '100', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706454642/Product/wbqcxmwfwwlmwkx2yjko.png', 'Roadster Jeans', '400', '4', '1', '1', '5', '1', '5', '1', '2024-01-24 18:03:39', 'Men Black Slim Fit Mid-Rise Clean Look Jeans');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('16', '200', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706454642/Product/l7h8nykrbjq5cuw8lyfy.png', 'Highlander Trouser', '300', '3', '1', '1', '5', '1', '4', '11', '2024-01-24 18:03:39', 'Men Mid-Rise Cotton Chinos Trousers');
INSERT INTO `ecomm`.`product_info` (`id`, `available_quantity`, `image_local_path`, `imageurl`, `name`, `price`, `ratings`, `seller_id`, `verification_status`, `apparel_id`, `gender_id`, `price_id`, `brand_id`, `modification_date`, `product_description`) VALUES ('17', '100', '', 'https://res.cloudinary.com/dessb5xeq/image/upload/v1706454642/Product/nnludpyew5cvk0yjjbbw.png', 'Allen Solly Jacket', '500', '5', '1', '1', '5', '1', '6', '4', '2024-01-24 18:03:39', 'Solid Bomber Jacket');
commit;