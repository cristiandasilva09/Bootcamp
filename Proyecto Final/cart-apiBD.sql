-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2018 a las 17:31:53
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cart-api`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cart`
--

CREATE TABLE `cart` (
  `idUser` bigint(20) NOT NULL,
  `idCart` bigint(20) NOT NULL,
  `buyed` tinyint(1) DEFAULT NULL,
  `dateBuy` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cart`
--

INSERT INTO `cart` (`idUser`, `idCart`, `buyed`, `dateBuy`) VALUES
(1, 1, 1, '2018-12-19'),
(1, 2, 1, '2018-12-18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `idProduct` bigint(20) NOT NULL,
  `nameProduct` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`idProduct`, `nameProduct`, `category`, `price`) VALUES
(1, 'rice1Kg', 'food', 30),
(2, 'meat1KG', 'food', 100),
(3, 'Spaghetti1Kg', 'food', 40),
(4, 'water2Lt', 'drink', 25),
(5, 'Coca-cola2Lt', 'drink', 50),
(6, 'Lemonade1Lt', 'drink', 25),
(7, 'beer1Lt', 'alcoholic-drinks', 110),
(8, 'wine1Lt', 'alcoholic-drinks', 90),
(9, 'fernet1Lt', 'alcoholic-drinks', 350),
(10, 'apple1Kg', 'fruit', 60),
(11, 'banana1Kg', 'fruit', 50),
(12, 'orange1Kg', 'fruit', 75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product-cart`
--

CREATE TABLE `product-cart` (
  `idCart` bigint(20) NOT NULL,
  `idUser` bigint(20) NOT NULL,
  `idProduct` bigint(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `totalImport` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product-cart`
--

INSERT INTO `product-cart` (`idCart`, `idUser`, `idProduct`, `quantity`, `totalImport`) VALUES
(1, 1, 1, 1, 30),
(1, 1, 2, 1, 100),
(1, 1, 5, 4, 200),
(1, 1, 7, 3, 110);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `idUser` bigint(20) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `monto` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `firstName`, `lastName`, `nickname`, `password`, `monto`) VALUES
(1, 'Carlos', 'Perez', 'CarlosP', '123456', 560);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idUser`,`idCart`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`);

--
-- Indices de la tabla `product-cart`
--
ALTER TABLE `product-cart`
  ADD PRIMARY KEY (`idCart`,`idUser`,`idProduct`),
  ADD KEY `idUser` (`idUser`,`idCart`),
  ADD KEY `idProduct` (`idProduct`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Filtros para la tabla `product-cart`
--
ALTER TABLE `product-cart`
  ADD CONSTRAINT `product-cart_ibfk_1` FOREIGN KEY (`idUser`,`idCart`) REFERENCES `cart` (`idUser`, `idCart`),
  ADD CONSTRAINT `product-cart_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
