-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 27-Maio-2019 às 22:35
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `facial_recognition`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'Abner', 'abner'),
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `person`
--

CREATE TABLE `person` (
  `id` varchar(80) NOT NULL,
  `first_name` varchar(80) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `phone_number` varchar(80) NOT NULL,
  `office` varchar(80) NOT NULL,
  `profile_facebook` varchar(80) NOT NULL,
  `profile_instagram` varchar(80) NOT NULL,
  `profile_linkedin` varchar(80) NOT NULL,
  `profile_github` varchar(80) NOT NULL,
  `register_date` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `phone_number`, `office`, `profile_facebook`, `profile_instagram`, `profile_linkedin`, `profile_github`, `register_date`) VALUES
('1', 'Abner', 'Rodrigues', '(11) 11112-2222', 'Developer', 'rodriguesabner2', 'rodriguesabner_', 'rodriguesabner_', 'kingaspx', '2019-05-27 16:42:10.000000'),
('2', 'Ronaldinho', 'Gaucho', '(00) 00000-0000', 'Footbal Player', 'ronaldinho', 'ronaldinho', 'ronaldinho', 'ronaldinho', '2019-05-27 16:44:30.000000'),
('3', 'Donald', 'Trump', '(66) 66666-6666', 'President', '0', '0', '0', '0', '2019-05-27 16:45:44.000000'),
('4', 'Beyonce', '.', '(99) 99999-9999', 'z', 'ab', 'b', 'c', 'd', '2019-05-27 16:48:16.000000'),
('5', 'Ariana', 'Grande', '(88) 88888-8888', 'z', 'p', 'o', 'l', 'k', '2019-05-27 16:49:26.000000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ws_msg`
--

CREATE TABLE `ws_msg` (
  `id` int(11) NOT NULL,
  `msg` text NOT NULL,
  `phone` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ws_msg`
--

INSERT INTO `ws_msg` (`id`, `msg`, `phone`) VALUES
(17, 'Olá, Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(18, 'Olá,Ronaldinho! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(00) 00000-0000'),
(19, 'Olá,Donald! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(66) 66666-6666'),
(20, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(21, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(22, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(23, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(24, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(25, 'Olá,Abner! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(11) 11112-2222'),
(26, 'Olá,Beyonce! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!', '(99) 99999-9999');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ws_msg`
--
ALTER TABLE `ws_msg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ws_msg`
--
ALTER TABLE `ws_msg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
