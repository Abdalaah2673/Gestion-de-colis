-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 02 avr. 2025 à 19:27
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdcolis`
--

-- --------------------------------------------------------

--
-- Structure de la table `colis`
--

DROP TABLE IF EXISTS `colis`;
CREATE TABLE IF NOT EXISTS `colis` (
  `id_colis` varchar(50) NOT NULL,
  `type_colis` varchar(50) NOT NULL,
  `poids_colis` varchar(50) NOT NULL,
  `frais_envoi` varchar(50) NOT NULL,
  `nomexp` varchar(100) NOT NULL,
  `prenomexp` varchar(100) NOT NULL,
  `villeexp` varchar(100) NOT NULL,
  `telexp` varchar(100) NOT NULL,
  `nomdest` varchar(100) NOT NULL,
  `prenomdest` varchar(100) NOT NULL,
  `villedest` varchar(100) NOT NULL,
  `teledest` varchar(100) NOT NULL,
  `quartierdest` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  PRIMARY KEY (`id_colis`),
  UNIQUE KEY `id_colis` (`id_colis`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `colis`
--

INSERT INTO `colis` (`id_colis`, `type_colis`, `poids_colis`, `frais_envoi`, `nomexp`, `prenomexp`, `villeexp`, `telexp`, `nomdest`, `prenomdest`, `villedest`, `teledest`, `quartierdest`, `date`) VALUES
('B88561799', 'Leger', '25kg-40kg', '4000', 'ezfffZE', 'fqsffezeffzfczFzf', 'BOBO-DIOULASSO', 'zfsdfzsdf', 'zfzez', 'fzefcsd', 'OUAGADOUGOU', 'fdfFSFD', 'Goughin', '2025-03-28'),
('B86658397', 'Leger', '1kg-25kg', '2000', 'jhb;', 'gliu:', 'BOBO-DIOULASSO', 'fhvj', 'duyhj', 'ygku', 'OUAGADOUGOU', 'kutchyv', 'Goughin', '2025-03-27'),
('B56674415', 'Leger', '1kg-25kg', '2000', 'CGHVDJHB', 'hjqdjn:k', 'BOBO-DIOULASSO', 'nklznlz', 'hJQKS/AZDBH', 'knl!,!qX', 'OUAGADOUGOU', 'qkdnlz', 'Zone 1', '2025-03-28'),
('B30694606', 'Leger', '1kg-25kg', '2000', 'dvkkzaj', 'fgee', 'BOBO-DIOULASSO', 'fzrfesf', 'sdffrsqfe', 'sdfeqz', 'OUAGADOUGOU', 'greqs', 'Goughin', '2025-03-28'),
('B13868707', 'Leger', '1kg-25kg', '2000', 'aefezafa', 'aerfrefae', 'BOBO-DIOULASSO', 'eraf', 'efrzer', 'ferferere', 'OUAGADOUGOU', 'erfefr', 'Goughin', '2025-03-28'),
('B67766404', 'Leger', '1kg-25kg', '2000', 'fdfdsa', 'fdfdsaf', 'BOBO-DIOULASSO', 'fdsfa', 'fdsaf', 'fdsfd', 'OUAGADOUGOU', 'fdsfds', 'Goughin', '2025-03-28'),
('B76462058', 'Leger', '25kg-40kg', '4000', 'fdsfdsf', 'fsfdf', 'BOBO-DIOULASSO', 'fsffffffff', 'ffffffffdfdfdfdfd', 'fdfdfdfdf', 'OUAGADOUGOU', 'fdfdfdfdfd', 'Goughin', '2025-03-28'),
('B28997284', 'Leger', '25kg-40kg', '4000', 'jdfgd', 'guuerg', 'OUAGADOUGOU', '453454', 'RMJIERM', 'DFHDG', 'OUAGADOUGOU', '5435', 'Goughin', '2025-03-31'),
('B78602924', 'Leger', '25kg-40kg', '4000', 'jfhdf', 'ghjf', 'BOBO-DIOULASSO', 'mihgdu', 'fkjgbfjh', 'hrjdb', 'OUAGADOUGOU', 'jlrtk', 'Goughin', '2025-03-31'),
('B67001810', 'Leger', '40kg-60kg', '6000', 'dhvd', 'sgfyis', 'BOBO-DIOULASSO', 'jh', 'fksgr', 'fysgusf', 'OUAGADOUGOU', 'lrjdfhv', 'Goughin', '2025-03-31'),
('B56277447', 'Leger', '25kg-40kg', '4000', 'erjgjld', 'ryreufrg', 'BOBO-DIOULASSO', 'ljkgri', 'grdljk', 'dgfjre', 'OUAGADOUGOU', 'jhflerkd', 'Goughin', '2025-03-31'),
('B28609603', 'Leger', '1kg-25kg', '2000', 'jfzlef', 'fuyzgdz', 'BOBO-DIOULASSO', 'hjz', 'dfgdfjk', 'hzflhzsf', 'OUAGADOUGOU', 'jhdfshdbs', 'Goughin', '2025-03-31'),
('B60042955', 'Leger', '25kg-40kg', '4000', 'gryzheger', 'jtekrhe', 'BOBO-DIOULASSO', 'etleuier', 'kjrete', 'hiort', 'OUAGADOUGOU', 'bdkfgjr', 'Centre-Ville', '2025-03-31');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupe` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `chiffre_affaire` tinyint(1) NOT NULL,
  `profil` tinyint(1) NOT NULL,
  `expédition` tinyint(1) NOT NULL,
  `réception` tinyint(1) NOT NULL,
  `personnel` tinyint(1) NOT NULL,
  `statistique` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `groupe` (`groupe`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `groupe`, `chiffre_affaire`, `profil`, `expédition`, `réception`, `personnel`, `statistique`) VALUES
(3, 'z', 1, 1, 1, 0, 0, 0),
(4, 'd', 1, 0, 0, 0, 1, 0),
(5, 'tdfy', 1, 1, 0, 0, 0, 0),
(6, 'Administrateur', 1, 1, 1, 1, 1, 1),
(7, 'lol', 1, 0, 0, 0, 0, 1),
(8, 'cool', 1, 1, 1, 1, 1, 1),
(9, 'daf', 1, 0, 0, 0, 0, 0),
(10, 'admi', 1, 0, 0, 0, 0, 1),
(11, 'caisse1', 0, 0, 1, 0, 0, 0),
(12, 'admin', 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `recepteur`
--

DROP TABLE IF EXISTS `recepteur`;
CREATE TABLE IF NOT EXISTS `recepteur` (
  `code_envoi` varchar(100) NOT NULL,
  `nom_recepteur` varchar(255) NOT NULL,
  `prenom_recepteur` varchar(255) NOT NULL,
  `type_piece` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numero_piece` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_reception` date NOT NULL,
  `numero_telephone` varchar(100) NOT NULL,
  PRIMARY KEY (`code_envoi`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `recepteur`
--

INSERT INTO `recepteur` (`code_envoi`, `nom_recepteur`, `prenom_recepteur`, `type_piece`, `numero_piece`, `date_reception`, `numero_telephone`) VALUES
('kzenfmklf', 'sffssk', 'vhdsbb', 'PASPORT', 'gdgffdkl', '2025-03-31', 'lejefdk');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) NOT NULL,
  `utilisateur` varchar(100) NOT NULL,
  `groupe` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifiant` (`identifiant`),
  KEY `groupe` (`groupe`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `identifiant`, `password`, `utilisateur`, `groupe`) VALUES
(11, 'williams', '2689367b205c16ce32ed4200942b8b8b1e262dfc70d9bc9fbc77c49699a4f1df', 'kam williams', 'admi'),
(12, 'admin', '2689367b205c16ce32ed4200942b8b8b1e262dfc70d9bc9fbc77c49699a4f1df', 'admin', 'admi'),
(13, 'admin ', '2689367b205c16ce32ed4200942b8b8b1e262dfc70d9bc9fbc77c49699a4f1df', 'admin', 'admin'),
(14, 'kam', '2689367b205c16ce32ed4200942b8b8b1e262dfc70d9bc9fbc77c49699a4f1df', 'kam', 'Administrateur');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
