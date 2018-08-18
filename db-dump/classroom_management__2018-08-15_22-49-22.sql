-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2018 at 10:49 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `classroom_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `link` varchar(512) DEFAULT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id`, `user_id`, `link`, `content`) VALUES
(1, 3, '#temp-link', 'Notification content for First Teacher room booking');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Teacher'),
(2, 'Operator');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `accommodation` int(11) NOT NULL,
  `damage` tinyint(1) NOT NULL DEFAULT '0',
  `image_url` varchar(512) DEFAULT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `name`, `accommodation`, `damage`, `image_url`, `description`) VALUES
(1, 'A1', 50, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(2, 'A2', 30, 0, 'images/room-a2.jpeg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(3, 'A3', 30, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(4, 'B1', 60, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(6, 'B2', 50, 1, 'images/room-b2.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(7, 'B3', 60, 1, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(8, 'B4', 50, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(9, 'C1', 80, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(10, 'C2', 30, 1, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(11, 'C3', 90, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(12, 'C4', 80, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(13, 'C5', 85, 0, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.'),
(14, 'C6', 80, 1, 'images/room-a1.jpg', 'ROOM A 2 Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.         Room description here.Room description here.Room description here.');

-- --------------------------------------------------------

--
-- Table structure for table `room_booking`
--

CREATE TABLE `room_booking` (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `from_time` time NOT NULL,
  `to_time` time NOT NULL,
  `date` date NOT NULL,
  `title` text NOT NULL,
  `approval` tinyint(1) NOT NULL DEFAULT '0',
  `created` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room_booking`
--

INSERT INTO `room_booking` (`id`, `room_id`, `user_id`, `from_time`, `to_time`, `date`, `title`, `approval`, `created`) VALUES
(1, 1, 3, '09:00:00', '12:00:00', '2018-08-17', 'Course A Introduction', 1, '2018-07-29 21:00:00'),
(2, 1, 3, '14:00:00', '16:00:00', '2018-08-17', 'Course A Introduction (continue)', 1, '2018-07-29 21:00:00'),
(3, 1, 4, '15:00:00', '17:00:00', '2018-08-17', 'Course B Introduction (continue)', 0, '2018-07-29 21:00:00'),
(5, 8, 3, '12:00:00', '15:00:00', '2018-08-10', 'Database class', 1, '2018-07-21 21:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `room_booking_repeate`
--

CREATE TABLE `room_booking_repeate` (
  `id` int(11) NOT NULL,
  `room_booking_id` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room_booking_repeate`
--

INSERT INTO `room_booking_repeate` (`id`, `room_booking_id`, `from_date`, `to_date`) VALUES
(1, 5, '2018-07-30', '2018-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `room_equipment`
--

CREATE TABLE `room_equipment` (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `equipment` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `age` smallint(6) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `age`, `role_id`) VALUES
(3, 'First Teacher', 'ft@test.com', '$2a$04$ttZfntWbBoC4n52rBgwyL.3WuWnY.QOul.tqSiJhFkbnMHCxC7f.C', 50, 1),
(4, 'Second Teacher', 'st@test.com', '$2a$04$ttZfntWbBoC4n52rBgwyL.3WuWnY.QOul.tqSiJhFkbnMHCxC7f.C', 60, 1),
(5, 'The Operator', 'to@test.com', '$2a$04$ttZfntWbBoC4n52rBgwyL.3WuWnY.QOul.tqSiJhFkbnMHCxC7f.C', 90, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room_booking`
--
ALTER TABLE `room_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `room_booking_repeate`
--
ALTER TABLE `room_booking_repeate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_booking_id` (`room_booking_id`);

--
-- Indexes for table `room_equipment`
--
ALTER TABLE `room_equipment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`room_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `room_booking`
--
ALTER TABLE `room_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `room_booking_repeate`
--
ALTER TABLE `room_booking_repeate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `room_equipment`
--
ALTER TABLE `room_equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `room_booking`
--
ALTER TABLE `room_booking`
  ADD CONSTRAINT `room_booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `room_booking_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Constraints for table `room_booking_repeate`
--
ALTER TABLE `room_booking_repeate`
  ADD CONSTRAINT `room_booking_repeate_ibfk_1` FOREIGN KEY (`room_booking_id`) REFERENCES `room_booking` (`id`);

--
-- Constraints for table `room_equipment`
--
ALTER TABLE `room_equipment`
  ADD CONSTRAINT `room_equipment_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
