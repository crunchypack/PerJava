-- --------------------------------------------------------
-- Värd:                         127.0.0.1
-- Serverversion:                10.5.9-MariaDB - mariadb.org binary distribution
-- Server-OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumpar databasstruktur för perscholas
DROP DATABASE IF EXISTS `perscholas`;
CREATE DATABASE IF NOT EXISTS `perscholas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `perscholas`;

-- Dumpar struktur för tabell perscholas.course
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `instructor` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell perscholas.course: ~11 rows (ungefär)
DELETE FROM `course`;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `name`, `instructor`) VALUES
	(1, 'English', 'Anderea Scamaden'),
	(2, 'Mathematics', 'Eustace Niemetz'),
	(3, 'Anatomy', 'Reynolds Pastor'),
	(4, 'Organic Chemistry', 'Odessa Belcher'),
	(5, 'Physics', 'Dani Swallow'),
	(6, 'Digital Logic', 'Glenden Reilingen'),
	(7, 'Object Oriented Programming', 'Giselle Ardy'),
	(8, 'Data Structures', 'Carolan Stoller'),
	(9, 'Politics', 'Carmita De Maine'),
	(10, 'Art', 'Kingsly Doxsey');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumpar struktur för tabell perscholas.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell perscholas.student: ~11 rows (ungefär)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`email`, `name`, `password`) VALUES
	('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j'),
	('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6'),
	('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S'),
	('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs'),
	('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj'),
	('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ'),
	('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP'),
	('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd'),
	('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU'),
	('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumpar struktur för tabell perscholas.student_course
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE IF NOT EXISTS `student_course` (
  `sEmail` varchar(255) NOT NULL,
  `cId` int(11) NOT NULL,
  PRIMARY KEY (`sEmail`,`cId`),
  KEY `FK_student_course_cId` (`cId`),
  CONSTRAINT `FK_student_course_cId` FOREIGN KEY (`cId`) REFERENCES `course` (`id`),
  CONSTRAINT `FK_student_course_sEmail` FOREIGN KEY (`sEmail`) REFERENCES `student` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell perscholas.student_course: ~6 rows (ungefär)
DELETE FROM `student_course`;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` (`sEmail`, `cId`) VALUES
	('aiannitti7@is.gd', 2),
	('aiannitti7@is.gd', 3),
	('aiannitti7@is.gd', 10),
	('ljiroudek8@sitemeter.com', 7),
	('sbowden1@yellowbook.com', 3),
	('tattwool4@biglobe.ne.jp', 5);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;

-- Dumpar struktur för tabell perscholas.teacher
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `TEMAIL` varchar(255) NOT NULL,
  `TNAME` varchar(255) DEFAULT NULL,
  `TPASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TEMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell perscholas.teacher: ~1 rows (ungefär)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`TEMAIL`, `TNAME`, `TPASSWORD`) VALUES
	('anscam@school.com', 'Anderea Scamaden', 'HungryKitten*1'),
	('cadma@school.com', 'Carmita De Maine', 'Sort11Nww'),
	('casto@school.com', 'Carolan Stoller', 'WERXCUMkp'),
	('daswa@school.com', 'Dani Swallow', 'Klsm(21'),
	('eunie@school.com', 'Eustace Niemetz', 'jNSJNa'),
	('giard@school.com', 'Giselle Ardy', 'MjjwyY1'),
	('glrei@school.com', 'Glenden Reilingen', 'pOe1sj'),
	('kidox@school.com', 'Kingsly Doxsey', 'FDXjn22'),
	('odbel@school.com', 'Odessa Belcher', 'kK"asM'),
	('repas@school.com', 'Reynolds Pastor', 'JUnnw');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Dumpar struktur för tabell perscholas.teacher_course
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE IF NOT EXISTS `teacher_course` (
  `Teacher_TEMAIL` varchar(255) NOT NULL,
  `courses_id` int(11) NOT NULL,
  PRIMARY KEY (`Teacher_TEMAIL`,`courses_id`),
  KEY `FK_TEACHER_COURSE_courses_id` (`courses_id`),
  CONSTRAINT `FK_TEACHER_COURSE_Teacher_TEMAIL` FOREIGN KEY (`Teacher_TEMAIL`) REFERENCES `teacher` (`TEMAIL`),
  CONSTRAINT `FK_TEACHER_COURSE_courses_id` FOREIGN KEY (`courses_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell perscholas.teacher_course: ~1 rows (ungefär)
DELETE FROM `teacher_course`;
/*!40000 ALTER TABLE `teacher_course` DISABLE KEYS */;
INSERT INTO `teacher_course` (`Teacher_TEMAIL`, `courses_id`) VALUES
	('anscam@school.com', 1),
	('anscam@school.com', 7),
	('cadma@school.com', 9),
	('casto@school.com', 8),
	('daswa@school.com', 5),
	('eunie@school.com', 2),
	('giard@school.com', 7),
	('glrei@school.com', 6),
	('kidox@school.com', 10),
	('odbel@school.com', 4),
	('repas@school.com', 3);
/*!40000 ALTER TABLE `teacher_course` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
