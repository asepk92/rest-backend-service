-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for demo_spring
CREATE DATABASE IF NOT EXISTS `demo_spring` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `demo_spring`;

-- Dumping structure for table demo_spring.histori_transaksi
CREATE TABLE IF NOT EXISTS `histori_transaksi` (
  `kd_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `user_from` varchar(50) NOT NULL,
  `no_rekening` varchar(50) NOT NULL,
  `kd_jenis_transaksi` varchar(50) NOT NULL,
  `amount` bigint(20) NOT NULL DEFAULT '0',
  `kd_bank` varchar(50) DEFAULT NULL,
  `no_rekening_tujuan` varchar(50) DEFAULT NULL,
  `user_to` varchar(50) DEFAULT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`kd_transaksi`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.histori_transaksi: ~0 rows (approximately)
/*!40000 ALTER TABLE `histori_transaksi` DISABLE KEYS */;
INSERT INTO `histori_transaksi` (`kd_transaksi`, `user_from`, `no_rekening`, `kd_jenis_transaksi`, `amount`, `kd_bank`, `no_rekening_tujuan`, `user_to`, `keterangan`, `created_date`) VALUES
	(1, '2', '0123456', '3', 500000, '1', '0654321', '3', 'Transfer Adam', '2018-06-03 00:00:00');
/*!40000 ALTER TABLE `histori_transaksi` ENABLE KEYS */;

-- Dumping structure for table demo_spring.jenis_transaksi
CREATE TABLE IF NOT EXISTS `jenis_transaksi` (
  `kd_jenis_transaksi` int(11) NOT NULL,
  `jenis_transaksi` varchar(40) NOT NULL,
  PRIMARY KEY (`kd_jenis_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.jenis_transaksi: ~4 rows (approximately)
/*!40000 ALTER TABLE `jenis_transaksi` DISABLE KEYS */;
INSERT INTO `jenis_transaksi` (`kd_jenis_transaksi`, `jenis_transaksi`) VALUES
	(1, 'Tarik Tunai'),
	(2, 'Setor Tunai'),
	(3, 'Transfer Antar Bank'),
	(4, 'Transfer Antar Rekening');
/*!40000 ALTER TABLE `jenis_transaksi` ENABLE KEYS */;

-- Dumping structure for table demo_spring.klien
CREATE TABLE IF NOT EXISTS `klien` (
  `id_klien` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT '0',
  `nama_lengkap` varchar(100) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_rekening` varchar(50) NOT NULL,
  `saldo` bigint(20) NOT NULL,
  `alamat` varchar(250) NOT NULL,
  PRIMARY KEY (`id_klien`),
  KEY `FK_klien_master_user` (`id_user`),
  CONSTRAINT `FK_klien_master_user` FOREIGN KEY (`id_user`) REFERENCES `master_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.klien: ~2 rows (approximately)
/*!40000 ALTER TABLE `klien` DISABLE KEYS */;
INSERT INTO `klien` (`id_klien`, `id_user`, `nama_lengkap`, `tempat_lahir`, `tgl_lahir`, `no_rekening`, `saldo`, `alamat`) VALUES
	(1, 2, 'luki', 'Jakarta', '2018-06-03', '0123456', 8500000, 'Jakarta'),
	(2, 3, 'adam', 'Bogor', '2018-06-03', '0654321', 5000000, 'Bogor');
/*!40000 ALTER TABLE `klien` ENABLE KEYS */;

-- Dumping structure for table demo_spring.master_bank
CREATE TABLE IF NOT EXISTS `master_bank` (
  `kd_bank` int(11) NOT NULL,
  `nama_bank` varchar(50) NOT NULL,
  PRIMARY KEY (`kd_bank`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.master_bank: ~4 rows (approximately)
/*!40000 ALTER TABLE `master_bank` DISABLE KEYS */;
INSERT INTO `master_bank` (`kd_bank`, `nama_bank`) VALUES
	(1, 'BCA'),
	(2, 'MANDIRI'),
	(3, 'BRI'),
	(4, 'DANAMON');
/*!40000 ALTER TABLE `master_bank` ENABLE KEYS */;

-- Dumping structure for table demo_spring.master_user
CREATE TABLE IF NOT EXISTS `master_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.master_user: ~4 rows (approximately)
/*!40000 ALTER TABLE `master_user` DISABLE KEYS */;
INSERT INTO `master_user` (`id_user`, `email`, `no_hp`, `password`, `username`) VALUES
	(1, 'ridwan@gmail.com', '081380976543', 'ridwan', 'ridwan'),
	(2, 'luki@gmail.com', '082213345678', 'wJNser3IzO4=', 'luki'),
	(3, 'adam@gmail.com', '082213345677', 'AQsOuUJfNXA=', 'adam'),
	(4, 'yudi@gmail.com', '082213345676', 'RZqLxkEGJkg=', 'yudi');
/*!40000 ALTER TABLE `master_user` ENABLE KEYS */;

-- Dumping structure for table demo_spring.tarik_setor_tunai
CREATE TABLE IF NOT EXISTS `tarik_setor_tunai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_klien` int(11) NOT NULL DEFAULT '0',
  `no_rekening` varchar(50) DEFAULT NULL,
  `kd_jenis_transaksi` int(11) NOT NULL DEFAULT '0',
  `amount` bigint(20) NOT NULL DEFAULT '0',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_tarik_setor_tunai_klien` (`id_klien`),
  KEY `FK_tarik_setor_tunai_jenis_transaksi` (`kd_jenis_transaksi`),
  CONSTRAINT `FK_tarik_setor_tunai_jenis_transaksi` FOREIGN KEY (`kd_jenis_transaksi`) REFERENCES `jenis_transaksi` (`kd_jenis_transaksi`),
  CONSTRAINT `FK_tarik_setor_tunai_klien` FOREIGN KEY (`id_klien`) REFERENCES `klien` (`id_klien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.tarik_setor_tunai: ~0 rows (approximately)
/*!40000 ALTER TABLE `tarik_setor_tunai` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarik_setor_tunai` ENABLE KEYS */;

-- Dumping structure for table demo_spring.transfer
CREATE TABLE IF NOT EXISTS `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_from` int(11) DEFAULT NULL,
  `no_rekening` varchar(50) DEFAULT NULL,
  `kd_jenis_transaksi` int(11) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `kd_bank` int(11) DEFAULT '1',
  `no_rekening_tujuan` varchar(50) DEFAULT NULL,
  `user_to` int(11) DEFAULT NULL,
  `keterangan` varchar(250) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_transfer_klien` (`user_from`),
  KEY `FK_transfer_jenis_transaksi` (`kd_jenis_transaksi`),
  KEY `FK_transfer_master_bank` (`kd_bank`),
  CONSTRAINT `FK_transfer_jenis_transaksi` FOREIGN KEY (`kd_jenis_transaksi`) REFERENCES `jenis_transaksi` (`kd_jenis_transaksi`),
  CONSTRAINT `FK_transfer_klien` FOREIGN KEY (`user_from`) REFERENCES `klien` (`id_klien`),
  CONSTRAINT `FK_transfer_master_bank` FOREIGN KEY (`kd_bank`) REFERENCES `master_bank` (`kd_bank`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table demo_spring.transfer: ~0 rows (approximately)
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` (`id`, `user_from`, `no_rekening`, `kd_jenis_transaksi`, `amount`, `kd_bank`, `no_rekening_tujuan`, `user_to`, `keterangan`, `created_date`) VALUES
	(2, 2, '0123456', 3, 500000, 1, '0654321', 3, 'Transfer Adam', '2018-06-03 00:00:00');
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
