-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 27 mars 2023 à 22:56
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `techwork`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE `candidature` (
  `id` int(100) NOT NULL,
  `offre` longtext NOT NULL,
  `recruteur` varchar(100) NOT NULL,
  `candidat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `informations` varchar(100) NOT NULL,
  `datePostulation` varchar(100) NOT NULL,
  `dateModification` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `candidature`
--

INSERT INTO `candidature` (`id`, `offre`, `recruteur`, `candidat`, `status`, `informations`, `datePostulation`, `dateModification`) VALUES
(25, '0', 'Proxym', 'Candidat', 'Rejetée', '', '2023-02-24', '2023-03-07'),
(26, '0', 'Proxym', 'Candidat', 'Rejetée', 'Not enough skills', '2023-02-24', '2023-02-24'),
(27, '0', 'Test', 'Candidat', 'Acceptée', '', '2023-02-24', '2023-03-07'),
(28, '0', 'Esprit', 'Candidat', 'Acceptée', 'Bon profil', '2023-02-24', '2023-02-24'),
(29, '0', 'Esprit', 'Candidat', 'Annulée', '', '2023-02-24', '2023-03-07'),
(122, '{\"id\":73,\"titre\":\"Educateur \",\"description\":\"Educateur d\'art\",\"post\":\"Educateur\",\"salaire\":1600,\"lieu\":\"Tunis\",\"duree\":12,\"status\":\"Disponible\",\"nomRecruteur\":\"Esprit\",\"emailRecruteur\":\"Esprit@gmail.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Art\"}', 'Esprit', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-08', 'Pas de modifications'),
(123, '{\"id\":67,\"titre\":\"Marketing Manager pour une société\",\"description\":\"Strategie de marketing et creation d\'une identité pour l\'entreprise\",\"post\":\"Head of Marketing\",\"salaire\":1200,\"lieu\":\"Tunis\",\"duree\":12,\"status\":\"Disponible\",\"nomRecruteur\":\"Proxym\",\"emailRecruteur\":\"Proxym@gmail.com\",\"typeContrat\":\"CDD: Contrat à durée déterminée\",\"domaineOffre\":\"Marketing\"}', 'Proxym', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-08', 'Pas de modifications'),
(124, '{\"id\":73,\"titre\":\"Educateur \",\"description\":\"Educateur d\'art\",\"post\":\"Educateur\",\"salaire\":1600,\"lieu\":\"Tunis\",\"duree\":12,\"status\":\"Disponible\",\"nomRecruteur\":\"Esprit\",\"emailRecruteur\":\"Esprit@gmail.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Art\"}', 'Esprit', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-08', 'Pas de modifications'),
(125, '{\"id\":93,\"titre\":\"jjj\",\"description\":\"jjjjj\",\"post\":\"jjj\",\"salaire\":0,\"lieu\":\"jj\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Informatique\"}', 'Recruter', 'Person', 'Rejetée', 'nop', '2023-03-08', '2023-03-08'),
(126, '{\"id\":94,\"titre\":\"ggg\",\"description\":\"gggg\",\"post\":\"ggg\",\"salaire\":0,\"lieu\":\"ggg\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Informatique\"}', 'Recruter', 'Person', 'Acceptée', 'HITHERE', '2023-03-08', '2023-03-08'),
(127, '{\"id\":95,\"titre\":\"kkk\",\"description\":\"kkkk\",\"post\":\"kkk\",\"salaire\":0,\"lieu\":\"kkk\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDD: Contrat à durée déterminée\",\"domaineOffre\":\"Assurance\"}', 'Recruter', 'Person', 'Acceptée', 'nice', '2023-03-08', '2023-03-08'),
(128, '{\"id\":96,\"titre\":\"OFFRE1\",\"description\":\"OFFRE1\",\"post\":\"OFFRE1\",\"salaire\":0,\"lieu\":\"OFFRE1\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Informatique\"}', 'Recruter', 'Person', 'Rejetée', 'Nein', '2023-03-08', '2023-03-08'),
(129, '{\"id\":98,\"titre\":\"OFFRE2\",\"description\":\"OFFRE2\",\"post\":\"OFFRE2\",\"salaire\":0,\"lieu\":\"OFFRE2\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Informatique\"}', 'Recruter', 'Person', 'Acceptée', 'Yass', '2023-03-08', '2023-03-08'),
(130, '{\"id\":68,\"titre\":\"Data Analysis for a dashboard creation\",\"description\":\"Analyser les données des clients\",\"post\":\"Data Analyst\",\"salaire\":2000,\"lieu\":\"Sousse\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Proxym\",\"emailRecruteur\":\"Proxym@gmail.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Data Analysis\"}', 'Proxym', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-08', 'Pas de modifications'),
(131, '{\"id\":68,\"titre\":\"Data Analysis for a dashboard creation\",\"description\":\"Analyser les données des clients\",\"post\":\"Data Analyst\",\"salaire\":2000,\"lieu\":\"Sousse\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Proxym\",\"emailRecruteur\":\"Proxym@gmail.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Data Analysis\"}', 'Proxym', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-08', 'Pas de modifications'),
(132, '{\"id\":67,\"titre\":\"Marketing Manager pour une société\",\"description\":\"Strategie de marketing et creation d\'une identité pour l\'entreprise\",\"post\":\"Head of Marketing\",\"salaire\":1200,\"lieu\":\"Tunis\",\"duree\":12,\"status\":\"Disponible\",\"nomRecruteur\":\"Proxym\",\"emailRecruteur\":\"Proxym@gmail.com\",\"typeContrat\":\"CDD: Contrat à durée déterminée\",\"domaineOffre\":\"Marketing\"}', 'Proxym', 'Person', 'En attente', 'Pas de changement pour le moment', '2023-03-09', 'Pas de modifications'),
(133, '{\"id\":96,\"titre\":\"OFFRE1\",\"description\":\"OFFRE1\",\"post\":\"OFFRE1\",\"salaire\":0,\"lieu\":\"OFFRE1\",\"duree\":0,\"status\":\"Disponible\",\"nomRecruteur\":\"Recruter\",\"emailRecruteur\":\"Recruter@yahoo.com\",\"typeContrat\":\"CDI: Contrat de travail à durée indéterminée\",\"domaineOffre\":\"Informatique\"}', 'Recruter', 'Person', 'Acceptée', 'yes', '2023-03-09', '2023-03-09');

-- --------------------------------------------------------

--
-- Structure de la table `chapitre`
--

CREATE TABLE `chapitre` (
  `id_chapitre` varchar(256) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `id_cours` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `profil_id` int(11) DEFAULT NULL,
  `contenu` longtext NOT NULL,
  `date` datetime DEFAULT current_timestamp(),
  `note` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `utilisateur_id`, `profil_id`, `contenu`, `date`, `note`) VALUES
(312, 1, 50, 'bravoooo', '2023-03-01 16:24:57', 5),
(354, 1, 50, 'aaaaaaa', '2023-03-01 18:58:18', 3),
(355, 1, 50, 'aaaaaaa', '2023-03-01 18:58:18', 3),
(356, 1, 50, 'aaaaaaa', '2023-03-01 18:58:19', 3),
(461, 1, 50, 'bien', '2023-03-02 11:36:33', 4),
(462, 1, 50, 'bien', '2023-03-02 11:36:48', 4),
(463, 1, 50, 'bien', '2023-03-02 11:36:51', 4),
(464, 1, 50, 'tres bien', '2023-03-02 22:58:24', 4),
(465, 1, 50, 'tres bien', '2023-03-02 22:58:26', 4),
(466, 1, 50, 'tres bien', '2023-03-02 22:58:28', 4),
(467, 1, 50, 'tres bien', '2023-03-02 22:58:32', 5),
(468, 1, 50, 'tres bien', '2023-03-02 22:58:38', 5),
(469, 1, 50, 'tres bien', '2023-03-02 22:58:40', 5),
(470, 1, 50, 'tfssy', '2023-03-07 16:14:24', 4),
(471, 1, 50, 'tfssy', '2023-03-07 16:14:26', 4),
(472, 1, 50, 'tfssy', '2023-03-07 16:14:33', 5),
(473, 1, 50, ',nyhbtgvrfcedxzsw', '2023-03-08 18:05:11', 4),
(474, 1, 50, ',nyhbtgvrfcedxzsw', '2023-03-08 18:05:15', 4),
(475, 1, 50, 'biennnnn', '2023-03-08 18:54:41', 5),
(476, 1, 50, 'biennnnn', '2023-03-08 18:54:46', 5),
(477, 1, 50, '', '2023-03-08 19:23:32', 4),
(478, 1, 50, '', '2023-03-08 19:23:34', 4),
(479, 1, 50, 'bieen', '2023-03-08 21:49:38', 5),
(480, 1, 50, 'bieen', '2023-03-08 21:49:42', 5);

-- --------------------------------------------------------

--
-- Structure de la table `contenu`
--

CREATE TABLE `contenu` (
  `id_contenu` varchar(256) NOT NULL,
  `type` varchar(30) NOT NULL,
  `duree` int(11) NOT NULL,
  `lien_contenu` varchar(256) NOT NULL,
  `id_chapitre` varchar(256) DEFAULT NULL,
  `Titre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id` varchar(256) NOT NULL,
  `titre` varchar(30) DEFAULT NULL,
  `id_tuteur` int(11) DEFAULT NULL,
  `categorie` varchar(30) NOT NULL,
  `duree` int(11) DEFAULT NULL,
  `date_de_lancement` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20230327155212', '2023-03-27 17:52:48', 891);

-- --------------------------------------------------------

--
-- Structure de la table `fichmedia`
--

CREATE TABLE `fichmedia` (
  `idmedia` int(20) NOT NULL,
  `nommedia` varchar(50) NOT NULL,
  `urlmedia` varchar(200) NOT NULL,
  `typemedia` varchar(50) NOT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `fichmedia`
--

INSERT INTO `fichmedia` (`idmedia`, `nommedia`, `urlmedia`, `typemedia`, `id`) VALUES
(32, 'ddd', 'ddddd', 'ddd', 34),
(36, 'nom', 'url', 'type', 138),
(37, 'a', 'a', 'a', 29),
(38, 'aaa', 'qqq', 'qqqq', 29);

-- --------------------------------------------------------

--
-- Structure de la table `likepub`
--

CREATE TABLE `likepub` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_pub` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `messenger_messages`
--

CREATE TABLE `messenger_messages` (
  `id` bigint(20) NOT NULL,
  `body` longtext NOT NULL,
  `headers` longtext NOT NULL,
  `queue_name` varchar(190) NOT NULL,
  `created_at` datetime NOT NULL,
  `available_at` datetime NOT NULL,
  `delivered_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` int(255) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `post` varchar(100) NOT NULL,
  `salaire` int(255) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `typeContrat` varchar(100) NOT NULL,
  `duree` int(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `domaineOffre` varchar(100) NOT NULL,
  `nomRecruteur` varchar(100) NOT NULL,
  `emailRecruteur` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `titre`, `description`, `post`, `salaire`, `lieu`, `typeContrat`, `duree`, `status`, `domaineOffre`, `nomRecruteur`, `emailRecruteur`) VALUES
(67, 'Marketing Manager pour une société', 'Strategie de marketing et creation d\'une identité pour l\'entreprise', 'Head of Marketing', 1200, 'Tunis', 'CDD: Contrat à durée déterminée', 12, 'Disponible', 'Marketing', 'Proxym', 'Proxym@gmail.com'),
(68, 'Data Analysis for a dashboard creation', 'Analyser les données des clients', 'Data Analyst', 2000, 'Sousse', 'CDI: Contrat de travail à durée indéterminée', 0, 'Disponible', 'Data Analysis', 'Proxym', 'Proxym@gmail.com'),
(69, 'Web Application for a bank', 'Créer une applciation mobile pour une banque', 'Mobile Developer', 300, 'CDD: Contrat à durée déterminée', 'CDD: Contrat à durée déterminée', 36, 'Plus disponible', 'Developpement Web', 'Proxym', 'Proxym@gmail.com'),
(70, 'Secretaire pour une grande entreprise', 'Secretaire pour gerer les dossiers', 'Secretaire', 800, 'CDI: Contrat de travail à durée indéterminée', 'CDI: Contrat de travail à durée indéterminée', 12, 'Plus disponible', 'Assurance', 'Test', 'Test@test'),
(72, 'Influencer pour notre brand', 'Influencer pour une gande entreprise', 'Influencer', 2000, 'France', 'CDI: Contrat de travail à durée indéterminée', 0, 'Disponible', 'Art', 'Test', 'Test@test'),
(99, 'Marketing Manager pour une société', 'Strategie de marketing et creation d\'une identité pour l\'entreprise', 'Head of Marketing', 1200, 'Tunis', 'CDD: Contrat à durée déterminée', 12, 'Disponible', 'Marketing', 'Proxym', 'Proxym@gmail.com'),
(100, 'Data Analysis for a dashboard creation', 'Analyser les données des clients', 'Data Analyst', 2000, 'Sousse', 'CDI: Contrat de travail à durée indéterminée', 0, 'Disponible', 'Data Analysis', 'Proxym', 'Proxym@gmail.com'),
(101, 'Web Application for a bank', 'Créer une applciation mobile pour une banque', 'Mobile Developer', 300, 'Tunis', 'CDD: Contrat à durée déterminée', 36, 'Disponible', 'Developpement Web', 'Proxym', 'Proxym@gmail.com'),
(102, 'a', 'a', 'a', 0, 'a', 'CDI: Contrat de travail à durée indéterminée', 0, 'Disponible', 'Mode', 'Recruter', 'Recruter@yahoo.com');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id_Profil` int(11) NOT NULL,
  `Nom` text NOT NULL,
  `Prenom` text NOT NULL,
  `Numéro_téléphone` text NOT NULL,
  `E_mail` text NOT NULL,
  `Localisation` text NOT NULL,
  `Description` text NOT NULL,
  `Langues` text NOT NULL,
  `Competences` text NOT NULL,
  `Formation` text NOT NULL,
  `Experiences_professionnelles` text NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `Diplome` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id_Profil`, `Nom`, `Prenom`, `Numéro_téléphone`, `E_mail`, `Localisation`, `Description`, `Langues`, `Competences`, `Formation`, `Experiences_professionnelles`, `latitude`, `longitude`, `Diplome`) VALUES
(12, 'daadaa', 'ssss', '29564225', 'daly.ghofrane@gmail.com', 'bizerte', 'Personne dynamique,motivée', 'français/anglais/arabe', 'java,web', 'licence en BI', 'telecom', '37.304761', '9.867178', 'oui'),
(37, 'ghofrane', 'daly', '21398220', 'daly.ghofrane@gmail.com', 'tunis', 'Personne dynamique,motivée', 'français/anglais/arabe', 'java,web', 'licence en BI', 'telecom', '0', '0', 'oui'),
(50, 'ghofrane', 'daly', '96398220', 'daly.ghofrane@gmail.com', 'tunis', 'Personne dynamique,motivée', 'français/anglais/arabe', 'java,web', 'licence en BI', 'telecom', '36.848808', '10.196847', 'oui'),
(53, 'manar', 'boukhris', '99874256', 'manar.boukhris@gmail.com', 'sousse', 'Personne dynamique,motivée', 'français/anglais/arabe', 'iot', 'licence en iot', 'tech', '35.82468', '10.63473', 'oui'),
(60, 'manar', 'boukhris', '99874256', 'manar.boukhris@gmail.com', 'sousse', 'Personne dynamique,motivée', 'français/anglais/arabe', 'iot', 'licence en iot', 'tech', '35.82468', '10.63473', 'oui');

-- --------------------------------------------------------

--
-- Structure de la table `progres`
--

CREATE TABLE `progres` (
  `id_cours` varchar(256) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `progres_utilisateur` int(11) NOT NULL,
  `note_examen` int(11) NOT NULL,
  `isComplete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id` int(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `domaine` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `nom`, `description`, `domaine`) VALUES
(29, 'esprit', 'esprit', 'agriculture'),
(31, 'manar', 'manar', 'informatique'),
(34, 'nom', 'description', 'informatique'),
(133, 'boxy', 'boite de medicament', 'iott'),
(134, 'techworck', 'platforme de chercheurs travail', 'informatique'),
(135, 'titre', 'description', 'marketing'),
(136, 'mm', 'mm', 'marketing'),
(137, 'techwork', 'plateforme', 'dev web'),
(138, 'projet', 'description projet', 'mobile'),
(139, 's', 's', 's'),
(140, 's', 's', 'sssss'),
(141, 'sss', 'ssss', 'sssss'),
(142, 'h', 'h', 'hh');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id_Pub` int(11) NOT NULL,
  `objet` text NOT NULL,
  `message` text NOT NULL,
  `id_cours` text NOT NULL,
  `id_Profil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id_Pub`, `objet`, `message`, `id_cours`, `id_Profil`) VALUES
(38, 'certif', 'j\'ai obtenu', '7', 50),
(43, 'pub', 'j\'ai reçu ma certificat', '7', 50),
(44, 'certification', 'certificat obtenu en iot', '7', 12),
(51, 'certiff', 'certiff en gl', '7', 60),
(61, 'publication', 'certification en bi', '7', 50);

-- --------------------------------------------------------

--
-- Structure de la table `typeprojet`
--

CREATE TABLE `typeprojet` (
  `idtypeprojet` int(20) NOT NULL,
  `nomtype` varchar(50) NOT NULL,
  `descriptiontype` varchar(200) NOT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `typeprojet`
--

INSERT INTO `typeprojet` (`idtypeprojet`, `nomtype`, `descriptiontype`, `id`) VALUES
(16, 'manar', 'manar', 31),
(25, 'TYPE', 'DESCRIPTION', 29);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(30) NOT NULL,
  `cin` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `motDePasse` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `cin`, `nom`, `prenom`, `motDePasse`, `email`, `role`) VALUES
(1, '1445689', 'Jasser', 'Miri', '123456789', 'JaserMriri@gmail.com', 'Admin'),
(5, '14587965', 'Firass', 'Auinty', '5522654', 'FirassAouinty@gmail.com', 'Candidat'),
(6, '15526898', 'ahmed', 'youssef', '123654', 'ahmed.youssef@gmail.com', 'recruteur'),
(7, '1445689', 'Jasser', 'Miri', '123456789', 'JaserMriri@gmail.com', 'Admin'),
(11, '56565', 'jghgj', ',kkljjlk', '5555', 'fghg@gmail.com', 'admin'),
(12, 'fgdfg', 'fdgdfgdfgf', 'dfgfdg', 'dfgfdg', 'dfgfdg', 'dfgfd'),
(13, 'dfgf', 'dfg', 'dfgfd', 'dfgfdg', 'fhgfh', 'fghgf'),
(14, 'ggggggggggg', 'gggggggggggg', 'gggggggg', 'ggggggggg', 'ggggggggg', 'gggggggg'),
(15, 'dfgfdg', 'dgfdg', 'dgfdg', 'fgdf', 'dfgfd', 'dfg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `chapitre`
--
ALTER TABLE `chapitre`
  ADD PRIMARY KEY (`id_chapitre`),
  ADD KEY `id_cours` (`id_cours`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_67F068BCFB88E14F` (`utilisateur_id`),
  ADD KEY `IDX_67F068BCB1E7706E` (`profil_id`);

--
-- Index pour la table `contenu`
--
ALTER TABLE `contenu`
  ADD PRIMARY KEY (`id_contenu`),
  ADD KEY `fk_chap_cont` (`id_chapitre`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tuteur` (`id_tuteur`) USING BTREE;

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `fichmedia`
--
ALTER TABLE `fichmedia`
  ADD PRIMARY KEY (`idmedia`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `likepub`
--
ALTER TABLE `likepub`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lidpub_pub` (`id_pub`);

--
-- Index pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_75EA56E0FB7336F0` (`queue_name`),
  ADD KEY `IDX_75EA56E0E3BD61CE` (`available_at`),
  ADD KEY `IDX_75EA56E016BA31DB` (`delivered_at`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id_Profil`);

--
-- Index pour la table `progres`
--
ALTER TABLE `progres`
  ADD PRIMARY KEY (`id_cours`,`id_utilisateur`),
  ADD KEY `fk_prog_utili` (`id_utilisateur`),
  ADD KEY `fk_prog_cours` (`id_cours`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id_Pub`),
  ADD KEY `fk_profil_pub` (`id_Profil`);

--
-- Index pour la table `typeprojet`
--
ALTER TABLE `typeprojet`
  ADD PRIMARY KEY (`idtypeprojet`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `candidature`
--
ALTER TABLE `candidature`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=481;

--
-- AUTO_INCREMENT pour la table `fichmedia`
--
ALTER TABLE `fichmedia`
  MODIFY `idmedia` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `id_Profil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id_Pub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT pour la table `typeprojet`
--
ALTER TABLE `typeprojet`
  MODIFY `idtypeprojet` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chapitre`
--
ALTER TABLE `chapitre`
  ADD CONSTRAINT `chapitre_ibfk_1` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `contenu`
--
ALTER TABLE `contenu`
  ADD CONSTRAINT `fk_chap_cont` FOREIGN KEY (`id_chapitre`) REFERENCES `chapitre` (`id_chapitre`);

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`id_tuteur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `fichmedia`
--
ALTER TABLE `fichmedia`
  ADD CONSTRAINT `fichmedia_ibfk_1` FOREIGN KEY (`id`) REFERENCES `projet` (`id`);

--
-- Contraintes pour la table `likepub`
--
ALTER TABLE `likepub`
  ADD CONSTRAINT `fk_lidpub_pub` FOREIGN KEY (`id_pub`) REFERENCES `publication` (`id_Pub`),
  ADD CONSTRAINT `likepub_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `progres`
--
ALTER TABLE `progres`
  ADD CONSTRAINT `fk_prog_cours` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id`),
  ADD CONSTRAINT `fk_prog_utili` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `fk_profil_pub` FOREIGN KEY (`id_Profil`) REFERENCES `profil` (`id_Profil`);

--
-- Contraintes pour la table `typeprojet`
--
ALTER TABLE `typeprojet`
  ADD CONSTRAINT `typeprojet_ibfk_1` FOREIGN KEY (`id`) REFERENCES `projet` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
