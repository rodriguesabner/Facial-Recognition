-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Mar-2019 às 01:08
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
  `profile_github` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `phone_number`, `office`, `profile_facebook`, `profile_instagram`, `profile_linkedin`, `profile_github`) VALUES
('1', 'Abner', 'Rodrigues', '(11) 91234-5678', 'Developer', 'rodriguesabner2', 'rodriguesabner_', 'rodriguesabner', 'abnerrodrigues2'),
('2', 'Ronaldinho', 'Gaúcho', '(11) 21121-2121', 'Football Player', 'ronaldinho', 'ronaldinho', 'ronaldinho', 'ronaldinho'),
('3', 'Dan', 'Bilzerian', '(11) 12345-6789', 'Poker Player', 'danbilzerian', 'danbilzerian', 'danbilzerian', 'danbilzerian'),
('4', 'Marta', 'Silva', '(12) 31321-3132', 'Football Player', 'martasilva', 'martasilva', 'martasilva', 'martasilva'),
('5', 'Shadow', 'Rodrigues', '(12) 31132-1321', 'Dono do pedaço', 'eduardo_shadow', 'eduardo_shadow', 'eduardo_shadow', 'eduardo_shadow');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
