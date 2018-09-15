/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21 : Database - financialdata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`financialdata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `financialdata`;

/*Table structure for table `fundbasedata` */

DROP TABLE IF EXISTS `fundbasedata`;

CREATE TABLE `fundbasedata` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fundCode` varchar(255) NOT NULL,
  `fundName` varchar(255) NOT NULL,
  `fundShortName` varchar(255) NOT NULL,
  `fundType` varchar(255) NOT NULL,
  `fundLastNAVDate` varchar(255) NOT NULL,
  `fundLastNAV` varchar(255) NOT NULL,
  `fundCumulativeNAV` varchar(255) NOT NULL,
  `fundNAVGrowthRate` varchar(255) NOT NULL,
  `fundIncomeRateOneWeek` varchar(255) NOT NULL,
  `fundIncomeRateOneMonth` varchar(255) NOT NULL,
  `fundIncomeRateThreeMonth` varchar(255) NOT NULL,
  `fundIncomeRateSixMonth` varchar(255) NOT NULL,
  `fundIncomeRateOneYear` varchar(255) NOT NULL,
  `fundIncomeRateTwoYear` varchar(255) NOT NULL,
  `fundIncomeRateThreeYear` varchar(255) NOT NULL,
  `fundIncomeRateCurrentYear` varchar(255) NOT NULL,
  `fundIncomeRateCreatedToNow` varchar(255) NOT NULL,
  `fundCreatedDate` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fundCode` (`fundCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4217 DEFAULT CHARSET=utf8;

/*Table structure for table `fundmanagerdata` */

DROP TABLE IF EXISTS `fundmanagerdata`;

CREATE TABLE `fundmanagerdata` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dataDate` varchar(255) NOT NULL,
  `managerCode` varchar(255) NOT NULL,
  `managerName` varchar(255) NOT NULL,
  `companyCode` varchar(255) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `currentFundCodeList` varchar(1000) NOT NULL,
  `currentFundNameList` varchar(1000) NOT NULL,
  `managerWorkTime` varchar(255) NOT NULL,
  `currentFundMaxIncome` varchar(255) NOT NULL,
  `currentFundMaxIncomeCode` varchar(255) NOT NULL,
  `currentFundMaxIncomeName` varchar(255) NOT NULL,
  `currentAssets` varchar(255) NOT NULL,
  `managerWorkTimeMaxIncome` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `managerCode` (`managerCode`)
) ENGINE=InnoDB AUTO_INCREMENT=3592 DEFAULT CHARSET=utf8;

/*Table structure for table `fundperformance` */

DROP TABLE IF EXISTS `fundperformance`;

CREATE TABLE `fundperformance` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fundCode` varchar(255) NOT NULL,
  `valueDate` varchar(255) NOT NULL,
  `fundIncomeRate30Day` varchar(255) NOT NULL,
  `fundIncomeRate90Day` varchar(255) NOT NULL,
  `fundIncomeRate180Day` varchar(255) NOT NULL,
  `fundIncomeRate360Day` varchar(255) NOT NULL,
  `fundIncomeRate1080Day` varchar(255) NOT NULL,
  `fundIncomeRateCreatedToNow` varchar(255) NOT NULL,
  `fundJensenAlpha90Day` varchar(255) NOT NULL,
  `fundJensenAlpha180Day` varchar(255) NOT NULL,
  `fundJensenAlpha360Day` varchar(255) NOT NULL,
  `fundMaxDown180Day` varchar(255) NOT NULL,
  `fundMaxDownTime180Day` varchar(255) NOT NULL,
  `fundMaxDown360Day` varchar(255) NOT NULL,
  `fundMaxDownTime360Day` varchar(255) NOT NULL,
  `fundDownStdevp360Day` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fundCode` (`fundCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4044 DEFAULT CHARSET=utf8;

/*Table structure for table `fundvaluedata` */

DROP TABLE IF EXISTS `fundvaluedata`;

CREATE TABLE `fundvaluedata` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fundCode` varchar(255) NOT NULL,
  `valueDate` varchar(255) NOT NULL,
  `NAV` varchar(255) NOT NULL,
  `cumulativeNAV` varchar(255) NOT NULL,
  `dailyGrowthRate` varchar(255) NOT NULL,
  `subscribeStatus` varchar(255) NOT NULL,
  `redemptionStatus` varchar(255) NOT NULL,
  `melonCutting` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4030244 DEFAULT CHARSET=utf8;

/*Table structure for table `stockdata` */

DROP TABLE IF EXISTS `stockdata`;

CREATE TABLE `stockdata` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stockCode` varchar(255) NOT NULL,
  `valueDate` varchar(255) NOT NULL,
  `openingPrice` varchar(255) NOT NULL,
  `topPrice` varchar(255) NOT NULL,
  `closingPrice` varchar(255) NOT NULL,
  `dailyGrowthRate` varchar(255) NOT NULL,
  `lowestPrice` varchar(255) NOT NULL,
  `turnoverValue` varchar(255) NOT NULL,
  `moneyValue` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20912 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
