/*
*********************************************************************
MySQL Database for the assignement for Manulife
*********************************************************************
Name: MySQL  Database "demoapp"
Version 1.0
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demoapp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `demoapp`;


DROP TABLE IF EXISTS `web_analytics`;

/* Table structure for web_analytics*/
CREATE TABLE web_analytics (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    website TEXT NOT NULL,
    visits BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE web_analytics ADD INDEX web_index (id,visits);

LOCK TABLES `web_analytics` WRITE;

/* Load data from CSV file - please change the location of your PC where you store the .CSV file*/
LOAD DATA INFILE 'C:/Data/Suman/Work/manulife-KL/db/data.csv' 
INTO TABLE web_analytics 
FIELDS TERMINATED BY '|' 
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

UNLOCK TABLES;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/* 

SAMPLE SQL QUERY TO SELECT TOP 5 WEBSITES BASED ON THE SELECTED DATE WITH THEIR RESPECTIVE TOTAL VISITS COLUMN.

SELECT date,website,visits FROM web_analytics 
WHERE date='2013-01-13' 
ORDER BY visits DESC LIMIT 5 ;

*/