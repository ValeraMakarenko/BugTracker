DROP SCHEMA IF EXISTS `BUG_TRACKER_DB`;

CREATE SCHEMA IF NOT EXISTS `BUG_TRACKER_DB`
CHARACTER SET `utf8`;

USE `BUG_TRACKER_DB`;

create table `USER` (
   `ID` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `LOGIN` VARCHAR(30) NOT NULL UNIQUE,
   `PASSWORD` VARCHAR(255) NOT NULL,
   `FIRST_NAME` VARCHAR(30) NOT NULL,
   `LAST_NAME`  VARCHAR(30) NOT NULL,
   `EMAIL` VARCHAR(30) NOT NULL 
);
  
create table `USER_PROFILE` (
   `ID` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `ROLE` VARCHAR(30) NOT NULL UNIQUE
);
 
CREATE TABLE `USER_USER_PROFILE` (
    `FK_USER_ID` BIGINT NOT NULL,
    `FK_USER_PROFILE_ID` BIGINT NOT NULL,
    PRIMARY KEY (`FK_USER_ID`, `FK_USER_PROFILE_ID`),
    CONSTRAINT `FK_USER` FOREIGN KEY (`FK_USER_ID`) REFERENCES `USER` (`ID`),
    CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`FK_USER_PROFILE_ID`) REFERENCES `USER_PROFILE` (`ID`)
);

CREATE TABLE `STATUS` (
	`ID` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`TYPE` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `PRIORITY` (
	`ID` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`TYPE` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `BUG_REPORT` (
	`ID` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`TITLE` VARCHAR(30) NOT NULL ,
	`SUMMARY` VARCHAR(1255) NOT NULL,
	`STEPS_TO_REPRODUCE` VARCHAR(1255) NOT NULL,
	`ACTUAL_RESULT` VARCHAR(30) NOT NULL,
	`EXPECTED_RESULT` VARCHAR(30) NOT NULL,
	`FK_REPORTER_ID` BIGINT NOT NULL,
	`FK_ASSIGNED_ID` BIGINT NOT NULL,
    `START_BUG_REPORT` DATETIME  NOT NULL,
	-- `FK_STATUS_ID` BIGINT NOT NULL,
-- 	`FK_PRIORITY_ID` BIGINT NOT NULL,
	
	CONSTRAINT `FK_USER_REPORT` FOREIGN KEY (`FK_REPORTER_ID`) REFERENCES `USER` (`ID`),
	CONSTRAINT `FK_USER_ASSIGNED` FOREIGN KEY (`FK_ASSIGNED_ID`) REFERENCES `USER` (`ID`)
   --  CONSTRAINT `FK_STATUS` FOREIGN KEY (`FK_STATUS_ID`) REFERENCES `STATUS` (`ID`),
-- 	CONSTRAINT `FK_PRIORITY` FOREIGN KEY (`FK_PRIORITY_ID`) REFERENCES `PRIORITY` (`ID`)
);



CREATE TABLE `BUG_REPORT_STATUS` (
	`FK_BUG_REPORT_ID` BIGINT NOT NULL,
	`FK_STATUS_ID` BIGINT NOT NULL,
	PRIMARY KEY (`FK_BUG_REPORT_ID`, `FK_STATUS_ID`),
 	CONSTRAINT `FK_BUG_REPORT_FOR_STATUS` FOREIGN KEY (`FK_BUG_REPORT_ID`) REFERENCES `BUG_REPORT` (`ID`),
 	CONSTRAINT `FK_STATUS` FOREIGN KEY (`FK_STATUS_ID`) REFERENCES `STATUS` (`ID`)
 );



 CREATE TABLE `BUG_REPORT_PRIORITY` (
 	`FK_BUG_REPORT_ID` BIGINT NOT NULL,
     `FK_PRIORITY_ID` BIGINT NOT NULL,
 	PRIMARY KEY (`FK_BUG_REPORT_ID`, `FK_PRIORITY_ID`),
 	CONSTRAINT `FK_BUG_REPORT_FOR_PRIORITY` FOREIGN KEY (`FK_BUG_REPORT_ID`) REFERENCES `BUG_REPORT` (`ID`),
 	CONSTRAINT `FK_PRIORITY` FOREIGN KEY (`FK_PRIORITY_ID`) REFERENCES `PRIORITY` (`ID`)
 );

INSERT INTO `BUG_TRACKER_DB`.`STATUS` (`ID`, `TYPE`) VALUES (1, 'Open');
INSERT INTO `BUG_TRACKER_DB`.`STATUS` (`ID`, `TYPE`) VALUES (2, 'Close');

INSERT INTO `BUG_TRACKER_DB`.`USER_PROFILE` (`ID`, `ROLE`) VALUES (1, 'Project_Manager');
INSERT INTO `BUG_TRACKER_DB`.`USER_PROFILE` (`ID`, `ROLE`) VALUES (2, 'Developer');
INSERT INTO `BUG_TRACKER_DB`.`USER_PROFILE` (`ID`, `ROLE`) VALUES (3, 'Tester');

INSERT INTO `BUG_TRACKER_DB`.`PRIORITY` (`ID`, `TYPE`) VALUES (1, 'Blocker');
INSERT INTO `BUG_TRACKER_DB`.`PRIORITY` (`ID`, `TYPE`) VALUES (2, 'Critical');
INSERT INTO `BUG_TRACKER_DB`.`PRIORITY` (`ID`, `TYPE`) VALUES (3, 'Major');
INSERT INTO `BUG_TRACKER_DB`.`PRIORITY` (`ID`, `TYPE`) VALUES (4, 'Minor');