-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2022 at 11:18 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_ticket_booking_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `name`, `password`) VALUES
(1000, 'PeiKang', 'abc123'),
(1001, 'pk123', '111');

-- --------------------------------------------------------

--
-- Table structure for table `booked_ticket`
--

CREATE TABLE `booked_ticket` (
  `ticketID` int(11) NOT NULL,
  `showID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `seatID` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booked_ticket`
--

INSERT INTO `booked_ticket` (`ticketID`, `showID`, `name`, `seatID`) VALUES
(104, 1007, 'ben', '2A1'),
(105, 1008, 'ioio', '3A3'),
(106, 1008, 'ong', '3A4'),
(107, 1007, 'ong', '2A2'),
(108, 1011, 'ong', '3A8'),
(112, 1011, 'Pikachu', '3E6'),
(113, 1012, 'ququ', '3A1'),
(114, 1012, 'red', '3C1'),
(115, 1007, 'sarah', '2A3'),
(116, 1007, 'rina', '2A3'),
(117, 1011, 'ioio', '3A6'),
(118, 1011, 'ioio', '3A3');

-- --------------------------------------------------------

--
-- Table structure for table `hall`
--

CREATE TABLE `hall` (
  `hall_ID` int(11) NOT NULL,
  `numberOfSeat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hall`
--

INSERT INTO `hall` (`hall_ID`, `numberOfSeat`) VALUES
(2, 69),
(3, 69);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `memberID` int(25) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`memberID`, `phone_number`, `password`, `name`) VALUES
(3, '0909', '789', 'ioio'),
(4, '1256', '7890', 'pk'),
(5, '01991', '456', 'ong');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movieID` int(11) NOT NULL,
  `movieName` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `price` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movieID`, `movieName`, `type`, `price`) VALUES
(2, 'abcbc', 'aaa', 15.00),
(4, 'digimon', 'cartoon', 10.00),
(5, 'erhere', 'erhher', 11.00);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seatID` varchar(3) NOT NULL,
  `row` char(1) NOT NULL,
  `number` int(11) NOT NULL,
  `hall_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seatID`, `row`, `number`, `hall_ID`) VALUES
('2A1', 'A', 1, 2),
('2A2', 'A', 2, 2),
('2A3', 'A', 3, 2),
('2A4', 'A', 4, 2),
('2A5', 'A', 5, 2),
('2A6', 'A', 6, 2),
('2A7', 'A', 7, 2),
('2A8', 'A', 8, 2),
('2A9', 'A', 9, 2),
('2B1', 'B', 1, 2),
('2B2', 'B', 2, 2),
('2B3', 'B', 3, 2),
('2B4', 'B', 4, 2),
('2B5', 'B', 5, 2),
('2B6', 'B', 6, 2),
('2B7', 'B', 7, 2),
('2B8', 'B', 8, 2),
('2B9', 'B', 9, 2),
('2C1', 'C', 1, 2),
('2C2', 'C', 2, 2),
('2C3', 'C', 3, 2),
('2C4', 'C', 4, 2),
('2C5', 'C', 5, 2),
('2C6', 'C', 6, 2),
('2C7', 'C', 7, 2),
('2C8', 'C', 8, 2),
('2C9', 'C', 9, 2),
('2D1', 'D', 1, 2),
('2D2', 'D', 2, 2),
('2D3', 'D', 3, 2),
('2D4', 'D', 4, 2),
('2D5', 'D', 5, 2),
('2D6', 'D', 6, 2),
('2D7', 'D', 7, 2),
('2D8', 'D', 8, 2),
('2D9', 'D', 9, 2),
('2E1', 'E', 1, 2),
('2E2', 'E', 2, 2),
('2E3', 'E', 3, 2),
('2E4', 'E', 4, 2),
('2E5', 'E', 5, 2),
('2E6', 'E', 6, 2),
('2E7', 'E', 7, 2),
('2E8', 'E', 8, 2),
('2E9', 'E', 9, 2),
('3A1', 'A', 1, 3),
('3A2', 'A', 2, 3),
('3A3', 'A', 3, 3),
('3A4', 'A', 4, 3),
('3A5', 'A', 5, 3),
('3A6', 'A', 6, 3),
('3A7', 'A', 7, 3),
('3A8', 'A', 8, 3),
('3A9', 'A', 9, 3),
('3B1', 'B', 1, 3),
('3B2', 'B', 2, 3),
('3B3', 'B', 3, 3),
('3B4', 'B', 4, 3),
('3B5', 'B', 5, 3),
('3B6', 'B', 6, 3),
('3B7', 'B', 7, 3),
('3B8', 'B', 8, 3),
('3B9', 'B', 9, 3),
('3C1', 'C', 1, 3),
('3C2', 'C', 2, 3),
('3C3', 'C', 3, 3),
('3C4', 'C', 4, 3),
('3C5', 'C', 5, 3),
('3C6', 'C', 6, 3),
('3C7', 'C', 7, 3),
('3C8', 'C', 8, 3),
('3C9', 'C', 9, 3),
('3D1', 'D', 1, 3),
('3D2', 'D', 2, 3),
('3D3', 'D', 3, 3),
('3D4', 'D', 4, 3),
('3D5', 'D', 5, 3),
('3D6', 'D', 6, 3),
('3D7', 'D', 7, 3),
('3D8', 'D', 8, 3),
('3D9', 'D', 9, 3),
('3E1', 'E', 1, 3),
('3E2', 'E', 2, 3),
('3E3', 'E', 3, 3),
('3E4', 'E', 4, 3),
('3E5', 'E', 5, 3),
('3E6', 'E', 6, 3),
('3E7', 'E', 7, 3),
('3E8', 'E', 8, 3),
('3E9', 'E', 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `showtime`
--

CREATE TABLE `showtime` (
  `showID` int(11) NOT NULL,
  `day` date NOT NULL,
  `time` time NOT NULL,
  `movieID` int(11) NOT NULL,
  `hall_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `showtime`
--

INSERT INTO `showtime` (`showID`, `day`, `time`, `movieID`, `hall_ID`) VALUES
(1007, '2022-06-10', '14:51:00', 2, 2),
(1008, '2022-06-17', '15:01:00', 4, 3),
(1009, '2022-06-02', '16:17:00', 2, 3),
(1010, '2022-06-03', '18:24:00', 4, 2),
(1011, '2022-06-18', '18:40:00', 4, 3),
(1012, '2022-06-25', '19:17:00', 2, 3),
(1013, '2022-06-17', '20:59:00', 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`name`) VALUES
('ben'),
('ioio'),
('jor'),
('kokomelon'),
('ong'),
('Pikachu'),
('pk'),
('ququ'),
('red'),
('rina'),
('sarah'),
('Starlord');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `booked_ticket`
--
ALTER TABLE `booked_ticket`
  ADD PRIMARY KEY (`ticketID`),
  ADD KEY `booked_ticket_ibfk_1` (`showID`),
  ADD KEY `booked_ticket_ibfk_2` (`name`),
  ADD KEY `booked_ticket_ibfk_3` (`seatID`);

--
-- Indexes for table `hall`
--
ALTER TABLE `hall`
  ADD PRIMARY KEY (`hall_ID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberID`),
  ADD KEY `name` (`name`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieID`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seatID`),
  ADD KEY `seat_ibfk_1` (`hall_ID`);

--
-- Indexes for table `showtime`
--
ALTER TABLE `showtime`
  ADD PRIMARY KEY (`showID`),
  ADD KEY `showtime_ibfk_1` (`movieID`),
  ADD KEY `showtime_ibfk_2` (`hall_ID`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `booked_ticket`
--
ALTER TABLE `booked_ticket`
  MODIFY `ticketID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `memberID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `showtime`
--
ALTER TABLE `showtime`
  MODIFY `showID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1014;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booked_ticket`
--
ALTER TABLE `booked_ticket`
  ADD CONSTRAINT `booked_ticket_ibfk_1` FOREIGN KEY (`showID`) REFERENCES `showtime` (`showID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booked_ticket_ibfk_2` FOREIGN KEY (`name`) REFERENCES `visitor` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booked_ticket_ibfk_3` FOREIGN KEY (`seatID`) REFERENCES `seat` (`seatID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`name`) REFERENCES `visitor` (`name`);

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`hall_ID`) REFERENCES `hall` (`hall_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `showtime`
--
ALTER TABLE `showtime`
  ADD CONSTRAINT `showtime_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `showtime_ibfk_2` FOREIGN KEY (`hall_ID`) REFERENCES `hall` (`hall_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
